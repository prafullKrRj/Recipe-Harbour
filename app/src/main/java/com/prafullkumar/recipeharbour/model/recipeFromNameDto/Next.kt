package com.prafullkumar.recipeharbour.model.recipeFromNameDto

import com.google.gson.annotations.SerializedName


data class Next (

  @SerializedName("href"  ) var href  : String? = null,
  @SerializedName("title" ) var title : String? = null

)