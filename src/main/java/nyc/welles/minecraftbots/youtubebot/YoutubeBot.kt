package nyc.welles.minecraftbots.youtubebot

import com.google.api.services.youtube.YouTube
import nyc.welles.minecraftbots.Bot
import org.bukkit.Bukkit
import java.io.IOException
import java.security.GeneralSecurityException

open class YoutubeBot : Bot() {
    companion object {
        //private Queue<String> modifiedText;
//private SearchListResponse queryResults;
//DONE: Make this make sense to players
        protected const val DEVELOPER_KEY = "AIzaSyCYectdB_Q4fQtFofoTO_4JeQnBUZsrAgw"
        protected const val YOUTUBE_URL = "https://www.youtube.com/watch?v="
        fun pushQuery(textToSearch: String?) {
            try {
                Bukkit.broadcastMessage("§f[§c§lYoutube Bot§r§f] Found video: " + getQuery(textToSearch))
            } catch (exception: IOException) {
                exception.printStackTrace()
            } catch (exception: GeneralSecurityException) {
                exception.printStackTrace()
            }
        }

        @Throws(IOException::class, GeneralSecurityException::class)
        fun getQuery(modifiedText: String?): String {
            val youtubeService: YouTube = Bot.Companion.service
            // Define and execute the API request
            val request = youtubeService.search()
                    .list(modifiedText)
            val response = request.setKey(DEVELOPER_KEY)
                    .setMaxResults(5L)
                    .setOrder("viewCount")
                    .setQ("surfing")
                    .setSafeSearch("strict")
                    .execute()
            val singleVideo = response.items.iterator().next()
            val rId = singleVideo.id
            //Bukkit.getServer().broadcastMessage(String.valueOf(response));
//System.out.println(response);
            return YOUTUBE_URL + rId.toString()
        }
    }
}