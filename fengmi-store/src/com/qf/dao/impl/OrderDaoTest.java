package com.qf.dao.impl;

import com.qf.dao.OrderDao;
import com.qf.entity.Order;
import com.qf.util.DateUtils;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class OrderDaoTest {
    OrderDao dao = new OrderDaoImpl();

    @Test
    public void testAdd() {

        Order order = new Order(1, 3, 2, DateUtils.toStringDate(new Date()), 1000, 1);
        System.out.println(order);
        dao.addOrder(order);
    }

    @Test
    public void testSelectList() {

        List<Order> orderListByUid = dao.getOrderListByUid(3);
        System.out.println(orderListByUid.get(0));
    }


}
