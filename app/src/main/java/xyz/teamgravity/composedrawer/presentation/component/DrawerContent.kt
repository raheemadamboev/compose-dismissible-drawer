package xyz.teamgravity.composedrawer.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import xyz.teamgravity.composedrawer.data.model.MenuModel

@Composable
fun DrawerContent(
    menus: List<MenuModel>,
    selectedMenu: MenuModel,
    onMenuClick: (MenuModel) -> Unit,
) {
    Column {
        DrawerHeader()
        DrawerBody(
            menus = menus,
            selectedMenu = selectedMenu,
            onMenuClick = onMenuClick
        )
    }
}