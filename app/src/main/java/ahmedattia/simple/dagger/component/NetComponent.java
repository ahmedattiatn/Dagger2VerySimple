package ahmedattia.simple.dagger.component;

import javax.inject.Singleton;

import ahmedattia.simple.dagger.module.AppModule;
import ahmedattia.simple.dagger.module.NetModule;
import ahmedattia.simple.ui.MainActivity;
import dagger.Component;

/**
 * Created by Ahmed Attia on 26/05/2017.
 */
@Singleton
@Component (modules ={AppModule.class, NetModule.class})
/*We create a method called inject and pass activity
 in which we will require retrofit in our case we will be calling it only
  from MainActivity.(You can add other Activity or Fragments)*/
public interface NetComponent {
    void inject (MainActivity mainActivity);
}
