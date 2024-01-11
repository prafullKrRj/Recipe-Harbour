package com.prafullkumar.recipeharbour.model.singleRecipeDto

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

@Entity
data class SingleRecipeDto (
  @PrimaryKey(autoGenerate = true)
  val id : Int = 0,
  @SerializedName("recipe" ) var recipe : Recipe? = Recipe(),
  @SerializedName("_links" ) var Links  : Links?  = Links()

)
class Converters {
  private val gson = Gson()

  @TypeConverter
  fun fromRecipe(recipe: Recipe?): String {
    return gson.toJson(recipe)
  }

  @TypeConverter
  fun toRecipe(recipeString: String): Recipe? {
    return gson.fromJson(recipeString, Recipe::class.java)
  }

  @TypeConverter
  fun fromLinks(links: Links?): String {
    return gson.toJson(links)
  }

  @TypeConverter
  fun toLinks(linksString: String?): Links {
    return gson.fromJson(linksString, Links::class.java)
  }
}