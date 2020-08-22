package com.qf.servlet;

import com.qf.entity.OrderDetail;
import com.qf.service.OrderDetailService;
import com.qf.service.impl.OrderDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderList")
public class orderListServlet extends HttpServlet {
    OrderDetailService odService = new OrderDetailServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("orderId");
        String gid = request.getParameter("gid");
        String num = request.getParameter("num");
        String money = request.getParameter("lastMoney");
        String time = request.getParameter("createTime");
        String address = request.getParameter("addressDetail");
        OrderDetail orderDetail = new OrderDetail(Integer.parseInt(oid), Integer.parseInt(gid), Integer.parseInt(num), Double.parseDouble(money));
        System.out.println(orderDetail);
        int i = odService.addOrderDetail(orderDetail);
        if (i == 0) {
            System.out.println("订单详情添加成功");
        }
        request.setAttribute("money",money);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
