package feedio.app.android.screen.reel.data

import feedio.app.android.network.NetworkResult
import feedio.app.android.screen.reel.ReelRepository
import feedio.app.android.screen.reel.model.ReelResponse
import javax.inject.Inject

class ReelRepositoryImpl @Inject constructor(
    private val reelApiService: ReelApiService
) : ReelRepository{
    override suspend fun fetchReel(userId: Int): NetworkResult<ReelResponse> {
        return try {
            val response = reelApiService.getReel(userId)
            if(response.isSuccessful) {
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