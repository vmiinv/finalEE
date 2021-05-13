<%@ page import="kz.iitu.ead.entities.Users" %><%
//   Users currentUser = (Users)session.getAttribute("user");
%>
<jsp:useBean id="user" class="kz.iitu.ead.entities.Users" scope="session"/>
<jsp:setProperty name="user" property="*"/>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgba(54,102,120,0.08);">
        <a class="navbar-brand" href="#" style="font-weight: bold;"><img src="https://i.plitka-sdvk.ru/i/plitka/Absolut-Keramika/Gold-Capuccino/163217163217_main.jpg" style="width: 200px;"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <%
                    if(user.getEmail()!=null){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="#"><jsp:getProperty name="user" property="fullName"/> </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="addcoffee.jsp">Add Coffee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout">Logout </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="profile">Profile </a>
                </li>
                <%
                }else if (user.getEmail() == null){
                %>
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Home </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="register.jsp">Register </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login </a>
                </li>
                <%
                    }
                %>
                <li class="nav-item">
                    <a class="nav-link" href="allcoffee">Coffee</a>
                </li>
            </ul>
            <form class="form-inline my-2 my-lg-0" action="/home" method="get">
                <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="key">
                <input type="hidden" name="searchBy" value="1">
                <button class="btn btn-outline-dark my-2 my-sm-0">Search</button>
            </form>
        </div>
    </nav>
</div>