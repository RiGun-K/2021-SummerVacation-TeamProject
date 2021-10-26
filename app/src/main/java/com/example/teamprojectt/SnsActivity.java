package com.example.teamprojectt;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SnsActivity extends AppCompatActivity {

    // 처음 시작은 Firebase console 에서
    // [프로젝트 만들기 or 추가] 를 통해 작업 순서[Workflow] 대로
    // 이 프로젝트와 firebase 연결

    TextView tv;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sns);

        // Sns 댓글창
        tv = findViewById(R.id.tv);
        et = findViewById(R.id.et);
    }

    public void clickSave(View view) {

    }
}
