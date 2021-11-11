package com.example.teamprojectt;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class PjRegisterRequest extends StringRequest {

    // 서버 URL 설정
    final static private String URL = "http://su1318ho.dothome.co.kr/PjRegister.php";
    private Map<String, String> map;

    public PjRegisterRequest(String pjName, String pjContent, String pjEffect, int pjCount, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("pjName",pjName);
        map.put("pjContent",pjContent);
        map.put("pjEffect",pjEffect);
        map.put("pjCount",pjCount+"");
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}

