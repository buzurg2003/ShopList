package app.programmer_2003.shoplist.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.programmer_2003.shoplist.ui.theme.numberColor

@Composable
fun FavouritesListCard(
  number: String,
  title: String,
  price: String,
  @DrawableRes image: Int
) {
  ElevatedCard(
    elevation = CardDefaults.cardElevation(
      defaultElevation = 6.dp
    ),
    modifier = Modifier
      .fillMaxWidth()
      .padding(
        start = 25.dp,
        end = 25.dp,
        bottom = 35.dp
      )
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      Spacer(Modifier.width(16.dp))
      Box(
        modifier = Modifier
          .size(40.dp)
          .clip(CircleShape)
          .background(numberColor)
          .align(Alignment.CenterVertically),
      ) {
        Text(
          text = number,
          color = Color.White,
          modifier = Modifier
            .align(Alignment.Center)
            .padding(2.dp),
          fontSize = 15.sp,
          fontWeight = FontWeight.Bold
        )
      }
      Spacer(Modifier.width(16.dp))
      Column(
        modifier = Modifier
          .weight(2f)
      ) {
        Text(
          text = title,
          fontSize = 16.sp,
          fontWeight = FontWeight.Bold
        )
        Text(
          text = price,
          fontSize = 14.sp,
        )
      }
      Image(
        painter = painterResource(id = image),
        contentDescription = title,
        Modifier
          .height(80.dp)
          .width(80.dp),
        contentScale = ContentScale.Crop
      )
    }
  }
}
