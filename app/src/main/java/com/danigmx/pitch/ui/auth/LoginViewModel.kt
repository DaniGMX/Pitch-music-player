/**
 * Created by Daniel Gracia Machado on 2020-01-20.
 */
package com.danigmx.pitch.ui.auth

import android.content.Context
import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.danigmx.pitch.App

class LoginViewModel() : ViewModel() {

    // Encapsulation of connection checking
    private val _connect = MutableLiveData<Boolean>()
    val connect: LiveData<Boolean>
        get() = _connect

    // Initialize connection chech to false
    init {
        _connect.value = false
    }

    // Set connect value on back thread to true
    fun connectWithSpotify() {
        _connect.postValue(true)
    }

    // Make the Intent for the SpotifyService API
    fun setIntent(ctx: Context): Intent {
        return Intent(ctx, App::class.java)
    }
}