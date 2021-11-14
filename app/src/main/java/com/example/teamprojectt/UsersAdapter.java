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
        protected TextView pjid;
        protected TextView pjName;
        protected TextView pjContent;
        protected TextView pjEffect;
        protected TextView pjCount;

        public CustomViewHolder(View view) {
            super(view);
            this.pjid = (TextView) view.findViewById(R.id.textView_list_pjid);
            this.pjName = (TextView) view.findViewById(R.id.textView_list_pjName);
            this.pjContent = (TextView) view.findViewById(R.id.textView_list_pjContent);
            this.pjEffect = (TextView) view.findViewById(R.id.textView_list_pjEffect);
            this.pjCount = (TextView) view.findViewById(R.id.textView_list_pjCount);

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

        viewholder.pjid.setText(mList.get(position).getMember_pjid());
        viewholder.pjName.setText(mList.get(position).getMember_pjName());
        viewholder.pjContent.setText(mList.get(position).getMember_pjContent());
        viewholder.pjEffect.setText(mList.get(position).getMember_pjEffect());
        viewholder.pjCount.setText(mList.get(position).getMember_pjCount());
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}
