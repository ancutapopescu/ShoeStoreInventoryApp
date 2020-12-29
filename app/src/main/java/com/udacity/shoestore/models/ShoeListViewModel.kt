package com.udacity.shoestore.models

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.navigateUp



class ShoeListViewModel : ViewModel() {

    val shoeName = MutableLiveData<String>()
    val shoeSize = MutableLiveData<String>()
    val shoeCompany = MutableLiveData<String>()
    val shoeDescription = MutableLiveData<String>()

    var shoe: Shoe = Shoe("", 0.0, "", "", mutableListOf())
        get() = field.apply {
            name = shoeName.value!!
            size = shoeSize.value?.toDouble() ?: 0.0
            company = shoeCompany.value!!
            description = shoeDescription.value!!
        }

    //create the list
    private val shoesList: MutableList<Shoe> = mutableListOf()

    //create the live data
    private val _shoeData = MutableLiveData<List<Shoe>>()
    val shoeData : LiveData<List<Shoe>>
        get() = _shoeData

    private val _shoeSaved = MutableLiveData<Boolean>()
    val shoeSaved: LiveData<Boolean>
        get() = _shoeSaved


    init {

           }


    fun addShoe(v:View, shoe: Shoe) {
        shoesList.add(shoe)
        _shoeData.value = shoesList
        _shoeSaved.value = true
        navigateUp(v)
    }

    fun navigateUp(v: View){
        v.findNavController().navigateUp()
    }


    fun onShoeSaved() {
        _shoeSaved.value = false
    }


}

