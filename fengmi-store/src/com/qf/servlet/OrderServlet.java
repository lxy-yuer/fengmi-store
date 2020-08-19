package com.qf.servlet;

import com.alibaba.fastjson.JSONObject;
import com.qf.entity.CartDetail;
import com.qf.entity.Goods;
import com.qf.service.GoodsService;
import com.qf.service.impl.GoodsServiceImpl;
import com.qf.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    OrderServiceImpl orderService = new OrderServiceImpl();
    GoodsService goodsService = new GoodsServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CartDetail cartDetail1 = new CartDetail(1, 1, 4, 2, 1500);
        CartDetail cartDetail2 = new CartDetail(2, 2, 3, 2, 1500);
        Goods good1 = goodsService.getGoodsById(4);
        Goods good2 = goodsService.getGoodsById(3);
        JSONObject jsonObject = new JSONObject();
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("cartDetail", cartDetail1);
        map1.put("good", good1);
        list.add(map1);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("cartDetail", cartDetail2);
        map2.put("good", good2);
        list.add(map2);
        System.out.println(list);
        request.setAttribute("orders", list);
        request.getRequestDispatcher("order.jsp").forward(request, response);
/*
        List<Order> orderList = orderService.getOrderListByUid(3);
        String orderListJsonString = JSON.toJSONString(orderList);
        PrintWriter pw = response.getWriter();
        request.setAttribute("orders", orderList);
        request.getRequestDispatcher("order.jsp").forward(request, response);*/
        // pw.write(orderListJsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
