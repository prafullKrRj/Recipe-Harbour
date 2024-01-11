package com.prafullkumar.recipeharbour.model.singleRecipeDto

import com.google.gson.annotations.SerializedName


data class Ingredients (

  @SerializedName("text"         ) var text         : String? = null,
  @SerializedName("quantity"     ) var quantity     : Double?    = null,
  @SerializedName("measure"      ) var measure      : String? = null,
  @SerializedName("food"         ) var food         : String? = null,
  @SerializedName("weight"       ) var weight       : Double? = null,
  @SerializedName("foodCategory" ) var foodCategory : String? = null,
  @SerializedName("foodId"       ) var foodId       : String? = null,
  @SerializedName("image"        ) var image        : String? = null

)