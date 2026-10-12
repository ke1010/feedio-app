package feedio.app.android.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import feedio.app.android.R

// Set of Material typography styles to start with

val PlusJakartaSans = FontFamily(
    Font(R.font.plus_jakarta_sans_variable_font, weight = FontWeight.Normal, variationSettings = FontVariation.Settings(FontVariation.weight(FontWeight.Normal.weight))),
    Font(R.font.plus_jakarta_sans_variable_font, weight = FontWeight.Medium, variationSettings = FontVariation.Settings(FontVariation.weight(FontWeight.Medium.weight))),
    Font(R.font.plus_jakarta_sans_variable_font, weight = FontWeight.SemiBold, variationSettings = FontVariation.Settings(FontVariation.weight(FontWeight.SemiBold.weight))),
    Font(R.font.plus_jakarta_sans_variable_font, weight = FontWeight.Bold, variationSettings = FontVariation.Settings(FontVariation.weight(FontWeight.Bold.weight)))
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = PlusJakartaSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

