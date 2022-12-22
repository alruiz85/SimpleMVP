package es.alruiz.awesomeapp.ui.main

import android.util.Log
import es.alruiz.awesomeapp.core.interactor.GetUsersInteractor
import es.alruiz.awesomeapp.core.interactor.impl.GetUsersInteractorImpl
import es.alruiz.awesomeapp.objects.User

/**
 * Created by AlfonsoRuiz on 30/10/2016.
 */
class MainPresenterImpl(private val view: MainView) {

    private val getUsersInteractor: GetUsersInteractor

    init {
        getUsersInteractor = GetUsersInteractorImpl()
    }

    fun getUsers() {
        view.showLoading()
        getUsersInteractor.getUsers(object : UserListener {
            override fun onSuccess(body: List<User>) {
                Log.i("TAG", "Usuario $body")
                view.setRepositoryUsers(body)
                view.hideLoading()
            }

            override fun onFailure() {
                Log.i("TAG", "Error: error del servidor")
                view.hideLoading()
            }
        })
    }

    interface UserListener {
        fun onSuccess(body: List<User>)
        fun onFailure()
    }
}