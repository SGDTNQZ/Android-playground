package com.projects.android_playground.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.projects.android_playground.entities.WorkoutEntity

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM WORKOUTENTITY")
    fun getWorkout() : LiveData<List<WorkoutEntity>>

    @Insert
    fun addWorkout(workoutEntity: WorkoutEntity)

    @Query("DELETE FROM WORKOUTENTITY WHERE id = :id ")
    fun deleteWorkout(id : Int)

    @Query("SELECT bodyPart FROM WorkoutEntity WHERE id = :id")
    fun getBodyPart(id : Int): LiveData<String>
}