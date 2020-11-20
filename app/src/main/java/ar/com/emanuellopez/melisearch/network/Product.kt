package ar.com.emanuellopez.melisearch.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val id: String,
    val title: String,
    val price: Double,
    val thumbnail: String,
    val permalink: String
) : Parcelable