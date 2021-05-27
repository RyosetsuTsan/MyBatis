package com.yuki.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Course {
    private Integer id;

    private String name;

    private Integer count;

    private Date startdate;

    private Date enddate;

    private String teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getStartdate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(startdate);
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(enddate);
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }


    @Override
    public String toString() {
        return id+"\t"+name+"\t"+count+"\t"+startdate+"\t"+enddate+"\t"+teacher;
    }
}