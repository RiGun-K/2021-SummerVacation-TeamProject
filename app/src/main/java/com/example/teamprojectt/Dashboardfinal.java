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

    tv_id = findViewById(R.id.tv_id);
    tv_pass = findViewById(R.id.tv_pass);


    Intent intent = getIntent();
    String userID = intent.getStringExtra("userID");
    String projectName = intent.getStringExtra("projectName");

    tv_id.setText(userID);
    tv_pass.setText(projectName);

    }

}
