package com.prafullkumar.recipeharbour.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.prafullkumar.recipeharbour.data.local.entities.HistoryNameEntity
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistoryName(name: HistoryNameEntity)

    @Query("SELECT * FROM history_name_table ORDER BY time DESC")
    fun getAllHistory(): Flow<List<HistoryNameEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipe(recipe: SingleRecipeDto)

    @Query("SELECT * FROM SingleRecipeDto ORDER BY id DESC")
    fun getSavedRecipes(): Flow<List<SingleRecipeDto>>
}