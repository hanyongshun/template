<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="../common/common.jsp" %>
	<script type="text/javascript" charset="utf-8" src="${path}/resources/common/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${path}/resources/common/ueditor/ueditor.all.min.js"> </script>
	<script type="text/javascript" charset="utf-8" src="${path}/resources/common/ueditor/lang/zh-cn/zh-cn.js"></script>
	<title>Ueditor</title>
</head>
<body>
	<!-- 加载编辑器的容器 -->
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
    <div>
    	<button onclick="console.info(ue.getContent());">获取内容</button>
    </div>
    <script type="text/javascript">
		var ue = UE.getEditor('editor',
				{
					serverUrl:"${path}/ueditor/ueditor",
					initialFrameWidth:360
				});
		
		ue.ready(function() {
		    ue.setContent('<div class="goodsInfonew goodsInfonewbg1 goodsInfonewbn" id="picture_0"> <img class="imgCalcu default_img" src="http://7xls5d.com2.z0.glb.qiniucdn.com/1452137491083.tmp" style="min-height: 150px;" width="306px;"> </div> <div class="goodsInfonew goodsInfonewbg1 goodsInfonewbn" id="picture_1"> <img class="imgCalcu default_img" src="http://7xls5d.com2.z0.glb.qiniucdn.com/1452137501748.tmp" style="min-height: 150px;" width="306px;"> </div> ');
		});
    </script>
</body>
</html>