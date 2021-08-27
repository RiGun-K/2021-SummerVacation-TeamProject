package com.example.teamprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboardfinal extends AppCompatActivity {

    private TextView tv_id, tv_pass, tv_name, tv_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);


        tv_id = findViewById(R.id.tv_id);
        tv_pass = findViewById(R.id.tv_pass);
        tv_name = findViewById(R.id.tv_name);
        tv_age = findViewById(R.id.tv_age);


        Intent intent = getIntent();

        String idUser = intent.getStringExtra("idUser");
        String projectName = intent.getStringExtra("projectName");
        String eMail = intent.getStringExtra("eMail");

        // Int 형 데이터는 기본값 0 이나 1을 주어야 함 !!
        Integer phoneNumber = intent.getIntExtra("phoneNumber",0);

        tv_id.setText(idUser);
        tv_pass.setText(projectName);
        tv_name.setText(eMail);

        // Int 형은 "" 을 줘야함 !
        tv_age.setText(phoneNumber+"");


    }

}
