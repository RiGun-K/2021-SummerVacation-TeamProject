package com.example.teamprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ListView noticeListView2;
    private NoticeListAdapter2 adapter;
    private List<Notice2> noticeList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ing);


        // 공지사항 작성란
        noticeListView2 = (ListView) findViewById(R.id.noticeListView2);
        noticeList2 = new ArrayList<Notice2>();
        noticeList2.add(new Notice2("1번째 프로젝트", " 7월5일 ~ ", "조장: 박ㅇㅇ"));
        noticeList2.add(new Notice2("2번째 프로젝트", " 6월 17일 ~ 개강전", "조장: ㅇㅇㅇ"));
        noticeList2.add(new Notice2("3번째 프로젝트", " 6월28일 ~ (월~금)", "조장: ㅇㅇㅇ"));
        noticeList2.add(new Notice2("4번째 프로젝트", " 7월 15일 ~ 23일", "조장: ㅇㅇㅇ"));

        adapter = new NoticeListAdapter2(getApplicationContext(), noticeList2);
        noticeListView2.setAdapter(adapter);


        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice2);

    }
}
