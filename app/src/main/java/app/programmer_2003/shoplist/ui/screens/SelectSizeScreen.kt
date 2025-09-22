package app.programmer_2003.shoplist.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.programmer_2003.shoplist.ui.components.DrawerSheet
import app.programmer_2003.shoplist.ui.components.SelectedSizeDropdown
import app.programmer_2003.shoplist.ui.components.ShopListTopAppBar
import app.programmer_2003.shoplist.ui.theme.FavouritesCardButtonColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectSizeScreen(
  navController: NavController,
) {
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
          title = "Leather boots",
          onMenuClick = {
            scope.launch {
              drawerState.open()
            }
          },
          onAccountClick = {
            scope.launch {}
          },
          color = Color(135, 82, 0)
        )
      },
    ) { paddingValues ->
      Box(
        Modifier
          .fillMaxSize()
          .padding(paddingValues)
      ) {
        Column(
          modifier = Modifier
            .align(Alignment.TopCenter)
            .fillMaxWidth()
        ) {
          Text(
            "Select size",
            fontSize = 24.sp,
            modifier = Modifier
              .padding(top = 28.dp)
              .align(Alignment.CenterHorizontally)
          )
          SelectedSizeDropdown(
            Modifier.padding(
              top = 28.dp,
              start = 83.dp,
              end = 83.dp
            )
          )
          Spacer(modifier = Modifier.weight(1f))
          Button(
            onClick = {
              navController.navigate("count_of_products")
            },
            Modifier
              .align(Alignment.CenterHorizontally)
              .padding(bottom = 36.dp),
            elevation = ButtonDefaults.buttonElevation(
              defaultElevation = 5.dp,
              pressedElevation = 5.dp,
              focusedElevation = 5.dp
            ),
            colors = ButtonDefaults.buttonColors(
              containerColor = FavouritesCardButtonColor,
              contentColor = Color.White
            )
          ) {
            Text("Next")
          }
        }
      }
    }
  }
}
