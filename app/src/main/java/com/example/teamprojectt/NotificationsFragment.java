package com.example.teamprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class NotificationsFragment extends Fragment {

    private View view;
    private Button btn_edit, mylist;


    // Ctrl + o


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notifications,container,false);
        // home layout 과 연결

        // 수정 및 저장버튼
        btn_edit = view.findViewById(R.id.btn_edit);
        // 해당 xml 안에 있는 Button 객체 생성

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NotificationsActivity.class);
                startActivity(intent);
            }
        });


        // 프로젝트 리스트 생성 관련 버튼
        mylist = view.findViewById(R.id.mylist);

        mylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NotificationsActivity2.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
