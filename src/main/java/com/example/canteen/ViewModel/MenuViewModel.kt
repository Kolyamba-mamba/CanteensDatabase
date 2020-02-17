package com.example.canteen.ViewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.canteen.Database.AppDatabase
import com.example.canteen.Entity.Dish
import com.example.canteen.Repository.MenuRepository
import com.example.canteen.ui.Client.CanteenMenuFragment
import kotlinx.coroutines.launch
import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MenuViewModel(application: Application, id: Int): AndroidViewModel(application) {
    private val repository: MenuRepository
    val dishes: LiveData<List<Dish>>

    init {
        val menuDao = AppDatabase.getDatabase(application,viewModelScope).menuDao()
        repository = MenuRepository(menuDao, id)
        dishes = repository.allDishes
    }

    class MyFactory(val application: Application, val arg: Int):ViewModelProvider.NewInstanceFactory(){
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MenuViewModel(application, arg) as T
        }
    }

}