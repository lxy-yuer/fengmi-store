<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/login2.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	 <div id="top">
    	<div id="topdiv">
            <span>
                <a href="" id="a_top" target="_blank">锋米之家</a>
                <li>|</li>
                <a href="" id="a_top">锋米之家网页版</a>
                <li>|</li>
                <a href="" id="a_top">问题反馈</a>
            </span>
            <span style="float:right">
	                <a href="login.jsp" id="a_top">登录</a>
	                <li>|</li>
	                <a href="register.jsp" id="a_top">注册</a>
           		
       				<li>|</li>
       				<a href="userLogout" id="a_top">注销</a>
       				<li>|</li>
       				<a href="getOrderList" id="a_top">我的订单</a>
                <li>|</li>
                <a href="" id="a_top">消息通知</a>
                <a href="" id="shorpcar">购物车</a>
            </span>
        </div>
	</div>
<div id="second" style="margin-bottom: 47px;">
	    <a href="" id="seimg" style=" margin-top:23px;"><img id="logo" src="image/logo_top.png" width="200px" height="100px"/></a>
<!--         <a href="" id="seimg" style=" margin-top:17px;"><img id="gif" src="image/yyymix.gif" width="180" height="66" /></a> -->
        <p id="goodsType" style="float: right;margin-right: 40px">
			<!-- 根据ajax 回调函数 填写数据 到此id中 -->
        </p>
       <form  class="form-inline pull-right" style="clear:both;margin-right: 10px;margin-bottom: 3px;">
		
		  <div class="form-group" >
		    <input type="text" class="form-control" style="width: 400px"  placeholder="幸福生活，搜索一下...">
		  </div>
		  <button type="submit" class="btn btn-warning"><span class="glyphicon glyphicon-search"></span>&nbsp;&nbsp;搜索</button>
	  </form>
</div>
</body>
</html>