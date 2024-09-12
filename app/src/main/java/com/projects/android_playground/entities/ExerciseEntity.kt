package com.projects.android_playground.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = WorkoutEntity::class,
            parentColumns = ["id"],
            childColumns = ["workoutId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ExerciseEntity(

    val workoutId: Int,
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var name : String,
    var weight : Float,
    var reps : Int,
    var set : Int
)
