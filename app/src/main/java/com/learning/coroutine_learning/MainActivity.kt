package com.learning.coroutine_learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.learning.coroutine_learning.ui.theme.Coroutine_learningTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Coroutine_learningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoroutinePracticeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CoroutinePracticeScreen(modifier: Modifier = Modifier) {

    var logs by remember {
        mutableStateOf(listOf<String>())
    }

    Column(
        modifier = modifier.padding(16.dp)
    ) {

        Button(
            onClick = {

                logs = emptyList()

                logs += "1. Before coroutine"

                CoroutineScope(Dispatchers.Default).launch {

                    logs += "2. Inside coroutine"

                    delay(2000)

                    logs += "3. After delay"
                }

                logs += "4. After launch"
                logs += "5. Bengaluru"
            }
        ) {
            Text("Run Coroutine")
        }

        Spacer(modifier = Modifier.height(16.dp))

        logs.forEach { log ->
            Text(text = log)
        }
    }
}
