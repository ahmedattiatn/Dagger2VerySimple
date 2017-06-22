package ahmedattia.simple.dagger.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ahmed Attia on 26/05/2017.
 */
@Module
public class AppModule {
    /*AppModule that will provide context to other modules

    * Now because Retrofit and OkHttp will be used through the application
     * we will created an AppModule that will be instantiated when the Application starts
     * so that the app context is provided to Retrofit and OkHttp library
    * */
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }
}
