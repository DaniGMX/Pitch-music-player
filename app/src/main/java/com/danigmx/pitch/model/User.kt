/**
 * Created by Daniel Gracia Machado on 2020-01-15.
 */
package com.danigmx.pitch.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey var id: Long,
    var username: String,
    var email: String
)