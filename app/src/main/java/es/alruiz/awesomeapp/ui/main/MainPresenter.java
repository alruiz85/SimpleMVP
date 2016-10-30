package es.alruiz.awesomeapp.ui.main;

import java.util.List;

import es.alruiz.awesomeapp.objects.User;

/**
 * Created by AlfonsoRuiz on 30/10/2016.
 */

public interface MainPresenter {

    interface UserListener {

        void onSuccess(List<User> body);

        void onFailure();
    }

    void getUsers();

}
