package com.projects.android_playground

import androidx.room.TypeConverter
import java.util.Date

class Converters {
    @TypeConverter
    fun toDate(value: Long?) : Date?{
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun fromDate( date: Date?) : Long?{
        return date?.time
    }
}