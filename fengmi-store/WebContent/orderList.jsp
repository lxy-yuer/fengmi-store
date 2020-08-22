<%--
  Created by IntelliJ IDEA.
  User: liuxiangyu
  Date: 2020-08-21
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>订单列表</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>

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
