package com.example.randomuserapp.presentation.users.ui_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.randomuserapp.R
import com.example.randomuserapp.data.remote.dto.Name
import com.example.randomuserapp.data.remote.dto.Picture
import com.example.randomuserapp.domain.models.RandomUser
import com.example.randomuserapp.presentation.ui.theme.RandomUserAppTheme

@Composable
fun UserItem(user: RandomUser, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Random",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .border(1.5.dp, Color.LightGray, CircleShape)
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "${user.name.first} ${user.name.last}",
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Email: ${user.email}",
                style = MaterialTheme.typography.subtitle1,
            )
            Text(
                text = "Phone Number: ${user.phone}",
                style = MaterialTheme.typography.subtitle1,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserItem() {
    RandomUserAppTheme {
        UserItem(
            user = RandomUser(
                email = "oleohialli@gmail.com",
                name = Name("Oleohi", "Alli", "Mr"),
                phone = "08039389339",
                picture = Picture(
                    "https://randomuser.me/api/portraits/men/78.jpg",
                    "https://randomuser.me/api/portraits/med/men/78.jpg",
                    "https://randomuser.me/api/portraits/thumb/men/78.jpg"
                )
            )
        )
    }
}