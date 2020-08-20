package com.qf.dao;

import com.qf.entity.OrderDetail;

import java.util.List;

public interface OrderDetailDao {
    int addOrderDetail(OrderDetail orderDetail);

    int updateOrderDetail(OrderDetail orderDetail);

    int deleteOrderDetail(int id);

    List<OrderDetail> selectOrderDetail(int oid);

    OrderDetail selectOrderDetailById(int id);


}
