package com.qf.service.impl.test;

import com.qf.service.impl.OrderServiceImpl;

import java.util.List;
import java.util.Map;

public class OrderServiceTest {
    public static void main(String[] args) {
        OrderServiceImpl orderService = new OrderServiceImpl();
        List<Map<String, Object>> orderListDetail = orderService.getOrderList("admin");
        System.out.println(orderListDetail);
    }
}
