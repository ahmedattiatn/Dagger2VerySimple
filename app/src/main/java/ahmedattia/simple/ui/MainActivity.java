package ahmedattia.simple.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import ahmedattia.simple.App;
import ahmedattia.simple.Post;
import ahmedattia.simple.R;
import ahmedattia.simple.RestApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    /*The inject method will look for type of  variables annotated with @Inject
     and will provide dependency if there is any @Provides method that
     returns the same type
    * */
    @Inject
    Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // injection
       /* (App)getApplication()) : Context (class App)
       getNetComponent() fi class  App bech thezna lel class NetComponent fel package
       component
       fi class  NetComponent 3anna  méthode  inject hiya li feha
       fi anahi bech nesta3mlou retrofit we okhhtp we gson ....
        */
        ((App) getApplication()).getNetComponent().inject(this);


        //Create textview and findViewByID
        textView = (TextView) findViewById(R.id.textview_post);

        Call<List<Post>> posts = retrofit.create(RestApi.class).getPosts();
        posts.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                textView.setText(response.body().get(0).getBody().toString());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textView.setText(t.toString());
            }
        });

    }
}
