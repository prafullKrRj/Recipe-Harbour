package com.prafullkumar.recipeharbour

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prafullkumar.recipeharbour.presentations.aiScreen.ChatBotScreenMain
import com.prafullkumar.recipeharbour.presentations.favouritesScreen.FavouriteScreen
import com.prafullkumar.recipeharbour.presentations.historyScreen.HistoryScreen
import com.prafullkumar.recipeharbour.presentations.homeScreen.HomeNavGraph
import com.prafullkumar.recipeharbour.presentations.searchScreen.SearchScreenMain

@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomAppBar {
                navController.navigate(Screen.entries[it].route)
            }
        },
    ) { paddingValues ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            NavHost(navController = navController, startDestination = Screen.HOME.route) {
                composable(Screen.HOME.route) {
                    HomeNavGraph(navController = navController)
                }
                composable(Screen.SEARCH.route) {
                    SearchScreenMain(
                        searchViewModel = viewModel(factory = ViewModelProvider.SearchScreenVM),
                    )
                }
                composable(Screen.AI.route) {
                    ChatBotScreenMain(
                        chatBotMainViewModel = viewModel(factory = ViewModelProvider.ChatBotScreenVM),
                    )
                }
                composable(Screen.FAVOURITE.route) {
                    FavouriteScreen(
                        viewModel = viewModel(factory = ViewModelProvider.FavouritesScreenVM),
                        navController
                    )
                }
                composable(Screen.HISTORY.route) {
                    HistoryScreen(
                        viewModel = viewModel(factory = ViewModelProvider.HistoryScreenVM),
                        navController
                    )
                }
            }
        }
    }
}

@Composable
fun BottomAppBar(
    navigationClick: (Int) -> Unit
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val items = listOf(
        Pair("Home", Pair(R.drawable.home_filled, R.drawable.outline_home_24)),
        Pair("Search", Pair(R.drawable.outline_search_24, R.drawable.outline_search_24)),
        Pair("AI", Pair(R.drawable.microchip, R.drawable.microchip)),
        Pair("Favourites", Pair(R.drawable.baseline_bookmark_24, R.drawable.outline_bookmark_24)),
        Pair("History", Pair(R.drawable.baseline_history_24, R.drawable.baseline_history_24)))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationBarItem(
                modifier = Modifier.weight(.20f),
                onClick = {
                    selectedItem = index
                    navigationClick(index)
                },
                text = item.first,
                icon = if (selectedItem == index) item.second.first else item.second.second,
                isSelected = selectedItem == index
            )
        }
    }
}

@Composable
fun BottomNavigationBarItem(modifier: Modifier, onClick: () -> Unit, text: String, icon: Int, isSelected: Boolean) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onClick()
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(4.dp)) // 4.dp is the default value for the medium space
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.alpha(if (isSelected) 1f else 0.5f).size(24.dp)
        )
        Spacer(modifier = Modifier.padding(4.dp)) // 4.dp is the default value for the medium space
        /*Text(
            text = text,
            modifier = Modifier.alpha(if (isSelected) 1f else 0.5f)
        )
        Spacer(modifier = Modifier.padding(4.dp)) // 4.dp is the default value for the medium space*/
    }
}
enum class Screen(val route: String) {
    HOME("home"),
    SEARCH("search"),
    AI("ai"),
    FAVOURITE("favourites"),
    HISTORY("history");
}