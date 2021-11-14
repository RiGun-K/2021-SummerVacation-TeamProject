package com.example.teamprojectt;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class DashboardActivity extends AppCompatActivity {

    // 로그에 사용할 TAG 변수
    final private String TAG = getClass().getSimpleName();

    ListView listView;
    Button reg_button;
    //    String et_id = "";
    String userid = "";

    // 리스트뷰 에 사용할 제목 배열
    ArrayList<String> titlelist = new ArrayList<>();
    // 클릭시 게시물 번호를 담기위한 배열
    ArrayList<String> seqList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        // LoginActivity 에서 넘긴 유저의 아이디값 받기
        userid = getIntent().getStringExtra("userid");

        // 컴포넌트 초기화
        listView = findViewById(R.id.listView);

        // listView 를 클릭시 이벤트
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // 어떤 값을 선택했는지 토스트 전송
                Toast.makeText(DashboardActivity.this, adapterView.getItemAtPosition(i)
                                + "클릭", Toast.LENGTH_SHORT).show();

                // 게시물 번호와 userID를 가지고 DashboardFinal2 로 이동
                Intent intent = new Intent(DashboardActivity.this, Dashboardfinal2.class);
                intent.putExtra("board_seq", seqList.get(i));
                intent.putExtra("userid", userid);
                startActivity(intent);
            }
        });


        // 버튼 컴포넌트 초기화
        reg_button = findViewById(R.id.reg_button);
        // 버튼 이벤트 추가
        reg_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // userID 를 가지고 DashboardFinal 로 이동
                Intent intent = new Intent(DashboardActivity.this, Dashboardfinal.class);
// 11/12 userid 없으므로 우선 주석              intent.putExtra("userid", userid);
                startActivity(intent);
            }
        });
    }

    // onResume() 은 해당 액티비티가 화면에 나타날때 호출
    @Override
    protected void onResume() {
        super.onResume();
        // 해당 액티비티가 활성화 될때, 게시물 리스트 불러오는 함수 호출
        GetBoard getBoard = new GetBoard();
        getBoard.execute();
    }

    class GetBoard extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "onPreExecute");
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.d(TAG, "onPostExecute" + result);

            // 배열들 초기화
            titlelist.clear();
            seqList.clear();

            try {
                // 결과물이 JSONArray 형태로 넘어오므로 파싱
                JSONArray jsonArray = new JSONArray(result);

                for(int i=0; i<jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    String title = jsonObject.optString("title");
                    String seq = jsonObject.optString("seq");

                    // title, seq 값을 변수로 받아 배열에 추가
                    titlelist.add(title);
                    seqList.add(seq);
                }

                // ListView에서 사용할 arrayAdapter 생성후 ListView 와 연결
                ArrayAdapter arrayAdapter = new ArrayAdapter<String>(DashboardActivity.this, android.R.layout.simple_list_item_1, titlelist);
                listView.setAdapter(arrayAdapter);

                // arrayAdapter의 데이터가 변경되었을때 새로고침
                arrayAdapter.notifyDataSetChanged();

            } catch(JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(String... params) {

            String server_url = "http://su1318ho.dothome.co.kr/content.php";
            URL url;
            String response = "";
            try {
                url = new URL(server_url);

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000);
                conn.setConnectTimeout(15000);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("userid", "");
// .appendQueryParameter("passwd", passwd);
                String query = builder.build().getEncodedQuery();

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();

                conn.connect();
                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    String line;
                    BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    while ((line=br.readLine()) != null) {
                        response+=line;
                    }
                }
                else {
                    response="";

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return response;
        }

    }
}
