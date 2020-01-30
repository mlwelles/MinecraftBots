package nyc.welles.minecraftbots

import nyc.welles.minecraftbots.serverwidemusic.SWMusicCommand
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

class MinecraftBots : JavaPlugin() {
    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(SWBEvent(), this)
        getCommand("swmusic")!!.setExecutor(SWMusicCommand())
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