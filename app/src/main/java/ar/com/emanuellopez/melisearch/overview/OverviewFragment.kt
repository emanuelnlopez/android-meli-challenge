package ar.com.emanuellopez.melisearch.overview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import ar.com.emanuellopez.melisearch.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        val searchTerm = OverviewFragmentArgs.fromBundle(requireArguments()).searchTerm
        val viewModelFactory = OverviewViewModelFactory(searchTerm)
        val overviewViewModel = ViewModelProvider(this, viewModelFactory).get(OverviewViewModel::class.java)
        binding.overviewViewModel = overviewViewModel

        binding.productGrid.adapter = ProductGridAdapter(ProductGridAdapter.OnClickListener {
            overviewViewModel.displayProductDetails(it)
        })

        overviewViewModel.navigateToSelectedProduct.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(OverviewFragmentDirections.actionShowDetail(it))
                overviewViewModel.displayPropertyDetailsComplete()
            }
        })
        return binding.root
    }
}