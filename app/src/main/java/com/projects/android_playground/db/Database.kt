package com.projects.android_playground.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.projects.android_playground.Converters
import com.projects.android_playground.entities.WorkoutEntity
import com.projects.android_playground.entities.ExerciseEntity


@Database(entities = [WorkoutEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class Database : RoomDatabase() {
    companion object{
        const val NAME = "Workout_DB"
    }

    abstract fun getWorkoutDao() : WorkoutDao
//    abstract fun getExerciseDao(): ExerciseDao

}