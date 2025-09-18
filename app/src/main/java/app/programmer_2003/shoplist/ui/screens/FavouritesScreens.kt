package app.programmer_2003.shoplist.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.programmer_2003.shoplist.ui.components.DrawerSheet
import app.programmer_2003.shoplist.ui.components.ShopListTopAppBar
import app.programmer_2003.shoplist.ui.theme.CardButtonColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesScreens(
  navController: NavController,
) {
  // Drawer state
  val drawerState = rememberDrawerState(DrawerValue.Closed)
  val scope = rememberCoroutineScope()

  ModalNavigationDrawer(
    drawerState = drawerState,
    drawerContent = {
      DrawerSheet(navController)
    }
  ) {
    Scaffold(
      topBar = {
        ShopListTopAppBar(
          title = "Favourites",
          onMenuClick = {
            scope.launch {
              drawerState.open()
            }
          },
          onAccountClick = {
            scope.launch {}
          }
        )
      },
    ) { paddingValues ->
      val scrollState = rememberScrollState()
      Box(
        Modifier
          .fillMaxSize()
          .padding(paddingValues)
      ) {
        Column(
          Modifier
            .padding(bottom = 80.dp) // Adjust bottom padding to make space for the button
            .verticalScroll(scrollState)
        ) {
          // Your content goes here
        }

        Button(
          onClick = {},
          modifier = Modifier
            .align(Alignment.BottomCenter),
          elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 8.dp,
            pressedElevation = 12.dp,
            focusedElevation = 10.dp
          ),
          colors = ButtonDefaults.buttonColors(
            containerColor = CardButtonColor,
            contentColor = Color.White
          )
        ) {
          Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add Icon"
          )
          Spacer(Modifier.width(5.dp))
          Text("Buy")
        }
      }
    }
  }
}
