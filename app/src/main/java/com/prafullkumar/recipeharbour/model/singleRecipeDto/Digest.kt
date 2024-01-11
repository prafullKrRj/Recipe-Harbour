package com.prafullkumar.recipeharbour.model.singleRecipeDto

import com.google.gson.annotations.SerializedName


data class Digest (

  @SerializedName("label"        ) var label        : String?        = null,
  @SerializedName("tag"          ) var tag          : String?        = null,
  @SerializedName("schemaOrgTag" ) var schemaOrgTag : String?        = null,
  @SerializedName("total"        ) var total        : Double?        = null,
  @SerializedName("hasRDI"       ) var hasRDI       : Boolean?       = null,
  @SerializedName("daily"        ) var daily        : Double?        = null,
  @SerializedName("unit"         ) var unit         : String?        = null,
  @SerializedName("sub"          ) var sub          : ArrayList<Sub> = arrayListOf()

)