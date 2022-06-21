<%@ page import="com.management_teachers_impression.management_teachers_impression.models.entities.User" %>
<%
    HttpSession httpSession = request.getSession();
    User user = (User) httpSession.getAttribute("user");
%>
<% if (user != null) { %>
<div class="sidebar" data-color="orange" data-image="../assets/img/sidebar-5.jpg">
    <div class="sidebar-wrapper">
        <div class="logo">
            <a href="#" class="simple-text logo-mini">
                Ct
            </a>
            <a href="#" class="simple-text logo-normal">
                <%= user.getFirstname() + " " + user.getLastname() %>
            </a>
        </div>
        <ul class="nav">
            <li class="nav-item ">
                <a class="nav-link" href="./dashboard/users">
                    <i class="nc-icon nc-chart-pie-35"></i>
                    <p>Dashboard</p>
                </a>
            </li>
            <% if (!user.getRole().equals("teacher")) { %>
            <li class="nav-item">
                <a class="nav-link" data-toggle="collapse" href="<%= request.getContextPath() %>/users">
                    <p>
                        Users
                    </p>
                </a>
            </li>
            <% } %>
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/subjects">
                    <p>
                        Subjects
                    </p>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/askForPrintList">
                    <p>
                        print actions list
                    </p>
                </a>
            </li>
            <% if (user.getRole().equals("teacher")) { %>
            <li class="nav-item">
                <a class="nav-link" href="<%= request.getContextPath() %>/askForPrintDocument">
                    <p>
                        ask for print document
                    </p>
                </a>
            </li>
            <% } %>
        </ul>
    </div>
</div>
<% } %>
