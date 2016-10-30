package es.alruiz.awesomeapp.ui.main;

import android.content.Context;

import es.alruiz.awesomeapp.core.interactor.GetUsersInteractor;
import es.alruiz.awesomeapp.core.interactor.impl.GetUsersInteractorImpl;

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

    }

}
