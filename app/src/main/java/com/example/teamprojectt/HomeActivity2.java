package com.example.teamprojectt;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity2 extends AppCompatActivity {

    // DB 연결

    private static String IP_ADDRESS = "http://su1318ho.dothome.co.kr";
    private TextView txtView;
    private EditText editText1, editText2;
    Button insertBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage2);


        // 사용할 액티비티 선언
        editText1 = findViewById(R.id.edtText1);
        editText2 = findViewById(R.id.edtText2);
        insertBtn = findViewById(R.id.insertBtn);


        // String url = "http://" + IP + "/php파일명.php";
        String url = "http://su1318ho.dothome.co.kr/getjson.php";
        selectDatabase selectDatabase = new selectDatabase(url, null);
        selectDatabase.execute(); // AsyncTask는 .excute()로 실행된다


    }
}
