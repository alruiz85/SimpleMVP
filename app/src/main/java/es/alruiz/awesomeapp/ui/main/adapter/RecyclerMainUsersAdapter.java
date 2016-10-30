package es.alruiz.awesomeapp.ui.main.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import es.alruiz.awesomeapp.R;
import es.alruiz.awesomeapp.objects.User;

/**
 * Created by AlfonsoRuiz on 30/10/2016.
 */

public class RecyclerMainUsersAdapter extends RecyclerView.Adapter<RecyclerMainUsersAdapter.UserViewHolder> {

    private Context context;

    private List<User> users;

    public RecyclerMainUsersAdapter(List<User> users, Context context) {
        this.users = users;
        this.context = context;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_mainactivity, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.userName.setText(users.get(position).getLogin());
        holder.userRepository.setText(users.get(position).getRepos_url());
        Glide.with(context)
                .load(users.get(position).getAvatar_url())
                .into(holder.userAvatar);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class UserViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView userName;
        TextView userRepository;
        ImageView userAvatar;

        UserViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            userName = (TextView) itemView.findViewById(R.id.user_name);
            userRepository = (TextView) itemView.findViewById(R.id.person_repository);
            userAvatar = (ImageView) itemView.findViewById(R.id.img_user);
        }
    }


}