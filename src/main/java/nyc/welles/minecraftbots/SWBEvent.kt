package nyc.welles.minecraftbots

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

open class SWBEvent : Listener {
    companion object {
        protected val PLUGIN: JavaPlugin? = MinecraftBots.Companion.getInstance()
        protected val config: FileConfiguration
            protected get() = PLUGIN!!.config

        protected var getPlugin = PLUGIN
    }
}