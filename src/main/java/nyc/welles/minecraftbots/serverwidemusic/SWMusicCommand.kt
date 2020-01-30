package nyc.welles.minecraftbots.serverwidemusic

import nyc.welles.minecraftbots.MinecraftBots
import nyc.welles.minecraftbots.SWBCommandHandler
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin

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

class SWMusicCommand : SWBCommandHandler(), CommandExecutor {
    private val Plugin: JavaPlugin? = MinecraftBots.Companion.getInstance()
    private val config: FileConfiguration
        get() = Plugin!!.config
    override fun onCommand(commandSender: CommandSender, command: Command, s: String, args: Array<String>): Boolean {
        /*if (args[2] == "url") {
            if (args[3].contains("https://www.youtube.com/watch?v=") && isValid(args[2])) {
                val messageList: List<String> = config.getStringList("ServerWideMusic.")
                for (message in messageList) {
                    if (!message.startsWith("//") && !message.startsWith("#")) {
                        val translatedMessage = ChatColor.translateAlternateColorCodes('&',
                                message.replace("%recommended-content%", args[3])
                                        .replace("%recommender%", commandSender.name))
                        Bukkit.broadcastMessage(translatedMessage)
                    }
                }
                return true
            } else {
                commandSender.sendMessage("§f[§aMusic Bot§f] Invalid link, make sure you're not using a youtu.be shortcut")
            }
        } else if (args[1] == "search") {
            val argsStringBuilder = StringBuilder()
            for (x in 2 until args.size) {
                argsStringBuilder.append(" ").append(args[x])
            }
            val argsString = argsStringBuilder.toString()
        }
        return false*/
        return false
    }
}