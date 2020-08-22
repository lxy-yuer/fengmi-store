package com.qf.service;

import com.qf.entity.OrderDetail;

import java.util.List;
import java.util.Map;

public interface OrderDetailService {
    int addOrderDetail(OrderDetail orderDetail);

    int updateOrderDetail(OrderDetail orderDetail);

    int deleteOrderDetail(int id);

    List<OrderDetail> selectOrderDetail(int oid);

    OrderDetail selectOrderDetailById(int id);

    public List<Map<String, Object>> getOrderDetailList(String username);

    List<Map<String, Object>> getOrderDetailListLimit(String admin, int limit);
}
