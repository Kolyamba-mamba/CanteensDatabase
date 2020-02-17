package com.example.canteen.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.canteen.BasketSingleton
import com.example.canteen.Database.AppDatabase
import com.example.canteen.Entity.Dish
import com.example.canteen.Repository.BasketRepository

class BasketViewModel(application: Application): AndroidViewModel(application){
    private val repository: BasketRepository
    val dishes: LiveData<List<Dish>>

    init {
        val basketDao = AppDatabase.getDatabase(application, viewModelScope).menuDao()
        repository = BasketRepository(basketDao, BasketSingleton.arrayOfDishId)
        dishes = repository.dishes
    }
}