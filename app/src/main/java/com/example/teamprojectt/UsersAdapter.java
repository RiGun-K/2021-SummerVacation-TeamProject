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
        protected TextView iduser;
        protected TextView projectname;
        protected TextView email;
        protected TextView phonenumber;

        public CustomViewHolder(View view) {
            super(view);
            this.iduser = (TextView) view.findViewById(R.id.textView_list_idUser);
            this.projectname = (TextView) view.findViewById(R.id.textView_list_projectName);
            this.email = (TextView) view.findViewById(R.id.textView_list_eMail);
            this.phonenumber = (TextView) view.findViewById(R.id.textView_list_phoneNumber);

        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {

        viewholder.iduser.setText(mList.get(position).getMember_iduser());
        viewholder.projectname.setText(mList.get(position).getMember_projectname());
        viewholder.email.setText(mList.get(position).getMember_email());
        viewholder.phonenumber.setText(mList.get(position).getMember_phonenumber());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
