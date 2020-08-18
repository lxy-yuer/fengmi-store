<%--
  Created by IntelliJ IDEA.
  User: liuxiangyu
  Date: 2020-08-18
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>订单预览页面</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery.min.js"></script>

</head>
<body style="background-color:#f5f5f5">
<div class="container" style="background-color: white;">
    <div class="row" style="margin-left: 40px">
        <h3>订单预览<small>温馨提示：请添加你要邮递到的地址</small></h3>
    </div>
    <div class="row" style="margin-top: 40px;">
        <input type="hidden" id="t1" value="${type }">
        <div class="col-md-10 col-md-offset-1">
            <table class="table table-bordered table-striped table-hover">
                <tr>
                    <th>序号</th>
                    <th>商品名称</th>
                    <th>价格</th>
                    <th>数量</th>
                    <th>小计</th>

                </tr>

                <tr>
                    <th>XXX</th>
                    <th>XXX</th>
                    <th>XXX</th>
                    <th>XXX</th>
                    <th>XXX</th>
                </tr>

                <tr>
                    <td colspan="5">
                        <h5>收货地址</h5>
                        <select id="address" style="width:60%" class="form-control">

                            <option value="${a.id}">XXX&nbsp;&nbsp;XXX&nbsp;&nbsp;XXX</option>
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