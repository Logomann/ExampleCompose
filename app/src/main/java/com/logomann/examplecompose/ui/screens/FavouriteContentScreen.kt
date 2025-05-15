package com.logomann.examplecompose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.logomann.examplecompose.ui.ContentItem

@Composable
fun FavouriteContentScreen(
    // viewModel: FavouriteContentViewmodel = koinViewModel()
) {
    val listOfItems = listOf<ContentItem>(
        ContentItem(
            userId = 1,
            id = 1,
            title = "Первый",
            body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
        ),
        ContentItem(
            userId = 2,
            id = 2,
            title = "Второй",
            body = "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla"
        ),
        ContentItem(
            userId = 3,
            id = 3,
            title = "Третий",
            body = "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut"
        )
    )
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val element = createRef()
        LazyColumn(
            modifier = Modifier.constrainAs(element) {
                start.linkTo(parent.start, 16.dp)
                top.linkTo(parent.top, 16.dp)
                end.linkTo(parent.end, 16.dp)
            }
        ) {
            items(listOfItems.size) { index ->
                Element(listOfItems[index])
            }
        }
    }
}