package es.alruiz.awesomeapp.ui.main;

import android.content.Context;
import android.util.Log;

import java.util.List;

import es.alruiz.awesomeapp.core.interactor.GetUsersInteractor;
import es.alruiz.awesomeapp.core.interactor.impl.GetUsersInteractorImpl;
import es.alruiz.awesomeapp.objects.User;

/**
 * Created by AlfonsoRuiz on 30/10/2016.
 */

public class MainPresenterImpl implements MainPresenter {

    private MainActivity mainActivity;
    private GetUsersInteractor getUsersInteractor;

    public MainPresenterImpl(MainActivity mainActivity, Context context) {
        this.mainActivity = mainActivity;
        getUsersInteractor = new GetUsersInteractorImpl();
    }

    @Override
    public void getUsers() {
        mainActivity.showLoading();
        getUsersInteractor.getUsers(new MainPresenter.UserListener() {
            @Override
            public void onSuccess(List<User> body) {
                Log.i("TAG", "Usuario "+ body);
                mainActivity.setRepositoryUsers(body);
                mainActivity.hideLoading();
            }

            @Override
            public void onFailure() {
                Log.i("TAG", "Error: error del servidor");
                mainActivity.hideLoading();
            }
        });
    }


}
