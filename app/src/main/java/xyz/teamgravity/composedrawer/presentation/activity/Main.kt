package xyz.teamgravity.composedrawer.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import xyz.teamgravity.composedrawer.R
import xyz.teamgravity.composedrawer.presentation.component.AppBar
import xyz.teamgravity.composedrawer.presentation.component.DrawerContent
import xyz.teamgravity.composedrawer.presentation.theme.ComposeDrawerTheme
import xyz.teamgravity.composedrawer.presentation.viewmodel.MainViewModel

class Main : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDrawerTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize()
                ) {
                    val viewmodel = viewModel<MainViewModel>()
                    val drawer = rememberDrawerState(initialValue = DrawerValue.Closed)
                    val scope = rememberCoroutineScope()

                    Scaffold(
                        topBar = {
                            AppBar(
                                drawerOpen = drawer.isOpen,
                                onNavigationClick = {
                                    scope.launch { if (drawer.isOpen) drawer.close() else drawer.open() }
                                }
                            )
                        },
                        floatingActionButton = {
                            FloatingActionButton(onClick = viewmodel::onHeartCheckedChange) {
                                Icon(
                                    imageVector = if (viewmodel.heartChecked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                    contentDescription = stringResource(id = R.string.cd_favorite_button)
                                )
                            }
                        }
                    ) { padding ->
                        DismissibleNavigationDrawer(
                            drawerState = drawer,
                            drawerContent = {
                                DrawerContent(
                                    menus = viewmodel.menus,
                                    selectedMenu = viewmodel.selectedMenu,
                                    onMenuClick = { menu ->
                                        scope.launch { drawer.close() }
                                        viewmodel.onSelectedMenuChange(menu)
                                    }
                                )
                            },
                            modifier = Modifier.padding(padding)
                        ) {
                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(padding)
                            ) {
                                Text(text = stringResource(id = viewmodel.selectedMenu.title))
                            }
                        }
                    }
                }
            }
        }
    }
}