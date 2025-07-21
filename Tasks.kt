package com.example.taskmanager

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.fontFamily
import com.example.taskmanager.ui.theme.fontFamily2

@Composable
fun Task() {
    val tasks = sharedTaskList
    val checkedMap = remember {
        mutableStateMapOf<String, Boolean>()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Spacer(modifier = Modifier
            .height(60.dp)
        )

        Text(
            modifier = Modifier
                .padding(start = 27.dp),
            fontWeight = FontWeight.Black,
            fontSize = 40.sp,
            fontFamily = fontFamily2,
            text = "Tasks"
        )

        Spacer(modifier = Modifier
            .height(40.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),
            horizontalAlignment = Alignment.Start
        ) {
            items(tasks.toList()) { item ->
                val isChecked = checkedMap.getOrPut(item) {
                    false
                }

                if (isChecked) {
                    LaunchedEffect(item) {
                        kotlinx.coroutines.delay(1000)
                        tasks.remove(item)
                        checkedMap.remove(item)
                        no_of_tasks.value -= 1
                    }
                }

                AnimatedVisibility(
                    visible = !isChecked,
                    exit = fadeOut()
                ) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .fillMaxWidth()
                            .height(50.dp)
                            .background(Color.White)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Checkbox(
                                checked = isChecked,
                                onCheckedChange = { checked ->
                                    checkedMap[item] = checked
                                },
                                modifier = Modifier.padding(start = 10.dp)
                            )

                            Text(
                                fontWeight = FontWeight.W500,
                                fontSize = 20.sp,
                                fontFamily = fontFamily,
                                textAlign = TextAlign.Center,
                                text = item
                            )
                        }
                    }
                }


                Spacer(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .height(5.dp)
                )
            }
        }
    }
}
