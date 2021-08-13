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

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
