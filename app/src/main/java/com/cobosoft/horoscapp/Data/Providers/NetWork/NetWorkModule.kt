package com.cobosoft.horoscapp.Data.Providers.NetWork

import com.cobosoft.horoscapp.BuildConfig.BASE_URL
import com.cobosoft.horoscapp.Data.Providers.Core.Interceptor.AuInterceptor
import com.cobosoft.horoscapp.Data.Providers.RepositoryImp
import com.cobosoft.horoscapp.Domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
      return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
          .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesOKhttpñient(auInterceptor: AuInterceptor):OkHttpClient{

        val interceptor=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .addInterceptor(auInterceptor)
            .build()

    }

    @Provides
    fun provideHoroscopeApiService(retrofit: Retrofit):HoroscopeApiService{

       return retrofit.create(HoroscopeApiService::class.java)
    }

    @Provides
    fun provideRepository(apiService: HoroscopeApiService):Repository{
        return RepositoryImp(apiService)
    }


}