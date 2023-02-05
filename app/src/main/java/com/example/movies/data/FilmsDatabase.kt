package com.example.movies.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movies.FILMS_DATABASE_NAME

@Database(entities = arrayOf(Film::class), version = 1, exportSchema = false)
@TypeConverters(ListTypeConverter::class)
public abstract class FilmsDatabase : RoomDatabase() {

    abstract fun filmsDao(): FilmsDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: FilmsDatabase? = null

        fun getDatabase(context: Context): FilmsDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FilmsDatabase::class.java,
                    FILMS_DATABASE_NAME
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}