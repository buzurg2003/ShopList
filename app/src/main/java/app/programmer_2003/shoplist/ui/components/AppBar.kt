package app.programmer_2003.shoplist.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.sharp.AccountCircle
import androidx.compose.material.icons.twotone.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopListTopAppBar(
  onMenuClick: () -> Unit,
  onAccountClick: () -> Unit,
  title: String
) {
  TopAppBar(
    title = {
      ShopListAppBarTitle(title)
    },
    navigationIcon = {
      DrawerMenuButton(onMenuClick)
    },
    actions = {
      AppBarActions(onAccountClick)
    }
  )
}

@Composable
fun DrawerMenuButton(
  onClick: () -> Unit
) {
  IconButton(
    onClick = onClick
  ) {
    Icon(
      imageVector = Icons.Filled.Menu,
      contentDescription = "Open Drawer",
      Modifier
        .height(24.dp)
        .width(24.dp)
    )
  }
}


@Composable
fun AppBarActions(
  onAccountClick: () -> Unit
) {
  IconButton(
    onClick = onAccountClick
  ) {
    Icon(
      imageVector = Icons.Filled.AccountCircle,
      contentDescription = "Open Drawer",
      Modifier
        .height(36.dp)
        .width(36.dp),
      tint = Color(135, 82, 0)
    )
  }
}

@Composable
fun ShopListAppBarTitle(
  title: String
) {
  Box(
    modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.Center
  ) {
    Text(
      title,
      fontWeight = FontWeight.W400
    )
  }
}
