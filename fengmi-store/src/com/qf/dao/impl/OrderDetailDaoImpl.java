package com.qf.dao.impl;

import com.qf.dao.OrderDetailDao;
import com.qf.entity.OrderDetail;
import com.qf.util.DBUtils;

import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {
    DBUtils<OrderDetail> dbUtils = new DBUtils<>();

    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        return dbUtils.updateData("insert into t_orderDetail(oid, gid, num, money) values(?, ?, ?, ?)",
                orderDetail.getOid(),
                orderDetail.getGid(),
                orderDetail.getNum(),
                orderDetail.getMoney());
    }

    @Override
    public int updateOrderDetail(OrderDetail orderDetail) {
        return dbUtils.updateData("update t_orderDetail set oid = ?, gid = ?, num = ?, money = ?",
                orderDetail.getOid(),
                orderDetail.getGid(),
                orderDetail.getNum(),
                orderDetail.getMoney());
    }

    @Override
    public int deleteOrderDetail(int id) {
        return dbUtils.updateData("delete from t_orderDetail where id = ?", id);
    }

    @Override
    public List<OrderDetail> selectOrderDetail(int oid) {
        return dbUtils.queryList("select * from t_orderDetail where oid = ?", OrderDetail.class, oid);
    }

    @Override
    public OrderDetail selectOrderDetailById(int id) {
        return dbUtils.querySingle("select * from t_orderDetail where id = ?", OrderDetail.class, id);
    }
}
