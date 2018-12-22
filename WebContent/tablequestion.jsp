<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<c:set var="count" value="${chonmon.size()-1}" />
	<c:forEach var="i" begin="0" step="1" end="${count}">
		<tr>
			<td>${i+1}</td>
			<td>${chonmon[i].macauhoi}</td>
			<td>${chonmon[i].noidung}</td>
			<td>${chonmon[i].dapan1}</td>
			<td>${chonmon[i].dapan2}</td>
			<td>${chonmon[i].dapan3}</td>
			<td>${chonmon[i].dapan4}</td>
			<td>${chonmon[i].dapandung}</td>		
			<td>
				<span class="table-edit" ><button type="button" id="myBtn" data-toggle="modal" data-target="#myModal" class="btn btn-primary btn-rounded btn-sm my-0" id="table-edit"><i class="fas fa-edit"></i></button></span>
				<span class="table-remove"><button type="button" class="btn btn-danger btn-rounded btn-sm my-0"><i class="fas fa-trash-alt"></i></button></span>
			</td>
		</tr>
	</c:forEach>
	
