package com.example.teamprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

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
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userID = et_id.getText().toString();
                String userPassword = et_pass.getText().toString();
                String userName = et_name.getText().toString();

                int userHakbun = Integer.parseInt(et_hakbun.getText().toString());



                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { // 회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(), "회원 조회에 성공하였습니다.", Toast.LENGTH_SHORT).show();

                            } else { // 회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(), "회원 조회에 실패하였습니다,", Toast.LENGTH_SHORT).show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                };


                // 서버로 Volley를 이용해서 요청을 함.
                HomeActivityRequest homeregisterRequest = new HomeActivityRequest(userID, userPassword, userName, userHakbun, responseListener);
                RequestQueue queue = Volley.newRequestQueue(HomeActivity.this);
                queue.add(homeregisterRequest);
            }



        });

       
    }
}
