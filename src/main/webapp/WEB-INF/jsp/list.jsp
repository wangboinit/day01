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

		//全选/全不选
		$("#qx").toggle(function(){
			$(":checkbox").prop("checked",true);
		},function(){
			$(":checkbox").prop("checked",false);
		})
	})
	
	function deleteAll() {
		var str="";
		$(":checkbox:checked").each(function(){
			str+=$(this).val()+",";
		})
		
		var flag=window.confirm("是否确定删除")
		if(flag){
			$.ajax({
				url:"deleteMtv.do",
				data:{"str":str},
				type:"post",
				success:function(data){
					if(data){
						alert("删除成功")
						window.location="list.do";
					}
				}
			})
		}else{
			alert("取消成功")
		}
		
	}
</script>
</head>
<body>
		<form action="list.do" method="post">
			电影名称：<input type="text" name="name">
			
			<input type="submit" value="搜索">
		</form>
		<input type="button" value="批量删除" onclick="deleteAll()">
	<table>
			<tr>
			<th colspan="11">
				欢迎进入电影选择界面<a href="toAddMtv.do"><input type="button" value="添加影视"></a>
			</th>
		</tr>
		
		<tr>
			<th>选择<input type="button" value="全选/全不选" id="qx"></th>
			<th>电影名称</th>
			<th>电影简绍</th>
			<th>电影导演</th>
			<th>影视类型</th>
			<th>上架时间</th>
			<th>操作</th>
		</tr>
<c:forEach items="${info.getList() }" var="m">
		<tr>
			<td><input type="checkbox" value="${m.mid }" ></td>
			<td>${m.mname }</td>
			<td>${m.studoe }</td>
			<td>${m.name }</td>
			<td>${m.tname }</td>
			<td>${m.fromTime }</td>
			<td><a href="updateMtv.do?mid=${m.mid }"><input type="button" value="修改影视"></a></td>
		</tr>
</c:forEach>
		<tr>
			<th colspan="11">
			<a href="list.do?pageNum=${info.getPageNum()-1<=0?1:info.getPageNum()-1 }">上一页</a>
				|
			<a href="list.do?pageNum=${info.getPageNum()+1>info.getPages()?info.getPages():info.getPageNum()+1 }">下一页</a>	
			</th>
		</tr>	
	</table>


</body>
</html>