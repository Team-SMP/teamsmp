package uk.teamsmp.aetherium.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.CommandExecutor
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import java.io.File
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.bukkit.Sound
import uk.teamsmp.aetherium.Aetherium

data class VoteData(
    val candidates: List<String>,
    val votes: MutableMap<String, Int>,
    val votedPlayers: MutableList<String>,
    val votingOpen: Boolean
)

class ModVoteCommand(private val plugin: Aetherium) : CommandExecutor, TabCompleter {
    private val gson = Gson()
    private val votesFile: File by lazy { File(plugin.dataFolder, "modvote.json") }
    private var voteData: VoteData
    private val mm = plugin.mm

    init {
        voteData = loadVotes() // Load existing votes when the command is initialized
    }

    private fun loadVotes(): VoteData {
        if (votesFile.exists()) {
            val reader = votesFile.bufferedReader()
            val type = object : TypeToken<VoteData>() {}.type
            val data = gson.fromJson<VoteData>(reader, type) ?: VoteData(emptyList(), mutableMapOf(), mutableListOf(), votingOpen = false)
            reader.close()
            return data
        }
        return VoteData(emptyList(), mutableMapOf(), mutableListOf(), votingOpen = false)
    }

    private fun saveVotes() {
        val writer = votesFile.bufferedWriter()
        writer.write(gson.toJson(voteData))
        writer.close()
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        voteData = loadVotes()

        if (sender !is Player) {
            sender.sendMessage("Hey, console user. Only players can vote.")
            return true
        }

        val player: Player = sender

        if (!voteData.votingOpen) {
            player.sendMessage(mm.deserialize("${plugin.chatPrefix}Sorry, voting isn't open just yet! We will announce when you will be able to vote for a moderator."))
            player.sendMessage(mm.deserialize("${plugin.chatPrefix}In the meantime, why don't you check out our website?<br>  - <u><click:open_url:https://teamsmp.pages.dev>https://teamsmp.pages.dev</click></u>"))
            player.playSound(player.location, Sound.BLOCK_ANVIL_LAND, 0.5f, 1.0f)
            return true
        }

        if (args.isEmpty()) {
            player.sendMessage(mm.deserialize("${plugin.chatPrefix}Incorrect usage!<br>  <gold>/modvote <<yellow>moderator</yellow>>"))
            player.playSound(player.location, Sound.BLOCK_ANVIL_LAND, 0.5f, 1.0f)
            return true
        }

        val moderatorName = args[0]

        // Check if the moderator is valid
        if (!voteData.candidates.contains(moderatorName)) {
            player.sendMessage(mm.deserialize("${plugin.chatPrefix}${moderatorName} is not a candidate! Valid options are:<br>  - <gold>${voteData.candidates.joinToString("</gold><br>  - <gold>")}</gold>"))
            player.playSound(player.location, Sound.BLOCK_ANVIL_LAND, 0.5f, 1.0f)
            return true
        }

        val playerUUID = player.uniqueId.toString()

        if (moderatorName == player.name) {
            player.sendMessage(mm.deserialize("${plugin.chatPrefix}No, you can't vote for yourself."))
            player.playSound(player.location, Sound.BLOCK_ANVIL_LAND, 0.5f, 1.0f)
            return true
        }
        // Check if the player has already voted
        if (voteData.votedPlayers.contains(playerUUID)) {
            player.sendMessage(mm.deserialize("${plugin.chatPrefix}You have already voted!"))
            player.playSound(player.location, Sound.BLOCK_ANVIL_LAND, 0.5f, 1.0f)
            return true
        }

        if (args.size < 2 || args[1] != "confirm") {
            player.sendMessage(mm.deserialize("${plugin.chatPrefix}Are you absolutely sure you want to vote for ${moderatorName}? You can NOT cancel your vote afterwards!<br>  - <click:run_command:'/modvote $moderatorName confirm'><u>Click here to <gold>confirm your vote</gold>.</u></click>"))
            player.playSound(player.location, Sound.BLOCK_NOTE_BLOCK_PLING, 0.5f, 1.5f)
            return true
        }

        // Increment the vote count for the specified moderator
        voteData.votes[moderatorName] = voteData.votes.getOrDefault(moderatorName, 0) + 1
        voteData.votedPlayers.add(playerUUID) // Add the player's UUID to the list

        player.sendMessage(mm.deserialize("${plugin.chatPrefix}You voted for ${moderatorName}!"))
        player.playSound(player.location, Sound.ENTITY_PLAYER_LEVELUP, 0.5f, 2.0f)

        // Save votes after each vote to ensure data persistence
        saveVotes()

        return true
    }

    override fun onTabComplete(sender: CommandSender, command: Command, label: String, args: Array<out String>): List<String>? {
        voteData = loadVotes()

        if (!voteData.votingOpen) return null

        if (args.size == 1) {
            return voteData.candidates.filter { it.startsWith(args[0], ignoreCase = true) }
        }
        return null
    }
}
