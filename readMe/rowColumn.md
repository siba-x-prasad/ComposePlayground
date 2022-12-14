# Row & Column
- By using Row and Column, we can arrange items in horizontally  or  vertically
## What's Layouts in Android?
- It provides an invisible container to hold the views or layouts. 
- We can place a group of views/layouts inside the layouts. 
- Row and column are layouts to arrange our views in Linear manner.
## What's Linear manner?
- A Linear manner means one element per line. 
- In this manner, arrange the elements one to another in the same order either horizontally or vertically.
- **Row** - It arranges the views horizontally.
- **Column** - It arranges the views vertically.
## Row
- A Row will show each child next to the previous children. It's like a LinearLayout with a horizontal orientation.
```
@Composable
fun SimpleRow(){
    Row {
        Text(text = "Row Text 1",Modifier.background(Color.Red))
        Text(text = "Row Text 2",Modifier.background(Color.White))
        Text(text = "Row Text 3",Modifier.background(Color.Green))
    }
}
```
## Column
- A Column will show each child below the previous children. It's like a LinearLayout with vertical orientation.
```
@Composable
fun SimpleColumn(){
    Column {
        Text(text = "Column Text 1", Modifier.background(Color.Red))
        Text(text = "Column Text 2", Modifier.background(Color.White))
        Text(text = "Column Text 3", Modifier.background(Color.Green))
    }
}
```
## Column horizontalAlignment verticalArrangement
- horizontalAlignment = 
  - Alignment.Center,
  - Alignment.Start,
  - Alignment.End,
  - Alignment.CenterHorizontally,
- verticalArrangement = 
  - Arrangement.SpaceEvenly
  - Arrangement.SpaceAround
  - Arrangement.SpaceBetween
  - Arrangement.Center
  - Arrangement.Top
  - Arrangement.Bottom
## Row horizontalArrangement verticalAlignment
- horizontalArrangement = Alignment.CenterHorizontally,
- verticalAlignment = Arrangement.SpaceEvenly,

## Alignment
- There are nine alignment options that can apply to child UI elements:

| TopStart    | TopCenter    |  TopEnd   |
|-----|-----|-----|
|  CenterStart   | Center    |  CenterEnd   |
| BottomStart    | BottomCenter    |  BottomEnd   |

## Arrangement
- We also have three arrangements that can be applied as vertical and horizontal arrangements:
- **SpaceEvenly** arrangement places child elements across the main axis, including free space before the first and after the last child.
- **SpaceBetween**  arrangement places child elements across the main axis without free space before first and after the last child.
- **SpaceAround** arrangement places child elements across the main axis with half of the free space before the first and after the last child.

## Row & Column Arrangement and Alignment
- Row Arrangement and Alignment
```
@Composable
fun RowArrangement(){
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top, horizontalArrangement  =  Arrangement.SpaceEvenly) {
        Text(text = " Text 1")
        Text(text = " Text 2")
        Text(text = " Text 3")
    }
}
```
- Column Arrangement and Alignment
```
@Composable
fun ColumnArrangement(){
    Column(modifier = Modifier.fillMaxHeight().fillMaxWidth(),
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment  =  Alignment.End) {
        Text(text = "Text 1",Modifier.background(Color.Red))
        Text(text = "Text 2",Modifier.background(Color.White))
        Text(text = "Text 3",Modifier.background(Color.Green))
    }
}
```


