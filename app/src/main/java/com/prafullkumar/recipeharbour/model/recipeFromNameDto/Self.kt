package com.prafullkumar.recipeharbour.model.recipeFromNameDto

import com.google.gson.annotations.SerializedName


data class Self (

  @SerializedName("title" ) var title : String? = null,
  @SerializedName("href"  ) var href  : String? = null

)