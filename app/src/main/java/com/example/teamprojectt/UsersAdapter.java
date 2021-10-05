package com.example.teamprojectt;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.CustomViewHolder> {

    private ArrayList<PersonalData> mList = null;
    private Activity context = null;


    public UsersAdapter(Activity context, ArrayList<PersonalData> list) {
        this.context = context;
        this.mList = list;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView idUser;
        protected TextView projectName;
        protected TextView eMail;
        protected TextView phoneNumber;

        public CustomViewHolder(View view) {
            super(view);
            this.idUser = (TextView) view.findViewById(R.id.textView_list_idUser);
            this.projectName = (TextView) view.findViewById(R.id.textView_list_projectName);
            this.eMail = (TextView) view.findViewById(R.id.textView_list_eMail);
            this.phoneNumber = (TextView) view.findViewById(R.id.textView_list_phoneNumber);

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

        viewholder.idUser.setText(mList.get(position).getMember_idUser());
        viewholder.projectName.setText(mList.get(position).getMember_projectName());
        viewholder.eMail.setText(mList.get(position).getMember_eMail());
        viewholder.phoneNumber.setText(mList.get(position).getMember_phoneNumber());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
