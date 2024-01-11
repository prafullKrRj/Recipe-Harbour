package com.prafullkumar.recipeharbour.model.singleRecipeDto

import com.google.gson.annotations.SerializedName


data class NA (

  @SerializedName("label"    ) var label    : String? = null,
  @SerializedName("quantity" ) var quantity : Double? = null,
  @SerializedName("unit"     ) var unit     : String? = null

)