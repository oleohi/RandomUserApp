package com.example.randomuserapp.presentation.users.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.randomuserapp.R
import com.example.randomuserapp.domain.models.RandomUser
import com.example.randomuserapp.presentation.ui.theme.RandomUserAppTheme
import com.example.randomuserapp.presentation.users.UserViewModel
import java.util.*

@Composable
fun UsersScreen(
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = hiltViewModel()
) {
    val state by viewModel.state
    val textState = remember { mutableStateOf(TextFieldValue("")) }

    val users: ArrayList<RandomUser> = arrayListOf()
    state.allUsers.forEach { users.add(it) }
    var filteredList: ArrayList<RandomUser>

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.search_text),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(24.dp))

        SearchView(state = textState)

        Spacer(modifier = Modifier.height(24.dp))

        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                val searchedText = textState.value.text
                filteredList = if (searchedText.isEmpty()) {
                    users
                } else {
                    val resultList = ArrayList<RandomUser>()
                    for (user in users) {
                        val fullName = "${user.name.first} ${user.name.last}"
                        if (fullName.contains(searchedText, true) ||
                            user.email.contains(searchedText, true)
                        ) {
                            resultList.add(user)
                        }
                    }
                    resultList
                }
                items(filteredList) { user ->
                    UserItem(user = user)
                }
            }

            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserScreenPreview() {
    RandomUserAppTheme {
        UsersScreen()
    }
}