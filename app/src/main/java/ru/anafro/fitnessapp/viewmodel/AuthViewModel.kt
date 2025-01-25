package ru.anafro.fitnessapp.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.anafro.fitnessapp.network.ApiService
import ru.anafro.fitnessapp.models.User
import ru.anafro.fitnessapp.utils.TokenManager
import retrofit2.Response

class AuthViewModel(
    private val apiService: ApiService,
    private val tokenManager: TokenManager
) : ViewModel() {

    fun login(user: User, onSuccess: (String) -> Unit, onError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = apiService.login(user)
                if (response.isSuccessful) {
                    response.body()?.let {
                        tokenManager.saveToken(it.token)
                        onSuccess(it.token)
                    }
                } else {
                    onError("Login failed")
                }
            } catch (e: Exception) {
                onError("Error: ${e.message}")
            }
        }
    }

    fun logout(onSuccess: () -> Unit, onError: (String) -> Unit) {
        val token = tokenManager.getToken()
        if (token != null) {
            viewModelScope.launch {
                try {
                    val response = apiService.logout("Bearer $token")
                    if (response.isSuccessful) {
                        tokenManager.removeToken()
                        onSuccess()
                    } else {
                        onError("Logout failed")
                    }
                } catch (e: Exception) {
                    onError("Error: ${e.message}")
                }
            }
        }
    }
}
