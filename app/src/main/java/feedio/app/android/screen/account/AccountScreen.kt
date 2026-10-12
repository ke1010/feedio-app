package feedio.app.android.screen.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import feedio.app.android.R
import feedio.app.android.ui.theme.PlusJakartaSans

@Composable
fun AccountScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        UserProfileHeader()
        OrderHistoryCard()
        AccountsAndPreferences()
        LogoutButton()
    }
}

@Composable
fun UserProfileHeader() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(25.dp))
            )
            Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    text = "User",
                    color = Color.Black,
                    fontFamily = PlusJakartaSans,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "73201725",
                    color = Color.DarkGray,
                    fontFamily = PlusJakartaSans,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun OrderHistoryCard() {
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        Icon(painter = painterResource(R.drawable.previous_icon),
            contentDescription = null,
            modifier = Modifier.padding(10.dp))

        Text(text = "Past Order",
            color = Color.Gray,
            fontFamily = PlusJakartaSans,
            fontSize = 14.sp)

        Spacer(modifier = Modifier.weight(1f))

        Text(text = "View Details",
            color = Color.Green,
            fontFamily = PlusJakartaSans,
            fontSize = 14.sp,)
    }

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Order Item",
                modifier = Modifier
                    .padding(8.dp)
                    .size(70.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = "The Burger Joint",
                    color = Color.Black,
                    fontFamily = PlusJakartaSans,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
                Text(
                    text = "Dec 12, 2023",
                    color = Color.Gray,
                    fontFamily = PlusJakartaSans,
                    fontSize = 13.sp
                )
                Text(
                    text = "Delivered",
                    color = Color.Green,
                    fontFamily = PlusJakartaSans,
                    fontSize = 13.sp
                )
            }

            Text(
                text = "$24.50",
                color = Color.Black,
                fontFamily = PlusJakartaSans,
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp,
                modifier = Modifier.padding(end = 12.dp)
            )
        }
    }
}

@Composable
fun AccountsAndPreferences() {
    Text(text = "ACCOUNTS & PREFERENCES",
        color = Color.Gray,
        fontSize = 14.sp,
        fontFamily = PlusJakartaSans)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            PreferenceRow(title = "Order & Invoices", subtitle = "Order history and receipts", R.drawable.invoice)
            PreferenceRow(title = "Favourites", subtitle = "Saved dishes & handpicked eateries", R.drawable.heart_icon)
            PreferenceRow(title = "Delivery Addresses", subtitle = "Home, Office and other saved spots", R.drawable.location)
            PreferenceRow(title = "Terms & Privacy Policy", subtitle = "License & legal documentation", R.drawable.information)
        }
    }
}

@Composable
fun PreferenceRow(title: String, subtitle: String, icon: Int) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Box(
            modifier = Modifier
                .padding(end = 12.dp)
                .clip(RoundedCornerShape(8.dp))
                .size(36.dp)
                .background(color = Color.Gray),
            contentAlignment = Alignment.Center,

        ) {
            Icon(
                painter = painterResource(icon),
                contentDescription = null
            )
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontFamily = PlusJakartaSans,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = subtitle,
                fontFamily = PlusJakartaSans,
                color = Color.Gray,
                fontSize = 12.sp,
            )
        }
        Icon(
            painter = painterResource(R.drawable.right_icon), // Replace with your right_icon
            contentDescription = "Navigate",
            modifier = Modifier.size(16.dp),
            tint = Color.Gray
        )
    }
}

@Composable
fun LogoutButton() {
    Card(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,

            ) {

            Icon(painter = painterResource(R.drawable.logout),
                contentDescription = null,
                modifier = Modifier.padding(end = 10.dp))

            Text(
                text = "Logout",
                fontFamily = PlusJakartaSans,
                color = Color.Red,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
    }
}
