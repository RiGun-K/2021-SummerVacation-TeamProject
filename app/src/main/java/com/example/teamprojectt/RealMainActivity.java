package com.example.teamprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamprojectt.databinding.ActivityMainBinding;

public class RealMainActivity extends AppCompatActivity {

    private TextView text;
    private TextView text2;
    private Button Button, Button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);


        Button = findViewById(R.id.Button);
        Button2 = findViewById(R.id.Button2);



        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealMainActivity.this, IngProject.class);
                startActivity(intent);


            }
        });

        Button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RealMainActivity.this, CompletedProject.class);
                startActivity(intent);


            }
        });

    }

}
