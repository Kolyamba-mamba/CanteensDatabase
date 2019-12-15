package com.example.canteen.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.canteen.Database.AppDatabase
import com.example.canteen.Entity.Client
import com.example.canteen.Repository.ClientRepository
import kotlinx.coroutines.launch

class ClientViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ClientRepository

    init {
        val clientDao = AppDatabase.getDatabase(application, viewModelScope).clientDao()
        repository = ClientRepository(clientDao)
    }

    fun insert(client: Client) = viewModelScope.launch {
        repository.insert(client)
    }
}