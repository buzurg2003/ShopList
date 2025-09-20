package app.programmer_2003.shoplist.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import app.programmer_2003.shoplist.ui.theme.dropdownColor

@Composable
fun SelectedSizeDropdown(
  modifier: Modifier = Modifier
) {
  var mExpanded by remember { mutableStateOf(false) }
  val mCities = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
  var mSelectedText by remember { mutableStateOf("") }
  var mTextFieldSize by remember { mutableStateOf(Size.Zero) }
  val icon = if (mExpanded)
    Icons.Filled.KeyboardArrowUp
  else
    Icons.Filled.KeyboardArrowDown

  Column(
    modifier
  ) {
    OutlinedTextField(
      value = mSelectedText,
      onValueChange = { mSelectedText = it },
      modifier = Modifier
        .fillMaxWidth()
        .onGloballyPositioned { coordinates ->
          mTextFieldSize = coordinates.size.toSize()
        },
      label = { Text("Input") },
      trailingIcon = {
        Icon(
          icon, "contentDescription",
          Modifier.clickable { mExpanded = !mExpanded },
          tint = dropdownColor
        )
      },
      singleLine = true,
      keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Number
      ),
      colors = OutlinedTextFieldDefaults.colors(
        focusedBorderColor = dropdownColor,
        focusedLabelColor = dropdownColor,
        unfocusedLabelColor = Color.Black
      ),
      shape = RoundedCornerShape(6.dp)
    )
    DropdownMenu(
      expanded = mExpanded,
      onDismissRequest = { mExpanded = false },
      modifier = Modifier
        .width(with(LocalDensity.current) {
            mTextFieldSize.width.toDp()
          }
        )
    ) {
      mCities.forEach { label ->
        DropdownMenuItem(
          text = { Text(text = label) },
          onClick = {
            mSelectedText = label
            mExpanded = false
          }
        )
      }
    }
  }
}

@Preview()
@Composable
fun SelectedSizeDropdownPreview() {
  SelectedSizeDropdown(
    modifier = Modifier
  )
}