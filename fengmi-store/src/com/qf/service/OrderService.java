package com.qf.service;

import com.qf.entity.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    /**
     * 添加订单
     *
     * @param order - 订单对象
     * @return -
     */
    int addOrder(Order order);

    /**
     * 更新订单
     *
     * @param order - 订单对象
     * @return -
     */
    int updateOrder(Order order);

    /**
     * 删除订单
     *
     * @param id - 订单id
     * @return -
     */
    int deleteOrder(int id);

    /**
     * 返回uid用户的订单列表
     *
     * @param uid - 用户id
     * @return -
     */
    List<Order> getOrderListByUid(int uid);

    /**
     * 通过id查询订单
     *
     * @param id - 订单id
     * @return -
     */
    Order getOrderById(int id);

    public List<Map<String, Object>> getOrderList(String username);
}
