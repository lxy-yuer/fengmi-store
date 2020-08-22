package com.qf.dao;

import com.qf.entity.OrderDetail;

import java.util.List;
import java.util.Map;

public interface OrderDetailDao {
    int addOrderDetail(OrderDetail orderDetail);

    int updateOrderDetail(OrderDetail orderDetail);

    int deleteOrderDetail(int id);

    List<OrderDetail> selectOrderDetail(int oid);

    OrderDetail selectOrderDetailById(int id);

    public List<Map<String, Object>> getOrderDetailList(String username);

    public List<Map<String, Object>> getOrderDetailList(String username, int limit);
}
