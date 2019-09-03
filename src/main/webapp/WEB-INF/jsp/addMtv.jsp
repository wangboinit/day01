<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/css.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function(){
		var str="";
		$.ajax({
			url:"selectType.do",
			success:function(data){
				$.each(data,function(i,val){
					var tid = val.tid;
					var tname = val.tname;
				str+="<input type='radio' value='"+tid+"' name='tid'>'"+tname+"'";
				})
				$("#sp1").html(str);
			}
		})
	})
	
	function addMtv() {
		$.ajax({
			url:"addMtv.do",
			data:$("form").serialize(),
			type:"post",
			success:function(data){
				if(data){
				var flag=window.confirm("添加成功是否返回列表页面？")
				if(flag){
					window.location="list.do";
				}
				}
			}
		})
	}
</script>
</head>
<body>
		<form action="">
			电影名称：<input type="text" name="mname"><br><br>
			导演名称：<input type="text" name="name"><br><br>
			影视简绍：<input type="text" name="studoe"><br><br>
			影视类型：
				<span id="sp1"></span>
			
			<br><br>
			上架时间：<input type="date" name="fromtime"><br><br>
		
			操作：<input type="button" value="添加" onclick="addMtv()">
			<a href="list.do"><input type="button" value="返回列表页面"></a>
			
		</form>
</body>
</html>