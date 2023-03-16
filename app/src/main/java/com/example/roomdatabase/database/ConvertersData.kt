package com.example.roomdatabase.database

import androidx.room.TypeConverter
import java.util.*

class ConvertersData {
    @TypeConverter
    fun dateToLong(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun longToDate(long: Long): Date {
        return Date(long)
    }
}