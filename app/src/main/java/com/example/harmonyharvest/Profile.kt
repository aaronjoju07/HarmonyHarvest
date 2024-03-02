package com.example.harmonyharvest

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface

import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.harmonyharvest.ui.theme.HarmonyHarvestTheme
import com.example.harmonyharvest.ui.theme.YellowCK

@Composable
fun Profile() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                ProfileHeader()
                Spacer(modifier = Modifier.height(16.dp))
                ProfileDetails()
            }
        }
    }
}

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // You can replace the placeholder image with the actual user avatar
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .padding(8.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = "John Doe", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Community Kitchen Member", fontSize = 14.sp, color = YellowCK)
        }
    }
}

@Composable
fun ProfileDetails() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        ProfileItem(Icons.Default.Person, "Username", "john_doe")
        Spacer(modifier = Modifier.height(8.dp))
        ProfileItem(Icons.Default.Email, "Email", "john.doe@example.com")
        Spacer(modifier = Modifier.height(8.dp))
        ProfileItem(Icons.Default.Phone, "Phone", "+1 123-456-7890")
        Spacer(modifier = Modifier.height(8.dp))
        ProfileItem(Icons.Default.LocationOn, "Location", "City, Country")
        Spacer(modifier = Modifier.height(16.dp))
        ProfileItem(Icons.Default.Settings, "Account Settings")
        Spacer(modifier = Modifier.height(8.dp))
        ProfileItem(Icons.Default.Edit, "Edit Profile")
        Spacer(modifier = Modifier.height(8.dp))
        ProfileItem(Icons.Default.Send, "Logout")
    }
}

@Composable
fun ProfileItem(icon: ImageVector, label: String, value: String? = null) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null)
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = label, fontWeight = FontWeight.Bold)
            if (value != null) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = value, color = YellowCK)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    HarmonyHarvestTheme {
        Profile()
    }
}
