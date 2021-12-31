package com.example.teamprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private EditText et_id, et_pass, et_name, et_hakbun;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        // 홈 액티비티에서 '내 정보' 메뉴바 클릭이후 페이지
        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_name = findViewById(R.id.et_name);
        et_hakbun = findViewById(R.id.et_hakbun);

        // 수정 및 저장 버튼 클릭시 수행
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intent);

                Toast toast = Toast.makeText(getApplicationContext(), et_id.getText()+" 님 수정 및 저장되었습니다.", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        
    }
}
