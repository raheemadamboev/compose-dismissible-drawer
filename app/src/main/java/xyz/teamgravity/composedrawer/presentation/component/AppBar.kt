package xyz.teamgravity.composedrawer.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import xyz.teamgravity.composedrawer.R

@Composable
fun AppBar(
    drawerOpen: Boolean,
    onNavigationClick: () -> Unit,
) {
    SmallTopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = if (drawerOpen) Icons.Default.Close else Icons.Default.Menu,
                    contentDescription = stringResource(id = R.string.cd_toggle_drawer)
                )
            }
        }
    )
}