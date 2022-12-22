package es.alruiz.awesomeapp.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.alruiz.awesomeapp.R
import es.alruiz.awesomeapp.objects.User
import es.alruiz.awesomeapp.ui.main.adapter.RecyclerMainUsersAdapter

class MainActivity : AppCompatActivity(), MainView {

    var mainPresenter: MainPresenterImpl? = null

    private lateinit var loading: RelativeLayout
    private lateinit var rvDataMainActivity: RecyclerView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loading = findViewById(R.id.loadingPanel)
        rvDataMainActivity = findViewById(R.id.rv_data_main_activity)
        button = findViewById(R.id.btn_getusers_main_activity)

        mainPresenter = MainPresenterImpl(this)
        button.setOnClickListener { mainPresenter?.getUsers() }
    }

    override fun showLoading() {
        loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loading.visibility = View.GONE
    }

    override fun setRepositoryUsers(body: List<User>) {
        rvDataMainActivity.layoutManager = LinearLayoutManager(this)
        rvDataMainActivity.adapter = RecyclerMainUsersAdapter(body, this)
    }
}