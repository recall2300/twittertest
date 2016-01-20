<%@page import="twitter4j.auth.*"%>
<%@page import="twitter.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String oAuthToken = request.getParameter("oauth_token");

	RequestToken requestToken = (RequestToken)session.getAttribute("requestToken");
	TwitterClient twitterClient = (TwitterClient)session.getAttribute("twitterClient");
	twitterClient.getAccessToken(oAuthToken,requestToken);
%>
</body>
</html>