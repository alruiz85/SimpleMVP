package es.alruiz.awesomeapp.ui.main;

import android.util.Log;

import java.util.List;

import es.alruiz.awesomeapp.core.interactor.GetUsersInteractor;
import es.alruiz.awesomeapp.core.interactor.impl.GetUsersInteractorImpl;
import es.alruiz.awesomeapp.objects.User;

/**
 * Created by AlfonsoRuiz on 30/10/2016.
 */

public class MainPresenterImpl {

    private MainView view;
    private GetUsersInteractor getUsersInteractor;

    public MainPresenterImpl(MainView view) {
        this.view = view;
        getUsersInteractor = new GetUsersInteractorImpl();
    }

    public void getUsers() {
        view.showLoading();
        getUsersInteractor.getUsers(new UserListener() {
            @Override
            public void onSuccess(List<User> body) {
                Log.i("TAG", "Usuario " + body);
                view.setRepositoryUsers(body);
                view.hideLoading();
            }

            @Override
            public void onFailure() {
                Log.i("TAG", "Error: error del servidor");
                view.hideLoading();
            }
        });
    }

    public interface UserListener {
        void onSuccess(List<User> body);
        void onFailure();
    }

}

