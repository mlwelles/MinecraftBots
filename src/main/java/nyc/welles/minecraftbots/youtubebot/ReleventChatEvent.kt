package nyc.welles.minecraftbots.youtubebot

import nyc.welles.minecraftbots.SWBEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

class ReleventChatEvent : SWBEvent(), Listener {
    @EventHandler
    fun onPlayerChat(chatEvent: AsyncPlayerChatEvent) {
        if (!chatEvent.player.hasPermission("mcbots.use.ytbot")) {
            return
        }
        var message = chatEvent.message
        if (!message.contains("#ytbot")) {
            return
        }
        YoutubeBot.Companion.pushQuery(message.split("#ytbot".toRegex()).toTypedArray()[1])
        println("YTBOT DEBUG: message after splicing is: " + message.split("#ytbot".toRegex()).toTypedArray()[1])
        message = message.replace("#ytbot", "")
        chatEvent.message = message
    }
}