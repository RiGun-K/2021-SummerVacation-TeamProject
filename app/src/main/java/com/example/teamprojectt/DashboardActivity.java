package com.example.teamprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class DashboardActivity extends AppCompatActivity {

    private EditText jo_id, jo_pass, jo_email, jo_number;
    private Button jo_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);


        jo_id = findViewById(R.id.jo_id);
        jo_pass = findViewById(R.id.jo_pass);
        jo_email = findViewById(R.id.jo_email);
        jo_number = findViewById(R.id.jo_number);


        // 회원가입 버튼 클릭시 수행
        jo_register = findViewById(R.id.jo_register);
        jo_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText 에 현재 입력되어 있는 값을 get(가져온다) 해온다..
                String idUser = jo_id.getText().toString();
                String projectName = jo_pass.getText().toString();
                String eMail = jo_email.getText().toString();

                int phoneNumber = Integer.parseInt(jo_number.getText().toString());



                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success) { // 회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(), "회원 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(DashboardActivity.this, Dashboardfinal.class);
                                startActivity(intent);
                            } else { // 회원등록에 실패한 경우
                                Toast.makeText(getApplicationContext(), "회원 등록에 실패하였습니다,", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "회원 등록에 실패하였습니다.(php 오류)", Toast.LENGTH_SHORT).show();
                        }

                    }

                };
                // 서버로 Volley를 이용해서 요청을 함.
                DashboardRequest dashboardRequest = new DashboardRequest(idUser, projectName, eMail, phoneNumber, responseListener);
                RequestQueue queue = Volley.newRequestQueue(DashboardActivity.this);
                queue.add(dashboardRequest);


            }


        });
    }
}
