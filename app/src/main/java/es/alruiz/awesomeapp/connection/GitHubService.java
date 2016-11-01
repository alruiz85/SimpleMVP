package es.alruiz.awesomeapp.connection;

import java.util.List;

import es.alruiz.awesomeapp.objects.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by AlfonsoRuiz on 01/11/2016.
 */

public interface GitHubService {

    @Headers("Accept:application/json")
    @GET("users")
    Call<List<User>> listUsers();

}
