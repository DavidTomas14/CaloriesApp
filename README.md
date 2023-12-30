# 🍎 CaloriesTrackerApp 
Welcome to CaloriesTrackerApp, your comprehensive tool for personalized nutrition management and healthy lifestyle choices! This app is designed to empower you to take control of your daily caloric intake, with a special focus on the nutritional content of each meal.

## 🥇 Features

1️⃣ Intuitive Calorie Tracking:
Easily log your daily meals, <span style="color:orange">including breakfast</span>  including breakfast, lunch, dinner, and snacks, with a user-friendly interface. Keep a real-time record of your calorie consumption throughout the day.

2️⃣ Nutrient Information from API:
CaloriesTrackerApp integrates with a powerful API that provides accurate and up-to-date nutritional information for each meal. Receive detailed insights into the amount of fat, protein, and carbohydrates in 100 grams of your chosen foods.

3️⃣ Personalized Nutrition Analysis:
Input your personal details such as weight, height, age, and exercise routine into the app. CaloriesTrackerApp then calculates the ideal caloric intake for your specific needs. Whether you're aiming to gain, lose, or maintain weight, the app tailors its recommendations to align with your health goals.

4️⃣ Meal-Specific Nutrient Breakdown:
Gain a deeper understanding of your nutrition by exploring the breakdown of nutrients for each meal. Track your macronutrient intake to ensure a well-balanced diet that supports your overall well-being.

Make informed choices about your nutrition and take charge of your well-being with CaloriesTrackerApp. Download now to embark on a journey towards a healthier, happier you!

## 📲 App Experience

https://github.com/DavidTomas14/CaloriesApp/assets/67898763/8f86db4c-19a3-4652-9d0a-02e7cdac8f0c

## 🛠️ Stack
- MultiModule: This app has been divided in differente modules, one for each feature of the app and to extra for sharing utilities. 
  - Onboarding: feature with all the screens to enter the user information
  - Tracker: feature with the screens to add meals and see the summary of the calories for the different days we have tracked.
  - BuildSrc: Powerful module to keep all the dependencies easy organised. This approach helps scaling the app as it is very easy to update deps versions
  - Core: Module shared with the different features
  - Core-Ui: Module shared with the different features, only ui utils
  - App: Entry point of the app where the navigations to the rest of modules are performed
- Feature layered based on Clean Architecture: This app is not only divided in feature modules but also is submoduled in clean architecture layers such as, domain, data and presentation.
- MVVM
- Jetpack Compose
- Dagger - Hilt
- Retrofit
- Room
- Coroutine
- Coil
- Moshi
- Unit, Integration and End to End tests
## 🏗️ Architecture Technical Explanation 
As mentioned in the previous section this app is multimodule. Each of this modules represent a feature and are divided in submodules that represent all of the Clean Architecture layers (Data, Domain and Presentation).
The different modules of this project are the following: app, buildSrc, core, core-ui and features subdivided in each of the feature modules, two in this case, onBoarding and Tracker.
<br> ![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/a0506074-3003-43b0-87e9-28805001885e) <br>
### 1️⃣   BuildSrc Module
This Module will contain Kotlin Objects with the different libraries that will be used in all the Project. This approach is very useful because is a very well organised way of having all the dependencies in the same place and makes it easier to update them in a single place rather than revising one by one the gradle files of all the modules. 
<br>
![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/77792dd9-dda6-42fe-bf54-1cb6d84c8793)
<br> 
Its important to add that two extra gradle files have been created as common templated for the different modules to use them in order to simplify the code. These are compose-module.gradle and base-module.gradle. Both of them are mainly composed of the common dependencies and make use of the BuildSrc module objects.
<br>
![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/773e3ce2-4bce-42d5-8806-494bb6ec70b7)
<br>

### 2️⃣   Features Modules
This app has only two feature modules, OnBoarding and Tracker. In this section the Tracker one will be used for the explanation as it covers the three Clean Architecture layers while the Data Layer. In the case of the Onboarding Module, the Data Layer is not implemented  because we dont need to retrieve any external data. 
<br>
![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/a0a9ed09-f8c5-44b5-b640-08825bd9fee0)
<br>

 🟥   DOMAIN <br>
The gradle file of this module will inherit from the base-module.gradle to have the common settings. In addition, this module will only have Core Module dependencies (this module will be explained later) and the Coroutines library dependencies extra to the common ones.
<br>
![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/0cf87ac0-c94a-4ddd-80c5-9a99c70aa55d)
<br>
This module includes:
- Di package: Includes the injected dependencies needed in the Module
- Model package: Includes all the models used all along the app, shared with data and presentation layer
- Repository package: Includes the interface with the different methods to provide data. This interface is implemented in the data layer (Mean of communication between data and domain layer)
- UseCases package: Different use cases needed in the presentation layer by the ViewModel (Mean of communication between presentation and domain layer). This use cases make use of the repository if data is needed and also contains bussiness logic.
<br>![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/65e1d61e-e1f5-4d1b-bd79-8bccfb86b0d7) <br>


 🟢   DATA <br>
The gradle file of this module will inherit from the base-module.gradle to have the common settings. In addition, this moudule has only the Domain and the Core dependencies apart from the ones from the necessary external libraries added to the common ones.
<br>![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/03423830-25fc-41e7-b031-a862005063da)<br>
This module includes
- Di package: Includes the injected dependencies needed in the Module
- Local package: Package with the necessary utilities to save data locally
  - Entity saved in local DB
  - Mapper used to map from domain model to entity and viceversa
  - Dao and Database used to save data locally
- Remote package: Package with the necessary utilities to communicate with remote server
  - Api with the different urls to communicate with remote server
  - Mapper used to map api responses and requests
  - Repository implementation of the interface that is created in domain layer for this module. Is in charge of using local and remote sources to provide data
<br>![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/3a778c2a-2d3b-40a4-925a-b5dda236d10f) <br>

 🔷 PRESENTATION <br>
The gradle file of this module will inherit from the compose-module.gradle to have the common settings. In addition, this module will have dependencies from the Domain, Core and CoreUI modules (this module will be explained later) and the Coil library dependencies extra to the common ones.
<br>![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/5ae82cb4-c693-401d-b85e-1ccc4dbb6ef3)<br>
This module includes:
- Components package: Includes all the shared components in the different screens
- Screens package: Includes one package for each screen of this module
- Each Screen package is subdivided in:
  - Components package: Includes all the shared components in the different screens
  - Different files that work together to create the screen
    - Event file: Sealed class that contains all the events that are triggered in the screen by the different components
    - ViewModel: the shield of the screen, nothing new. Without viewModel screen is nothing
    - State: Data Class with all the fields that are used in the different components to be created.
    - Screen: the class that defines the screen, is based on the different components created on the components package
    - ModelUi: Data classes that are created only control the state of components. In the case of the MealUi of this app, it includes all the info around a meal and a it also has a dedicated field specially to control if the component that uses this object is Expanded or not. <br>
![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/397b7a51-af28-4220-9470-626bf5e91a16)

### 3️⃣   Core and CoreUi Modules
This two modules cover many aspects that will be used in different modules of the app.
- CoreUi: it includes aspects related to the presentation Ui, such as the Colors, Dimensions, Shape, Theme and Type. The gradle file of this module will inherit from the compose-module.gradle 
- Core: The gradle file of this module will inherit from the base-module.gradle
  - Data Package: objects related to data layer that may be reused in different modules of the app. In this case all the data from the user is saved in Sharedpreferences in the Onboarding Module, and after consumed in the Tracker Module
  - Domain Package: Includes all the models or usecases that are used in several modules of the app
  - Util Package: In this app there have been used to ver handy classes
    - UiEvent: Sealed class with common events that need to be observed by composables in order to trigger events from the proper composable. A very obvious example are the SnackBars that need context info an need to be triggered inside the composable. These UiEvents are used in the different screens of the app
    - UiText: Utility class that easily handles if a string is static and is taken from the strings.xml, or is dynamic and comes from any source of data.
<br>

![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/31e13045-247e-432e-8889-cd1654470933)

![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/c9a6a825-621e-464f-8060-bf29367f6a46)

### 4️⃣   App Module
This module has dependencies from the rest of the modules. Is the central module in which the MainActivity of the app is setted to control the navigation between de different modules.
- Di: Dependency injection of the dependencies needed in the module
- Route: Object with the routes of the different screens of the app
- App: Needed to initiate DaggerHilt (dont forget to add it in Manifest)
- MainActivity: entry point of the app, where navigations are controlled. <br>
![image](https://github.com/DavidTomas14/CaloriesApp/assets/67898763/24b7f7cd-ca62-4cee-9c2e-c1990f4394a9)

## 🖌️ Presentation UI detail explanation - Components - ViewModel - Screen - Compose
In order to explain how this different classes from the UI interact, it is necessary to start explaining the principal one that manages all the events and hosts the state of the screen. However before starting with the viewModel is necessary to explain to classes needed by the viewModel to do the magic.
STATE CLASS AND UIMODELS
The state class represent the state of the screen and will be used by the components to recompose. The UiModels represent models used to represent part of the state grouped in a better organised way. In this case the MealUi is passed to a component to create the meal and control its state of expanded or collapsed
```
data class TrackerOverviewState(
    val totalCarbs: Int = 0,
    val totalProtein: Int = 0,
    ....
    val trackedFoods: List<TrackedFood> = emptyList(),
    val mealUis: List<MealUi> = defaultsMealUis
)
data class MealUi(
    val name: UiText,
    @DrawableRes val drawableRes: Int,
    val mealType: MealType,
    ...
    val calories: Int = 0,
    val isExpanded: Boolean = false
)
```
### 1️⃣ **VIEWMODEL**
#### 🟥 State
The state is wrapped in a mutableState that will be used by the screen to configure the components. Any change of this state will trgger recomposition and will change the components.
```
var state by mutableStateOf(TrackerOverviewState())
        private set
```
#### 🟢 UiEvents
As we mentioned in a previous section there are common events that need to be handled by the UI and triggered in composables, such as showing a SnackBar. 
To make this possible a Channel were this UiEvent are emitted is created. This will be observed in the screen and triggered when any event is emitted. The emissions are made in the viewModel in the onEvent function (explained in next section) 
```
private val _uiEvent = Channel<UiEvent>()
val uiEvent = _uiEvent.receiveAsFlow()
```
#### 🔷 OnEvent Function
Is the handler of the events of the screen. The components will execute this function when any event is triggered. When this function is called it receives one of the Events from our sealed class to contro events, and depending on which one is passed it will do one thing or another.
In most of the cases the state will be modified and this will trigger recomposition of the components that observe the state. 
```
 fun onEvent(event: TrackerOverviewEvent) {
        when (event) {
            is TrackerOverviewEvent.OnDeleteTrackedFoodClick -> {
                _uiEvent.send(
                        UiEvent.ShowSnackBar(
                            UiText.StringResource(R.string.error_something_went_wrong)
                        )
                    )
            }
             is TrackerOverviewEvent.OnNextDayClick -> {
                state = state.copy(
                    date = state.date.plusDays(1),
                )
                refreshFoods()
            }
            is ...
```

### 2️⃣ **SCREEN**
The screen consists of the different components of the UI. The screen uses the state that is in the viewModel to pass the different elements of it to create the components. As we mentioned previously all of the changes made on the stae will trigger the recomposition of such components.
In the next example the DaySelector component makes use of the date field from the state and also receives listeners with the onEvent function of the viewModel passing the corresponding Event thay is triggered.
```
          DaySelector(
                date = state.date,
                onPreviousDayClicked = {
                    viewModel.onEvent(TrackerOverviewEvent.OnPreviousDayClick)
                },
                onNextDayClicked = {
                    viewModel.onEvent(TrackerOverviewEvent.OnNextDayClick)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spaceMedium)
            )
```
As we mentioned in a previous section, there are also UiEvents that need to be executed in composables. This is done by observing the emissions in the channel previously created in the viewModel.
```
LaunchedEffect(key1 = keyboardController) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.ShowSnackBar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        message = event.message.asString(context)
                    )
                    keyboardController?.hide()
                }

                is UiEvent.NavigateUP -> onNavigateUp()
                else -> Unit
            }
        }
    }
```
## ➕ Extras
### 🟥 **Navigation in MainActivity**
Is controlled in the MainActivity from the App Module. Compose navigation is used in this case and the different composables are setted to their corresponding routes. In order to avoid coupling and making modules completely independent from each other, the navigation is passed to the different screen as a parameter. In addition if any screen needs the scaffoldstate to for example show a Snackbar it is also passed as a parameter. 
```
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
                        composable ...
```
### 🟢**Passing Params in Navigation**
```
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
```

### 🔷**LocalSpacing**
A very useful way of providing the different dimensions used in the app is by using a LocalComposition. This is easily done by using compositionLocalOf
```
data class Dimensions(
    val default: Dp = 0.dp,
    val spaceExtraSmall: Dp = 4.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceLarge: Dp = 32.dp,
    val spaceExtraLarge: Dp = 64.dp,
)

val LocalSpacing = compositionLocalOf {
    Dimensions()
}
```
This LocalComposition has to be provided in de CompositionLocalProvider inside the Theme.
```
@Composable
fun CaloryTrackerTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider (LocalSpacing provides Dimensions()) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}
```
This will enable to use the LocalSpacing in any of our composables of our app.
This is the same ase the context thay is also a LocalComposable. 
```
@Composable
fun TrackerOverviewScreen(
    onNavigateToSearch: (String, Int, Int, Int) -> Unit,
    viewModel: TrackerOverviewViewModel = hiltViewModel()
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

  ....
```
