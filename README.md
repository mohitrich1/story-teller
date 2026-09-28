# Offline Storyteller

A simple offline Android story app with built-in stories and Android Text-to-Speech.

## Build locally
1. Install Android Studio.
2. Open this folder as a project.
3. Let Gradle sync.
4. Build > Build Bundle(s) / APK(s) > Build APK(s).

## Build on GitHub
1. Create a GitHub repository.
2. Upload the complete contents of this folder.
3. Push to `main`.
4. Open GitHub > Actions > Build Android APK.
5. Open the completed workflow run.
6. Download the `OfflineStoryteller-debug-apk` artifact.
7. Extract it and install `app-debug.apk` on your Android phone.

This first version uses Android's built-in Text-to-Speech engine. It does not contain a fully local generative AI model yet.
