package com.prafullkumar.recipeharbour.model.recipeFromNameDto

import com.google.gson.annotations.SerializedName


data class CHOCDF (

  @SerializedName("label"    ) var label    : String? = null,
  @SerializedName("quantity" ) var quantity : Double? = null,
  @SerializedName("unit"     ) var unit     : String? = null

)