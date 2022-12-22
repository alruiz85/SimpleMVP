package es.alruiz.awesomeapp.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.alruiz.awesomeapp.R;
import es.alruiz.awesomeapp.objects.User;
import es.alruiz.awesomeapp.ui.main.adapter.RecyclerMainUsersAdapter;

public class MainActivity extends AppCompatActivity implements MainView {

    Context context;

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

        context = getApplicationContext();
        mainPresenter = new MainPresenterImpl(this, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void showLoading() {
        rl_loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        rl_loading.setVisibility(View.GONE);
    }

    @OnClick({R.id.btn_getusers_main_activity})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_getusers_main_activity:
                mainPresenter.getUsers();
                break;
        }
    }

    @Override
    public void setRepositoryUsers(List<User> body) {
        LinearLayoutManager llm = new LinearLayoutManager(context);
        rvDataMainActivity.setLayoutManager(llm);

        RecyclerMainUsersAdapter adapter = new RecyclerMainUsersAdapter(body, context);
        rvDataMainActivity.setAdapter(adapter);
    }
}
