package com.prafullkumar.recipeharbour.model.singleRecipeDto

import com.google.gson.annotations.SerializedName


data class REGULAR (

  @SerializedName("url"    ) var url    : String? = null,
  @SerializedName("width"  ) var width  : Double?    = null,
  @SerializedName("height" ) var height : Double?    = null

)