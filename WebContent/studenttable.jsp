<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:set var="count" value="${student.size()-1}" />
	<c:forEach var="i" begin="0" step="1" end="${count}">
		<tr>
			<td>${i+1}</td>
			<td>${student[i].manguoidung}</td>
			<td>${student[i].tennguoidung}</td>
			<td>
					<span class="table-remove"><button type="button" class="btn btn-danger btn-rounded btn-sm my-0"><i class="fas fa-edit"></i></button></span>
			</td>
		</tr>
	</c:forEach>