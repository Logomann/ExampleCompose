package com.logomann.examplecompose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.logomann.examplecompose.R
import com.logomann.examplecompose.ui.ContentItem


@Composable
fun Element(
    element: ContentItem,
    onElementClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onElementClick
            }
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = element.id.toString()
        )
        Column(
            modifier = Modifier
                .weight(5f),
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
        val icon = if (element.isFavourite) {
            painterResource(R.drawable.icon_star_filled)
        } else {
            painterResource(R.drawable.icon_star)
        }
        IconButton(
            modifier = Modifier.padding(end = 16.dp),
            onClick = { onElementClick() }) {
            Icon(
                painter = icon,
                contentDescription = null,
                tint = Color.Red
            )
        }
    }
}