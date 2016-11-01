package es.alruiz.awesomeapp.core.interactor.impl;

import android.util.Log;

import java.util.List;

import es.alruiz.awesomeapp.connection.GitHubService;
import es.alruiz.awesomeapp.connection.ServiceManager;
import es.alruiz.awesomeapp.core.interactor.GetUsersInteractor;
import es.alruiz.awesomeapp.objects.User;
import es.alruiz.awesomeapp.ui.main.MainPresenter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by AlfonsoRuiz on 30/10/2016.
 */

public class GetUsersInteractorImpl implements GetUsersInteractor {

    @Override
    public void getUsers(final MainPresenter.UserListener userListener) {
        GitHubService gitHubService = ServiceManager.createUsersService(GitHubService.class);
        Call<List<User>> userCall = gitHubService.listUsers();
        userCall.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    userListener.onSuccess(response.body());
                } else {
                    userListener.onFailure();
                }

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("TAG", "Error: " + t.getMessage(), t);
            }
        });
    }
}
