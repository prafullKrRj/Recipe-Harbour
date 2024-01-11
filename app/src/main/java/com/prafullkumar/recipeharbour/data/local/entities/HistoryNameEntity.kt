package com.prafullkumar.recipeharbour.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_name_table")
data class HistoryNameEntity (
    @PrimaryKey
    val time: Long = System.currentTimeMillis(),
    val name: String
)