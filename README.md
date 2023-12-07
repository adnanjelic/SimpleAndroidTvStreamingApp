# SimpleAndroidTvStreamingApp

This is a simple TV streaming app for AndroidTV that shows and play movie content from HLS sources.


## Architecture and patterns
It is based on a **Clean Architecture**, **Coroutines**, **MVVM**, observable (**Flow**) and command patterns while following the **SOLID** principles and best practices.

Each feature is implemented in 5 layers with Dependency Inversion between datasource, data and domain layers (we can add to the presentation/domain layer as well in the future): 
- `datasource` layer provides local (`Room`) or remote (stubbed API response in `HomeInfoRemoteSourceImpl` for now) data sources. Since the API layer is behind an interface, the real REST service could easily be added later on.
- `data` layer holds the repositories and controls the data source flow. The data is provided from local source and if not found, updated from the remote service with `Flow`.
- `domain` layer holds the business logic and entities (`UseCases` and Domain models), and is in the center of the architecture, so it does not depend on any other module but `architecture`. The `domain` layer also controls the thread switching (main -> async -> main).  
- `presentation` layer is based on `ViewModel` (Android one to be lifecycle aware and easier DI).
- `ui` layer is a pure `Compose` layer with `Compose Navigation` between features.
- All layers have their own models and mappers to map them to/from other layers. 
- Dependency Injection is provided by `Hilt`.
- The lib dependencies are provided by the versions catalog.
- All code should be tested, but for the showcase purpose, only the `GetHomeInfoUseCase` and `MovieDomainToPresentationModelMapper` classes are covered by `UnitTests` for now.

## Features and modules
The idea is to have each feature as a separate set of modules (grouping feature layers in one module) for easier maintenance and easier integration into the app (or removing a feature completely).

There are 3 features/screens modules:
1. **Home** - Home screen with 6 category rows and 12 movies per category. Each movie has an unique id, but since the content is stubbed (there are 12 stubbed movies in the remote source), for faster implementation, they are shared among all categories (the movie order is randomized for each category).
2. **Movie Details** - Shows the details of a selected movie with poster, title, duration, rating, description, button to initiate the playback, and a button to go to the previous screen.
3. **Video Player** - Plays the video with progress info and standard controls. Additionally, there is a back button to go to the previous screen. It uses an external module player so it is easier to change in the future. 

The shared modules are exposed for all features to use them.
1. `shared` module contains specific `submodules` to be shared among features
2. `architecture`, `navigation` and `theme` modules are at a root level to be shared with all modules in the project

## Future plans
1. Fix the bugs with item/content selection on home and movie details screen
2. Make the navigation and notification code more abstract, simpler and reusable among features
3. Cover the rest of the code with Unit and UI tests.
4. Add `Compose` previews with data
5. Add the app title to the launcher icon to make it easier to discover
