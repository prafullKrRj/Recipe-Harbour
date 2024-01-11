package com.prafullkumar.recipeharbour.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OpenedRecipeHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)
