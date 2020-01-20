package com.danigmx.pitch.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.danigmx.pitch.App
import com.danigmx.pitch.R
import com.danigmx.pitch.databinding.ActivityLoginBinding
import com.danigmx.pitch.spotify.SpotifyService

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val binding: ActivityLoginBinding = DataBindingUtil
            .setContentView(
                this,
                R.layout.activity_login
            )

        binding.viewModel = LoginViewModel()

        binding.loginConnectButton.setOnClickListener {
            SpotifyService.connect(this) {
                val intent = Intent(this, App::class.java)
                startActivity(intent)
            }
        }
    }
}
