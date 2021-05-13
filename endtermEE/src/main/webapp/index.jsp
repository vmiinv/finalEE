<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.iitu.ead.entities.Coffee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<html>
<head>
    <title>Coffee</title>
<%--     Action tag --%>
    <%@include file="head.jsp"%>
    <style>
        img{
            max-width: 100%;
        }
    </style>
</head>
<body>
<%--<jsp:useBean id="coffeeList" class="java.util.List<kz.iitu.ead.entities.Coffee>" scope="request"/>--%>
<%--<jsp:setProperty name="coffeeList" property="*"/>--%>
<%-- Directives --%>
<%@include file="navbar.jsp"%>
<div class="container mt-3">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
        </ol>
    </nav>
</div>
<div class="container mt-3">
    <div class="row">
  <h1>Here you can buy coffees</h1>
    </div>
</div>
<%-- Action tag --%>
<%--<jsp:include page="footer.jsp"/>--%>
