package app.programmer_2003.shoplist.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.programmer_2003.shoplist.R
import app.programmer_2003.shoplist.ui.components.ShopListCard
import app.programmer_2003.shoplist.ui.components.DrawerSheet
import app.programmer_2003.shoplist.ui.components.ShopListTopAppBar
import kotlinx.coroutines.launch
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import app.programmer_2003.shoplist.ui.theme.FABColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopListScreen(
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
          title = "Shop list",
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
      floatingActionButton = {
        FloatingActionButton(
          onClick = {},
          containerColor = FABColor
        ) {
          Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(R.drawable.fab_icon),
            contentDescription = "",
          )
        }
      }
    ) { paddingValues ->
      val scrollState = rememberScrollState()
      Column(
        modifier = Modifier
          .padding(paddingValues)
          .fillMaxSize()
          .verticalScroll(scrollState),
      ) {
        Spacer(Modifier.height(17.dp))
        ShopListCard(
          cardImage = R.drawable.card_image,
          title = "Leather boots",
          price = "27,5 $",
          description = "Great warm shoes from the artificial leather. You can buy this model only in our shop",
          onBuyClick = {},
          onAddToFavoriteClick = {},
          onCardClick = {
            navController.navigate("selected_size")
          }
        )
        ShopListCard(
          cardImage = R.drawable.card_image,
          title = "Leather boots",
          price = "27,5 $",
          description = "Great warm shoes from the artificial leather. You can buy this model only in our shop",
          onBuyClick = {},
          onAddToFavoriteClick = {},
          onCardClick = {
            navController.navigate("selected_size")
          }
        )
      }
    }
  }
}
