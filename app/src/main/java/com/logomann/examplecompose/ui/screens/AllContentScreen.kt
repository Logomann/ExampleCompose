package com.logomann.examplecompose.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.logomann.examplecompose.ui.ContentItem

@Composable
fun AllContentScreen(
    // viewModel: AllContentViewmodel = koinViewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    //Здесь список сделал через remember, потому что нужно хранить состояние,
    // но хранение состояния нужно передать вьюмодели
    // val state = viewModel.state.collectAsState()
    // И можно сделать так:
    // when (val collectState = state.value) {
    //        is ScreenState.ItemUpdated -> {}
    //        is ScreenState.Loading -> {}
    // }
    val listOfItems = remember {
        mutableStateListOf<ContentItem>(
            ContentItem(
                userId = 1,
                id = 10,
                title = "Десятый",
                body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto",
                isFavourite = false
            ),
            ContentItem(
                userId = 2,
                id = 15,
                title = "Пятнадцатый",
                body = "est rerum tempore vitae\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\nqui aperiam non debitis possimus qui neque nisi nulla",
                isFavourite = false
            ),
            ContentItem(
                userId = 3,
                id = 8,
                title = "Восьмой",
                body = "et iusto sed quo iure\nvoluptatem occaecati omnis eligendi aut ad\nvoluptatem doloribus vel accusantium quis pariatur\nmolestiae porro eius odio et labore et velit aut",
                isFavourite = false
            )
        )
    }
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
                Element(listOfItems[index]) {
                    // viewModel.addToFavourites(item = listOfItems[index])

                    listOfItems[index] = listOfItems[index].copy(
                        isFavourite = !listOfItems[index].isFavourite
                    )
                }
            }
        }
    }
}