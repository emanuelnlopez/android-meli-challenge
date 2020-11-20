package ar.com.emanuellopez.melisearch.search

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.com.emanuellopez.melisearch.network.SearchTerm

class SearchViewModel : ViewModel(), Observable {
    @Bindable
    val searchString = MutableLiveData<String>()

    private val _searchTerm = MutableLiveData<SearchTerm>()
    val searchTerm: LiveData<SearchTerm>
        get() = _searchTerm

    fun searchProducts() {
        _searchTerm.value = SearchTerm(searchString.value!!)
    }

    fun searchProductsComplete() {
        _searchTerm.value = null
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}