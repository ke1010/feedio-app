package feedio.app.android.screen.home.data

import feedio.app.android.network.ApiUrl
import feedio.app.android.screen.home.model.HomeFeedResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApiService {

    @GET(ApiUrl.HOME_FEED)
    suspend fun fetchHomeFeed(@Query("lat") lat : Double,
                              @Query("lng") lng : Double) : Response<HomeFeedResponse>
}