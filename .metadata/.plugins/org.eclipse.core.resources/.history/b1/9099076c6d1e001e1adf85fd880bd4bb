<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="row my-10" id="global-content">
	<div class="col">
		<div class="row text-center">
			<div class="col">
				<h2 class="fs-3 fw-bold">form 양식</h2>
			</div>
		</div>
		<div class="col-8 offset-md-2">
			<label for="writer" class="form-label">회원</label> <input type="text"
				class="form-control" name="writer" id="writer" value="${b.memberId}">
		</div>
		<form action="insertAction">
			<div class="col-8 offset-md-2 text-center">
				<table border="1">
					<tr>
						<td>아이디</td>
						<td><input type="text" name="memberId"></td>
					</tr>
					<tr>
						<td>날짜</td>
						<td><input type="text" name="reservationDate">${reservationDate}</td>
						<!--ex) 20230629 -->
					</tr>
					<tr>
						<td>시간</td>
						<td><input type="text" name="reservationTime"></td>
						<!--ex) 0900 -->
					</tr>
					<tr>
						<td>장소</td>
						<td><input type="text" name="locationNo"></td>
						<!-- 숫자 -->
					</tr>
					<tr>
						<td>헌혈상태</td>
						<td><input type="text" name="stateNo"></td>
						<!-- 숫자 -->
					</tr>
					<tr>
						<td>헌혈타입</td>
						<td><input type="text" name="donationtypeNo"></td>
						<!-- 숫자 -->
					</tr>
				</table>
				<button type="submit">전송</button>
				<a href="resvBldHousStep5"><button type="button"
						class="btn btn-primary">확인</button></a>
			</div>
		</form>
	</div>

</div>

