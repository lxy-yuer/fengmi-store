package com.qf.dao.impl;

import com.qf.dao.OrderDao;
import com.qf.entity.Order;
import com.qf.util.DBUtils;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    DBUtils<Order> dbUtils = new DBUtils<>();

    @Override
    public int addOrder(Order order) {
        return dbUtils.updateData("insert into t_order(id, uid, uaid, createtime, money, flag) values(?, ?, ?, ?, ?, ?)",
                order.getId(), order.getUid(),
                order.getUaid(), order.getCreateTime(),
                order.getManey(), order.getFlag());
    }

    @Override
    public int updateOrder(Order order) {
        return dbUtils.updateData("update t_order set id=?, uid=?, uaid=?, createtime=?, money=?, flag=?",
                order.getId(), order.getUid(),
                order.getUaid(), order.getCreateTime(),
                order.getManey(), order.getFlag());
    }

    @Override
    public int deleteOrder(int id) {
        return dbUtils.updateData("delete from t_order where id = ?", id);
    }

    @Override
    public List<Order> getOrderListByUid(int uid) {
        return dbUtils.queryList("select * from t_order where uid = ?", Order.class, uid);
    }

    @Override
    public Order getOrderById(int id) {
        return dbUtils.querySingle("select * from t_order where id = ?", Order.class, id);
    }

}
