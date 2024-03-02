import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.harmonyharvest.Screens
import com.example.harmonyharvest.ui.theme.HarmonyHarvestTheme
import com.example.harmonyharvest.ui.theme.YellowCK

@Composable
fun Notification() {
    var donationAmount by remember { mutableStateOf("0") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        DonationHeader()

        Spacer(modifier = Modifier.height(16.dp))

        // Donation amount input
        TextField(
            value = donationAmount,
            onValueChange = {
                // Validate the input if needed
                donationAmount = it
            },
            label = { Text("Enter Amount") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Donation options
        DonationOption(
            icon = Icons.Default.Add,
            title = "General Donation",
            description = "Support community food initiatives"
        )

        Spacer(modifier = Modifier.height(8.dp))

        DonationOption(
            icon = Icons.Default.FavoriteBorder,
            title = "Essential Items Fund",
            description = "Contribute towards purchasing essential items for those in need"
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Donate button
        Button(
            onClick = {
                // Handle donation action
//                handleDonation(donationAmount)
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text("Donate", fontWeight = FontWeight.Bold)
        }
    }
}
@Composable
fun DonationOption(
    icon: ImageVector,
    title: String,
    description: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { /* Handle option selection if needed */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(40.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = title, fontWeight = FontWeight.Bold)
            Text(text = description, color = Color.Gray)
        }
    }
}

@Composable
fun DonationHeader() {
    Text(
        text = "Make a Donation",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = YellowCK
    )
}
@Composable
fun handleDonation(amount: String) {
    // Simulating a successful donation
    val context = LocalContext.current
    Toast.makeText(context, "Donation of $$amount Successful!", Toast.LENGTH_SHORT).show()
}