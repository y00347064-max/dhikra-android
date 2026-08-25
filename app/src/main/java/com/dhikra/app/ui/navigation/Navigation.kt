package com.dhikra.app.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

seal class NavigationItem(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val arabicLabel: String
) {
    data object Home : NavigationItem(
        route = "home",
        label = "Home",
        icon = Icons.Default.Home,
        arabicLabel = "الرئيسية"
    )

    data object Quran : NavigationItem(
        route = "quran",
        label = "Quran",
        icon = Icons.Default.Info,
        arabicLabel = "القرآن"
    )

    data object Azkar : NavigationItem(
        route = "azkar",
        label = "Azkar",
        icon = Icons.Default.Info,
        arabicLabel = "الأذكار"
    )

    data object Prayer : NavigationItem(
        route = "prayer",
        label = "Prayer",
        icon = Icons.Default.Info,
        arabicLabel = "الصلاة"
    )

    data object More : NavigationItem(
        route = "more",
        label = "More",
        icon = Icons.Default.Menu,
        arabicLabel = "المزيد"
    )
}

val bottomNavItems = listOf(
    NavigationItem.Home,
    NavigationItem.Quran,
    NavigationItem.Azkar,
    NavigationItem.Prayer,
    NavigationItem.More
)
