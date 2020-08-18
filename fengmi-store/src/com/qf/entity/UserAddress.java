package com.qf.entity;

public class UserAddress {
    private int id;
    private int uid;
    private String address_detail;

    public UserAddress(int id, int uid, String address_detail) {
        this.id = id;
        this.uid = uid;
        this.address_detail = address_detail;
    }

    public UserAddress(int uid, String address_detail) {
        this.uid = uid;
        this.address_detail = address_detail;
    }

    public UserAddress() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", uid=" + uid +
                ", address_detail='" + address_detail + '\'' +
                '}';
    }
}
