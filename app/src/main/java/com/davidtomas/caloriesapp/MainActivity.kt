package com.davidtomas.caloriesapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.davidtomas.caloriesapp.navigation.Route
import com.davidtomas.caloriesapp.ui.theme.CaloryTrackerTheme
import com.davidtomas.core.domain.preferences.Preferences
import com.davidtomas.presentation.activity_level.ActivityLevelScreen
import com.davidtomas.presentation.age.AgeScreen
import com.davidtomas.presentation.gender.GenderScreen
import com.davidtomas.presentation.goal.GoalScreen
import com.davidtomas.presentation.height.HeightScreen
import com.davidtomas.presentation.nutrient_goal.NutrientGoalScreen
import com.davidtomas.presentation.search.SearchScreen
import com.davidtomas.presentation.tracker_overview.TrackerOverviewScreen
import com.davidtomas.presentation.weigth.WeightScreen
import com.davidtomas.presentation.welcome.WelcomeScreen
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var preferences: Preferences

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val shouldShowOnboarding = preferences.loadShouldShowOnboarding()
        setContent {
            CaloryTrackerTheme {
                val navController = rememberNavController()
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    scaffoldState = scaffoldState
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = if (shouldShowOnboarding) Route.WELCOME else Route.TRACKER_OVERVIEW
                    ) {
                        composable(Route.WELCOME) {
                            WelcomeScreen(onNextButtonClick = { navController.navigate(Route.GENDER) })
                        }
                        composable(Route.GENDER) {
                            GenderScreen(onNextButtonClick = { navController.navigate(Route.AGE) })
                        }
                        composable(Route.AGE) {
                            AgeScreen(
                                scaffoldState = scaffoldState,
                                onNextButtonClick = { navController.navigate(Route.HEIGHT) }
                            )
                        }
                        composable(Route.HEIGHT) {
                            HeightScreen(
                                scaffoldState = scaffoldState,
                                onNextButtonClick = { navController.navigate(Route.WEIGHT) }
                            )
                        }
                        composable(Route.WEIGHT) {
                            WeightScreen(
                                scaffoldState = scaffoldState,
                                onNextButtonClick = { navController.navigate(Route.ACTIVITY) }
                            )
                        }
                        composable(Route.ACTIVITY) {
                            ActivityLevelScreen(
                                onNextButtonClick = { navController.navigate(Route.GOAL) }
                            )
                        }
                        composable(Route.GOAL) {
                            GoalScreen(
                                onNextButtonClick = { navController.navigate(Route.NUTRIENT_GOAL) }
                            )
                        }
                        composable(Route.NUTRIENT_GOAL) {
                            NutrientGoalScreen(
                                scaffoldState = scaffoldState,
                                onNextButtonClick = { navController.navigate(Route.TRACKER_OVERVIEW) }
                            )
                        }
                        composable(Route.TRACKER_OVERVIEW) {
                            TrackerOverviewScreen(
                                onNavigateToSearch = { mealName, day, month, year ->
                                    navController.navigate(
                                        Route.SEARCH +
                                                "/$mealName" +
                                                "/$day" +
                                                "/$month" +
                                                "/$year"
                                    )
                                }
                            )
                        }
                        composable(
                            route = Route.SEARCH + "/{mealName}/{dayOfMonth}/{month}/{year}",
                            arguments = listOf(
                                navArgument("mealName") {
                                    type = NavType.StringType
                                },
                                navArgument("dayOfMonth") {
                                    type = NavType.IntType
                                },
                                navArgument("month") {
                                    type = NavType.IntType
                                },
                                navArgument("year") {
                                    type = NavType.IntType
                                }
                            )
                        ) {
                            val mealName = it.arguments?.getString("mealName")!!
                            val dayOfMonth = it.arguments?.getInt("dayOfMonth")!!
                            val month = it.arguments?.getInt("month")!!
                            val year = it.arguments?.getInt("year")!!
                            SearchScreen(
                                scaffoldState = scaffoldState,
                                mealName = mealName,
                                dayOfMonth = dayOfMonth,
                                month = month,
                                year = year,
                                onNavigateUp = {
                                    navController.navigateUp()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}