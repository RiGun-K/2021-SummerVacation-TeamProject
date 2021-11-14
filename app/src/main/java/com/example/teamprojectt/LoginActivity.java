package com.example.teamprojectt;

import android.content.Intent;
        import android.os.Bundle;
        import android.text.method.HideReturnsTransformationMethod;
        import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.CompoundButton;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import androidx.appcompat.app.AppCompatActivity;

        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONException;
        import org.json.JSONObject;


        // 안드로이드 메인액티비티,레이아웃은 순서상관없이 무조건 첫화면에 뜨게 되어있음, 따라서 메인을 첫 화면으로 보내야함 ,
public class LoginActivity extends AppCompatActivity {
        private EditText et_id, et_pass;
        private Button btn_login, btn_register;
//        private CheckBox checkBox;
        private TextView et_jin;
        private ImageView et_logo;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);

                et_jin = findViewById(R.id.et_jin);
                et_id = findViewById(R.id.et_id);
                et_pass = findViewById(R.id.et_pass);
                btn_login = findViewById(R.id.btn_login);
                btn_register = findViewById(R.id.btn_register);
//                checkBox = findViewById(R.id.checkBox);
//
//                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                        @Override
//                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                                if (isChecked) {
//                                        et_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                                } else {
//                                        et_pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                                }
//                        }
//                });

                // 회원가입 버튼 클릭시 수행
                btn_register.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                                startActivity(intent);
                        }
                });


                btn_login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // EditText 에 현재 입력되어 있는 값을 get(가져온다) 해온다..
                                String userID = et_id.getText().toString();
                                String userPass = et_pass.getText().toString();

                                et_pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                                Response.Listener<String> responseListener = new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                                try {
                                                        JSONObject jsonObject = new JSONObject(response);
                                                        boolean success = jsonObject.getBoolean("success");
                                                        if (success) { // 로그인에 성공한 경우
                                                                String userID = jsonObject.getString("userID");
                                                                String userPass = jsonObject.getString("userPassword");


                                                                Toast toast = Toast.makeText(getApplicationContext(), et_id.getText()+" 님 환영합니다", Toast.LENGTH_LONG);
//                                                                Toast.makeText(getApplicationContext(), et_id.getText()+" 님 환영합니다", Toast.LENGTH_LONG).show();
//                                                                toast.setGravity(Gravity.BOTTOM, 0, 0);
                                                                toast.show();



                                                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                                                                intent.putExtra("userID", userID);
                                                                intent.putExtra("userPass", userPass);
                                                                startActivity(intent);
                                                        } else { // 로그인에 실패한 경우
                                                                Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다,", Toast.LENGTH_SHORT).show();
                                                                return;
                                                        }
                                                } catch (JSONException e) {
                                                        e.printStackTrace();
                                                }
                                        }
                                };
                                LoginRequest loginRequest = new LoginRequest(userID, userPass, responseListener);
                                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                                queue.add(loginRequest);
                        }
                });

        }



}
