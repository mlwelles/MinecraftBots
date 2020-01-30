package nyc.welles.minecraftbots.nsfwbot

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

/*Copyright (C) 2020  Henry0w

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published
by the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.*/

class NsfwChatEvent : NotSafeForWorkBot(), Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    fun onPlayerChat(chatEvent: AsyncPlayerChatEvent) { //If player not in the hashmap (player is new)
        val nsfwChatters = getNsfwChatters()
        val nsfwReceivers = getNsfwReceivers()
        if (!nsfwChatters!!.containsKey(chatEvent.player.uniqueId)) {

            nsfwChatters[chatEvent.player.uniqueId] = getDefaultChatter()
            //If new players chat on nsfw
            if (getDefaultChatter()) { //Remove nsfw receivers
                for (player in chatEvent.recipients) {
                    if (nsfwReceivers!!.containsKey(player.uniqueId)) {
                        if (!nsfwReceivers[player.uniqueId]!!) {
                            try {
                                chatEvent.recipients.remove(player)
                            } catch (ignored: UnsupportedOperationException) { //e.printStackTrace();
                            }
                        }
                    } else {
                        nsfwReceivers[player.uniqueId] = getDefaultReceiver()
                        if (!getDefaultReceiver()) {
                            try {
                                chatEvent.recipients.remove(player)
                            } catch (ignored: UnsupportedOperationException) { //e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } // If player is in the hashmap
        else { //If they're chatting nsfw
            if (nsfwChatters[chatEvent.player.uniqueId]!!) { //remove non-nsfw players
                for (player in chatEvent.recipients) { //If player not in nsfw chat
                    if (!nsfwReceivers!![player.uniqueId]!!) { //Try to remove
                        try {
                            chatEvent.recipients.remove(player)
                        } catch (ignored: UnsupportedOperationException) { //e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}