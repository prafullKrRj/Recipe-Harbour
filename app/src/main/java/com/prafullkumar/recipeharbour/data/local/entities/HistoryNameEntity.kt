package com.prafullkumar.recipeharbour.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_name_table")
data class HistoryNameEntity (
    val time: Long = System.currentTimeMillis(),
    @PrimaryKey
    val name: String
)