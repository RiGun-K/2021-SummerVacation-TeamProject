package com.example.teamprojectt;

// 채팅창에 글 마다에 사진, 이름, 시간, 메세지 내용이 있다.
//
//이것을 class로 새로 만들어서 데이터를 저장한다.

// 아이템 하나의 모양을 만들자. (두개의 모양 필요 : 내 메세지 박스, 상대방 메세지 박스  ) => my_msgbox.xml



public class MessageItem {

    String name;
    String message;
    String time;
    String pofileUrl;

    public MessageItem(String name, String message, String time, String pofileUrl) {
        this.name = name;
        this.message = message;
        this.time = time;
        this.pofileUrl = pofileUrl;
    }

    //firebase DB에 객체로 값을 읽어올 때..
    //파라미터가 비어있는 생성자가 핑요함.
    public MessageItem() {
    }

    //Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPofileUrl() {
        return pofileUrl;
    }

    public void setPofileUrl(String pofileUrl) {
        this.pofileUrl = pofileUrl;
    }
}
