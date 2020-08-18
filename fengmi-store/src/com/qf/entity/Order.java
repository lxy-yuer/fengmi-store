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
    private String createTime;
    private double maney;
    private int flag = 1;

    public Order(int uid, int uaid, String createTime, double maney) {
        this.uid = uid;
        this.uaid = uaid;
        this.createTime = createTime;
        this.maney = maney;
    }

    public Order(int id, int uid, int uaid, String createTime, double maney, int flag) {
        super();
        this.id = id;
        this.uid = uid;
        this.uaid = uaid;
        this.createTime = createTime;
        this.maney = maney;
        this.flag = flag;
    }

    public Order(int uid, int uaid, String createTime, double maney, int flag) {
        super();
        this.uid = uid;
        this.uaid = uaid;
        this.createTime = createTime;
        this.maney = maney;
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

    public double getManey() {
        return maney;
    }

    public void setManey(double maney) {
        this.maney = maney;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", uid=" + uid + ", uaid=" + uaid + ", createTime=" + createTime + ", maney=" + maney
                + ", flag=" + flag + "]";
    }

}
