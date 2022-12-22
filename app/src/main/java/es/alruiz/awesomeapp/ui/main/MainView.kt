package es.alruiz.awesomeapp.ui.main

import es.alruiz.awesomeapp.objects.User

/**
 * Created by AlfonsoRuiz on 30/10/2016.
 */
interface MainView {
    fun showLoading()
    fun hideLoading()
    fun setRepositoryUsers(body: List<User>)
}