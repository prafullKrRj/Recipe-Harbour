package com.prafullkumar.recipeharbour.model.recipeFromNameDto

import com.google.gson.annotations.SerializedName


data class RecipeFromNameDto (

  @SerializedName("from"   ) var from  : Int?            = null,
  @SerializedName("to"     ) var to    : Int?            = null,
  @SerializedName("count"  ) var count : Int?            = null,
  @SerializedName("_links" ) var Links : Links?          = Links(),
  @SerializedName("hits"   ) var hits  : ArrayList<Hits> = arrayListOf()
)