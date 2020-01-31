package nyc.welles.minecraftbots.youtubebot

import nyc.welles.minecraftbots.SWBEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

/**
 * Copyright (C) 2020  Henry0w
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 **/
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