package com.example.randomuserapp.presentation.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuserapp.domain.models.RandomUser
import com.example.randomuserapp.domain.use_cases.GetRandomUserUseCase
import com.example.randomuserapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getRandomUserUseCase: GetRandomUserUseCase
) : ViewModel() {

    private val _state = mutableStateOf(UserState())
    val state: State<UserState> = _state

    init {
        getRandomUser()
    }

    private fun getRandomUser() {
        viewModelScope.launch {
            val result = getRandomUserUseCase.execute()
            when(result) {
                is Resource.Success<*> -> {
                    _state.value = UserState(user = result.data as RandomUser)
                }
                is Resource.Error<*> -> {
                    _state.value = UserState(error = result.message.toString())
                }
                is Resource.Loading<*> -> {
                    _state.value = UserState(isLoading = true)
                }
            }
        }

    }
}