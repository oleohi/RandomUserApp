package com.example.randomuserapp.presentation.users.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.randomuserapp.R
import com.example.randomuserapp.presentation.ui.theme.RandomUserAppTheme

@Composable
fun SearchView(
    state: MutableState<TextFieldValue>,
    modifier: Modifier = Modifier
) {
    TextField(
        value = state.value,
        onValueChange = { value ->
            state.value = value
        },
        modifier = modifier
            .fillMaxWidth(),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = stringResource(R.string.search_icon_text),
                modifier = modifier.padding(2.dp)
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(10.dp),
        placeholder = {
            Text(text = "Search for name, email, phone...")
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SearchPreview() {
    val state = remember { mutableStateOf(TextFieldValue("")) }
    RandomUserAppTheme {
        SearchView(state = state)
    }
}