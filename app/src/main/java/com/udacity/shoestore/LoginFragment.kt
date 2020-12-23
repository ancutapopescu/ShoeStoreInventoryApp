package com.udacity.shoestore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_login, container, false)
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.loginButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }
        binding.signupButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_welcomeFragment)
        }

        return binding.root
    }

}