package com.yuki.bean;

public class Starinfo {
    private String userid;
    private String username;
    private String gender;
    private String areaname;
    private Integer fanscount;

    public Starinfo() {}

    public Starinfo(String userid, String username, String gender, String areaname, Integer fanscount) {
        this.userid = userid;
        this.username = username;
        this.gender = gender;
        this.areaname = areaname;
        this.fanscount = fanscount;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public Integer getFanscount() {
        return fanscount;
    }

    public void setFanscount(Integer fanscount) {
        this.fanscount = fanscount;
    }

    @Override
    public String toString() {
        return userid + "--" + username + "--" + gender + "--" + areaname + "--" + fanscount;
    }
}
