package com.qf.servlet;

import com.alibaba.fastjson.JSONObject;
import com.qf.entity.Order;
import com.qf.entity.OrderDetail;
import com.qf.entity.User;
import com.qf.entity.UserAddress;
import com.qf.service.OrderDetailService;
import com.qf.service.OrderService;
import com.qf.service.UserAddressService;
import com.qf.service.UserService;
import com.qf.service.impl.OrderDetailServiceImpl;
import com.qf.service.impl.OrderServiceImpl;
import com.qf.service.impl.UserAddressServiceImpl;
import com.qf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/orderList")
public class OrderListServlet extends HttpServlet {
    OrderDetailService odService = new OrderDetailServiceImpl();
    UserService userService = new UserServiceImpl();
    OrderService orderService = new OrderServiceImpl();
    UserAddressService uaService = new UserAddressServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String oid = request.getParameter("orderId");
        String gid = request.getParameter("gid");
        String num = request.getParameter("num");
        String money = request.getParameter("lastMoney");
        OrderDetail orderDetail = new OrderDetail(Integer.parseInt(oid), Integer.parseInt(gid), Integer.parseInt(num), Double.parseDouble(money));
        System.out.println(orderDetail);
        int i = odService.addOrderDetail(orderDetail);
        if (i == 1) {
            System.out.println("订单详情添加成功");
        }
        response.sendRedirect("orderList.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        User user = userService.QueryUser("admin");
        int uid = user.getId();
        List<Order> orderList = orderService.getOrderListByUid(uid);
        System.out.println(orderList);
        List<Integer> uaid = new ArrayList<>();
        List<UserAddress> userAddressList = new ArrayList<>();
        for (Order order : orderList) {
            UserAddress userAddress = uaService.selectAddress(order.getUaid());
            userAddressList.add(userAddress);
        }
        PrintWriter pw = response.getWriter();
        JSONObject jo = new JSONObject();
        jo.put("orderList", orderList);
        jo.put("userAddressList", userAddressList);
        pw.write(jo.toJSONString());
        pw.flush();
        pw.close();
    }
}
