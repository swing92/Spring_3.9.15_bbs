<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
<div class="row my-10" id="global-content">
	<div class="col">
		<div class="row my-3 p-2 text-center">
			<div class="col-8 offset-2">
				<h2 class="fs-3 fw-bold rext-center">헌혈의집 헌혈예약</h2>
			</div>
		</div>

		<!-- checkBox  -->
		<div class="container offset-2 p-3" action="#" name="checkboxForm"
			method="post" id="check_all">
			<div class="row">
				<div class="col-6 col-sm-2">모두 선택</div>
				<div class="col-6 col-sm-2">
					모두선택 <input type="checkbox" id="check_all" name="check_all">
				</div>
				<div class="p-2 w-100"></div>

				<div class="col-6 col-sm-2">헌혈종류 선택</div>
				<div class="col-6 col-sm-1">
					전혈<input type="checkbox" id="check_unit_1" name="check_unit">
				</div>
				<div class="col-6 col-sm-1">
					혈장<input type="checkbox" id="check_unit_2" name="check_unit">
				</div>
				<div class="col-6 col-sm-1">
					혈소판<input type="checkbox" id="check_unit_3" name="check_unit">
				</div>

				<div class="p-2 w-100"></div>

				<div class="col-6 col-sm-2">운영정보 선택</div>
				<div class="col-6 col-sm-1">
					평일 <input type="checkbox" id="check_unit_4" name="check_unit">
				</div>
				<div class="col-6 col-sm-1">
					주말 <input type="checkbox" id="check_unit_4" name="check_unit">
				</div>
				<div class="col-6 col-sm-1">
					공휴일<input type="checkbox" id="check_unit_4" name="check_unit">
				</div>

				<div class="p-2 w-100"></div>

				<div class="col-6 col-sm-2">편의시설 선택</div>
				<div class="col-6 col-sm-2">
					주차기능<input type="checkbox" id="check_unit_4" name="check_unit">
				</div>
				<div class="col-6 col-sm-2">
					지하철인근<input type="checkbox" id="check_unit_4" name="check_unit">
				</div>
				<div class="col-6 col-sm-2">
					인터넷이용<input type="checkbox" id="check_unit_4" name="check_unit">
				</div>
			</div>
		</div>

		<!-- 장소 검색  -->
		<form name="searchForm" id="searchForm" action="#"
			class="offset-2 p-3">
			<div class="row">
				<div class="col-6 col-sm-2">지역 선택</div>
				<div class="col-6 col-sm-1">
					<select type="type" class="form-select">
						<option>시도</option>
						<option>서울</option>
						<option>부산</option>
						<option>인천</option>
					</select>
				</div>
				<div class="col-6 col-sm-2">
					<select type="type" class="form-select">
						<option>시군구</option>
						<option>강남구</option>
						<option>노원구</option>
					</select>
				</div>

				<div class="p-2 w-100"></div>

				<div class="col-6 col-sm-2">키워드 입력</div>
				<div class="col-6 col-sm-4">
					<input class="form-control" type="text" name="keyword"
						placeholder="헌혈의집 명 또는 헌혈의집 주소를 입력해 주세요">
				</div>
				<div class="col-6 col-sm-3">
					<input type="submit" class="btn btn-warning" value="검 색">
				</div>
			</div>
		</form>
		<!-- 안내문구 -->
		<div class="col-8 offset-2">
			<div class="p-2 w-100">

				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
					fill="currentColor" class="bi bi-exclamation-circle"
					viewBox="0 0 16 16">
				<path
						d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
				<path
						d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 4.995z" />
			</svg>
				전혈은 운영 종료시간 30분 전, 혈장은 1시간, 혈소판은 1시간 30분 전에 헌혈 접수가 마감되며 현장 상황에 따라<br>&nbsp;&nbsp;&nbsp;
				접수가 조기 마감될 수 있으니 헌혈의집 방문전에 참고하시기 바랍니다.
			</div>
		</div>

		<!-- 검색  Total 리스트-->

		<div class="col-8 offset-2 fs-6 text-wrap" style="width: 68rem;">
			<div class="col-6 col-sm">Total 건</div>
			<table class="table table-hover">
				<thead class="table-Light text-center">
					<tr>
						<th>1</th>
						<th>2</th>
						<th>3</th>
						<th>4</th>
						<th>5</th>
						<th>6</th>
						<th>7</th>
						<th>8</th>
					</tr>
				</thead>
				<%-- <tbody class="text-secondary">
					<!-- 게시 글이 있는 경우 -->
					<c:if test="${not empty bList}">
						<c:forEach var="b" items="${bList}">
							<tr>
								<td>${b.reservationNo}</td>
								<td>${b.donationtype}</td>
								<td>${b.reservationTime}</td>
								<td>${b.reservationDate}</td>
								<td>${b.adress}</td>
								<td>
								<td><input type="button" value="상세보기"
									onclick="location.href='resvBldHousStep3'"
									class="btn btn-primary" /></td>
							</tr>
						</c:forEach>
					</c:if> --%>
				<!-- 게시 글이 없는 경우 -->
				<c:if test="${empty bList}">
					<tr>
						<td colspan="5">게시 글이 존재하지 않습니다.</td>
					</tr>
				</c:if>
				</tbody>
			</table>
			<div class="p-4  row">
				<div class="col text-end">
					<input type="button" value="예약하기"
						onclick="location.href='resvBldHousStep3'" class="btn btn-warning" />
				</div>
			</div>
		</div>
	</div>
</div>
</div>