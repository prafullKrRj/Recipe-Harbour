package com.prafullkumar.recipeharbour.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.prafullkumar.recipeharbour.data.local.entities.HistoryNameEntity
import com.prafullkumar.recipeharbour.model.singleRecipeDto.Converters
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto


@Database(
    entities = [HistoryNameEntity::class, SingleRecipeDto::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    abstract fun historyDao(): AppDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context) : AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "history_db")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}