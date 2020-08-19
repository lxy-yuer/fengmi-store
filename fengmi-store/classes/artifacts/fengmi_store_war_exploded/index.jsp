<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>锋米之家</title>
<link rel="stylesheet" type="text/css" href="css/login2.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file = "header.jsp" %>
	<!--网站中间内容开始-->
	<div id="thred" style="height:510px">
		<div id="myCarousel" class="carousel slide" >
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="image/banner4.jpg" alt="First slide">
				</div>
				<div class="item">
					<img src="image/banner2.jpg" alt="Second slide">
				</div>
				<div class="item">
					<img src="image/banner2.jpg" alt="Third slide">
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<!-- <img src="image/banner2.jpg" width="1230" height="400" />  -->
	</div>
	<div id="forth">
		<span> 
			<a href=""><img src="image/hjh_01.gif" /></a> 
			<a href=""><img src="image/hjh_02.gif" /></a> 
			<a href=""><img src="image/hjh_03.gif" /></a> 
			<a href=""><img src="image/hjh_04.gif" /></a> 
			<a href=""><img src="image/hjh_05.gif" /></a> 
			<a href=""><img src="image/hjh_06.gif" /></a>
		</span> 
		<a href="" id="a_left"><img src="image/hongmi4x.png" width="316" height="170" /></a> 
		<a href="" id="a_left"><img src="image/xiaomi5.jpg" width="316" height="170" /></a> 
		<a href="" id="a_left"><img src="image/pinghengche.jpg" width="316" height="170" /></a>
	</div>
	<div id="fifth">
		<span id="fif_text">明星单品</span>
	</div>
	<div id="sixth">
		<span style="margin-left: 0px; border-top: #ff0000 1px solid">
			<a href="" id="siximg"><img src="image/pinpai1.png" width="234" height="234" /></a> 
			<a href="" id="na">小米MIX</a>
			<p id="chip">5月9日-21日享花呗12期分期免息</p>
			<p id="pri">3499元起</p>
		</span>
		<!-- <span style="margin-left: 0px; border-top: #ffa500 1px solid">
			<a href="" id="siximg"><img src="image/pinpai1.png" width="234" height="234" /></a> 
			<a href="" id="na">小米MIX</a>
			<p id="chip">5月9日-21日享花呗12期分期免息</p>
			<p id="pri">3499元起</p>
		</span> 
		<span style="border-top: #008000 1px solid"> 
			<a href="" id="siximg"><img src="image/pinpai2.png" width="234" height="234" /></a>
			<a href="" id="na">华为P10</a>
			<p id="chip">6月9日-21日享12期分期免息</p>
			<p id="pri">5499元起</p>
		</span> 
		<span style="border-top: #0000ff 1px solid"> <a href=""
			id="siximg"><img src="image/pinpai3.png" width="234" height="234" /></a>
			<a href="" id="na">iphone8</a>
			<p id="chip">1月9日-21日享招商银行12期分期免息</p>
			<p id="pri">5499元起</p>
		</span> 
		<span style="border-top: #ff0000 1px solid"> <a href=""
			id="siximg"><img src="image/pinpai4.png" width="234" height="234" /></a>
			<a href="" id="na">乐视电视</a>
			<p id="chip">4月9日-12日享花呗12期分期免息</p>
			<p id="pri">4499元起</p>
		</span> 
		<span style="border-top: #008080 1px solid"> <a href=""
			id="siximg"><img src="image/pinpai5.png" width="234" height="234" /></a>
			<a href="" id="na">华为笔记本</a>
			<p id="chip">5月9日-21日享花呗12期分期免息</p>
			<p id="pri">7499元起</p>
		</span> -->
	</div>
</body>
</html>