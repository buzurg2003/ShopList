package app.programmer_2003.shoplist.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.programmer_2003.shoplist.R
import app.programmer_2003.shoplist.ui.theme.CardDescriptionColor
import app.programmer_2003.shoplist.ui.theme.FavouritesCardButtonColor
import app.programmer_2003.shoplist.ui.theme.Pink
import app.programmer_2003.shoplist.ui.theme.scaffoldBackgroundColor

@Composable
fun AddToFavourites(
  onDismiss: () -> Unit
) {
  AlertDialog(
    onDismissRequest = onDismiss,
    shape = RoundedCornerShape(25.dp),
    backgroundColor = scaffoldBackgroundColor,
    buttons = {
      Surface(
        modifier = Modifier
          .width(312.dp)
          .height(289.dp),
        shape = MaterialTheme.shapes.medium
      ) {
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
          horizontalAlignment = Alignment.CenterHorizontally,
          verticalArrangement = Arrangement.SpaceBetween
        ) {
          Column(
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Image(
              painter = painterResource(R.drawable.add_to_fav_message_icon),
              contentDescription = stringResource(R.string.add_to_fav),
              modifier = Modifier.size(24.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text(
              text = "Added to favourites",
              fontSize = 24.sp,
              textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(16.dp))
            Text(
              text = "Now you can find this product at item favourites",
              color = CardDescriptionColor,
              textAlign = TextAlign.Left
            )
          }
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
          ) {
            TextButton(onClick = onDismiss) {
              Text("Dismiss", color = FavouritesCardButtonColor)
            }
            TextButton(onClick = onDismiss) {
              Text("Ok", color = FavouritesCardButtonColor)
            }
          }
        }
      }
    }
  )
}

@Preview
@Composable
fun AddToFavouritesPreview() {
  AddToFavourites(
    onDismiss = {}
  )
}