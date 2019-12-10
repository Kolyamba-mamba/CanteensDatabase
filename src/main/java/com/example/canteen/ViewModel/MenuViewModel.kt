package com.example.canteen.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.canteen.Database.AppDatabase
import com.example.canteen.Entity.Dish
import com.example.canteen.Repository.MenuRepository
import kotlinx.coroutines.launch

class MenuViewModel(application: Application): AndroidViewModel(application) {
    private val repository: MenuRepository
    val dishes: LiveData<List<Dish>>

    init {
        val menuDao = AppDatabase.getDatabase(application,viewModelScope).menuDao()
        repository = MenuRepository(menuDao)
        dishes = repository.allDishes
    }

    fun insert(dish: Dish) = viewModelScope.launch {
        repository.insert(dish)
    }

}