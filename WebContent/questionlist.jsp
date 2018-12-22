<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:forEach items="${question}" var="i" varStatus="loop">
	<li class="question" id="question${loop.index}"><label
		class="questionLabel" id="question_2_${loop.index}"
		for="question_${loop.index}">${loop.index + 1}. ${i.noidung}
			<button type="button" class="btn btn-default edit" data-toggle="modal"
				data-target="#questionModal">
				<i class="far fa-edit"></i>
			</button>
	</label>
		<div class="answerSet">
			<span> <input id="question_${loop.index}_1"
				name="question_${loop.index}" class="element radio" type="radio"
				value="1"> <label class="choice"
				id="question_3_${loop.index}" for="question_${loop.index}_1">${i.dapan1}</label>
			</span> <span> <input id="questioni_${loop.index}_2"
				name="question_${loop.index}" class="element radio" type="radio"
				value="2"> <label class="choice"
				id="question_4_${loop.index}" for="question_${loop.index}_2">${i.dapan2}</label>
			</span> <span> <input id="questioni_${loop.index}_3"
				name="question_${loop.index}" class="element radio" type="radio"
				value="3"> <label class="choice"
				id="question_5_${loop.index}" for="question_${loop.index}_3">${i.dapan3}</label>
			</span> <span> <input id="questioni_${loop.index}_4"
				name="question_${loop.index}" class="element radio" type="radio"
				value="4"> <label class="choice"
				id="question_6_${loop.index}" for="question_${loop.index}_4">${i.dapan4}</label>
			</span>
		</div></li>
</c:forEach>
