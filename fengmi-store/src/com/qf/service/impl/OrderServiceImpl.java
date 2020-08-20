package com.qf.service.impl;

import com.qf.dao.OrderDao;
import com.qf.dao.impl.OrderDaoImpl;
import com.qf.entity.Order;
import com.qf.service.OrderService;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao = new OrderDaoImpl();

    /**
     * 添加订单
     *
     * @param order - 订单对象
     * @return -
     */
    @Override
    public int addOrder(Order order) {
        if (order == null) {
            return -1;
        }

        return orderDao.addOrder(order);
    }

    /**
     * 更新订单
     *
     * @param order - 订单对象
     * @return -
     */
    @Override
    public int updateOrder(Order order) {
        return orderDao.updateOrder(order);
    }

    /**
     * 删除订单
     *
     * @param id - 订单id
     * @return -
     */
    @Override
    public int deleteOrder(int id) {
        return orderDao.deleteOrder(id);
    }

    /**
     * 返回uid用户的订单列表
     *
     * @param uid - 用户id
     * @return -
     */
    @Override
    public List<Order> getOrderListByUid(int uid) {
        return orderDao.getOrderListByUid(uid);
    }

    /**
     * 通过id查询订单
     *
     * @param id - 订单id
     * @return -
     */
    @Override
    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public List<Map<String, Object>> getOrderList(String username) {
        OrderDaoImpl orderDao = (OrderDaoImpl) this.orderDao;
        return orderDao.getOrderList(username);
    }
}
