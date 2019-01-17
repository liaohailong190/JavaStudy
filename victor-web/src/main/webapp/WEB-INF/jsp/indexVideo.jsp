<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台视频管理系统</title>
</head>
<body>
	<center>
		<h1>视频后台管理系统</h1>
		<a href="localAddVideo">添加资源</a>
		<table style="border-collapse: collapse; text-align: center;"
			bordercolor="#000000" height=40 cellpadding=1 width="70%"
			align="center" border=1>
			<thead>
				<tr>
					<th>图片</th>
					<th>视频名称</th>
					<th>视频类型</th>
					<th>预览视频</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${videoList}" var="p">
					<tr style="font-size: 18px">
						<td><img alt="" width="150px" height="150px"
							src="/victor-web/static/imgs/11111111111.png"></td>
						<td>${p.name}</td>
						<td>${p.typeName}</td>
						<td><a href="videoDetails?/id=${p.id}"
							style="text-decoration: none;">预览视频</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</center>
</body>
</html>