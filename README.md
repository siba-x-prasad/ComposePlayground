# Jetpack Compose 

## Important Links
- https://www.jetpackcompose.net/
- https://www.youtube.com/watch?v=cDabx3SjuOY&list=PLQkwcJG4YTCSpJ2NLhDTHhi6XBNfk9WiC&index=2
- https://medium.com/androiddevelopers/effective-state-management-for-textfield-in-compose-d6e5b070fbe5
- 
- **What is Jetpack Compose ?**
- Jetpack Compose is a modern toolkit for building native Android UI. 
- Jetpack Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs. 
- Jetpack Compose is totally declarative programming, which means you can describe your user interface by invoking a set of composable.
- For past ten years we have been using a traditional way of imperative UI design.  

## Advantages of Jetpack Compose 
- It is very fast and offers a smooth performance. 
- It’s simple to learn.
- It is possible to interoperate with an imperative approach.
- Offers a better way to implement loose coupling principles.
- It is 100% made in Kotlin which makes it a modern approach in Android development.

## Composable Function
- It's same as any function in programming. But we need to annotate with @Composable annotation.
- Syntax:
```
@Composable
fun MethodName(parameter: String) {
//your content
}
```
- Example
```
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
```
## HelloWorld using Jetpack Compose
```
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting("World")
        }
    }
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
```

## Compose Topics
- [Youtube Link](https://github.com/siba-x-prasad/ComposePlayground/blob/main/readMe/ComposeYoutube.md)
- [Modifier](https://github.com/siba-x-prasad/ComposePlayground/blob/main/readMe/modifiers.md)
- [Preview](https://github.com/siba-x-prasad/ComposePlayground/blob/main/readMe/preview.md)
- [List](https://github.com/siba-x-prasad/ComposePlayground/blob/main/readMe/list.md)
- [Row & Column](https://github.com/siba-x-prasad/ComposePlayground/blob/main/readMe/rowColumn.md)
- [Scaffold](https://github.com/siba-x-prasad/ComposePlayground/blob/main/readMe/scaffold.md)
- [State Management](https://github.com/siba-x-prasad/ComposePlayground/blob/main/readMe/stateManagement.md)
- [Theme](https://github.com/siba-x-prasad/ComposePlayground/blob/main/readMe/theme.md)
- [TopBar & Navigation](https://github.com/siba-x-prasad/ComposePlayground/blob/main/readMe/topAppBarAndBottomNavigastionBar.md)


## Dependencies
```
And also you need to add some dependencies for Jetpack Compose. 

//compose_version = '1.0.2'
implementation 'androidx.activity:activity-compose:1.3.0-alpha06'
implementation "androidx.compose.ui:ui:$compose_version"
implementation "androidx.compose.material:material:$compose_version"
implementation "androidx.compose.ui:ui-tooling:$compose_version"
```



