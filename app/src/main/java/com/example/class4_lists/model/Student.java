package com.example.class4_lists.model;

public class Student {
    String name = "";
    String id = "";
    String phone = "";
    String address = "";
    boolean flag = false;

    public Student() {}

    public Student(String name, String id,String phone,String address, boolean flag) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.address = address;
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
