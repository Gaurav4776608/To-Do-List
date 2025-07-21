package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Task
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AddCircleOutline
import androidx.compose.material.icons.outlined.Task
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*

import com.example.taskmanager.ui.theme.TaskManagerTheme
import com.example.taskmanager.ui.theme.fontFamily2

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var BottomNavigationItems = listOf(
                BottomNavigation(
                    title = "Profile",
                    route = "profile",
                    selectedIcon = Icons.Filled.AccountCircle,
                    unselectedIcon = Icons.Outlined.AccountCircle,
                    textBadge = 0
                ),
                BottomNavigation(
                    title = "Add",
                    route = "add",
                    selectedIcon = Icons.Filled.AddCircle,
                    unselectedIcon = Icons.Outlined.AddCircleOutline,
                    textBadge = 0
                ),
                BottomNavigation(
                    title = "Tasks",
                    route = "tasks",
                    selectedIcon = Icons.Filled.Task,
                    unselectedIcon = Icons.Outlined.Task,
                    textBadge = no_of_tasks.value
                )
            )

            TaskManagerTheme {

                var selectedState by remember {
                    mutableIntStateOf(0)
                }
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            BottomNavigationItems.forEachIndexed { index, item ->
                                NavigationBarItem(
                                    selected = index == selectedState,
                                    onClick = {
                                        selectedState = index
                                        navController.navigate(item.route)
                                    },
                                    icon = {
                                        BadgedBox(
                                            badge = {
                                                if (item.textBadge > 0) {
                                                    Badge {
                                                        Text(text = item.textBadge.toString())
                                                    }
                                                }
                                            }
                                        ) {
                                            Icon(
                                                imageVector = if (index == selectedState) {
                                                    item.selectedIcon
                                                }
                                                else {
                                                    item.unselectedIcon
                                                },
                                                contentDescription = null
                                            )
                                        }
                                    },
                                    label = {
                                        Text(text = item.title)
                                    }
                                )
                            }
                        }
                    }
                ) {
                    val padding = it

                    NavHost(
                        navController = navController,
                        startDestination = "profile"
                    ) {
                        composable("profile") {
                            Profile()
                        }
                        composable("add") {
                            Tasks()
                        }
                        composable("tasks") {
                            Task()
                        }
                    }
                }
            }
        }
    }
}




data class BottomNavigation(
    val title: String,
    val route: String,
    var selectedIcon: ImageVector,
    var unselectedIcon: ImageVector,
    var textBadge: Int
)