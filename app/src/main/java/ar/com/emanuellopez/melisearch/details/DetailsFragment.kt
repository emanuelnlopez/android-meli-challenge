package ar.com.emanuellopez.melisearch.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ar.com.emanuellopez.melisearch.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        val product = DetailsFragmentArgs.fromBundle(requireArguments()).selectedProduct
        val viewModelFactory = DetailsViewModelFactory(product)
        binding.detailsViewModel = ViewModelProvider(this, viewModelFactory).get(DetailsViewModel::class.java)
        return binding.root
    }

}