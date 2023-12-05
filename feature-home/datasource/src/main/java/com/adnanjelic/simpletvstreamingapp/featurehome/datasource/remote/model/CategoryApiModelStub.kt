package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.model


internal fun stubCategoryApiModels(): List<CategoryApiModel> = listOf(
    CategoryApiModel(
        id = "28",
        name = "Action",
        movies = stubMovieApiModels(28)
    ),
    CategoryApiModel(
        id = "12",
        name = "Adventure",
        movies = stubMovieApiModels(12)
    ),
    CategoryApiModel(
        id = "16",
        name = "Animation",
        movies = stubMovieApiModels(16)
    ),
    CategoryApiModel(
        id = "35",
        name = "Comedy",
        movies = stubMovieApiModels(35)
    ),
    CategoryApiModel(
        id = "80",
        name = "Crime",
        movies = stubMovieApiModels(80)
    )
)

private fun stubMovieApiModels(categoryId: Int) = (1..12).map { movieNumber ->
    MovieApiModel(
        id = "$categoryId$movieNumber",
        title = movieNames.random(),
        description = MOVIE_DESCRIPTION,
        posterUrl = posterUrls.random(),
        duration = durations.random(),
        rating = ratings.random(),
        trailerUrl = trailerUrls.random()
    )
}

private val movieNames = listOf(
    "The Creator",
    "Reign of Chaos",
    "Inferno",
    "Fast X",
    "Mission: Impossible - Dead Reckoning Part One",
    "The Equalizer 3",
    "The Hunger Games: The Ballad of Songbirds & Snakes"
)

private const val MOVIE_DESCRIPTION = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

private val posterUrls = listOf(
    "https://www.closeup-shop.com/media/oart_0/oart_m/oart_14146/1023019_G524780.JPG",
    "https://assets-global.website-files.com/6009ec8cda7f305645c9d91b/6408f6e7b5811271dc883aa8_batman-min.png",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTvHewK7CkVROUSV6nDdO5Jg5qvyj4hsmTHcbp3QUw73faWUEnZxzeB8Xzy2LbRjavu-Hs&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLEhz9cl-xEPBqbMFoHNjvKIgCNeJvuixaFlQfhcATU5fPTFPA8x1CXi9fMOFBgqykPOY&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTmemzKKVB0fY9LSMGCrirER7gvgAeYfWHYnhK2egnm1BsyWKIoFtiyiMHaPNee69Z5hwY&usqp=CAU",
    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-H1SyGc-iERy3rLEk26nEq0UnUA1b6N7MZA&usqp=CAU"
)

private val durations = listOf("1:55:12", "0:52:23", "2:11:00", "1:34:23", "1:45:00", "1:33:25")

private val ratings = listOf(4.7f, 9.8f, 6.6f, 7.5f, 8.9f, 5.9f, 9.1f, 8.3f)

private val trailerUrls = listOf(
    "https://nasa-i.akamaihd.net/hls/live/253565/NTV-Public1/master.m3u8",
    "http://www.streambox.fr/playlists/test_001/stream.m3u8",
    "http://cdn-fms.rbs.com.br/hls-vod/sample1_1500kbps.f4v.m3u8",
    "https://abclive1-lh.akamaihd.net/i/abc_live05@423399/master.m3u8"
)
