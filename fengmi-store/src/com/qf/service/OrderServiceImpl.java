package com.qf.service;

import com.qf.dao.OrderDao;
import com.qf.dao.OrderDaoImpl;
import com.qf.entity.Order;

import java.util.List;

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
        return 0;
    }

    /**
     * 更新订单
     *
     * @param order - 订单对象
     * @return -
     */
    @Override
    public int updateOrder(Order order) {
        return 0;
    }

    /**
     * 删除订单
     *
     * @param id - 订单id
     * @return -
     */
    @Override
    public int deleteOrder(int id) {
        return 0;
    }

    /**
     * 返回uid用户的订单列表
     *
     * @param uid - 用户id
     * @return -
     */
    @Override
    public List<Order> getOrderListByUid(int uid) {
        return null;
    }

    /**
     * 通过id查询订单
     *
     * @param id - 订单id
     * @return -
     */
    @Override
    public Order getOrderById(int id) {
        return null;
    }
}
