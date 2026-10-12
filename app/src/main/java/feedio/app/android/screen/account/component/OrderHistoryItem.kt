package feedio.app.android.screen.account.component

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import feedio.app.android.ui.theme.PlusJakartaSans

@Composable
fun OrderHistoryItem(
    modifier: Modifier,
    imgRes: String,
    name: String,
    date: String,
    status: String,
    price: String
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(id = feedio.app.android.R.drawable.ic_launcher_background),
            contentDescription = "",
            modifier = Modifier
                .padding(12.dp)
                .size(80.dp)
                .clip(shape = RoundedCornerShape(15.dp))
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)        ) {
            Text(
                text = name,
                color = Color.Black,
                fontFamily = PlusJakartaSans,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Text(
                text = date,
                color = Color.Gray,
                fontFamily = PlusJakartaSans,
                fontSize = 14.sp
            )
            Text(
                text = status,
                color = Color.Green,
                fontFamily = PlusJakartaSans,
                fontSize = 14.sp
            )
        }

        Text(
            text = price,
            color = Color.Black,
            fontFamily = PlusJakartaSans,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            modifier = Modifier.padding(end = 16.dp)
        )
    }

}

@Composable
fun orderItemPreview() {
    OrderHistoryItem(
        modifier = Modifier,
        imgRes = "",
        name = "The Burger Joint",
        date = "Dec 12, 2023",
        status = "Delivered",
        price = "$240.00"
    )
}