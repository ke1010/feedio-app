package feedio.app.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import feedio.app.android.screen.auth.data.AuthApiService
import feedio.app.android.screen.home.data.HomeApiService
import feedio.app.android.screen.reel.data.ReelApiService
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
    @InstallIn(SingletonComponent::class)
    object ApiModule {

        @Provides
        @Singleton
        fun provideAuthApiService(@AuthUrl retrofit: Retrofit): AuthApiService {
            return retrofit.create(AuthApiService::class.java)
        }

        @Provides
         @Singleton
        fun provideHomeApiService(@HomeUrl retrofit: Retrofit): HomeApiService {
            return retrofit.create(HomeApiService::class.java)

    }


    @Provides
    @Singleton
    fun provideReelApiService(@ReelUrl retrofit: Retrofit): ReelApiService {
        return retrofit.create(ReelApiService::class.java)

    }
}