<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ page import="sample.*" %>

<%-- (1)各スコープのJavaBeansオブジェクトを生成します。 --%>
<jsp:useBean id="reqObject" class="sample.NoteBean" 
             scope="request" />
<jsp:useBean id="sesObject" class="sample.NoteBean" 
             scope="session" />
<jsp:useBean id="appObject" class="sample.NoteBean" 
             scope="application" />
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>untitled</title>
</head>
<body>
</body>
</html>