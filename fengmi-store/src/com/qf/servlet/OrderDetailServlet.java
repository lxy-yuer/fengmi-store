package com.qf.servlet;

import com.qf.entity.Order;
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

@WebServlet("/orderDetail")
public class OrderDetailServlet extends HttpServlet {
    OrderDetailService service = new OrderDetailServiceImpl();
    UserAddressService addrService = new UserAddressServiceImpl();
    UserService userService = new UserServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");
        System.out.println(flag);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String, Object>> orderDetailList = service.getOrderDetailList("admin");
        User user = userService.QueryUser("admin");
        Order order = orderService.getOrderByUid(user.getId());
        int orderId = order.getId();
        List<UserAddress> userAddressList = addrService.selectAddressByUid(user.getId());
        int uaid = order.getUaid();
        UserAddress userAddressObj = addrService.selectAddress(uaid);
        String[] addressDetail = userAddressObj.getAddress_detail().split("-");
        request.setAttribute("orderDetailList", orderDetailList);
        request.setAttribute("orderId", orderId);
        String createTime = DateUtils.toStringDate(new Date());
        request.setAttribute("createTime", createTime);
        request.setAttribute("addressDetail", addressDetail);
        request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
    }
}
