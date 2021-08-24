package com.example.teamprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Dashboardfinal extends AppCompatActivity {

    private TextView tv_id, tv_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        // 프로젝트 생성한 아이디,비밀번호 값 넘어오지않음

    tv_id = findViewById(R.id.tv_id);
//    tv_pass = findViewById(R.id.tv_pass);


    Intent intent = getIntent();
    String idUser = intent.getStringExtra("idUser");
//    String projectName = intent.getStringExtra("projectName");

    tv_id.setText(idUser);
//    tv_pass.setText(projectName);


    }

}
