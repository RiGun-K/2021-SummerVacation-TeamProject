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

public class CompletedActivity extends AppCompatActivity {

    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);


        // 공지사항 작성란
        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();
        noticeList.add(new Notice("1번째 프로젝트", " 1월1일 ~ ", "조장: 김ㅇㅇ"));
        noticeList.add(new Notice("2번째 프로젝트", " 7월 17일 ~ 개강전", "조장: ㅇㅇㅇ"));
        noticeList.add(new Notice("3번째 프로젝트", " 6월28일 ~ (월~금)", "조장: ㅇㅇㅇ"));
        noticeList.add(new Notice("4번째 프로젝트", " 7월 15일 ~ 23일", "조장: ㅇㅇㅇ"));

        adapter = new NoticeListAdapter(getApplicationContext(), noticeList);
        noticeListView.setAdapter(adapter);


        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);

    }

}
