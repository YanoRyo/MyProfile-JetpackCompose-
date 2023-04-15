package com.example.myprofilejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myprofilejetpackcompose.components.CompanySection
import com.example.myprofilejetpackcompose.components.DetailSection
import com.example.myprofilejetpackcompose.ui.theme.MyProfileJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyProfileJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        // プロフィール画像
        Image(painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "プロフィール",
            modifier = Modifier
                .size(120.dp)
                .clip(RoundedCornerShape(30.dp))
        )
        Spacer(modifier = Modifier.height(20.dp))
        // 名前
        Text(text = "矢野　涼",
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Spacer(modifier = Modifier.height(20.dp))
        // 職業
        Text(text = "職業: Androidエンジニア",
            color = Color.Gray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))
        CompanySection()
        Spacer(modifier = Modifier.height(10.dp))

        // 詳細表示ボタン
        Button(
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF85F6A)),
            onClick = { /*TODO*/ },
        ) {
            Text(text = "詳細を表示",
                color = Color.White,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        // 居住地と趣味セクション
        DetailSection()
    }
}

