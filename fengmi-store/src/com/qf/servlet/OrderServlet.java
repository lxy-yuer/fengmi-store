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
        for (Map<String, Object> stringObjectMap : orderList) {
            int uid = (int) stringObjectMap.get("uid");
            int gid = (int) stringObjectMap.get("gid");
            double money = (double) stringObjectMap.get("money");
            Order order = new Order(uid, uaid, gid, DateUtils.toStringDate(new Date()), money);
            int iFlag = service.addOrder(order);
            if (iFlag == 1) {
                System.out.println(order);
                System.out.println("添加订单成功");
            }
        }
        response.sendRedirect("./orderDetailServlet");
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
