package com.github.bqtankiet.layoutgridsystem

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.bqtankiet.layoutgridsystem.layoutgrid.LayoutGridSystem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LayoutGridSystem()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewApp() {
    LayoutGridSystem()
}