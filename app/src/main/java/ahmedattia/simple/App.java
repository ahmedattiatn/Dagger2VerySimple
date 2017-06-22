package ahmedattia.simple;

import android.app.Application;

import ahmedattia.simple.dagger.component.DaggerNetComponent;
import ahmedattia.simple.dagger.component.NetComponent;
import ahmedattia.simple.dagger.module.AppModule;
import ahmedattia.simple.dagger.module.NetModule;

/**
 * Created by Ahmed Attia on 26/05/2017.
 */
/*this class is to tell Dagger to generate to code
for the dependency Injection
we always Put Dagger then name of the component  like this :DaggerNetComponent
* */
public class App extends Application {
    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://jsonplaceholder.typicode.com/"))
                .build();

    }

    public NetComponent getNetComponent() {
        return netComponent;
    }
}
