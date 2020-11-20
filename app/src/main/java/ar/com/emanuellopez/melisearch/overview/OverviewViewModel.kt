package ar.com.emanuellopez.melisearch.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.com.emanuellopez.melisearch.network.MeliSearchApi
import ar.com.emanuellopez.melisearch.network.Product
import ar.com.emanuellopez.melisearch.network.SearchTerm
import kotlinx.coroutines.launch

class OverviewViewModel(searchTerm: SearchTerm) : ViewModel() {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    private val _navigateToSelectedProduct = MutableLiveData<Product>()
    val navigateToSelectedProduct: LiveData<Product>
        get() = _navigateToSelectedProduct

    init {
        searchProducts(searchTerm)
    }

    private fun searchProducts(searchTerm: SearchTerm) {
        viewModelScope.launch {
            try {
                val response = MeliSearchApi.retrofitService.searchProducts(searchTerm.term)
                _products.value = response.results
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun displayProductDetails(product: Product) {
        _navigateToSelectedProduct.value = product
    }

    fun displayProductDetailsComplete() {
        _navigateToSelectedProduct.value = null
    }

}