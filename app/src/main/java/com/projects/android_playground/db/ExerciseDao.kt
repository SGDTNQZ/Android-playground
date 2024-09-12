package com.projects.android_playground.db

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.projects.android_playground.entities.ExerciseEntity

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM ExerciseEntity")
    suspend fun getAllExercises(): List<ExerciseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: ExerciseEntity)

    @Query("DELETE FROM ExerciseEntity WHERE id = :id")
    fun deleteExercise(id : Int)
}