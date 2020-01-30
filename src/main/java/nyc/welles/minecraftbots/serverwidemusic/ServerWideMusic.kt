package nyc.welles.minecraftbots.serverwidemusic

import nyc.welles.minecraftbots.Bot
import nyc.welles.minecraftbots.youtubebot.YoutubeBot
import org.bukkit.Bukkit
import org.bukkit.event.Listener
import java.util.*

class ServerWideMusic : YoutubeBot(), Listener {
    private val queue: Queue<String>? = null
    private val players: HashMap<Long, Boolean>? = null
    fun startSendingMessages() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Bot.Companion.PLUGIN!!, { Bukkit.broadcastMessage("§f[§aMusic Bot§f] Currently Playing") }, 0L, Bot.Companion.getConfig().getInt("MusicBot.delay").toLong())
    }
}