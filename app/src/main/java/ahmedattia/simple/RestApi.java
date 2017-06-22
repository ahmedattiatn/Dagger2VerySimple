package ahmedattia.simple;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ahmed Attia on 26/05/2017.
 */

public interface RestApi {
    @GET("/posts")
    Call<List<Post>> getPosts();

}
