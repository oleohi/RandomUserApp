package com.example.randomuserapp.presentation.users.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.disk.DiskCache
import coil.request.ImageRequest
import coil.size.Size
import com.example.randomuserapp.R
import com.example.randomuserapp.data.remote.dto.Name
import com.example.randomuserapp.data.remote.dto.Picture
import com.example.randomuserapp.domain.models.RandomUser
import com.example.randomuserapp.presentation.ui.theme.RandomUserAppTheme

@Composable
fun UserItem(user: RandomUser, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize()) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(user.picture.large)
                    .size(Size.ORIGINAL)
                    .placeholder(R.drawable.ic_person_24)
                    .error(R.drawable.ic_error_24)
                    .build(),
                    contentScale = ContentScale.Crop
                ),
                contentDescription = "Random User",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.LightGray, CircleShape)
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
                    text = user.email,
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    text = user.phone,
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.SemiBold,
                )
            }
        }
        Divider(modifier = modifier.padding(bottom = 8.dp))
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