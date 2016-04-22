<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<form method="post" action="http://upload.qiniu.com/"
		enctype="multipart/form-data">
<!-- 		<input name="key" type="hidden" value="" />  -->
<%-- 		<input name="x:<custom_name>" type="hidden" value="<custom_value>"> --%>
		<input name="token" type="hidden" value="" />
		<input name="file" type="file" />
<!-- 		<input name="crc32" type="hidden" /> -->
<!-- 		<input name="accept" type="hidden" /> -->
		<input type="button" value="上传">
	</form>
	
	<script type="text/javascript">
		$(function(){
			$("input[type=button]").bind("click",function(){
				var fileName = $("input[type=file]").val();
				if(!fileName){
					alert("请选择文件");
					return false;
				}else{
					var mimeType = fileName.substring(fileName.lastIndexOf(".") + 1);
					$.ajax({
						type:'get',
						async:false,
						cache:false,
						dataType:'text',
						url:contextPath+"/qiniu/uploadToken/"+mimeType,
						success:function(data){
							$("input[name=token]").val(data);
							$("form").submit();
						},
						error:function(){
							alert("服务器异常，请稍后重试！");
						}
					});
				}
				
			});
			
		});
		
	</script>
</body>
</html>