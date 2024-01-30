Here are step-by-step instructions to create an android app with a replica of the All Books screen from the Acharya Prashant app using Jetpack Compose:

Steps
1. Create a new Android Studio project
Select "Empty Compose Activity" when prompted to add Compose support.

2. Add dependencies
In the build.gradle file, add dependencies for:

Compose
Retrofit (for API calls) etc
Sync the project after adding dependencies.

3. Create data model classes
Create Kotlin data model classes for books, authors etc. based on the JSON responses from the API.

4. Create repository
Create a BooksRepository class to make API calls using Retrofit and handle data.

5. Create viewmodel
Create a BooksViewModel to hold the books data and communicate with the repository.

6. Create Composable UI screens
Use Column, Row, LazyColumn etc. to create a UI similar to the app's All Books screen.

Handle empty and error states.


7. Documentation
Document the code using comments explaining functionality and edge cases handled.

8. Error handling
9. The full code is pushed to this GitHub repo: https://github.com/poojathakral97/BookReplicaJEtpackTask.git
