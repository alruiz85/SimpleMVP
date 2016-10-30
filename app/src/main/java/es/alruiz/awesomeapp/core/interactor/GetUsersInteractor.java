package es.alruiz.awesomeapp.core.interactor;

import es.alruiz.awesomeapp.ui.main.MainPresenter;

/**
 * Created by AlfonsoRuiz on 30/10/2016.
 */

public interface GetUsersInteractor {

    void getUsers(MainPresenter.UserListener userListener);

}
