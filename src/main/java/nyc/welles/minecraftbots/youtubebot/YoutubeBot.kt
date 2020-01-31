package nyc.welles.minecraftbots.youtubebot

import com.google.api.services.youtube.YouTube
import nyc.welles.minecraftbots.Bot
import org.bukkit.Bukkit
import java.io.IOException
import java.security.GeneralSecurityException

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