package com.example.teamprojectt;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DashboardRequest extends StringRequest {

    // 서버 URL 설정
    final static private String URL = "http://su1318ho.dothome.co.kr/Join.php";
    private Map<String, String> map;

    public DashboardRequest(String idUser, String projectName, String eMail, int phoneNumber, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("idUser",idUser);
        map.put("projectName",projectName);
        map.put("eMail",eMail);
        map.put("phoneNumber",phoneNumber+"");
    }

    // insert into USER -> JOIN 으로 바꿧음
    // 하지만 회원등록이 되지않음 ,, 다시 점검

    // 08/24
    // http://su1318ho.dothome.co.kr/Join.php 로 들어가면 php 상태확인가능
    // You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 오류
    // INSERT INTO JOIN VALUES ~~   => INSERT INTO `JOIN` VALUES ~~ 로 바꾸기
    
    // 다만 DB에 넘어오는 phoneNumber 값 처음에 0이 안나옴


    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
