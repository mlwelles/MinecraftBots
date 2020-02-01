package nyc.welles.minecraftbots

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.net.URL


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
//TODO: remove

open class SWBCommandHandler {
    protected fun isValid(url: String?): Boolean { /* Try creating a valid URL */
        return try {
            URL(url).toURI()
            true
        } // If there was an Exception
// while creating URL object
        catch (e: Exception) {
            false
        }
    }
}