package br.com.luizinho.goldwise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.luizinho.goldwise.ui.theme.GoldWiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoldWiseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GoldWise(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GoldWise(modifier: Modifier = Modifier) {

    var quantity by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.ic_logo),
                contentDescription = "Logo do app",
                modifier = Modifier.size(64.dp)
            )

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                stringResource(R.string.app_name),
                fontSize = 22.sp,
                fontWeight =  FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))
        
        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Quantidade") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Preço") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        var context = LocalContext.current

        Button(
            onClick = {
                if (price.isEmpty() || quantity.isEmpty()){
                    result = "Preencha todos os campos!"
                }else{
                    val total = quantity.toDouble()*price.toDouble()
                    result = context.getString(R.string.label_result, total)
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }

        OutlinedButton(
            onClick = {
                quantity = ""
                price = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Limpar")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(result)


    }
}


@Preview(showBackground = true)
@Composable
fun GoldWisePreview(modifier: Modifier = Modifier) {
    GoldWiseTheme {
        GoldWise()
    }
}