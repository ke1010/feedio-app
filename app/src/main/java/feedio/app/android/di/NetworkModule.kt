package feedio.app.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    @AuthUrl
    fun provideAuthRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://feedio-auth.onrender.com/v1-auth/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @HomeUrl
    fun provideHomeRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://feedio-rest.onrender.com/v1-home/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @ReelUrl
    fun provideReelRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://feedio-reel.onrender.com/v1-reel/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}