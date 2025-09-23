package app.programmer_2003.shoplist.ui.screens

import ChatAlert
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import app.programmer_2003.shoplist.R
import app.programmer_2003.shoplist.ui.components.AddToFavourites
import app.programmer_2003.shoplist.ui.components.DrawerSheet
import app.programmer_2003.shoplist.ui.components.ShopListCard
import app.programmer_2003.shoplist.ui.components.ShopListTopAppBar
import app.programmer_2003.shoplist.ui.theme.FABColor
import app.programmer_2003.shoplist.ui.theme.scaffoldBackgroundColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopListScreen(
  navController: NavController,
) {
  val drawerState = rememberDrawerState(DrawerValue.Closed)
  val scope = rememberCoroutineScope()
  var showChatAlertDialog by remember { mutableStateOf(false) }
  var showAddToFavouritesDialog by remember { mutableStateOf(false) }
  var messageText by remember { mutableStateOf("") }

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
          color = scaffoldBackgroundColor
        )
      },
      floatingActionButton = {
        FloatingActionButton(
          onClick = {
            showChatAlertDialog = true
          },
          containerColor = FABColor
        ) {
          Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(R.drawable.fab_icon),
            contentDescription = "Add new item",
          )
        }
      }
    ) { paddingValues ->
      val scrollState = rememberScrollState()
      if (showChatAlertDialog) {
        ChatAlert(
          text = messageText,
          onTextChanged = { messageText = it },
          onSendClick = {
            showChatAlertDialog = false
            println("Message Sent: $messageText")
          },
          onDismiss = {
            showChatAlertDialog = false
          }
        )
      }
      if (showAddToFavouritesDialog) {
        AddToFavourites(
          onDismiss = {
            showAddToFavouritesDialog = false
          }
        )
      }
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
          onAddToFavoriteClick = {
            showAddToFavouritesDialog = true
          },
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
          onAddToFavoriteClick = {
            showAddToFavouritesDialog = true
          },
          onCardClick = {
            navController.navigate("selected_size")
          }
        )
      }
    }
  }
}
