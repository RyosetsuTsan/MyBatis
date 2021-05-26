package com.yuki.pojo;

//创建实体类
public class Emp {
    private Integer id;
    private String name;
    private String gender;
    private String birthday;
    private String phone;
    private Type type;

    public Emp(Integer id, String name, String gender, String birthday, String phone, Type type) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.type = type;
    }

    public Emp(Integer id, String name, String gender, String birthday, String phone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
