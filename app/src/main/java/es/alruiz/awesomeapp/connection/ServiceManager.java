package es.alruiz.awesomeapp.connection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import es.alruiz.awesomeapp.BuildConfig;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AlfonsoRuiz on 01/11/2016.
 */

public class ServiceManager {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    private static Retrofit retrofit;

    public static <T> T createUsersService(Class<T> serviceClass) {
        createRestAdapterInstance();
        return retrofit.create(serviceClass);
    }

    private static void createRestAdapterInstance() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(DATE_FORMAT);
        Gson gson = gsonBuilder
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }


}