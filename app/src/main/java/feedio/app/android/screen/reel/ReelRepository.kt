package feedio.app.android.screen.reel

import feedio.app.android.network.NetworkResult
import feedio.app.android.screen.reel.model.ReelResponse

interface ReelRepository {

    suspend fun fetchReel(userId : Int) : NetworkResult<ReelResponse>
}