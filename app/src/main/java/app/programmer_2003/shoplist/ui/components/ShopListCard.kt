package app.programmer_2003.shoplist.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.programmer_2003.shoplist.R
import app.programmer_2003.shoplist.ui.theme.ShopListCardButtonColor
import app.programmer_2003.shoplist.ui.theme.CardDescriptionColor
import app.programmer_2003.shoplist.ui.theme.CardTitleColor
import app.programmer_2003.shoplist.ui.theme.PriceColor

@Composable
fun CardMinimal(
  title: String,
  price: String,
  description: String,
  @DrawableRes cardImage: Int,
  onAddToFavoriteClick: () -> Unit,
  onBuyClick: () -> Unit
) {
  ElevatedCard(
    elevation = CardDefaults.cardElevation(
      defaultElevation = 6.dp
    ),
    modifier = Modifier
      .fillMaxWidth()
      .padding(18.dp)
  ) {
    Image(
      painter = painterResource(cardImage),
      contentDescription = stringResource(R.string.card_image_content_desc),
      Modifier
        .fillMaxWidth()
        .height(256.dp)
    )
    Column {
      Row(
        modifier = Modifier
          .padding(16.dp)
      ) {
        Column {
          Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 17.sp,
            color = CardTitleColor
          )
          Text(
            text = price,
            fontSize = 15.sp,
            color = PriceColor
          )
        }
      }
      Row(
        modifier = Modifier
          .padding(16.dp)
      ) {
        Text(
          text = description,
          fontSize = 14.sp,
          color = CardDescriptionColor
        )
      }
      Row(
        modifier = Modifier
          .padding(16.dp)
      ) {
        Spacer(modifier = Modifier.weight(1f))
        Row() {
          OutlinedButton(
            onClick = onAddToFavoriteClick,
            border = BorderStroke(1.dp, ShopListCardButtonColor),
          ) {
            Text(
              stringResource(R.string.add_to_fav),
              color = ShopListCardButtonColor
            )
          }
          Spacer(Modifier.width(8.dp))
          Button(
            onClick = onBuyClick,
            colors = ButtonDefaults.buttonColors(
              containerColor = ShopListCardButtonColor,
              contentColor = Color.White
            )
          ) {
            Text(stringResource(R.string.buy))
          }
        }
      }
    }
  }
}