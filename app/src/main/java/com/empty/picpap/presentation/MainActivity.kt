package com.empty.picpap.presentation

import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.empty.picpap.presentation.random_photo.RandomPhotoViewModel
import com.empty.picpap.presentation.ui.theme.PicpapTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val randomPhotoViewModel: RandomPhotoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        randomPhotoViewModel.photoImg.observe(this,{
            runOnUiThread{
                Toast.makeText(this,it, Toast.LENGTH_LONG).show()
            }
        })
        setContent {
            PicpapTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
//        val BASE_URL = "https://api.unsplash.com/"
//        val retrofit =
//            Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl(BASE_URL)
//                .build()
//        val cloudDataSource = BaseCloudDataSource(retrofit.create(ApiService::class.java))
//        val repository = BaseRandomPhotoRepository(cloudDataSource, CloudPhotoMapper())
//        val getRandomPhotoInteractor = GetRandomPhotoInteractor(repository, PhotoDataToRandomPhotoDomain())
//        GlobalScope.launch(Dispatchers.IO) {
//            Log.d("Photo", getRandomPhotoInteractor.invoke().toString())
//        }
    }

}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PicpapTheme {
        Greeting("Android")
    }
}