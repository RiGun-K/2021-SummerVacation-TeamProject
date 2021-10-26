package com.example.teamprojectt;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.net.HttpCookie;

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

    // layout 의 clickSave 정의
    public void clickSave(View view) {

        // EditText 에 잇는 글씨 열어오기
        String data = et.getText().toString();

        // Firebase 실시간 데이터 베이스에 저장

        // 1. Firebase 실시간 DB 관리 객체 얻어오기
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

        // 2. 저장시킬 노드 참조객체 가져오기
        //    ( )안에 비어있으면 최상위 노드
       DatabaseReference rootRef = firebaseDatabase.getReference();


        // 여기서부터 마지막 소스 코드 작성

        // 각 노드에 값 대입

//        // 1) 별도의 키 [Key : 식별자] 없이 값[value] 만 저장하기
//        rootRef.setValue(data);
//
//
//    //////////////////// 여기까지가 입력 데이터 DB 에 저장하기 /////////////////
//
//    //////////////////// 여기서부터 저장된 DB 데이터 불러오기 ////////////////////
//
//
//    // 별도의 읽어오기 버튼 X
//    // 실시간 DB 이므로, Data 가 변경되면 이에 반응하는 리스너를 통해 실시간 DB를 읽어옴
//    rootRef.addValueEventListener(new ValueEventListener() {
//        @Override
//        public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//            // 파라미터로 전달되어 온 DataSnapshot 객체를 통해 데이터를 가져올 수 있음
//            // 형변환이 귀찮으면 , getValue( ) 의 매개 변수로 자료형.class를 지정
//            String data = snapshot.getValue(String.class);
//            tv.setText(data);
//        }
//
//        @Override
//        public void onCancelled(@NonNull DatabaseError error) {
//
//        }
//    });

    // 위의 코드는 데이터 값이 변경됨 , 누적되어 저장되지 않음
    // 2) 누적 값 저장


    }
}
