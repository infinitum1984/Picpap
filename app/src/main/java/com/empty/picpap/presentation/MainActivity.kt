package com.empty.picpap.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.empty.picpap.data.BaseRandomPhotoRepository
import com.empty.picpap.data.mapper.CloudPhotoMapper
import com.empty.picpap.data.net.ApiService
import com.empty.picpap.data.net.BaseCloudDataSource
import com.empty.picpap.domain.interactor.GetRandomPhotoInteractor
import com.empty.picpap.domain.mapper.PhotoDataToRandomPhotoDomain
import com.empty.picpap.presentation.ui.theme.PicpapTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        val BASE_URL = "https://api.unsplash.com/"
        val retrofit =
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
        val cloudDataSource = BaseCloudDataSource(retrofit.create(ApiService::class.java))
        val repository = BaseRandomPhotoRepository(cloudDataSource, CloudPhotoMapper())
        val getRandomPhotoInteractor = GetRandomPhotoInteractor(repository, PhotoDataToRandomPhotoDomain())
        GlobalScope.launch(Dispatchers.IO) {
            Log.d("Photo", getRandomPhotoInteractor.invoke().toString())
        }
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