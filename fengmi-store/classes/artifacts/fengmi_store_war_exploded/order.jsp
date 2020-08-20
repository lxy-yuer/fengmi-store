<%@ page import="com.qf.entity.UserAddress" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: liuxiangyu
  Date: 2020-08-18
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>订单预览页面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">

        $(function () {
            $("#btn_add").click(function () {
                $.post({
                    url: "order",
                    data: {
                        lastMoney: $("#lastMoney").text(),
                    }
                });
            });
        });

    </script>
    <%
        Object orderList = request.getAttribute("orderList");
        List<Map<String, Object>> list = (List<Map<String, Object>>) orderList;
        request.setAttribute("list", list);
        Object userAddressList = request.getAttribute("userAddressList");
        List<UserAddress> addressList = (List<UserAddress>) userAddressList;
        request.setAttribute("addressList", addressList);
        double lastMoney = 0;
        for (Map<String, Object> map : list) {
            lastMoney += (Double) map.get("money");
        }
        request.setAttribute("lastMoney", lastMoney);
    %>

</head>
<body style="background-color:#f5f5f5">

<form action="order" method="post">
    <div class="container" style="background-color: white;">
        <div class="row" style="margin-left: 40px">
            <h3>订单预览<small>温馨提示：请添加你要邮递到的地址</small></h3>
        </div>
        <div class="row" style="margin-top: 40px;">
            <input type="hidden" id="t1" value="${type}">
            <div class="col-md-10 col-md-offset-1">
                <table id="list" class="table table-bordered table-striped table-hover">
                    <tr>
                        <th>序号</th>
                        <th>商品名称</th>
                        <th>价格</th>
                        <th>数量</th>
                        <th>小计</th>

                    </tr>

                    <c:forEach items="${list}" varStatus="status" var="order" begin="0">

                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${order.get("name")}</td>
                            <td>${order.get("price")}</td>
                            <td>${order.get("num")}</td>
                            <td>${order.get("money")}</td>
                        </tr>


                    </c:forEach>


                    <tr>
                        <td colspan="5">
                            <h5><label for="address">收货地址</label></h5>
                            <select id="address" name="address" style="width:60%" class="form-control">
                                <c:if test="${!(addressList.size() eq 0)}">
                                    <option value="0">请选择地址...</option>
                                    <c:forEach items="${addressList}" var="addr">
                                        <option value="${addr.id}">${addr.address_detail}</option>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${addressList.size() eq 0}">
                                    <option value="0">没有地址，请去个人中心添加新地址</option>
                                </c:if>
                            </select>


                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <hr>
        <div class="row">
            <div style="margin-left: 40px;">
                <h4>商品金额总计：<span id="total" class="text-danger"><b id="lastMoney">￥${lastMoney}</b></span></h4>
            </div>
        </div>
        <div class="row pull-right" style="margin-right: 40px;">
            <div style="margin-bottom: 20px;">
                <input id="btn_add" class="btn  btn-danger btn-lg" type="submit" value="提交订单">
            </div>
        </div>
    </div>
</form>

</body>
</html>