/**
 * Created by Daniel Gracia Machado on 2020-01-21.
 */
package com.danigmx.pitch.data.models

data class User(
    var userId: Long,
    var username: String,
    var country: String,
    var email: String,
    var birthday: String
)