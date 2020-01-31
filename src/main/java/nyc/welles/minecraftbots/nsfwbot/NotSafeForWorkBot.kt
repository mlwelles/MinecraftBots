package nyc.welles.minecraftbots.nsfwbot

import nyc.welles.minecraftbots.Bot
import nyc.welles.minecraftbots.MinecraftBots
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.util.*
import kotlin.collections.HashMap

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