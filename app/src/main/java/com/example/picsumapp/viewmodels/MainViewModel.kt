package com.example.picsumapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.picsumapp.model.Post
import com.example.picsumapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel(
        private val repository: Repository,
): ViewModel(){



    val myResponse:MutableLiveData<Response<List<Post>>> = MutableLiveData()
//    val postsResponse:MutableLiveData<NetworkResult<Post>> = MutableLiveData()
//
////    fun getPosts(){
////        getPostsSafeCall()
////    }
//
//    @RequiresApi(Build.VERSION_CODES.M)
//    private suspend fun getPostsSafeCall() {
//        if (hasInternetConnection()){
//            try {
//                val response = repository.getPosts()
//                postsResponse.value = handlePostsResponse(response)
//            }catch (e:Exception){
//
//            }
//        }else{
//            postsResponse.value = NetworkResult.Error("No Internet Connection")
//        }
//    }
//
//    private fun handlePostsResponse(response: Response<Post>): NetworkResult<Post>? {
//        when{
//            response.message().toString().contains("timeout")->{
//                return NetworkResult.Error("TimeOut")
//            }
//            response.code() == 404 ->{
//                return NetworkResult.Error("Not Found")
//            }
//            response.body().() ->{
//                return NetworkResult.Error("Posts not Found.")
//            }
//            response.isSuccessful ->{
//                val posts = response.body()
//                return NetworkResult.Success(posts)
//            }
//            else->{
//               return NetworkResult.Error(response.message())
//            }
//        }
//    }
//
    fun getPosts(){
       viewModelScope.launch {
           val response = repository.getPosts()
           myResponse.value = response
       }
    }
//
//    @RequiresApi(Build.VERSION_CODES.M)
//    private fun hasInternetConnection():Boolean{
//        val connectivityManager = getApplication<Application>().getSystemService(
//                Context.CONNECTIVITY_SERVICE
//        )as ConnectivityManager
//
//        val activeNetwork = connectivityManager.activeNetwork ?: return false
//        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
//
//        return when{
//            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
//            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
//            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
//            else ->false
//        }
//
//    }
}