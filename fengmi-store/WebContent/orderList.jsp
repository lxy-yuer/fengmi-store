<%--
  Created by IntelliJ IDEA.
  User: liuxiangyu
  Date: 2020-08-21
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>订单列表</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(function () {
            if (window.history && window.history.pushState) {
                $(window).on('popstate', function () {
                    window.history.pushState('forward', null, '');
                    window.history.forward(1);
                });
            }
            window.history.pushState('forward', null, '');
            window.history.forward(1);

            $.get("orderList", "", function (data) {
                for (let i = 0; i < data.orderList.length; i++) {
                    console.log(data.orderList[i].id);
                    console.log(data.userAddressList[i].id);
                    let tr = document.createElement("tr");
                    let td = document.createElement("td");
                    let td1 = document.createElement("td");
                    let td2 = document.createElement("td");
                    let td3 = document.createElement("td");
                    let td4 = document.createElement("td");
                    let td5 = document.createElement("td");
                    let td6 = document.createElement("td");
                    td.innerHTML = (i + 1) + "";
                    td1.innerHTML = data.orderList[i].id;
                    td2.innerHTML = data.orderList[i].money;
                    td3.innerHTML = "已支付,待发货";
                    td4.innerHTML = data.orderList[i].createTime;
                    td5.innerHTML = data.userAddressList[i].address_detail;
                    td6.innerHTML = ' <button type="button" class="btn btn-danger btn-sm">\n' +
                        '                            订单详情\n' +
                        '                        </button>\n' +
                        '                        <button type="button" class="btn btn-warning btn-sm">\n' +
                        '                            确认收货\n' +
                        '                        </button>';
                    tr.appendChild(td);
                    tr.appendChild(td1);
                    tr.appendChild(td2);
                    tr.appendChild(td3);
                    tr.appendChild(td4);
                    tr.appendChild(td5);
                    tr.appendChild(td6);
                    $("#tb_list").append(tr);
                }
            }, "json");
        })
    </script>
</head>
<body style="background-color:#f5f5f5">
<div class="container" style="background-color: white;">
    <div class="row" style="margin-left: 40px">
        <h3>我的订单列表&nbsp;&nbsp;
            <small>温馨提示：<em>XXX</em>有<font color="red">xxx</font>个订单</small></h3>
    </div>
    <div class="row" style="margin-top: 40px;">
        <div class="col-md-12">
            <table id="tb_list" class="table table-striped table-hover table-bordered table-condensed">
                <tr>
                    <th>1</th>
                    <th>订单编号</th>
                    <th>总金额</th>
                    <th>订单状态</th>
                    <th>订单时间</th>
                    <th>收货地址</th>
                    <th>操作</th>
                </tr>
                <tr>
                    <td>xxx</td>
                    <td>xxx</td>
                    <td>xxx</td>
                    <td>
                        <font color="red">
                            已支付,待发货
                        </font>
                    </td>
                    <td>xxx</td>
                    <td>xxx</td>
                    <td>
                        <button type="button" class="btn btn-danger btn-sm">
                            订单详情
                        </button>
                        <button type="button" class="btn btn-warning btn-sm">
                            确认收货
                        </button>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</div>

</body>
</html>
