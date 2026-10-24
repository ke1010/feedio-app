package feedio.app.android.screen.home

import feedio.app.android.network.NetworkResult
import feedio.app.android.screen.home.model.HomeFeedResponse

interface HomeRepository {

    suspend fun getHomeFeed(lat : Double,lng: Double): NetworkResult<HomeFeedResponse>
}