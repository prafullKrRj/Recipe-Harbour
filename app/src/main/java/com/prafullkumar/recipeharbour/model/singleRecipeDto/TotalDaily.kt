package com.prafullkumar.recipeharbour.model.singleRecipeDto

import com.google.gson.annotations.SerializedName


data class TotalDaily (

  @SerializedName("ENERC_KCAL" ) var ENERCKCAL : ENERCKCAL? = ENERCKCAL(),
  @SerializedName("FAT"        ) var FAT       : FAT?       = FAT(),
  @SerializedName("FASAT"      ) var FASAT     : FASAT?     = FASAT(),
  @SerializedName("CHOCDF"     ) var CHOCDF    : CHOCDF?    = CHOCDF(),
  @SerializedName("FIBTG"      ) var FIBTG     : FIBTG?     = FIBTG(),
  @SerializedName("PROCNT"     ) var PROCNT    : PROCNT?    = PROCNT(),
  @SerializedName("CHOLE"      ) var CHOLE     : CHOLE?     = CHOLE(),
  @SerializedName("NA"         ) var NA        : NA?        = NA(),
  @SerializedName("CA"         ) var CA        : CA?        = CA(),
  @SerializedName("MG"         ) var MG        : MG?        = MG(),
  @SerializedName("K"          ) var K         : K?         = K(),
  @SerializedName("FE"         ) var FE        : FE?        = FE(),
  @SerializedName("ZN"         ) var ZN        : ZN?        = ZN(),
  @SerializedName("P"          ) var P         : P?         = P(),
  @SerializedName("VITA_RAE"   ) var VITARAE   : VITARAE?   = VITARAE(),
  @SerializedName("VITC"       ) var VITC      : VITC?      = VITC(),
  @SerializedName("THIA"       ) var THIA      : THIA?      = THIA(),
  @SerializedName("RIBF"       ) var RIBF      : RIBF?      = RIBF(),
  @SerializedName("NIA"        ) var NIA       : NIA?       = NIA(),
  @SerializedName("VITB6A"     ) var VITB6A    : VITB6A?    = VITB6A(),
  @SerializedName("FOLDFE"     ) var FOLDFE    : FOLDFE?    = FOLDFE(),
  @SerializedName("VITB12"     ) var VITB12    : VITB12?    = VITB12(),
  @SerializedName("VITD"       ) var VITD      : VITD?      = VITD(),
  @SerializedName("TOCPHA"     ) var TOCPHA    : TOCPHA?    = TOCPHA(),
  @SerializedName("VITK1"      ) var VITK1     : VITK1?     = VITK1()

)