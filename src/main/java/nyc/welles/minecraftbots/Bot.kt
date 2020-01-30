package nyc.welles.minecraftbots

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.json.JsonFactory
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.youtube.YouTube
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.IOException
import java.security.GeneralSecurityException

open class Bot {
    companion object {

        /*fun getService(): YouTube {
            return service
        }*/

        //Please don't misuse, or I will eat your wrists while /u/Lolwutm8 steals your kneecaps
        //@JvmStatic

        //@JvmStatic

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