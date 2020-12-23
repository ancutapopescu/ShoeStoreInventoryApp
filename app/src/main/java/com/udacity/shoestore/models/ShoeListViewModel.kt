package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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



    init {

           }


    fun addShoe(shoe: Shoe) {
        shoesList.add(shoe)
        _shoeData.value = shoesList
    }

}