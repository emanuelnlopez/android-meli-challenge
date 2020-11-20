package ar.com.emanuellopez.melisearch.overview

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.com.emanuellopez.melisearch.network.SearchTerm

class OverviewViewModelFactory(private val searchTerm: SearchTerm) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OverviewViewModel::class.java)) {
            return OverviewViewModel(searchTerm) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}