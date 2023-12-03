package com.adnanjelic.simpletvstreamingapp.ui.model

internal fun stubItems() = (1..6).map { categoryNumber ->
    val movies = (1..12).map { movieNumber ->
        MovieUiModel(
            id = movieNumber.toString(),
            title = "Category: $categoryNumber\n Movie: $movieNumber",
            posterUrl = posters.random()
        )
    }
    CategoryUiModel(
        id = categoryNumber.toString(),
        name = "Category$categoryNumber",
        items = movies
    )
}

private val posters = listOf(
    "https://www.closeup-shop.com/media/oart_0/oart_m/oart_14146/1023019_G524780.JPG",
    "https://assets-global.website-files.com/6009ec8cda7f305645c9d91b/6408f6e7b5811271dc883aa8_batman-min.png",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvHewK7CkVROUSV6nDdO5Jg5qvyj4hsmTHcbp3QUw73faWUEnZxzeB8Xzy2LbRjavu-Hs&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLEhz9cl-xEPBqbMFoHNjvKIgCNeJvuixaFlQfhcATU5fPTFPA8x1CXi9fMOFBgqykPOY&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmemzKKVB0fY9LSMGCrirER7gvgAeYfWHYnhK2egnm1BsyWKIoFtiyiMHaPNee69Z5hwY&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-H1SyGc-iERy3rLEk26nEq0UnUA1b6N7MZA&usqp=CAU"
)
