# My Pregnancy Assistant (MomChildCare)

An Android app that supports expecting mothers with tips, health tools and reminders.

## Features
- **Sign up and sign in** with Firebase Authentication
- **Tips** grouped into food, lifestyle, health issues, baby's growth, and do's and don'ts
- **BMI calculator:** enter height (cm) and weight (kg) to get your BMI and what it means,
  with recommendations
- **Reminders:** pick a time and get a notification (AlarmManager + notifications)
- **Message:** send an SMS to a chosen number from inside the app
- **Video guides:** watch pregnancy-care videos with an embedded YouTube player

## Tech
Java, Android SDK (min SDK 21, target SDK 29), Firebase Authentication, Firestore and Realtime Database,
[android-youtube-player](https://github.com/PierfrancescoSoffritti/android-youtube-player).

## Build
1. Open the project in Android Studio.
2. Create a Firebase project, add an Android app with the package name `com.example.momchildcare`,
   download its `google-services.json` and put it in the `app/` folder. The file is not included in
   this repository.
3. Run the app on an emulator or an Android phone.
