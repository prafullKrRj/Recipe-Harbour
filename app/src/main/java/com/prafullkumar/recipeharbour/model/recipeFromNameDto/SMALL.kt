package com.prafullkumar.recipeharbour.model.recipeFromNameDto

import com.google.gson.annotations.SerializedName


data class SMALL (

  @SerializedName("url"    ) var url    : String? = null,
  @SerializedName("width"  ) var width  : Int?    = null,
  @SerializedName("height" ) var height : Int?    = null

)