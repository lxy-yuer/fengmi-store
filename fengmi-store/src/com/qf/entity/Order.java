package com.qf.entity;

/**
 * 订单
 *
 * @author liuxiangyu
 */
public class Order {
    private int id;
    private int uid;
    private int uaid;
    private int gid;
    private String createTime;
    private double money;
    private int flag = 2;

    public Order(int uid, int uaid, int gid, String createTime, double money) {
        this.uid = uid;
        this.uaid = uaid;
        this.gid = gid;
        this.createTime = createTime;
        this.money = money;
    }

    public Order(int id, int uid, int uaid, int gid, String createTime, double money, int flag) {
        this.id = id;
        this.uid = uid;
        this.uaid = uaid;
        this.gid = gid;
        this.createTime = createTime;
        this.money = money;
        this.flag = flag;
    }

    public Order() {
        super();
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

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getUaid() {
        return uaid;
    }

    public void setUaid(int uaid) {
        this.uaid = uaid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", uid=" + uid +
                ", uaid=" + uaid +
                ", gid=" + gid +
                ", createTime='" + createTime + '\'' +
                ", money=" + money +
                ", flag=" + flag +
                '}';
    }
}
