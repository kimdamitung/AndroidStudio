package com.example.myapplication;

public class Data {
    private int flags;
    private String nameCoutrys;
    private int populations;
    public int getFlags() {
        return flags;
    }
    public void setFlags(int flags) {
        this.flags = flags;
    }
    public int getPopulations() {
        return populations;
    }
    public void setPopulations(int populations) {
        this.populations = populations;
    }
    public String getNameCoutrys() {
        return nameCoutrys;
    }
    public void setNameCoutrys(String nameCoutrys) {
        this.nameCoutrys = nameCoutrys;
    }
    public Data(int flags, int populations, String nameCoutrys) {
        this.flags = flags;
        this.populations = populations;
        this.nameCoutrys = nameCoutrys;
    }
}
