package nyc.welles.minecraftbots

import nyc.welles.minecraftbots.serverwidemusic.SWMusicCommand
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitRunnable
import java.io.File
import java.nio.file.Files


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

class MinecraftBots : JavaPlugin() {
    override fun onEnable() {
        if (!this.dataFolder.exists()) {
            this.dataFolder.mkdir();
        }
        val runnable = object : BukkitRunnable(){
            override fun run() {
                println("MinecraftBots: This program/plugin is licensed under the GNU Affero General Public License. You can find the source code at: https://github.com/Henry0w/MinecraftBots")
                println("MinecraftBots: You can find a copy of the GNU Affero General Public License located in the config folder of this plugin")
            }

        }
        runnable.runTaskLater(this, 5L)
        val asyncMakeConfig = object : BukkitRunnable(){
            override fun run() {
                val file = File(dataFolder, "GNU-Affero-General-Public-License.txt")
                file.parentFile.mkdirs()
                saveResource("GNU-Affero-General-Public-License.txt", true)

            }

        }
        asyncMakeConfig.runTaskAsynchronously(this)

        //val link = this.getResource("GNU-Affero-General-Public-License.txt")
        //Files.copy(link!!, this.)
        //instance = this
        //server.pluginManager.registerEvents(SWBEvent(), this)
        //getCommand("swmusic")!!.setExecutor(SWMusicCommand())
    }

    companion object {

        fun getInstance(): JavaPlugin? {
            return instance
        }

        /*public void onEnable() {
        INSTANCE = this;
    }*/ var instance: MinecraftBots? = null
            private set
    }
}