package com.example.taskmanager

import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

val sharedTaskList = mutableStateListOf<String>()
var no_of_tasks = mutableIntStateOf(0)
