package main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Tab(item: TabRoutEnum,selected:Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(shape = CircleShape, color = if (selected) Color.Black else Color.Gray, onClick = onClick) {
        Box(modifier = modifier.padding(horizontal = 24.dp, vertical = 8.dp), contentAlignment = Alignment.Center) {
            Text(item.toText(), color = Color.White)
        }
    }
}