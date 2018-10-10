<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="./js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="./css/semantic.min.css">
<link rel="stylesheet" type="text/css" href="./css/index.css">
<script src="./js/semantic.min.js"></script>
<style>
.container1{
margin:20px;
}

</style>
<title>theGameOfLife</title>
</head>
<body style="background-color: #f3f3f3;">
	<div class="ui raised very padded text container segment" style="
    margin-top: 100px;">
	<div class="container1">
  		<div class="ui left labeled input">
  			<div class="ui basic label">行数</div>
  			<input type="text" id="rowText" placeholder="Enter height" >
		</div>
	</div>
	<div class="container1">
		<div class="ui left labeled input">
  			<div class="ui basic label">列数</div>
  			<input type="text" id="colText" placeholder="Enter width" >
		</div>
	</div>
	<div class="container1">
		<div class="ui left labeled input">
  			<div class="ui basic label">当前代数</div>
  			<div class="ui disabled input">
  				<input type="text" id="generateCount" placeholder="0" >
			</div>
		</div>
	</div>
	<button class="ui button" style="margin-left: 20px;" id="initButton" type="button">
		<font style="vertical-align: inherit;">
			<font style="vertical-align: inherit;">初始化</font>
		</font>
	</button>
	<button class="ui button "id="multiply_once">
		<font style="vertical-align: inherit;"id="multiply_once">
			<font style="vertical-align: inherit;">繁衍一代</font>
		</font>
	</button>
	<button class="ui button"id="multiply_auto">
		<font style="vertical-align: inherit;">
			<font style="vertical-align: inherit;">自动繁衍</font>
		</font>
	</button>
	<button class="ui button"id="multiply_stop">
		<font style="vertical-align: inherit;">
			<font style="vertical-align: inherit;">停止繁衍</font>
		</font>
	</button>

	<div id="table" style="margin-top: 30px;margin-left: 20px;" >
	</div>

	</div>
</body>
<script src="./js/index.js"></script>
</html>