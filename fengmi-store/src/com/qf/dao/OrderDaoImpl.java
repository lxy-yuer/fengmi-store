package com.qf.dao;

import com.qf.entity.Order;
import com.qf.util.DBUtil;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    DBUtil<Order> dbutil = new DBUtil<>();

    @Override
    public int addOrder(Order order) {
        return dbutil.updateData("insert into order(id, uid, uaid, createtime, money, flag) values(?, ?, ?, ?, ?, ?)",
                order.getId(), order.getUid(),
                order.getUaid(), order.getCreateTime(),
                order.getManey(), order.getFlag());
    }

    @Override
    public int updateOrder(Order order) {
        return dbutil.updateData("update order set id=?, uid=?, uaid=?, createtime=?, money=?, flag=?",
                order.getId(), order.getUid(),
                order.getUaid(), order.getCreateTime(),
                order.getManey(), order.getFlag());
    }

    @Override
    public int deleteOrder(int id) {
        return dbutil.updateData("delete from order where id = ?", id);
    }

    @Override
    public List<Order> getOrderListByUid(int uid) {
        return dbutil.queryList("select * from order where uid = ?", Order.class, uid);
    }

    @Override
    public Order getOrderById(int id) {
        return dbutil.querySingle("select * from order where id = ?", Order.class, id);
    }

}
