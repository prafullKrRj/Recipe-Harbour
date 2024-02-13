package com.prafullkumar.recipeharbour.data.local.entities

import androidx.room.Entity
import com.prafullkumar.recipeharbour.model.singleRecipeDto.SingleRecipeDto

@Entity(primaryKeys = ["uniqueId"])
data class HistoryEntity(
    val uniqueId: String = "",
    val time: Long = System.currentTimeMillis(),
    val isFavourite: Boolean = false,
    val singleRecipeDto: SingleRecipeDto? = SingleRecipeDto()
)
