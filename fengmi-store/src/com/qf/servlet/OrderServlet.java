package com.qf.servlet;

import com.alibaba.fastjson.JSON;
import com.qf.entity.Order;
import com.qf.service.OrderService;
import com.qf.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        OrderService orderService = new OrderServiceImpl();
        List<Order> orderList = orderService.getOrderListByUid(3);
        String orderListJsonString = JSON.toJSONString(orderList);
        PrintWriter pw = response.getWriter();
        request.setAttribute("orders", orderList);
        request.getRequestDispatcher("order.jsp").forward(request, response);
        // pw.write(orderListJsonString);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
