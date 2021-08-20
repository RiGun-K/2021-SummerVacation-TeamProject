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


        tv_id = findViewById(R.id.tv_id);

        Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");

        tv_id.setText(userID);

    }
}
