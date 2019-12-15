package com.example.canteen.Repository

import com.example.canteen.DAO.ClientDao
import com.example.canteen.Entity.Client

class ClientRepository(private val clientDao: ClientDao) {

    suspend fun insert(client: Client){
        clientDao.insertClient(client)
    }
}