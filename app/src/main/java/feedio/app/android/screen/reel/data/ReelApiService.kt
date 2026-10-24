package feedio.app.android.screen.reel.data

import feedio.app.android.network.ApiUrl
import feedio.app.android.screen.reel.model.ReelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ReelApiService {

    @GET(ApiUrl.FETCH_REEL)
    suspend fun getReel(@Path("userId") userId: Int) : Response<ReelResponse>

}