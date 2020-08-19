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
        /*$(function () {
            $.post({
                url: "order",
                dataType: "json",
                data: "",
                success: function (data) {
                    for (let i = 0; i < data.length; i++) {
                        let item = "<tr><td>" + data[i].id + "</td><td>" + data[i].oid + "</td><td>" + data[i].gid + "</td></tr>";
                        $("#list").append(item);
                    }
                    // fun();
                }
            });
        });*/

        /*function fun() {
            let tr = $("#list tr");
            for (let i = 1; i < tr.length; i++) {
                tr[i].id = "tr" + i;
            }
            let delList = $("#list tr td input");
            for (let i = 0; i < delList.length; i++) {
                delList[i].setAttribute("did", i + 1);
            }
            delList.click(function () {
                let did = $(this).attr("did");
                $("#tr" + did).remove();
            });
        }*/
    </script>
    <%
        double lastMoney = 0;
    %>

</head>
<body style="background-color:#f5f5f5">
<div class="container" style="background-color: white;">
    <div class="row" style="margin-left: 40px">
        <h3>订单预览<small>温馨提示：请添加你要邮递到的地址</small></h3>
    </div>
    <div class="row" style="margin-top: 40px;">
        <input type="hidden" id="t1" value="${type }">
        <div class="col-md-10 col-md-offset-1">
            <table id="list" class="table table-bordered table-striped table-hover">
                <tr>
                    <th>序号</th>
                    <th>商品名称</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>小计</th>

                </tr>

                <tr>
                    <th>${1 }</th>
                    <th>${orders[0].value.goodsName }</th>
                    <th>${orders[0].value.price }</th>
                    <th>${orders[0].value.num }</th>
                    <th>${orders[0].value.goodsPrice }</th>
                </tr>

                <c:forEach items="${orders }" varStatus="status" var="order" begin="0">

                    <tr>
                        <th>${status.index + 2 }</th>
                        <th>${order.good.name }</th>
                        <th>${order.good.price }</th>
                        <th>${order.cartDetail.num }</th>
                        <th>${order.good.price * order.cartDetail.num }</th>
                    </tr>



                </c:forEach>


                <tr>
                    <td colspan="5">
                        <h5>收货地址</h5>
                        <select id="address" style="width:60%" class="form-control">

                            <option value="${a.id}">${order[0].addressDetail }</option>
                            <option value="${a.id}">XXX&nbsp;&nbsp;XXX&nbsp;&nbsp;XXX</option>
                            <option value="${a.id}">XXX&nbsp;&nbsp;XXX&nbsp;&nbsp;XXX</option>

                        </select>


                    </td>
                </tr>
            </table>
        </div>
    </div>
    <hr>
    <div class="row">
        <div style="margin-left: 40px;">
            <h4>商品金额总计：<span id="total" class="text-danger"><b>￥&nbsp;&nbsp;XXX </b></span></h4>
        </div>
    </div>
    <div class="row pull-right" style="margin-right: 40px;">
        <div style="margin-bottom: 20px;">
            <button id="btn_add" class="btn  btn-danger btn-lg" type="button">提交订单</button>
        </div>
    </div>
</div>


</body>
</html>