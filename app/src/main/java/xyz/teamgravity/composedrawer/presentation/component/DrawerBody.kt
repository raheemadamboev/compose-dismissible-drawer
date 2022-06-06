package xyz.teamgravity.composedrawer.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.teamgravity.composedrawer.data.model.MenuModel

@Composable
fun DrawerBody(
    menus: List<MenuModel>,
    onMenuClick: (MenuModel) -> Unit,
) {
    LazyColumn {
        items(menus) { menu ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onMenuClick(menu)
                    }
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = menu.icon,
                    contentDescription = menu.contentDescription
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = menu.title,
                    style = TextStyle(fontSize = 18.sp),
                    modifier = Modifier.weight(1F)
                )
            }
        }
    }
}