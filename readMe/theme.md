# Themes in Jetpack Compose
- If you create a new Jetpack compose project, you will see ui.theme package. It contains the following classes.
- **Color.kt**  - for custom colors
- **Shape.kt** - for custom shapes 
- **Type.kt** - for custom typography 
- **Theme.kt** - for custom themes
## Material Theme
- A Material Theme defines the styling principles from the Material Design specification. 
- In Jetpack Compose, MaterialTheme is available as a composable function with which we can customize the default attributes.
```
MaterialTheme(
    colors = colors,
    typography = Typography,
    shapes = Shapes,
    content = content
)
```
- The Material Design components (buttons, cards, switches, and so on) are built on top of Material Theming, which is a systematic way to customize Material Design to better reflect your product’s brand. 
- A Material Theme comprises color, typography and shape attributes. When you customize these attributes, it automatically reflected your changes in the components.

- Follow this **https://www.jetpackcompose.net/themes-in-jetpack-compose**
- 