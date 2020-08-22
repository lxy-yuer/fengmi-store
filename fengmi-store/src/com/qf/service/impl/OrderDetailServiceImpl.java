package com.qf.service.impl;

import com.qf.dao.OrderDetailDao;
import com.qf.dao.impl.OrderDetailDaoImpl;
import com.qf.entity.OrderDetail;
import com.qf.service.OrderDetailService;

import java.util.List;
import java.util.Map;

public class OrderDetailServiceImpl implements OrderDetailService {

    OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();

    @Override
    public int addOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.addOrderDetail(orderDetail);
    }

    @Override
    public int updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailDao.addOrderDetail(orderDetail);
    }

    @Override
    public int deleteOrderDetail(int id) {
        return orderDetailDao.deleteOrderDetail(id);
    }

    @Override
    public List<OrderDetail> selectOrderDetail(int oid) {
        return orderDetailDao.selectOrderDetail(oid);
    }

    @Override
    public OrderDetail selectOrderDetailById(int id) {
        return orderDetailDao.selectOrderDetailById(id);
    }

    @Override
    public List<Map<String, Object>> getOrderDetailList(String username) {
        return orderDetailDao.getOrderDetailList(username);
    }

    @Override
    public List<Map<String, Object>> getOrderDetailListLimit(String username, int limit) {
        return orderDetailDao.getOrderDetailList(username, limit);
    }
}
