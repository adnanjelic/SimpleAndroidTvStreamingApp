package com.adnanjelic.simpletvstreamingapp.featurehome.datasource.remote.model


internal fun stubCategoryApiModels(): List<CategoryApiModel> = listOf(
    CategoryApiModel(
        id = "28",
        name = "Action",
        movies = moviesForCategory("28").shuffled()
    ),
    CategoryApiModel(
        id = "12",
        name = "Adventure",
        movies = moviesForCategory("12").shuffled()
    ),
    CategoryApiModel(
        id = "16",
        name = "Animation",
        movies = moviesForCategory("16").shuffled()
    ),
    CategoryApiModel(
        id = "35",
        name = "Comedy",
        movies = moviesForCategory("35").shuffled()
    ),
    CategoryApiModel(
        id = "80",
        name = "Crime",
        movies = moviesForCategory("80").shuffled()
    )
)

private const val HLS_VIDEO_STREAM =
    "https://cbsn-dal.cbsnstream.cbsnews.com/out/v1/ffa98bbf7d2b4c038c229bd4d9122708/master.m3u8"

private fun moviesForCategory(categoryId: String) = listOf(
    MovieApiModel(
        id = "$categoryId 1",
        title = "The Shawshank Redemption",
        description = "Over the course of several years, two convicts form a friendship, seeking consolation and, eventually, redemption through basic compassion.",
        posterUrl = "https://www.themoviedb.org/t/p/w1280/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg",
        duration = "2h 22m",
        rating = "9.3/10",
        trailerUrl = HLS_VIDEO_STREAM
    ),
    MovieApiModel(
        id = "$categoryId 2",
        title = "The Godfather",
        description = "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger.",
        posterUrl = "https://www.themoviedb.org/t/p/w1280/3bhkrj58Vtu7enYsRolD1fZdja1.jpg",
        duration = "2h 55m",
        rating = "9.2/10",
        trailerUrl = HLS_VIDEO_STREAM
    ),
    MovieApiModel(
        id = "$categoryId 3",
        title = "The Dark Knight",
        description = "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
        posterUrl = "https://www.themoviedb.org/t/p/w1280/qJ2tW6WMUDux911r6m7haRef0WH.jpg",
        duration = "2h 32m",
        rating = "9.0/10",
        trailerUrl = HLS_VIDEO_STREAM
    ),
    MovieApiModel(
        id = "$categoryId 4",
        title = "The Godfather Part II",
        description = "The early life and career of Vito Corleone in 1920s New York City is portrayed, while his son, Michael, expands and tightens his grip on the family crime syndicate.",
        posterUrl = "https://www.themoviedb.org/t/p/w1280/v3KCBeX0CBlZnHZndimm7taYqwo.jpg",
        duration = "3h 22m",
        rating = "9.0/10",
        trailerUrl = HLS_VIDEO_STREAM
    ),
    MovieApiModel(
        id = "$categoryId 5",
        title = "12 Angry Men",
        description = "Don Vito Corleone, head of a mafia family, decides to hand over his empire to his youngest son Michael. However, his decision unintentionally puts the lives of his loved ones in grave danger.",
        posterUrl = "https://www.themoviedb.org/t/p/w1280/ow3wq89wM8qd5X7hWKxiRfsFf9C.jpg",
        duration = "1h 36m",
        rating = "9.0/10",
        trailerUrl = HLS_VIDEO_STREAM
    ),
    MovieApiModel(
        id = "$categoryId 6",
        title = "Schindler's List",
        description = "In German-occupied Poland during World War II, industrialist Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.",
        posterUrl = "https://www.themoviedb.org/t/p/w1280/sF1U4EUQS8YHUYjNl3pMGNIQyr0.jpg",
        duration = "3h 15m",
        rating = "9.0/10",
        trailerUrl = HLS_VIDEO_STREAM
    ),
    MovieApiModel(
        id = "$categoryId 7",
        title = "The Lord of the Rings: The Return of the King",
        description = "Gandalf and Aragorn lead the World of Men against Sauron's army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.",
        posterUrl = "https://www.themoviedb.org/t/p/w1280/rCzpDGLbOoPwLjy3OAm5NUPOTrC.jpg",
        duration = "3h 21m",
        rating = "9.0/10",
        trailerUrl = HLS_VIDEO_STREAM
    ),
    MovieApiModel(
        id = "$categoryId 8",
        title = "Pulp Fiction",
        description = "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
        posterUrl = "https://www.themoviedb.org/t/p/w1280/d5iIlFn5s0ImszYzBPb8JPIfbXD.jpg",
        duration = "2h 34m",
        rating = "8.9/10",
        trailerUrl = HLS_VIDEO_STREAM
    ),
    MovieApiModel(
        id = "$categoryId 9",
        title = "The Lord of the Rings: The Fellowship of the Ring",
        description = "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.",
        posterUrl = "https://www.themoviedb.org/t/p/w1280/6oom5QYQ2yQTMJIbnvbkBL9cHo6.jpg",
        duration = "2h 58m",
        rating = "8.8/10",
        trailerUrl = HLS_VIDEO_STREAM
    ),
    MovieApiModel(
        id = "$categoryId 10",
        title = "The Good, the Bad and the Ugly",
        description = "A bounty hunting scam joins two men in an uneasy alliance against a third in a race to find a fortune in gold buried in a remote cemetery.",
        posterUrl = "https://www.themoviedb.org/t/p/w1280/bX2xnavhMYjWDoZp1VM6VnU1xwe.jpg",
        duration = "2h 58m",
        rating = "8.8/10",
        trailerUrl = HLS_VIDEO_STREAM
    ),
    MovieApiModel(
        id = "$categoryId 11",
        title = "Forrest Gump",
        description = "The history of the United States from the 1950s to the '70s unfolds from the perspective of an Alabama man with an IQ of 75, who yearns to be reunited with his childhood sweetheart.",
        posterUrl = "https://www.themoviedb.org/t/p/w1280/arw2vcBveWOVZr6pxd9XTd1TdQa.jpg",
        duration = "2h 22m",
        rating = "8.8/10",
        trailerUrl = HLS_VIDEO_STREAM
    ),
    MovieApiModel(
        id = "$categoryId 12",
        title = "Fight Club",
        description = "An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into much more.",
        posterUrl = "https://www.themoviedb.org/t/p/w1280/pB8BM7pdSp6B6Ih7QZ4DrQ3PmJK.jpg",
        duration = "2h 19m",
        rating = "8.8/10",
        trailerUrl = HLS_VIDEO_STREAM
    )
)
