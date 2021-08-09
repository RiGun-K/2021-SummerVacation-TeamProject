package com.example.teamprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public class HomeFragment extends Fragment {

    private View view;
    private Button MainButton, MainButton2;
    private ImageView imageView;

    // Ctrl + o



    // 메인 (HomeFragment) 에서의 이벤트 처리

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        // fragment_home.xml 소환 

        MainButton = view.findViewById(R.id.MainButton);
        MainButton2 = view.findViewById(R.id.MainButton2);
        // 해당 xml 안에 있는 Button 객체 생성
        
        MainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                startActivity(intent);
            }
        });


        MainButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CompletedActivity.class);
                startActivity(intent);
            }
        });
        // 해당 Button 이벤트 객체 생성



        return view;
    }

}

