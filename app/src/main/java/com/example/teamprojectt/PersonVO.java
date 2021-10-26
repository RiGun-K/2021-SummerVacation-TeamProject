package com.example.teamprojectt;

public class PersonVO {

    String name;
    int age;
    String address;

    // Firebase DB 는 객체 단위로 값을 넣을때
    // 반드시 매개변수가 비어있는 생성자를 요구

    public PersonVO() {

    }

    public PersonVO(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
