package ar.com.emanuellopez.melisearch.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ar.com.emanuellopez.melisearch.network.Product

class DetailsViewModelFactory(private val product: Product): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailsViewModel::class.java)) {
            return DetailsViewModel(product) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}