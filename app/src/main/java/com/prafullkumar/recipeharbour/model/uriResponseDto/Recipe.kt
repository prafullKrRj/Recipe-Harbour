package com.prafullkumar.recipeharbour.model.uriResponseDto

import com.google.gson.annotations.SerializedName


data class Recipe (

  @SerializedName("uri" ) var uri : String? = null

)