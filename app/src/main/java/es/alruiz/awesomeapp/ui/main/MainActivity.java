package es.alruiz.awesomeapp.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.alruiz.awesomeapp.R;
import es.alruiz.awesomeapp.objects.User;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.btn_getusers_main_activity)
    Button bUsersMainActivity;
    @BindView(R.id.rv_data_main_activity)
    RecyclerView rvDataMainActivity;
    @BindView(R.id.loadingPanel)
    RelativeLayout rl_loading;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mainPresenter = new MainPresenterImpl(this, this);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void setRepositoryUsers(List<User> body) {

    }
}
