package com.qf.servlet;

import com.qf.service.OrderDetailService;
import com.qf.service.UserAddressService;
import com.qf.service.impl.OrderDetailServiceImpl;
import com.qf.service.impl.UserAddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/orderDetailServlet")
public class OrderDetailServlet extends HttpServlet {
    OrderDetailService service = new OrderDetailServiceImpl();
    UserAddressService addrService = new UserAddressServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map<String, Object>> orderDetailList = service.getOrderDetailList("admin");
        addrService.selectAddressByUid(1);
        request.setAttribute("orderDetailList", orderDetailList);
        request.getRequestDispatcher("orderDetail.jsp").forward(request,response);
    }
}
