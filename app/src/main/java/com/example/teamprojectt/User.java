package com.example.teamprojectt;

public class User {
    //list view에 대한 자바코드임

    //회원들의 무슨 정보를 표시할 것인가. (이거는 DB를 모르기 때문에 임의로 제가 정합니당.)
    String name, lastMessage, lastMsgTime, phoneNo, country;
    int iamgeId;

    public User(String name, String lastMessage, String lastMsgTime, String phoneNo, int imageId) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.lastMsgTime = lastMsgTime;
        this.phoneNo = phoneNo;
        this.country = country;
        this.iamgeId = iamgeId;
    }
}
