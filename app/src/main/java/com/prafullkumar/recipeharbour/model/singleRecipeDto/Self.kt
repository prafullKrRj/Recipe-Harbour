package com.prafullkumar.recipeharbour.model.singleRecipeDto

import com.google.gson.annotations.SerializedName


data class Self (

  @SerializedName("title" ) var title : String? = null,
  @SerializedName("href"  ) var href  : String? = null

)