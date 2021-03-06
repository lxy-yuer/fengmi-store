<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: liuxiangyu
  Date: 2020-08-20
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>订单详情页</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <%
        double lastMoney = 0;
        int num = 0;
        Object od = request.getAttribute("orderDetailList");
        List<Map<String, Object>> list = (List<Map<String, Object>>) od;
        for (Map<String, Object> map : list) {
            lastMoney += (Double) map.get("money");
            num += (int) map.get("num");
        }
        request.setAttribute("lastMoney", lastMoney);
        request.setAttribute("num", num);
        request.setAttribute("list", list);
    %>

    <script type="text/javascript">
        /*$(function () {
            $("#back").click(function () {
                $.post("orderDetail", {flag: '1', orderId: '<%--${orderId}--%>'}, "json");
            });
        });*/
        $(function () {
            if (window.history && window.history.pushState) {
                $(window).on('popstate', function () {
                    window.history.pushState('forward', null, '');
                    window.history.forward(1);
                });
            }
            window.history.pushState('forward', null, '');
            window.history.forward(1);
        })
    </script>

</head>
<div class="panel panel-default" style="margin: 0 auto;width: 95%;">
    <div class="panel-heading">
        <h3 class="panel-title"><span class="glyphicon glyphicon-equalizer"></span>订单详情</h3>
    </div>
    <div class="panel-body">
        <table cellpadding="0" cellspacing="0" align="center" width="100%"
               class="table table-striped table-bordered table-hover">

            <tr>
                <td>订单编号:</td>
                <td>${orderId}</td>
                <td>订单时间:</td>
                <td>${createTime}</td>
            </tr>
            <tr>
                <td>收件人:</td>
                <td>${addressDetail[0]}</td>
                <td>联系电话:</td>
                <td>${addressDetail[2]}</td>
            </tr>
            <tr>
                <td>送货地址:</td>
                <td>${addressDetail[1]}</td>
                <td>总价:</td>
                <td>${lastMoney}</td>
            </tr>
            <tr>
                <td align="center">商品列表:</td>
                <td colspan="3">
                    <table align="center" cellpadding="0" cellspacing="0" width="100%"
                           class="table table-striped table-bordered table-hover">
                        <tr align="center" class="info">
                            <th>序号</th>
                            <th>商品封面</th>
                            <th>商品名称</th>
                            <th>商品评分</th>
                            <th>商品日期</th>
                            <th>商品单价</th>
                            <th>购买数量</th>
                            <th>小计</th>
                        </tr>

                        <c:forEach items="${orderDetailList}" var="orderDetail" varStatus="status" begin="0">
                            <tr align="center">
                                <td>${status.index + 1}</td>
                                <td>
                                    <img src="${orderDetail.get("picture")}" width="50px" height="50px" alt="img">
                                </td>
                                <td>${orderDetail.get("name")}</td>
                                <td>${orderDetail.get("star")}</td>
                                <td>${orderDetail.get("pubdate")}</td>
                                <td>${orderDetail.get("price")}</td>
                                <td>${orderDetail.get("num")}</td>
                                <td>${orderDetail.get("money")}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
            <tr>
                <td align="right" colspan="4" style="margin-right: 40px;">
                    <%--<a href="" id="back" class="btn btn-danger btn-sm">返回订单列表</a>--%>
                    <form action="orderDetail" method="post">
                        <input type="hidden" name="flag" value="1">
                        <input type="hidden" name="orderId" value="${orderId}">
                        <input type="submit" class="btn btn-danger btn-sm" value="返回订单列表">
                    </form>
                    <form action="orderList" method="post">
                        <%--<button type="button" class="btn btn-warning btn-sm">支付</button>--%>
                        <input type="hidden" name="orderId" value="${orderId}">
                        <input type="hidden" name="lastMoney" value="${lastMoney}">
                        <input type="hidden" name="num" value="${num}">
                        <input type="hidden" name="createTime" value="${createTime}">
                        <input type="hidden" name="addressDetail" value="${addressDetail[1]}">
                        <input type="hidden" name="gid" value="${list.get(0).get("gid")}">
                        <input type="submit" class="btn btn-danger btn-sm" value="支付">
                    </form>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>