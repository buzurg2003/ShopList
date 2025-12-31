package app.programmer_2003.shoplist.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import app.programmer_2003.shoplist.R
import app.programmer_2003.shoplist.ui.components.DrawerSheet
import app.programmer_2003.shoplist.ui.components.FavouritesListCard
import app.programmer_2003.shoplist.ui.components.ShopListTopAppBar
import app.programmer_2003.shoplist.ui.theme.FavouritesCardButtonColor
import app.programmer_2003.shoplist.ui.theme.scaffoldBackgroundColor
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
					title = "Favorites",
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
		) { paddingValues ->
			val scrollState = rememberScrollState()
			Box(
				Modifier
					.fillMaxSize()
					.padding(paddingValues)
			) {
				Column(
					Modifier
						.verticalScroll(scrollState)
				) {
					Spacer(Modifier.height(35.dp))
					FavouritesListCard(
						number = "1",
						title = "Leather boots",
						price = "27,5 $",
						image = R.drawable.card_image
					)
					FavouritesListCard(
						number = "2",
						title = "Leather boots",
						price = "27,5 $",
						image = R.drawable.card_image
					)
					FavouritesListCard(
						number = "3",
						title = "Leather boots",
						price = "27,5 $",
						image = R.drawable.card_image
					)
				}
				Button(
					onClick = {},
					modifier = Modifier
						.align(Alignment.BottomCenter)
						.padding(bottom = 33.dp),
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
