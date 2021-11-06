package com.example.teamprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainFragment extends AppCompatActivity {


    private TextView tv_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {    // 액티비티 시작시 처음으로 실행
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);


//        시작하면 userID 값 받아와서 텍스트로 띄우는 코드 ( 필요없는 관계로 우선 주석처리 )
//        tv_id = findViewById(R.id.tv_id);
//
//        Intent intent = getIntent();
//        String userID = intent.getStringExtra("userID");
//
//        tv_id.setText(userID);

    }
}
