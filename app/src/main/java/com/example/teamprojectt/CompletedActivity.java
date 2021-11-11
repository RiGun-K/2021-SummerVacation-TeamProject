package com.example.teamprojectt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamprojectt.databinding.ActivityListcompleteBinding;

import java.util.ArrayList;

public class CompletedActivity extends AppCompatActivity {

    //binding은 간단히 findViewById를 쓰지않고 XML에 바로 접근해 object를 받아 View에 접근하는 방식
    ActivityListcompleteBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListcompleteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //DB가 없으므로 일단 대충 알잘딱으로 때려넣겠읍니당
        int[] imageId = {R.drawable.people4,R.drawable.people2,R.drawable.people3};
        String[] name = {"LeeHyounHo","Kimminsu","Parkjihye"};
        String[] lastMessage = {"Hey How are you", "I'm fine", "What ssap"};
        String[] lastmsgTime = {"8:45 am","11:12 am","18:05 pm"};
        String[] phoneNo = {"010-3888-3080","010-2288-7799","010-6805-9332"};
        String[] country = {"Korea","Russia","germany"};

        ArrayList<User> userArrayList = new ArrayList<>();

        for(int i = 0;i<imageId.length;i++){
            User user = new User(name[i],lastMessage[i],phoneNo[i],country[i],imageId[i]);
            userArrayList.add(user);
        }

        ListAdapter listAdapter = new ListAdapter(CompletedActivity.this,userArrayList);

        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(CompletedActivity.this,UserActivity.class);
                i.putExtra("name",name[position]);
                i.putExtra("phone",phoneNo[position]);
                i.putExtra("country",country[position]);
                i.putExtra("imageid",imageId[position]);
                startActivity(i);

            }
        });


    }

}
