<%--
  Created by IntelliJ IDEA.
  User: UlviyyaIbrahimli
  Date: 2022-02-05
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="mt-2">
    <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

        <li class="nav-item">
            <a href="#" class="nav-link">
                <i class="nav-icon fas fa-book-open"></i>
                <p>
                    Browse
                    <i class="right fas fa-angle-left"></i>
                </p>
            </a>
            <ul class="nav nav-treeview">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/ultra/newEmployeeWithExcel"
                       class="nav-link">
                        <i class="far fa-circle nav-icon"></i>
                        <p>New Employee</p>
                    </a>
                </li>
            </ul>
        </li>
    </ul>
    </nav>
