package nyc.welles.minecraftbots.nsfwbot

import nyc.welles.minecraftbots.Bot
import nyc.welles.minecraftbots.MinecraftBots
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.util.*
import kotlin.collections.HashMap

open class NotSafeForWorkBot : Bot() {

    private var nsfwChatters: HashMap<UUID, Boolean>? = null
    private var nsfwReceivers: HashMap<UUID, Boolean>? = null
    protected fun getNsfwChatters() = nsfwChatters
    protected fun getNsfwReceivers() = nsfwReceivers
    protected fun getDefaultChatter() = `getDefaultChatter()`
    protected fun getDefaultReceiver() = `getDefaultReceiver()`
    companion object {
        protected val `getDefaultChatter()` = config.getBoolean("bots.nsfw.chat-on-nsfw-as-default")
        protected val `getDefaultReceiver()` = config.getBoolean("bots.nsfw.receive-nsfw-chat-as-default")
        protected val PLUGIN: JavaPlugin? = MinecraftBots.Companion.getInstance()
        protected val config: FileConfiguration
            get() = PLUGIN!!.config

        protected var getPlugin = PLUGIN
    }
}