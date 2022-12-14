# State Management
## What is state in jetpack compose?
- A state is an object it can hold our data. If data changes happen, it will update all its subscribed UI widgets. 
- If you want to update the data at runtime in your widgets, you can use the state object.
## State<T>
- A type that holds a read-only value: It notifies the composition when value changes.
## MutableState<T>
- It's extension function of State. It allows us to update the value.
- When the value property is written to and changed, a recomposition of any subscribed RecomposeScopes will be scheduled.
- If value is written to with the same value, no recompositions will be scheduled.
- Example:
```
    var selectedIndex by mutableStateOf(0)
    //selectedIndex = 5
```
## No State
- If we create the object without state, it doesn't update your UI when your data get changed.
```
@Composable
fun NoState() {
    var clickCount = 0
    Column {
        Button(onClick = {
            clickCount++
            Log.d("TAG", "NoState: "+clickCount)
            }) {
                Text(text = ""+clickCount+" times clicked")
        }
    }
}
```
- **Why it doesn't update the UI?**
- It just changes the value of the variable, but our UI needs to refresh.
- For auto UI refresh, we need state objects. 
- If we use a state object, our UI will get refreshed automatically when data gets changed. 
- Let's test the same code with the state object.
## With State Object:
- It works as expected. But it has some problems, if you use this state object with child composable it will not work. 
- When you use this code, Android studio will give a warning and it recommended using it along with remember.
```
@Composable
fun MutableStateClick() {
    var clickCount by mutableStateOf(0)//Not recommended
    Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "" + clickCount + " times clicked")
        }
    }
}
```
## Remember:
- The remember keyword can store a mutable or an immutable object. 
- If value changes, it will trigger recomposition(refresh the UI) to update the widgets.
-Syntax:
```
    val currentValue = remember { mutableStateOf(0) } //Int
    val userName = remember { mutableStateOf("") } //String
```
- Example:
```
@Composable
fun RememberSample() {
    var clickCount by remember { mutableStateOf(0) }
        Column {
        Button(onClick = { clickCount++ }) {
            Text(text = "" + clickCount + " times clicked")
        }
    }
}
```
- Remember works with child composable also. You can pass as an argument to your child composable function. 
## Drawback:
- If your device orientation gets changed, the value will reset.
- If you want to keep the data even if the activity recreated/orientation change happened, use "rememberSavable". 

## Remember Saveable:
- Use rememberSaveable to restore your UI state after an activity or process is recreated. 
- rememberSaveable retains state across recompositions. 
- In addition, rememberSaveable also retains state across activity and process recreation.
```
@Composable
fun RememberSaveableSample() {
    var clickCount = rememberSaveable { mutableStateOf(0) }
        Column {
        Button(onClick = { clickCount.value++ }) {
            Text(text = "" + clickCount.value + " times clicked")
        }
    }
}
```




