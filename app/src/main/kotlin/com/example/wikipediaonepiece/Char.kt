package com.example.wikipediaonepiece
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Char(
    val name: String,
    val description: String,
    val photo: Int,
    val bounty: String,
    val affiliation: String,
    val devilFruit: String,
    val abilities: String,
    val status: String,
    val origin: String,
    val dream: String
) : Parcelable
