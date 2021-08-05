package com.example.cadernodereceitas.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cadernodereceitas.entities.ListCategoryRemote
import com.example.cadernodereceitas.network.CategoriesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class CategoryViewModel : ViewModel(){

    val listCategories = MutableLiveData<ListCategoryRemote>()

    fun getCategories(){
        viewModelScope.launch {
            try{
                listCategories.value = getListCategories()
            } catch (e: Exception){
                Log.e("MainViewModel", e.toString())
            }
        }
    }

    private suspend fun getListCategories(): ListCategoryRemote {
        return withContext(Dispatchers.IO){
            CategoriesService.service.getCategories()
        }
    }

}