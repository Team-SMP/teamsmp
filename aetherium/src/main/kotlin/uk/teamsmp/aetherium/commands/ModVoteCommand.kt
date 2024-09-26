package uk.teamsmp.aetherium.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.CommandExecutor
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import java.io.File
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import net.kyori.adventure.text.minimessage.MiniMessage
import uk.teamsmp.aetherium.Aetherium

data class VoteData(
    val candidates: List<String>,
    val votes: MutableMap<String, Int>,
    val votedPlayers: MutableList<String>
)

class ModVoteCommand(private val plugin: Aetherium) : CommandExecutor, TabCompleter {
    private val mm = MiniMessage.miniMessage()
    private val gson = Gson()
    private val votesFile: File by lazy { File(plugin.dataFolder, "modvote.json") }
    private var voteData: VoteData

    init {
        voteData = loadVotes() // Load existing votes when the command is initialized
    }

    private fun loadVotes(): VoteData {
        if (votesFile.exists()) {
            val reader = votesFile.bufferedReader()
            val type = object : TypeToken<VoteData>() {}.type
            val data = gson.fromJson<VoteData>(reader, type) ?: VoteData(emptyList(), mutableMapOf(), mutableListOf())
            reader.close()
            return data
        }
        return VoteData(emptyList(), mutableMapOf(), mutableListOf())
    }

    private fun saveVotes() {
        val writer = votesFile.bufferedWriter()
        writer.write(gson.toJson(voteData))
        writer.close()
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isEmpty()) {
            sender.sendMessage(mm.deserialize("${plugin.chatPrefix}Incorrect usage!<br>  <gold>/modvote <<yellow>moderator</yellow>>"))
            return true
        }

        val moderatorName = args[0]

        // Check if the moderator is valid
        if (!voteData.candidates.contains(moderatorName)) {
            sender.sendMessage(mm.deserialize("${plugin.chatPrefix}${moderatorName} is not a candidate! Valid options are:<br>  - <gold>${voteData.candidates.joinToString("</gold><br>  - <gold>")}</gold>"))
            return true
        }

        // Check if the sender is a player
        if (sender is Player) {
            val playerUUID = sender.uniqueId.toString()

            // Check if the player has already voted
            if (voteData.votedPlayers.contains(playerUUID)) {
                sender.sendMessage(mm.deserialize("${plugin.chatPrefix}You have already voted!"))
                return true
            }

            if (args.size < 2 || args[1] != "confirm") {
                sender.sendMessage(mm.deserialize("${plugin.chatPrefix}Are you absolutely sure you want to vote for ${moderatorName}? You can NOT cancel your vote afterwards!<br>  - <click:run_command:'/modvote $moderatorName confirm'><u>Click here to <gold>confirm your vote</gold>.</u></click>"))
                return true
            }

            // Increment the vote count for the specified moderator
            voteData.votes[moderatorName] = voteData.votes.getOrDefault(moderatorName, 0) + 1
            voteData.votedPlayers.add(playerUUID) // Add the player's UUID to the list

            sender.sendMessage(mm.deserialize("${plugin.chatPrefix}You voted for ${moderatorName}!"))

            // Save votes after each vote to ensure data persistence
            saveVotes()

            return true
        } else {
            sender.sendMessage("Hey, console user. Only players can vote.")
            return false
        }
    }

    override fun onTabComplete(sender: CommandSender, command: Command, label: String, args: Array<out String>): List<String>? {
        if (args.size == 1) {
            return voteData.candidates.filter { it.startsWith(args[0], ignoreCase = true) }
        }
        return null
    }
}
