package com.example.teamprojectt;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.ArrayList;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.CustomViewHolder> {

    private ArrayList<PersonalData> mList = null;
    private Activity context = null;


    public UsersAdapter(Activity context, ArrayList<PersonalData> list) {
        this.context = context;
        this.mList = list;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView userID;
        protected TextView userPassword;
        protected TextView userName;
        protected TextView userHakbun;

        public CustomViewHolder(View view) {
            super(view);
            this.userID = (TextView) view.findViewById(R.id.textView_list_userID);
            this.userPassword = (TextView) view.findViewById(R.id.textView_list_userPassword);
            this.userName = (TextView) view.findViewById(R.id.textView_list_userName);
            this.userHakbun = (TextView) view.findViewById(R.id.textView_list_userHakbun);

        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mypage2_list, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.userID.setText(mList.get(position).getMember_userID());
        viewholder.userPassword.setText(mList.get(position).getMember_userPassword());
        viewholder.userName.setText(mList.get(position).getMember_userName());
        viewholder.userHakbun.setText(mList.get(position).getMember_userHakbun());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
