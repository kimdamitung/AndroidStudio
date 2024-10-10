package com.example.myapplication;

public class Data {
    private String name, nameHP, hocphi;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameHP() {
        return nameHP;
    }

    public void setNameHP(String nameHP) {
        this.nameHP = nameHP;
    }

    public String getHocphi() {
        return hocphi;
    }

    public void setHocphi(String hocphi) {
        this.hocphi = hocphi;
    }

    public Data(String name, String nameHP, String hocphi) {
        this.name = name;
        this.nameHP = nameHP;
        this.hocphi = hocphi;
    }
}
