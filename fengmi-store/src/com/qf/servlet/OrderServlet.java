package com.qf.servlet;

import com.qf.entity.Order;
import com.qf.entity.UserAddress;
import com.qf.service.OrderService;
import com.qf.service.UserAddressService;
import com.qf.service.impl.OrderServiceImpl;
import com.qf.service.impl.UserAddressServiceImpl;
import com.qf.util.DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    OrderService service = new OrderServiceImpl();
    UserAddressService addressService = new UserAddressServiceImpl();
    List<Map<String, Object>> orderList = service.getOrderList("admin");

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aValue = request.getParameter("address");
        int uaid = Integer.parseInt(aValue);
        for (int i = 0; i < orderList.size(); i++) {
            int uid = (int) orderList.get(i).get("uid");
            int gid = (int) orderList.get(i).get("gid");
            double money = (double) orderList.get(i).get("money");
            Order order = new Order(uid, uaid, DateUtils.toStringDate(new Date()), money);
            System.out.println(order);
        }

        Order order = new Order();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserAddress> userAddressList = null;
        if (orderList.size() != 0) {
            userAddressList = addressService.selectAddressByUid((Integer) orderList.get(0).get("uid"));
        }
        assert userAddressList != null;
        if (userAddressList.size() != 0) {
            request.setAttribute("userAddressList", userAddressList);
        }
        request.setAttribute("orderList", orderList);
        request.getRequestDispatcher("order.jsp").forward(request, response);
    }
}
