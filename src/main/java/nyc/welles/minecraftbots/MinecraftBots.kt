package nyc.welles.minecraftbots

import nyc.welles.minecraftbots.serverwidemusic.SWMusicCommand
import org.bukkit.plugin.java.JavaPlugin

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