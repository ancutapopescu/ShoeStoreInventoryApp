package com.udacity.shoestore.models

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val shoeListViewModel: ShoeListViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        //First review suggestion: You can use Kotlin scope functions to write it in more concise way.
        /*binding.shoe = Shoe("", 0.0, "", "", mutableListOf())
        binding.shoeViewModel = shoeListViewModel
        binding.lifecycleOwner = this*/

        with(binding){
            shoe = Shoe("", 0.0, "", "", mutableListOf())
            shoeViewModel = shoeListViewModel
            lifecycleOwner = this@ShoeDetailFragment
        }

        shoeListViewModel.shoeSaved.observe(viewLifecycleOwner) {   isShoeSaved ->
/* When we have new data, we will navigate back using the navigateUp() method and since ViewModel is shared, the newly added data will be automatically observed and displayed.
            */
            if(isShoeSaved) {
                findNavController().popBackStack()
                shoeListViewModel.onShoeSaved()
            }
        }

        //Second review
        /*binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }*/

        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().popBackStack()
        }

        return binding.root
    }
}