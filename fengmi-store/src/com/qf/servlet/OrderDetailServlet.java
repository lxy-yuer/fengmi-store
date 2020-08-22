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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        String orderId = request.getParameter("orderId");
        Order order = orderService.getOrderById(Integer.parseInt(orderId));
        System.out.println(order);
        if (order != null) {
            order.setFlag(Integer.parseInt(flag));
            int i = orderService.updateOrder(order);
        }
        response.sendRedirect("./order");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String listSize = "1";
        if (session != null) {
            listSize = (String) session.getAttribute("listSize");
        }
        List<Map<String, Object>> orderDetailList = service.getOrderDetailListLimit("admin", Integer.parseInt(listSize));
        System.out.println(orderDetailList);
        User user = userService.QueryUser("admin");
        Order order = orderService.getOrderByLastUid(user.getId());
        int orderId = order.getId();
        int uaid = order.getUaid();
        UserAddress userAddressObj = addrService.selectAddress(uaid);
        if (userAddressObj != null) {
            String[] addressDetail = userAddressObj.getAddress_detail().split("-");
            request.setAttribute("addressDetail", addressDetail);
        } else {
            request.setAttribute("addressDetail", "请去用户中心添加地址");
            //判断如果addressDetail为空的话提示用户添加地址
        }
        request.setAttribute("orderDetailList", orderDetailList);
        request.setAttribute("orderId", orderId);
        request.setAttribute("createTime", order.getCreateTime());
        request.getRequestDispatcher("orderDetail.jsp").forward(request, response);
    }
}
