package ahmedattia.simple.dagger.module;

import android.app.Application;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ahmed Attia on 26/05/2017.
 */
@Module
public class NetModule {
    /*NetModule that will provide Retrofit and OkHttp*/
    private String mBaseURL;

    public NetModule(String mBaseURL) {
        this.mBaseURL = mBaseURL;
    }

    /* in this method we provide the Cache for our app (to store data
    from network)
    we initialize the cache ( initialize size to 10 mb and set the location of cache)
    */
    @Provides
    @Singleton
    Cache provideHttpCache(Application application) {
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    // provide Gson
    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    // provide  OkHttpClient
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Cache cache) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.cache(cache);

        return okHttpClient.build();
    }

    // provide Retrofit
    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        Retrofit.Builder retrofit = new Retrofit.Builder();
        retrofit.addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl(mBaseURL);
        return retrofit.build();
    }
}
