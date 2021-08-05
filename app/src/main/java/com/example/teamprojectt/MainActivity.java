package com.example.teamprojectt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.teamprojectt.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // 싹 다 갈아엎고 프레그먼트를 사용해서 화면전환을 하는수 밖에 없다.
    //


    private TextView text;
    private TextView text2;
    private Button Button, Button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//
//
//        Button = findViewById(R.id.Button);
//        Button2 = findViewById(R.id.Button2);
//
//
//
//        Button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, IngProject.class);
//                startActivity(intent);
//
//
//            }
//        });
//
//
//
//
//
//
//        Button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, CompletedProject.class);
//                startActivity(intent);
//
//
//            }
//        });
//
//
    }



    private long lastTimeBackPressed;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
            finish();
            return;
        }
        Toast.makeText(this, "'뒤로' 버튼을 한 번 더 눌러 종료합니다.", Toast.LENGTH_SHORT).show();
        lastTimeBackPressed = System.currentTimeMillis();

    }

}