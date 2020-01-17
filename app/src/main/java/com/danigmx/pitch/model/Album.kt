/**
 * Created by Daniel Gracia Machado on 2020-01-13.
 */
package com.danigmx.pitch.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Album(
    @PrimaryKey var id: Long,
    val artist: Artist
)