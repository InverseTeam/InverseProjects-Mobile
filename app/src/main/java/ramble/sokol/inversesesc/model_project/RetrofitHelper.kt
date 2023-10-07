package ramble.sokol.inversesesc.model_project

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitHelper {

    // basic link to api
    private const val BASE_URL = "https://inverse-projects.store/api/"


    @Singleton
    @Provides
    fun getInstance(): Retrofit{

        // create Retrofit
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

}