package feedio.app.android.screen.home.data

import feedio.app.android.network.NetworkResult
import feedio.app.android.screen.home.HomeRepository
import feedio.app.android.screen.home.model.HomeFeedResponse
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val homeApiService: HomeApiService
) : HomeRepository {

    override suspend fun getHomeFeed(lat : Double, lng : Double): NetworkResult<HomeFeedResponse> {
        return try {
            val response = homeApiService.fetchHomeFeed(lat, lng)
           if(response.isSuccessful){
               val body = response.body()
               if(body!=null && body.success){
                   NetworkResult.Success(body)
               }else{
                   NetworkResult.Error(body?.message ?: "Something went wrong")
               }
           }else{
               NetworkResult.Error(response.errorBody()?.string() ?: "Process failed")

           }

        }catch (e: Exception){
            NetworkResult.Error(e.localizedMessage ?: "Network error occurred")

        }
    }
}