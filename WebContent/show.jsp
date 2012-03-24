<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Note</title>
</head>
<body>
	<jsp:useBean id="noteBean" scope="request" class="sample.NoteBean" />
	<h1><jsp:getProperty name="noteBean" property="title" /></h1>
	<p>
		<jsp:getProperty name="noteBean" property="body" />
	</p>
	<a href=edit>Edit</a>
</body>
</html>