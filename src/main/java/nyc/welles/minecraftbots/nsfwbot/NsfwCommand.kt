package nyc.welles.minecraftbots.nsfwbot

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.entity.Player
import java.util.*

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

class NsfwCommand : NotSafeForWorkBot(), CommandExecutor, TabCompleter {
    //TODO: maybe implement config-based chat messages
    override fun onCommand(commandSender: CommandSender, command: Command, s: String, args: Array<String>): Boolean {

        if (commandSender !is Player) {
            commandSender.sendMessage("§cYou can only run this command as a player")
            return false
        }
        val player : Player = commandSender
        if (args[1] == "toggle") {
            when (args[2]){
                "receiver" -> {
                    if (!player.hasPermission("mcbots.nsfwbot.togglechat")){
                        player.sendMessage("§cYou do not have permission to toggle if you receive nsfw messages")
                        return false
                    }
                    var receiverValue = !getDefaultReceiver()
                    if (!getNsfwReceivers()?.containsKey(commandSender.uniqueId)!!) {
                        getNsfwReceivers()?.put(commandSender.uniqueId, !getDefaultReceiver())
                    } else{
                        receiverValue = !getNsfwReceivers()?.get(commandSender.uniqueId)!!
                    }
                    getNsfwReceivers()?.set(commandSender.uniqueId, receiverValue)
                    commandSender.sendMessage("§4§lNSFW§r§f: You will now " + (if (receiverValue) "receive" else "§l§cNOT§r§f receive") + "not safe for work messages.")
                }
                "chatter" -> {
                    if (!player.hasPermission("mcbots.nsfwbot.togglereceive")){
                        player.sendMessage("&cYou do not have permission to toggle if you chat to nsfw-disabled players")
                        return false
                    }
                    var chatterValue = !getDefaultChatter()
                    if (!getNsfwChatters()?.containsKey(commandSender.uniqueId)!!){
                        getNsfwChatters()?.put(commandSender.uniqueId, chatterValue)
                    } else{
                        chatterValue = !getNsfwChatters()?.get(commandSender.uniqueId)!!
                    }
                    getNsfwChatters()?.set(commandSender.uniqueId, chatterValue)
                    commandSender.sendMessage("§4§lNSFW§r§f: You will now " + (if (chatterValue) "chat" else "§l§cNOT§r§f chat") + "to players who have disabled nsfw mode")
                }

            }

        }
        return true
    }
    //TODO: add better tab complete support
    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<String>): List<String>? {
        val tabComplete: MutableList<String> = ArrayList()
        if (args[1] != "toggle") {
            return if (args.size == 2) {
                tabComplete.add("toggle")
                tabComplete
            } else {
                null
            }
        }else{
            return if (args.size == 3) {
                when {
                    args[3].startsWith("r")-> tabComplete.add("receiver")
                    args[3].startsWith("c") -> tabComplete.add("chatter")
                    else -> {
                        tabComplete.add("receiver")
                        tabComplete.add("chatter")
                    }
                }
                /*if (args[3].startsWith("re")){
                    tabComplete.add("receiver")
                }else if (args[3].startsWith("ch")){
                    tabComplete.add("chatter")
                }else{

                }*/
                tabComplete
            } else{
                tabComplete.add("receiver")
                tabComplete.add("chatter")
                tabComplete
            }
        }
        return null
    }
}