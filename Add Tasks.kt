package com.example.taskmanager

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.fontFamily
import com.example.taskmanager.ui.theme.fontFamily2

@Composable
fun Tasks() {
    val tasks = sharedTaskList
    var num = no_of_tasks

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var isVisible by remember {
            mutableStateOf(false)
        }

        LaunchedEffect(isVisible) {
            if (isVisible) {
                kotlinx.coroutines.delay(1000)
                isVisible = false
            }
        }


        Spacer(
            modifier = Modifier
                .height(100.dp)
        )

        Text(
            fontFamily = fontFamily2,
            text = "Add Task",
            fontSize = 40.sp,
            fontWeight = FontWeight.Black
        )

        Spacer(
            modifier = Modifier
                .height(40.dp)
        )

        var text by remember {
            mutableStateOf("")
        }

        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = {
                Text(fontFamily = fontFamily,
                    text = "Add Task")
            },
            placeholder = {
                Text(fontFamily = fontFamily,
                    text = "Enter your new task")
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            minLines = 1,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )

        Spacer(
            modifier = Modifier
                .height(30.dp)
        )


        Button(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .clip(RoundedCornerShape(10.dp)),
            onClick = {
                if (text != "") {
                    tasks.add(text)
                    text = ""
                    no_of_tasks.value += 1
                    isVisible = true
                }
            }
        ) {
            Text(
                fontSize = 20.sp,
                fontFamily = fontFamily,
                text = "Add"
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Text(
                text = "Task Added",
                fontFamily = fontFamily,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

        }
    }
}

