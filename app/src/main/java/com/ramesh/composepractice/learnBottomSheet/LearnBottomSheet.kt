package com.ramesh.composepractice.learnBottomSheet

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnBottomSheet() {
    val context = LocalContext.current
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    var sheetState = rememberModalBottomSheetState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            IconButton(
                onClick = { showBottomSheet = true },
                modifier = Modifier.padding(10.dp),
                colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "AddButton",
                    tint = Color.Blue
                )
            }
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false }, sheetState = sheetState
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.padding(15.dp),
            ) {
                BottSheetListItem(icon = Icons.Filled.Email, title = "Post", onClick = {
                    Toast.makeText(
                        context,
                        "Post",
                        Toast.LENGTH_SHORT
                    ).show()
                })
                BottSheetListItem(icon = Icons.Default.Favorite, title = "Likes", onClick = {
                    Toast.makeText(
                        context,
                        "Likes",
                        Toast.LENGTH_SHORT
                    ).show()
                })
                BottSheetListItem(icon = Icons.Default.Notifications, title = "Alerts", onClick = {
                    Toast.makeText(
                        context,
                        "Alerts",
                        Toast.LENGTH_SHORT
                    ).show()
                })
            }
        }
    }
}

@Preview
@Composable
fun LearnSheetPreview() {
    LearnBottomSheet()
}