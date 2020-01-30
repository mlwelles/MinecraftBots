package nyc.welles.minecraftbots.serverwidemusic

import nyc.welles.minecraftbots.Bot
import nyc.welles.minecraftbots.youtubebot.YoutubeBot
import org.bukkit.Bukkit
import org.bukkit.event.Listener
import java.util.*

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

class ServerWideMusic : YoutubeBot(), Listener {
    private val queue: Queue<String>? = null
    private val players: HashMap<Long, Boolean>? = null
    /*fun startSendingMessages() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Bot.Companion.PLUGIN!!, { Bukkit.broadcastMessage("§f[§aMusic Bot§f] Currently Playing") }, 0L, Bot.Companion.getConfig().getInt("MusicBot.delay").toLong())
    }*/
}