package app.programmer_2003.shoplist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.programmer_2003.shoplist.ui.screens.FavouritesScreens
import app.programmer_2003.shoplist.ui.screens.ShopListScreen
import app.programmer_2003.shoplist.ui.theme.Pink
import app.programmer_2003.shoplist.ui.theme.ShopListTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    WindowCompat.getInsetsController(
      window,
      window.decorView
    ).isAppearanceLightStatusBars = true
    setContent {
      ShopListTheme(
        darkTheme = false,
      ) {
        val navController = rememberNavController()
        Scaffold(
          modifier = Modifier.fillMaxSize(),
        ) { innerPadding ->
          NavHost(
            navController = navController,
            startDestination = "favourites",
          ) {
            composable("home") {
              ShopListScreen(navController)
            }
            composable("favourites") {
              FavouritesScreens(navController)
            }
          }
        }
      }
    }
  }
}