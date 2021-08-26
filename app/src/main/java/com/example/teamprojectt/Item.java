package com.example.teamprojectt;

public class Item {
    String idUser;
    String projectName;
    String eMail;
    int phoneNumber;

    public Item() {
    }

    public Item(String idUser, String projectName, String eMail, int phoneNumber) {
        this.idUser = idUser;
        this.projectName = projectName;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getprojectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

