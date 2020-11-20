package ar.com.emanuellopez.melisearch.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchTerm(val term: String) : Parcelable