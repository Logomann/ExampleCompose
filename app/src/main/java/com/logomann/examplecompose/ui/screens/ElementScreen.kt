package com.logomann.examplecompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.logomann.examplecompose.ui.ContentItem


@Composable
fun Element(element: ContentItem) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.weight(1f).padding(start = 16.dp),
            text = element.id.toString())
        Column(
            modifier = Modifier.weight(5f).padding(end = 16.dp),
        ) {
            Text(
                fontSize = 18.sp,
                color = Color.Blue,
                modifier = Modifier.padding(bottom = 4.dp),
                text = element.title.toString()
            )
            Text(
                modifier = Modifier.padding(bottom = 4.dp),
                fontSize = 12.sp,
                text = element.body.toString()
            )
        }
    }
}