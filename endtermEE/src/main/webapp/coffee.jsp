<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.iitu.ead.entities.Coffee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="java.util.List" %>
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
<jsp:useBean id="coffees" type="java.util.List<kz.iitu.ead.entities.Coffee>" scope="request"/>
<jsp:setProperty name="coffees" property="*"/>
<%-- Directives --%>
<%@include file="navbar.jsp"%>
<div class="container mt-3">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/">Home</a></li>
            <li class="breadcrumb-item active" aria-current="page">All Coffees</li>
        </ol>
    </nav>
</div>
<div class="container mt-3">
    <div class="row">
        <div class="col-sm-12">

                        <%
                                for(int i = 0; i< coffees.size(); i++){
                        %>
                        <div class="jumbotron">
                            <h2><% out.print(coffees.get(i).getName());%></h2>
                            <h3>For <% out.print(coffees.get(i).getPrice());%> KZT</h3>
                            <hr class="my-4">
                            <a class="btn btn-primary btn-sm" href="details?&id=<%=coffees.get(i).getId()%>" role="button">Details</a>
                        </div>
                        <%
                            }
                        %>
        </div>
    </div>
</div>
<%-- Action tag --%>
<%--<jsp:include page="footer.jsp"/>--%>
