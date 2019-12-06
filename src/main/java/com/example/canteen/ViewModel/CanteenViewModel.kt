package com.example.canteen.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.canteen.Database.AppDatabase
import com.example.canteen.Entity.Canteen
import com.example.canteen.Repository.CanteenRepository
import kotlinx.coroutines.launch

class CanteenViewModel(application: Application): AndroidViewModel(application){
    private val repository: CanteenRepository
    val allCanteens: LiveData<List<Canteen>>

    init {
        val canteenDao = AppDatabase.getDatabase(application, viewModelScope).canteenDao()
        repository = CanteenRepository(canteenDao)
        allCanteens = repository.allCanteen
    }

    fun insert(canteen: Canteen) = viewModelScope.launch {
        repository.insert(canteen)
    }
}