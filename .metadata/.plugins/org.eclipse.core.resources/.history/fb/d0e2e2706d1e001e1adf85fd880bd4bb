<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Time"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/monthCal.css">
<style>
.Calendar {
	border: 1px solid black;
}
</style>
<script src="resources/js/monthCal.js"></script>
<script type="text/javascript">
	//bList 예시 데이터
	var bList = [ {
		donationtypeName : "A"
	}, {
		donationtypeName : "B"
	}, {
		donationtypeName : "C"
	},
	// 추가적인 데이터...
	];

	// 테이블 생성 함수
	function createTable() {
		var table = document.createElement("table");
		table.classList.add("table-Light", "text-center");

		var thead = document.createElement("thead");
		var tbody = document.createElement("tbody");

		// 헤더 생성
		var headerRow = document.createElement("tr");
		var headerCell = document.createElement("td");
		headerCell.textContent = "시간";
		headerRow.appendChild(headerCell);

		var timeSlots = [ "9:00", "10:00", "11:00", "12:00", "13:00", "14:00",
				"15:00", "16:00", "17:00", "18:00", "19:00" ];
		timeSlots.forEach(function(time) {
			var timeCell = document.createElement("td");
			timeCell.textContent = time;
			headerRow.appendChild(timeCell);
		});

		thead.appendChild(headerRow);
		table.appendChild(thead);

		// 헌혈 종류 생성
		var bListRow = document.createElement("tr");
		var bListLabelCell = document.createElement("td");
		bListLabelCell.textContent = "예약 가능\n헌혈 종류 시간";
		bListRow.appendChild(bListLabelCell);

		bList.forEach(function(b) {
			var bListCell = document.createElement("td");
			bListCell.textContent = b.donationtypeName;
			bListRow.appendChild(bListCell);
		});

		tbody.appendChild(bListRow);
		table.appendChild(tbody);

		return table;
	}

	// 테이블 생성 및 컨테이너에 추가
	var tableContainer = document.getElementById("tableContainer");
	var table = createTable();
	tableContainer.appendChild(table);
</script>
<title>달력</title>
</head>
<form name="reservationChkProcess" id="reservationChkProcess"
	method="post">
	<!-- <input type="hidden" name="no" id="no" value="${b1.no}" /> -->
	<%-- <input type="hidden" name="pageNum" value="${ pageNum }" /> --%>
</form>
<body>
	<form id="reservationChk" name="reservationChk"
		action="reservationChkProcess"></form>
	<table class="Calendar mt-5">
		<thead>
			<tr>
				<td onClick="prevCalendar();" style="cursor: pointer;">&#60;</td>
				<td colspan="5"><span id="calYear"></span>년 <span id="calMonth"></span>월
				</td>
				<td onClick="nextCalendar();" style="cursor: pointer;">&#62;</td>
			</tr>
			<tr>
				<td>일</td>
				<td>월</td>
				<td>화</td>
				<td>수</td>
				<td>목</td>
				<td>금</td>
				<td>토</td>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
	<!-- 선택된 날짜 -->

	<!-- 캘린더 날짜 클릭하면 시간 나옴 -->

	<!-- 달력에  -->
	<div id="selectedDate" class="text-center mt-3"></div>


	<!-- 캘린더 날짜 클릭하면 시간 나옴 -->
	<div id="s-eTime" class="d-flex justify-content-center mt-4">
		<table id="resvBtn1" style="display: none;">

			<thead class="table-Light text-center ">
				<tr>

					<td>내용1</td>
					<!-- cell -->
					<td>내용2</td>
					<!-- cell -->
				</tr>
				<tr>
					<td>내용1</td>
					<td>내용2</td>

				</tr>
				<tr>
					<td>예약가능<br>헌혈종류시간
					</td>

					<!-- 게시 글이 있는 경우 -->
					<c:if test="${not empty bList}">
						<c:forEach var="b" items="${bList}">
							<td>${b.donationtypeName}</td>
						</c:forEach>
					</c:if>
					<!-- 게시 글이 없는 경우 -->
					<c:if test="${empty bList}">
						<tr>
							<td colspan="5">게시 글이 존재하지 않습니다.</td>
						</tr>
					</c:if>

				</tr>
				<tr>
					<td>시간</td>
					<td>15:00</td>
					<td>16:00</td>
					<td>17:00</td>
					<td>18:00</td>
					<td>19:00</td>
				</tr>
				<tr>
					<td>예약가능<br>헌혈종류시간
					</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</thead>


		</table>
	</div>

	
	<br>
	<br>
	<!--resvBldHousStep4?locationNo=1&reservationDate=20220711&reservationTime=0900  -->
	<!-- <a href="khj/"><button type="button" class="btn btn-primary">예약</button></a> -->
	<div class="p-4  row">
		<div class="col text-end">
			<input type="button" value="예c약"
				onclick="location.href='resvBldHousStep4'" class="btn btn-warning" />
		</div>
	</div>
</body>
</html>