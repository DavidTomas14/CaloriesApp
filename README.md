# 🍎 CaloriesTrackerApp 
Welcome to CaloriesTrackerApp, your comprehensive tool for personalized nutrition management and healthy lifestyle choices! This app is designed to empower you to take control of your daily caloric intake, with a special focus on the nutritional content of each meal.

## Features

1️⃣ Intuitive Calorie Tracking:
Easily log your daily meals, including breakfast, lunch, dinner, and snacks, with a user-friendly interface. Keep a real-time record of your calorie consumption throughout the day.

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
