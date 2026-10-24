package feedio.app.android.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import feedio.app.android.screen.auth.data.AuthRepositoryImpl
import feedio.app.android.screen.auth.domain.AuthRepository
import feedio.app.android.screen.home.HomeRepository
import feedio.app.android.screen.home.data.HomeRepositoryImpl
import feedio.app.android.screen.reel.ReelRepository
import feedio.app.android.screen.reel.data.ReelRepositoryImpl
import jakarta.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository


    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository

    @Binds
    @Singleton
    abstract fun bindReelRepository(
        reelRepositoryImpl: ReelRepositoryImpl
    ): ReelRepository


}