package ar.com.emanuellopez.melisearch.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ar.com.emanuellopez.melisearch.R
import ar.com.emanuellopez.melisearch.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by lazy {
        ViewModelProvider(this).get(SearchViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSearchBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.searchViewModel = searchViewModel

        searchViewModel.searchTerm.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(SearchFragmentDirections.actionShowOverview(it))
                searchViewModel.searchProductsComplete()
            }
        })
        return binding.root

    }
}