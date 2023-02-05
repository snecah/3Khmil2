package com.example.movies.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FilmDatabaseDao {
    @Insert
    fun insert(movie:Film)

    @Update
    fun update(movie: Film)

    @Query("SELECT * FROM film_properties_table")
    fun getAllMovies(): LiveData<List<Film>>
}


////@Database(entities = [Film::class], version = 1, exportSchema = false)
//abstract class FilmDatabase : RoomDatabase() {
//
//    abstract val filmDatabaseDao: FilmDatabaseDao
//
//    companion object {
//
//        @Volatile
//        private var INSTANCE: FilmDatabase? = null
//
//        fun getInstance(context: Context): FilmDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        FilmDatabase::class.java,
//                        "sleep_history_database"
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }
//}