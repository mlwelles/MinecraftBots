package nyc.welles.minecraftbots.randomselector

import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter
import org.bukkit.scheduler.BukkitRunnable
import java.io.File
import java.lang.NumberFormatException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class RandomSelectorCommand : CommandExecutor, TabCompleter {
//    private var words : LinkedList<String>? = null
    private var seed = 55028065
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args[1].equals("player", ignoreCase = true)){
            if (!sender.hasPermission("mcbots.random.player")){
                sender.sendMessage("[RANDBOT] You do not have permission to request a random player")
                return false
            }
            val onlinePlayers = Bukkit.getOnlinePlayers()
            val offlinePlayers = Bukkit.getOfflinePlayers()
            val allPlayers = ArrayList<String>()
            for (player in onlinePlayers){
                allPlayers.add(player.displayName)
            }
            for (offlinePlayer in offlinePlayers){
                offlinePlayer.name?.let { allPlayers.add(it) }
            }
            //val firstRand = Random(seed).nextBoolean()
            sender.sendMessage("[RANDBOT] The random player selected is" + allPlayers[Random(seed).nextInt(0, allPlayers.size)])


            if (Random(seed).nextBoolean()){
                seed += Random(seed).nextInt()
            } else{
                seed = Random(seed).nextInt()

            }
            return true

        }
        if (args[1].equals("number", ignoreCase = true)){
            if (!sender.hasPermission("mcbots.random.number")){
                sender.sendMessage("[RANDBOT] You do not have permission to request a random number")
                return false
            }

            if (args[2] == ("")){
                sender.sendMessage("[RANDBOT] Your number has been chosen: " + Random(seed).nextInt())
                return true
            }
            return try{
                val parsedMin = args[2].toInt()
                val parsedMax = args[3].toInt()
                sender.sendMessage("[RANDBOT] Your number has been chosen: " + Random(seed).nextInt(parsedMin, parsedMax))
                true

            } catch (nfe: NumberFormatException){
                sender.sendMessage("[RANDBOT] Failed to parse limit values, make sure to specify a number")
                false
            }


        }
        if (args[1].equals("word", ignoreCase = true)){
            //TODO: Implement word things
            var runnable = object : BukkitRunnable(){
               override fun run() {

               }

            }
        }
        return false
    }

    override fun onTabComplete(sender: CommandSender, command: Command, alias: String, args: Array<out String>): MutableList<String>? {
        return null
    }
}