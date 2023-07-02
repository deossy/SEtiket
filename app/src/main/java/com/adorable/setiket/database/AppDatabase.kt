package com.adorable.setiket.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adorable.setiket.database.dao.DatabaseDao
import com.adorable.setiket.model.ModelDatabase


@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}