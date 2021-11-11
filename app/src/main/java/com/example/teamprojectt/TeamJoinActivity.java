package com.example.teamprojectt;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class TeamJoinActivity extends AppCompatActivity {

    EditText pj_name, pj_count, pj_content, pj_effect;
    Button pj_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teamjoin);


        // 아이디 값 찾아주기
        pj_name = findViewById(R.id.pj_name);
        pj_count = findViewById(R.id.pj_count);
        pj_content = findViewById(R.id.pj_content);
        pj_effect = findViewById(R.id.pj_effect);



        // 프로젝트 생성 버튼 클릭시 수행
        pj_register = findViewById(R.id.pj_register);
        pj_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText 에 현재 입력되어 있는 값을 get(가져온다) 해온다..

                String pjName = pj_name.getText().toString();
                String pjContent = pj_content.getText().toString();
                String pjEffect = pj_effect.getText().toString();

                int pjCount = Integer.parseInt(pj_count.getText().toString());


                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { // 회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(), "프로젝트 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(TeamJoinActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else { // 회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(), "프로젝트 등록에 실패하였습니다,", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                };
                // 서버로 Volley를 이용해서 요청을 함.
                                                        // 객체생성한 순서대로 넣어야함
                PjRegisterRequest pjregisterRequest = new PjRegisterRequest(pjName,pjContent,pjEffect,pjCount, responseListener);
                RequestQueue queue = Volley.newRequestQueue(TeamJoinActivity.this);
                queue.add(pjregisterRequest);

            }


        });

    }






}
