<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${chonbd}" var="item" >
<option value="${item.maBode}">${item.tenBoDe}</option>
</c:forEach>