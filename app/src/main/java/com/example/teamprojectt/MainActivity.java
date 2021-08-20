package com.example.teamprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView; // 바텀 네비게이션 뷰 (하단바)
    private FragmentManager fm;
    private FragmentTransaction ft;

    private HomeFragment HomeFragment;
    private DashboardFragment DashboardFragment;
    private NotificationsFragment NotificationsFragment;
    private SnsFragment SnsFragment;


    private Button Button,Button2;
    private TextView tv_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {    // 액티비티 시작시 처음으로 실행
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 객체들을 생성
        bottomNavigationView = findViewById(R.id.bottomNavi);

        // 프래그먼트를 트랜잭션 작업
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        setFrag(0);
                        break;
                    case R.id.navigation_dashboard:
                        setFrag(1);
                        break;
                    case R.id.navigation_notifications:
                        setFrag(2);
                        break;
                    case R.id.navigation_sns:
                        setFrag(3);
                }
                return true;
            }
        });


        HomeFragment = new HomeFragment();
        DashboardFragment = new DashboardFragment();
        NotificationsFragment = new NotificationsFragment();
        SnsFragment =  new SnsFragment();

        // 처음 진입할시 (첫화면) 설정
        setFrag(0);   // case 0 번째에 해당하는 화면으로


    }

    // 프래그먼트 교체가 일어나는 실행문
    private void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        // 프레그먼트 교체시에 이 프레그먼트를 가져와서 트렌잭션을 하겠다.
        switch (n) {
            case 0:
                ft.replace(R.id.main_frame, HomeFragment);
                ft.commit(); // commit = 저장
                break;
            case 1:
                ft.replace(R.id.main_frame, DashboardFragment);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, NotificationsFragment);
                ft.commit();
                break;
            case 3:
                ft.replace(R.id.main_frame, SnsFragment);
                ft.commit();
                break;
        }


    }


}
