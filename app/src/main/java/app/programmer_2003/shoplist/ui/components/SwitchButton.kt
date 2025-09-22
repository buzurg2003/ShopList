package app.programmer_2003.shoplist.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.programmer_2003.shoplist.ui.theme.FavouritesCardButtonColor

@Composable
fun SwitchButton(
  checked: Boolean,
  onCheckedChange: (Boolean) -> Unit
) {
  Column(
    modifier = Modifier
      .fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Switch(
      checked = checked,
      onCheckedChange = { newCheckedState -> onCheckedChange(newCheckedState) },
      modifier = Modifier.align(
        Alignment.CenterHorizontally
      ),
      colors = SwitchDefaults.colors(
        checkedThumbColor = FavouritesCardButtonColor,
        uncheckedThumbColor = Color(200,168,155),
        checkedTrackColor = Color(200,168,155),
        uncheckedTrackColor = Color(218,206,201),
      ),
    )
  }
}
