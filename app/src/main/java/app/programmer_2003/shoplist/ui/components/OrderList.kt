package app.programmer_2003.shoplist.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.programmer_2003.shoplist.ui.theme.CardDescriptionColor
import app.programmer_2003.shoplist.ui.theme.ShopListCardButtonColor
import app.programmer_2003.shoplist.ui.theme.cardColor
import app.programmer_2003.shoplist.ui.theme.cardDividerColor
import app.programmer_2003.shoplist.ui.theme.numberColor

@Composable
fun OrderList(
  backButtonClick: () -> Unit,
  buyButtonClick: () -> Unit,
  onDismiss: () -> Unit
) {
  AlertDialog(
    containerColor = cardColor,
    onDismissRequest = onDismiss,
    title = {
      Text(
        text = "Order list",
        fontSize = 24.sp,
        fontWeight = FontWeight.W400
      )
    },
    text = {
      Column {
        Text(
          "There are products, which you have chosen to buy. Make the final purchase decision and place an order.",
          fontSize = 16.sp,
          color = CardDescriptionColor,
          modifier = Modifier.padding(bottom = 24.dp)
        )

        // Вставляем список заказов
        OrderListCard("1", "Leather boots", false)
        OrderListCard("2", "Sneakers", false)
        OrderListCard("3", "Yellow Slippers", false)
      }
    },
    confirmButton = {
      TextButton(onClick = buyButtonClick) {
        Text("Buy", color = ShopListCardButtonColor)
      }
    },
    dismissButton = {
      TextButton(onClick = backButtonClick) {
        Text("Back", color = ShopListCardButtonColor)
      }
    }
  )
}

@Composable
fun OrderListCard(
  number: String,
  title: String,
  check: Boolean,
  onCheckedChange: (Boolean) -> Unit = {}
) {
  Card(
    modifier = Modifier
      .fillMaxWidth(),
    colors = CardDefaults.cardColors(
      containerColor = cardColor,
    )
  ) {
    Column(
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(numberColor),
          contentAlignment = Alignment.Center
        ) {
          Text(
            text = number,
            color = Color.White,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
          )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
          text = title,
          fontSize = 16.sp,
          fontWeight = FontWeight.Medium,
          modifier = Modifier.weight(1f)
        )
        Checkbox(
          checked = check,
          onCheckedChange = onCheckedChange
        )
      }
      Divider(
        color = cardDividerColor,
        thickness = 1.dp,
      )
    }
  }
}

@Preview
@Composable
fun OrderListPreview() {
  var showOrderListDialog by remember { mutableStateOf(false) }
  OrderList(
    backButtonClick = {
      showOrderListDialog = false
    },
    buyButtonClick = {
      println("Order placed")
      showOrderListDialog = false
    },
    onDismiss = {
      showOrderListDialog = false
    }
  )
}