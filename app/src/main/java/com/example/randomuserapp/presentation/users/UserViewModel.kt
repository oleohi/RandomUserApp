package com.example.randomuserapp.presentation.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuserapp.domain.models.RandomUser
import com.example.randomuserapp.domain.use_cases.GetRandomUserUseCase
import com.example.randomuserapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
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
        getRandomUserUseCase.execute().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UserState(users = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = UserState(error = result.message.toString())
                }
                is Resource.Loading -> {
                    _state.value = UserState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}