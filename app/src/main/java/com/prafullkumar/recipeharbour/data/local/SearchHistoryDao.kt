package com.prafullkumar.recipeharbour.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prafullkumar.recipeharbour.data.local.entities.HistoryNameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SearchHistoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoryName(name: HistoryNameEntity)

    @Query("SELECT * FROM history_name_table ORDER BY time DESC")
    fun getAllHistory(): Flow<List<HistoryNameEntity>>
}