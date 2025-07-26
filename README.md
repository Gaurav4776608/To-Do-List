# 📋 To-Do List App

A simple and modern Task Manager app built using **Jetpack Compose**.
This app allows users to add tasks, track how many tasks are active, and mark them as complete.
The app also includes bottom navigation and beautiful animated transitions.

---

## ✨ Features

- 📝 Add new tasks using a TextField and button
- 📄 View all added tasks in a scrolling list
- ✅ Mark tasks as completed using a checkbox (automatically removes after 1 second)
- 🔢 Displays total task count
- 🎨 Material 3 theming with modern Jetpack Compose UI
- 🚀 Smooth animations (fade, visibility transitions)
- 📱 Bottom Navigation bar with badge count on Tasks tab

---

## 📱 Screens

### 👤 Profile Screen
- Displays your profile image (static curently) and total number of tasks

### ➕ Add Task Screen
- Allows user to input and submit new tasks
- Shows confirmation when a task is added

### 📋 Task List Screen
- Lists all active tasks
- Checkbox to mark a task as done
- Uses animations and removes the task with a delay

---

## 🛠️ Tech Stack

- **Language:** Kotlin
- **UI Toolkit:** Jetpack Compose
- **Architecture:** Single Activity with Navigation Compose
- **Design:** Material 3
- **State Management:** `mutableStateListOf`, `mutableIntStateOf`

---

## 📦 Folder Structure

com.example.taskmanager/
i. MainActivity.kt # Sets up navigation and bottom bar
ii. Profile.kt # Profile screen UI
iii. Tasks.kt # Add Task screen
iv. Task.kt # Display Task list screen
v. SharedState.kt # Shared task list and task count state
vi. ui.theme/ # Theming files (fonts, colors, etc.)
