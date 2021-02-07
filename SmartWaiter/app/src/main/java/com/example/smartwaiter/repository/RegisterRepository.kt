package com.example.smartwaiter.repository


import com.example.webservice.RetrofitInstance
import com.example.webservice.model.Korisnik
import retrofit2.Response

class RegisterRepository : BaseRepository() {

    suspend fun RegisterKorisnik(
        table: String,
        method: String,
        username: String,
        firstName: String,
        lastName: String,
        email: String,
        userType: String,
        password: String
    ){
        return RetrofitInstance.api.RegisterKorisnik(table, method, username, firstName, lastName, email, userType, password)
    }

    suspend fun getUsername(
        table: String,
        method: String,
        username: String,
        operator: String,
        email: String
    ): Response<List<Korisnik>> {
        return RetrofitInstance.api.getUsername(table, method, username, operator, email)
    }

}