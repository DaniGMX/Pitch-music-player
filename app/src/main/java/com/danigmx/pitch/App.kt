package com.danigmx.pitch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.danigmx.pitch.spotify.SpotifyService

class App : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
    }

    override fun onStop() {
        super.onStop()

        SpotifyService.disconnect()
    }
}
