package app.programmer_2003.shoplist.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import app.programmer_2003.shoplist.ui.components.DrawerSheet
import app.programmer_2003.shoplist.ui.components.SelectedSizeDropdown
import app.programmer_2003.shoplist.ui.components.ShopListTopAppBar
import app.programmer_2003.shoplist.ui.components.SwitchButton
import app.programmer_2003.shoplist.ui.theme.FavouritesCardButtonColor
import app.programmer_2003.shoplist.ui.theme.scaffoldBackgroundColor
import kotlinx.coroutines.launch

@Composable
fun CountOfProductScreen(navController: NavController) {
  val drawerState = rememberDrawerState(DrawerValue.Closed)
  val scope = rememberCoroutineScope()
  var isSwitchChecked by remember { mutableStateOf(false) }

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
            scope.launch { drawerState.open() }
          },
          onAccountClick = { },
          color = scaffoldBackgroundColor
        )
      }
    ) { paddingValues ->

      Column(
        modifier = Modifier
          .fillMaxSize()
          .padding(paddingValues)
          .padding(horizontal = 16.dp)
      ) {
        Column(
          modifier = Modifier
            .weight(1f)
            .verticalScroll(rememberScrollState()),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Spacer(modifier = Modifier.height(28.dp))

          Text(
            text = "Count of product",
            fontSize = 24.sp
          )

          Spacer(modifier = Modifier.height(20.dp))

          // Your dropdown
          SelectedSizeDropdown(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 52.dp)
          )

          Spacer(modifier = Modifier.height(40.dp))

          Text(
            text = "Deliver to home?",
            fontSize = 24.sp
          )

          Spacer(modifier = Modifier.height(15.dp))

          // Your switch
          SwitchButton(
            checked = isSwitchChecked,
            onCheckedChange = { newState -> isSwitchChecked = newState }
          )
        }

        // Buttons pinned to bottom
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(
              bottom = 31.dp,
              start = 31.dp,
              end = 31.dp
            ),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          OutlinedButton(
            onClick = {
              navController.popBackStack()
            },
            colors = ButtonDefaults.outlinedButtonColors(
              contentColor = FavouritesCardButtonColor
            ),
            border = BorderStroke(1.dp, FavouritesCardButtonColor)
          ) {
            Text("Back")
          }

          Button(
            onClick = { /* Handle Buy */ },
            colors = ButtonDefaults.buttonColors(
              containerColor = FavouritesCardButtonColor,
              contentColor = Color.White
            )
          ) {
            Text("Buy")
          }
        }
      }
    }
  }
}
