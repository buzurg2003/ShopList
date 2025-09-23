import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import kotlinx.coroutines.delay
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import app.programmer_2003.shoplist.ui.theme.FavouritesCardButtonColor
import app.programmer_2003.shoplist.ui.theme.Pink
import app.programmer_2003.shoplist.ui.theme.ShopListCardButtonColor
import app.programmer_2003.shoplist.ui.theme.dropdownColor

@Composable
fun ChatAlert(
  text: String,
  onTextChanged: (String) -> Unit,
  onSendClick: () -> Unit,
  onDismiss: () -> Unit
) {
  val focusRequester = remember { FocusRequester() }
  val keyboardController = LocalSoftwareKeyboardController.current

  LaunchedEffect(Unit) {
    // Delay to wait until dialog fully composes
    delay(50)
    focusRequester.requestFocus()
    keyboardController?.show()
  }

  AlertDialog(
    onDismissRequest = onDismiss,
    containerColor = Pink,
    title = {
      Text(
        text = "Chat with manager",
        fontSize = 24.sp,
      )
    },
    text = {
      OutlinedTextField(
        value = text,
        onValueChange = onTextChanged,
        label = {
          Text("Enter your message")
        },
        modifier = Modifier
          .fillMaxWidth()
          .focusRequester(focusRequester),
        colors = OutlinedTextFieldDefaults.colors(
          focusedBorderColor = ShopListCardButtonColor,
          disabledBorderColor = Color.LightGray,
          focusedLabelColor = dropdownColor,
          errorBorderColor = Color.Red
        ),
        singleLine = false
      )
    },
    confirmButton = {
      Button(
        onClick = {
          onSendClick()
          onDismiss()
        },
        colors = ButtonDefaults.buttonColors(
          containerColor = FavouritesCardButtonColor,
          contentColor = Color.White
        )
      ) {
        Text("Send")
      }
    },
    dismissButton = {
      Button(
        onClick = onDismiss,
        colors = ButtonDefaults.buttonColors(
          containerColor = Color.LightGray,
          contentColor = Color.Black
        )
      ) {
        Text("Cancel")
      }
    },
  )
}
