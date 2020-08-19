package com.qf.entity;

public class CartDetail {
    private int id;
    private int cid;
    private int gid;
    private int num;
    private double money;

    public CartDetail() {
    }

    public CartDetail(int id, int cid, int gid, int num, double money) {
        this.id = id;
        this.cid = cid;
        this.gid = gid;
        this.num = num;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "CartDetail{" +
                "id=" + id +
                ", cid=" + cid +
                ", gid=" + gid +
                ", num=" + num +
                ", money=" + money +
                '}';
    }
}
