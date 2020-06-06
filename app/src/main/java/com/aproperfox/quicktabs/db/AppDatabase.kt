package com.aproperfox.quicktabs.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aproperfox.quicktabs.models.Project
import java.lang.IllegalArgumentException

@Database(entities = [Project::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun projectDao(): ProjectDao

    companion object {
        const val DB_NAME = "quick_tabs"

        @Volatile
        private var instance: AppDatabase? = null

        fun instantiate(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        fun get(): AppDatabase =
            instance ?: throw IllegalArgumentException("AppDatabase instance hasn't been set")

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
        }
    }
}