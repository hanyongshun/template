<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>360</title>
<%@include file="./common/common.jsp"%>
<!-- scriptMergeTo: -->
	<script type="text/javascript" src="${contextPath}/resources/script/app/index.js"></script>
<%-- 	<script type="text/javascript" src="${contextPath}/resources/script/app/common.js"></script> --%>
<!-- scriptMergeTo -->
	<script type="text/javascript">
		require(["jquery"],function($){
			alert("a");
			$(function(){
				alert("end");
			});
		});
		alert("b");
	</script>
</head>
<body>
	<div id="test">
		abc
	</div>
</body>
</html>