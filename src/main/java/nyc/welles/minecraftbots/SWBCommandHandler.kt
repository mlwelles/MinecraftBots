package nyc.welles.minecraftbots

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.net.URL

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