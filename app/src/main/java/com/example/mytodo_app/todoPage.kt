package com.example.mytodo_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.Locale


@Composable
fun todolstpage(viewModel: todoViewModel) {
    var inputxt by remember {
        mutableStateOf("")
    }
    val todoList by viewModel.todoList.observeAsState()

    Column(modifier= Modifier
        .fillMaxHeight()
        .padding(10.dp)) {

        Spacer(modifier = Modifier.height(40.dp))
        hdline("❔What 2 Do📃")


        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
            OutlinedTextField(value =inputxt , onValueChange ={
                inputxt = it
            },
                )
            Button(onClick = {
                viewModel.addTodo(inputxt)
                inputxt= ""
            }) {
                Text(text = "Add")
            }
        }
        todoList?.let {
            LazyColumn(
                content = {
                    itemsIndexed(it){index: Int, item: todo ->
                        todoitem(item = item, ondel = {
                            viewModel.deltodo(item.id)
                        })
                    }
                }
            )
        }?: Text(
            modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
            text = "No Items added yet",
            fontSize = 16.sp
        )

    }
}

@Composable
fun todoitem(item : todo,ondel: ()-> Unit) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(text = SimpleDateFormat("HH:mm:aa, dd/MM",
                Locale.ENGLISH).format(item.createdAt),
                fontSize = 12.sp,
                color = Color.White
                )
            Text(text = item.title,
                fontSize = 20.sp,
                color = Color.White)
        }
        IconButton(onClick = ondel ) {
            Icon(painter = painterResource(id = R.drawable.del_icon),
                contentDescription = "del icon",
                tint = Color.White
                )
        }
    }
}

@Composable
fun hdline(head: String){
    Text(text = head,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp,10.dp),
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.SemiBold
        )

}

//@Preview(showBackground = true)
@Composable
private fun hdline() {
    hdline(head = "What 2 Do")
}