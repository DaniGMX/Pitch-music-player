package com.danigmx.pitch.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.danigmx.pitch.R
import com.danigmx.pitch.databinding.ActivityLoginBinding
import com.danigmx.pitch.spotify.SpotifyService

class LoginActivity : AppCompatActivity() {

    /** Lazily retrieve [LoginViewModel] */
    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        /** Data Binding with the login layout */
        val binding: ActivityLoginBinding = DataBindingUtil
            .setContentView(
                this,
                R.layout.activity_login
            )

        // Retrieve ViewModel
        binding.viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        // Observe connect variable to connect when user decides to
        viewModel.connect.observe(this, Observer {
            if (it == true) {
                SpotifyService.connect(this) {
                    startActivity(viewModel.setIntent(this))
                }
                viewModel.finishedConnecting()
            }
        })
    }
}
