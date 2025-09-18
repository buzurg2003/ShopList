package app.programmer_2003.shoplist.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.programmer_2003.shoplist.R
import app.programmer_2003.shoplist.ui.theme.SectionHeaderColor

// Updated DrawerItem data class to use image resources
data class DrawerItem(
  val label: String,
  val iconResId: Int, // Use Int to refer to image resources
  val contentDescription: String,
  val count: Int? = null
)

// Updated drawerItems with image resources (change to your own image resource IDs)
val drawerItems = listOf(
  DrawerItem("Shop list", R.drawable.nav_icon_1, "Shop list"),
  DrawerItem("Favourites", R.drawable.nav_icon_2, "Favourites", count = 3),
  DrawerItem("Profile", R.drawable.nav_icon_3, "Profile"),
  DrawerItem("Settings", R.drawable.nav_icon_4, "Settings")
)

@Composable
fun DrawerSheet(navController: NavController) {
  ModalDrawerSheet {
    Column(
      modifier = Modifier
        .padding(top = 12.dp, end = 12.dp, start = 12.dp)
    ) {
      Text(
        "Title",
        fontSize = 16.sp,
        fontWeight = FontWeight.W600,
        modifier = Modifier.padding(start = 20.dp),
        color = Color(82, 67, 6)
      )
      Spacer(Modifier.height(32.dp))
      Text(
        "Section Header",
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(start = 20.dp),
        color = SectionHeaderColor
      )
      Spacer(Modifier.height(10.dp))

      drawerItems.forEach { item ->
        NavigationDrawerItem(
          label = {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                item.label,
                fontWeight = FontWeight.Bold
              )
              item.count?.let {
                Text(
                  text = it.toString(),
                  style = MaterialTheme.typography.bodyMedium,
                  fontWeight = FontWeight.Bold,
                  color = Color(82, 67, 62),
                )
              }
            }
          },
          selected = false,
          onClick = {
            if (item.label == "Shop list") {
              navController.navigate("home")
            } else if (item.label == "Favourites") {
              navController.navigate("favourites")
            }
          },
          icon = {
            Image(
              painter = painterResource(id = item.iconResId),
              contentDescription = item.contentDescription,
              modifier = Modifier.size(12.dp),
              colorFilter = ColorFilter.tint(Color(44, 22, 13))
            )
          }
        )
      }
    }
  }
}
