package nyc.welles.minecraftbots

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.youtube.YouTube
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.IOException
import java.security.GeneralSecurityException

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

open class Bot {
    companion object {

        /*fun getService(): YouTube {
            return service
        }*/

        protected val JSON_FACTORY: JsonFactory = JacksonFactory.getDefaultInstance()
        protected const val APPLICATION_NAME = "MinecraftBots"
        @get:Throws(GeneralSecurityException::class, IOException::class)
        @JvmStatic
        protected val service: YouTube
            get() {
                val httpTransport = GoogleNetHttpTransport.newTrustedTransport()
                return YouTube.Builder(httpTransport, JSON_FACTORY, null)
                        .setApplicationName(APPLICATION_NAME)
                        .build()
            }

        protected val PLUGIN: JavaPlugin? = MinecraftBots.Companion.getInstance()
        protected val config: FileConfiguration
            get() = PLUGIN!!.config

    }
}