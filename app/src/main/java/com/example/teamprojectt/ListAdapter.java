package com.example.teamprojectt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class ListAdapter extends ArrayAdapter {

    //ListView의 어댑터 자바

    public ListAdapter(Context context, ArrayList<User> userArrayList) {

        super(context,R.layout.activity_list_item,userArrayList);


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        User user = (User) getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item,parent,false);

        }

        //listview는 ConvertView라는 배열로 관리하는데 제일 우수해서 사용함함
        ImageView imageView = convertView.findViewById(R.id.profile_image);
        //유저의 개인사진
        TextView username = convertView.findViewById(R.id.listviewName);
        //유저의 이름
        TextView lastMsg = convertView.findViewById(R.id.lastMessage);
        //유저의 한마디? 등등
        TextView time = convertView.findViewById(R.id.msgtime);
        //유저의 작성한 시간 DB에 created_at사용하면 될듯

        imageView.setImageResource(user.iamgeId);
        username.setText(user.name);
        lastMsg.setText(user.lastMessage);
        time.setText(user.lastMsgTime);


        //return super.getView(position, convertView, parent);
        return convertView;
    }
}