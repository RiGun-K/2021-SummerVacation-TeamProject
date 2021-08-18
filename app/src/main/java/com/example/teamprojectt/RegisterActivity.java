package com.example.teamprojectt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

        TextView tv_error_email;
        private EditText et_id, et_pass, et_name, et_hakbun, et_email;
        private Button btn_register,validateButton;
        private boolean validate = false;       // 사용할 수 있는 아이디 인지 체크

        @Override
        protected void onCreate(Bundle savedInstanceState) {    // 액티비티 시작시 처음으로 실행
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_register);



            // 아이디 값 찾아주기
            et_id = findViewById(R.id.et_id);
            et_pass = findViewById(R.id.et_pass);
            et_name = findViewById(R.id.et_name);
            et_hakbun = findViewById(R.id.et_hakbun);

            /////////////////////// 중복 체크  하다 말앗음 php 없어서
            final Button validateButton = (Button) findViewById(R.id.validateButton);
            validateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String userID = et_id.getText().toString();
                    if (validate) {
                        return;             // 체크되면 종료
                    }
                    Dialog dialog;
                    if (userID.equals(""))   // 빈 값이라면
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        dialog = builder.setMessage("아이디는 빈칸 일 수 없습니다.")
                                .setPositiveButton("확인",null)
                                .create();
                        dialog.show();
                        return;
                    }
                    Response.Listener<String> responseListener = new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");

                                if(success) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                    builder.setMessage("사용할 수 있는 아이디입니다,")
                                            .setPositiveButton("확인",null)
                                            .create();
                                    builder.show();
                                    et_id.setEnabled(false);
                                    validate = true;
                                    et_id.setBackgroundColor(getResources().getColor(R.color.good));
                                    validateButton.setBackgroundColor(getResources().getColor(R.color.logo));

                                }
                                else {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                    builder.setMessage("사용할 수 없는 아이디입니다.")
                                            .setNegativeButton("확인",null)
                                            .create();
                                    builder.show();
                                }
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    };
                    ValidateRequest validateRequest = new ValidateRequest(userID,responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(validateRequest);

                }
            });


////////////////////////////////////

            et_email=findViewById(R.id.et_email);
            tv_error_email=findViewById(R.id.tv_error_email);

            et_email.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(!android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()){
                        tv_error_email.setText("이메일 형식으로 입력해주세요.");    // 경고 메세지
                        et_email.setBackgroundResource(R.drawable.red_edittext);  // 적색 테두리 적용
                    }
                    else{
                        tv_error_email.setText("");         //에러 메세지 제거
                        et_email.setBackgroundResource(R.drawable.white_edittext);  //테투리 흰색으로 변경
                    }
                }// afterTextChanged()..
            });


            // 회원가입 버튼 클릭시 수행
            btn_register = findViewById(R.id.btn_register);
            btn_register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // EditText 에 현재 입력되어 있는 값을 get(가져온다) 해온다..
                    String userID = et_id.getText().toString();
                    String userPass = et_pass.getText().toString();
                    String userName = et_name.getText().toString();

                    int userHakbun = Integer.parseInt(et_hakbun.getText().toString());


                    // 중복체크를 하지 않고 회원가입을 누를시 메세지가 호출되며 창이 닫힌다 .
                    if(!validate) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                        builder.setMessage("먼저 중복 체크를 해주세요.")
                                .setNegativeButton("확인",null)
                                .create();
                        builder.show();
                        return;
                    }

                    // equals 는 String 값은 빈칸을 확인 할 수 있지만 int는 안되는데 , int가 되는 메소드를 몰라서 생략함
//                if(userID.equals("") || userPass.equals("") || userName.equals("")  ) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
//                    builder.setMessage("빈 칸 없이 입력해주세요.")
//                            .setNegativeButton("확인",null)
//                            .create();
//                    builder.show();
//                    return;
//
//                }



                    Response.Listener<String> responseListener = new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");
                                if (success) { // 회원등록에 성공한 경우
                                    Toast.makeText(getApplicationContext(), "회원 등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                } else { // 회원등록에 실패한 경우
                                    Toast.makeText(getApplicationContext(), "회원 등록에 실패하였습니다,", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }

                    };
                    // 서버로 Volley를 이용해서 요청을 함.
                    RegisterRequest registerRequest = new RegisterRequest(userID,userPass,userName,userHakbun, responseListener);
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                    queue.add(registerRequest);


                }


            });



        }
}
