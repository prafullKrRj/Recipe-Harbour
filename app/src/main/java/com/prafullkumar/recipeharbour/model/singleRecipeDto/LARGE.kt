package com.prafullkumar.recipeharbour.model.singleRecipeDto

import com.google.gson.annotations.SerializedName


data class LARGE (

  @SerializedName("url"    ) var url    : String? = null,
  @SerializedName("width"  ) var width  : Int?    = null,
  @SerializedName("height" ) var height : Int?    = null

)