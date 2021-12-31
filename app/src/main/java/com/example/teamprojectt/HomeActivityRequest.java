package com.example.teamprojectt;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class HomeActivityRequest extends StringRequest {

    // 서버 URL 설정
    final static private String URL = "http://su1318ho.dothome.co.kr/Myif.php";
    private Map<String, String> map;

    public HomeActivityRequest(String userID, String userPassword, String userName, int userHakbun, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID",userID);
        map.put("userPassword",userPassword);
        map.put("userName",userName);
        map.put("userHakbun",userHakbun+"");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
