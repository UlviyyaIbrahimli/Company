<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: UlviyyaIbrahimli
  Date: 2022-02-05
  Time: 18:08
  To change this template use File | Settings | File Templates.
--%>
<a href="${pageContext.request.contextPath}/ultra/home" class="brand-link">
    <img src="${pageContext.request.contextPath}/resources/dist/img/download1.png" alt="Ultra"
         class="brand-image img-circle elevation-3" style="opacity: .8">
    <span class="brand-text font-weight-light">Ultra Technologies</span>
</a>
<div class="sidebar">
    <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
            <img src="${pageContext.request.contextPath}/resources/dist/img/download.jpg"
                 class="img-circle elevation-2" alt="Image">
        </div>
        <div class="info">
            <h5 class="d-block">Ibrahimli Ulviyya</h5>
        </div>
    </div>
    <c:import url="static/menu.jsp"></c:import>
</div>
