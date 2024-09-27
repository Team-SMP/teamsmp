package uk.teamsmp.aetherium

import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.plugin.java.JavaPlugin
import uk.teamsmp.aetherium.commands.*
import uk.teamsmp.aetherium.utils.Utils

class Aetherium : JavaPlugin() {
    val mm = MiniMessage.miniMessage()
    val chatPrefix = "<gradient:#8922bd:blue:aqua><b>${Utils.smallCaps("aetherium")}</b></gradient> <grey>> <reset>"

    override fun onEnable() {
        getCommand("modvote")?.apply {
            setExecutor(ModVoteCommand(this@Aetherium))
            tabCompleter = ModVoteCommand(this@Aetherium)
        }
        logger.info("Command MODVOTE has been registered.")
        getCommand("srvi")?.apply {
            setExecutor(SrviCommand(this@Aetherium))
            tabCompleter = SrviCommand(this@Aetherium)
        }
        logger.info("Command SRVI has been registered.")
        logger.info("aetherium has loaded")
        logger.info("Hold onto your pickaxes! aetherium is now live!")
    }

    override fun onDisable() {
        logger.info("aetherium left the chat.\nStatus: don't wake me up unless you have snacks")
        logger.info("aetherium has been disabled")
    }
}
