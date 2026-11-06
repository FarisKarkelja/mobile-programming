# Gric - Restaurant & Recipe Discovery App
## Table of Contents
- [Description](#description)
- [Languages and Technologies Used](#languages-and-technologies-used)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

## Description
Gric is a native Android application built for the Introduction to Mobile Programming course. It lets users discover restaurants, browse food and drink menus, save favorites, and explore recipes. The app follows a clean MVVM architecture with a repository layer, local caching via Room, and remote data access via Retrofit, wired together with Hilt for dependency injection.

## Languages and Technologies Used
- Kotlin
- Jetpack Compose
- Hilt (dependency injection)
- Room (local database)
- Retrofit & OkHttp (networking)
- Firebase (Authentication, Firestore, Analytics)
- Jetpack Navigation Compose
- Gradle (Kotlin DSL)

## Features
1. **Authentication:**
   - Email/password login and registration
   - Google Sign-In support via Firebase Auth
2. **Restaurant Discovery:**
   - Browse restaurants with filtering and search
   - View detailed restaurant pages with ratings, cuisine type, and location
3. **Menu Browsing:**
   - Explore food dishes and drinks by category
   - Detailed dish/drink pages with descriptions
4. **Favorites:**
   - Save and manage favorite restaurants
   - Category-based favorites view
5. **Recipes:**
   - Browse recipe details separate from restaurant menus
6. **User Profile:**
   - View and manage account details
   - Logout functionality
7. **Offline-Friendly Architecture:**
   - Local Room database seeded on app start
   - Repository pattern abstracting local (Room) and remote (Retrofit) data sources

## Installation
1. Clone the repository:
```bash
   git clone https://github.com/FarisKarkelja/mobile-programming.git
```
2. Open the project in **Android Studio**.
3. Let Gradle sync and download all dependencies.
4. Add your own `google-services.json` file under `app/` to enable Firebase features (Auth, Firestore, Analytics).

## Usage
1. Build and run the app on an emulator or physical device (min SDK 24, target SDK 36).
2. Register a new account or sign in with Google.
3. Browse restaurants, view menus, and add items to your favorites.
4. Explore the Recipes tab for additional content outside restaurant menus.
5. Manage your account from the Profile tab.

## Contributing
If you'd like to contribute to this project, please follow these guidelines:
1. Fork the Project
2. Create your Feature Branch
3. Commit your Changes
4. Push to the Branch
5. Open a Pull Request

## License
This project is not licensed.

## Acknowledgements
- [Android Developers Documentation](https://developer.android.com/)
- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Stack Overflow](https://stackoverflow.com/)
- University materials and resources
