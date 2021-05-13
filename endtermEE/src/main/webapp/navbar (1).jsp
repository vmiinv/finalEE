<%@ page import="kz.iitu.ead.entities.Users" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%-- Implicit obj --%>
<%
    Users currentUser = (Users)session.getAttribute("user");
%>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgba(54,102,120,0.08);">
        <a class="navbar-brand" href="index.jsp" style="font-weight: bold;"><img src="https://i.plitka-sdvk.ru/i/plitka/Absolut-Keramika/Gold-Capuccino/163217163217_main.jpg" style="width: 200px;"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">

                <li class="nav-item">

                    <%-- Action tag --%>
                    <jsp:useBean id="date" class="java.util.Date" />

                        <%-- Implicit obj --%>
                    <% out.print("Today: "+new SimpleDateFormat("dd.MM.yyyy").format(date)); %>
                </li>

                <%
                    if(currentUser!=null){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="/profile"><%=currentUser.getFullName()%> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/addcoffee">Add Coffee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout">Logout </a>
                </li>
                <%
                }else{
                %>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/register">Register </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Login </a>
                </li>
                <%
                    }
                %>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="/home" method="get">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="key">
                <input type="hidden" name="searchBy" value="1">
                <button class="btn btn-outline-dark my-2 my-sm-0">Search</button>
            </form>
        </div>
    </nav>
</div>