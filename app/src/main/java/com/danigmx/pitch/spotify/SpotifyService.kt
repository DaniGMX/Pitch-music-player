/**
 * Created by Daniel Gracia Machado on 2020-01-20.
 */
package com.danigmx.pitch.spotify

import android.content.Context
import android.util.Log
import com.spotify.android.appremote.api.ConnectionParams
import com.spotify.android.appremote.api.Connector
import com.spotify.android.appremote.api.SpotifyAppRemote

object SpotifyService {

    private const val CLIENT_ID = "5b51a68f20a8439e818dafa2ac43d975"
    private const val REDIRECT_URI = "com.danigmx.pitch://callback"

    private var spotifyAppRemote: SpotifyAppRemote? = null
    private var connectionParams: ConnectionParams = ConnectionParams.Builder(CLIENT_ID)
        .setRedirectUri(REDIRECT_URI)
        .showAuthView(true)
        .build()

    fun connect(context: Context, handler: (connected: Boolean) -> Unit) {

        if (spotifyAppRemote?.isConnected == true) {
            handler(true)
            return
        }

        val connectionListener = object: Connector.ConnectionListener {

            override fun onConnected(spotifyAppRemote: SpotifyAppRemote?) {
                this@SpotifyService.spotifyAppRemote = spotifyAppRemote
                handler(true)
            }

            override fun onFailure(throwable: Throwable) {
                Log.e("SpotifyService", throwable.message, throwable)
            }
        }

        SpotifyAppRemote.connect(context, connectionParams, connectionListener)
    }
}