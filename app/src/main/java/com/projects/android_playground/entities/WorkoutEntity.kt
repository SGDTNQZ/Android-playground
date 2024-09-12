package com.projects.android_playground.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class WorkoutEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var bodyPart : String,
    var createdAt : Date,
    var isCompleted : Boolean = false
)
