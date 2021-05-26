package com.yuki.pojo;

public class Type {
    private int Tid;
    private String Tname;

    public Type(int tid, String tname) {
        Tid = tid;
        Tname = tname;
    }

    @Override
    public String toString() {
        return "Type{" +
                "Tid=" + Tid +
                ", Tname='" + Tname + '\'' +
                '}';
    }

}
