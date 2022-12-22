package es.alruiz.awesomeapp.core.interactor;

import es.alruiz.awesomeapp.ui.main.MainPresenterImpl;

/**
 * Created by AlfonsoRuiz on 30/10/2016.
 */

public interface GetUsersInteractor {

    void getUsers(MainPresenterImpl.UserListener userListener);

}
