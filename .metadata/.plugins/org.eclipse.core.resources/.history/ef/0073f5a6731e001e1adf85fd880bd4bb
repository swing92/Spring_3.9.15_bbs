<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

  <div class="container pt-5">
    <h2>헌혈의집 찾기</h2>
    <hr>
  </div>

    <div class="container pt-5"> 
    
<form class="addressForm form-inline" name="addressForm" method="get" action="SearchAddress">
  <input type="hidden" name="type" value="address"/>
  <div class="row justify-content-center">
    <div class="col-2 border border-lightgray bg-light">      
          <label for="sido" class="sr-only">지역 선택</label>
    </div>
    <div class="col-4 border border-lightgray d-flex align-items-center">
      <select class="form-control" style="width: 100px;" id="sido">
        <option value="">시도</option>
        <option value="서울">서울</option>
                   <option value="경기">경기</option>
                   <option value="수원">수원</option>      
				   <option value="충북">충북</option>
				   <option value="대전">대전</option>
				   <option value="전북">전북</option>
				   <option value="대구">대구</option>
				   <option value="울산">울산</option>
				   <option value="경남">경남</option>
				   <option value="부산">부산</option>
				   <option value="광주">광주</option>
				   <option value="제주">제주</option>
      </select>
      &nbsp;&nbsp;
      <select class="form-control" style="width: 100px;" id="sigungu" name="locationAddress">
        <option value="">시군구</option>
      </select>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <button class="btn btn-primary" type="submit" id="button-addon2">검색</button>
    </div> 
  </div>
</form>

<form class="addressForm form-inline" name="addressForm" method="get" action="SearchArea"> 
  <input type="hidden" name="type" value="area"/>
  <div class="row justify-content-center">
    <div class="col-2 border border-lightgray bg-light">
       <label for="areaNo" class="sr-only">혈액원 선택</label>
    </div>
    <div class="col-4 border border-lightgray d-flex align-items-center">
      <select class="form-control" style="width:150px;" name="areaNo">
        <option value="">선택해주세요</option>
        <option value="1">서울중앙혈액원</option>
          <option value="3">서울동부혈액원</option>
          <option value="2">서울남부혈액원</option>
          <option value="6">인천혈액원</option>
          <option value="5">경기혈액원</option>
          <option value="7">강원혈액원</option>
          <option value="8">충북혈액원</option>
          <option value="9">대전세종충남혈액원</option>
          <option value="10">전북혈액원</option>
          <option value="12">대구혈액원</option>
          <option value="14">울산혈액원</option>   
           <option value="13">경남혈액원</option>
          <option value="4">부산혈액원</option> 
          <option value="11">광주전남현액원</option>
          <option value="15">제주혈액원</option>
      </select>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <button class="btn btn-danger" type="submit" id="adButton">검색</button>
    </div>             
  </div> 
</form>

 </div>    



<div class="container pt-5">
    
전혈은 운영 종료시간 30분 전, 혈장은 1시간, 혈소판은 1시간 30분 전에 헌혈 접수가 마감되며 현장 상황에 따라 접수가 조기 마감될 수 있으니 헌혈의집 방문전에 참고하시기 바랍니다.
    
</div>

<div class="container pt-5">
<h4>헌혈의집 지도 표시</h4>
</div>

<div class="container p-5">
  <div class="row">
    <div class="col-12">

<div class="row featurette justify-content-center">

<div id="map" style="width:70%;height:500px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=742f90c577057b60c33f80faeadf9ee0"></script>
<script>

document.getElementById("sido").addEventListener("change", function() {
	  var sidoValue = this.value;
	  var sigunguSelect = document.getElementById("sigungu");
	  
	  // 기존의 시군구 선택 옵션을 모두 제거합니다.
	  sigunguSelect.innerHTML = "";
	  
	  // 서울이 선택된 경우에만 시군구 선택 옵션을 생성합니다.
	  if (sidoValue === "서울") {
	    var seoulDistricts = [
	      "종로구", "중구", "용산구", "성동구", "광진구", "동대문구", "중랑구", "성북구",
	      "강북구", "도봉구", "노원구", "은평구", "서대문구", "마포구", "양천구", "강서구",
	      "구로구", "금천구", "영등포구", "동작구", "관악구", "서초구", "강남구", "송파구", "강동구"
	    ];
	    
	    for (var i = 0; i < seoulDistricts.length; i++) {
	      var option = document.createElement("option");
	      option.value = seoulDistricts[i]; // 구 이름을 option의 value로 설정
	      option.text = seoulDistricts[i];
	      sigunguSelect.appendChild(option);
	    }
	  } else if (sidoValue === "경기") {
		    var gyeonggiDistricts = [
		        "수원시", "성남시", "의정부시", "안양시", "부천시", "광명시", "평택시", "동두천시",
		        "안산시", "고양시", "과천시", "구리시", "남양주시", "오산시", "시흥시", "군포시",
		        "의왕시", "하남시", "용인시", "파주시", "이천시", "안성시", "김포시", "화성시",
		        "광주시", "양주시", "포천시", "여주시", "연천군", "가평군", "양평군"
		      ];

		      for (var i = 0; i < gyeonggiDistricts.length; i++) {
		        var option = document.createElement("option");
		        option.value = gyeonggiDistricts[i]; // 시군구 이름을 option의 value로 설정
		        option.text = gyeonggiDistricts[i];
		        sigunguSelect.appendChild(option);
		      }
		    }	  
	});


var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(37.471666, 126.937666), // 지도의 중심좌표
        level: 8 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 
//마커를 표시할 위치와 title 객체 배열입니다 
//console.log("${location}");



let latitudeCount = 0; // latitude의 개수를 저장할 변수 추가
let longitudeCount = 0

var positions = [];

<c:choose>
<c:when test="${not empty locationList}">
    <c:forEach var="l" items="${locationList}" varStatus="status">
    positions.push({
        title: '${l.locationName}',
        latlng: new kakao.maps.LatLng(${l.latitude}, ${l.longitude})
    });
    latitudeCount++; // latitude의 개수 증가
    longitudeCount++; // latitude의 개수 증가
    </c:forEach>
</c:when>
<c:when test="${not empty areaList}">
    <c:forEach var="a" items="${areaList}" varStatus="status">
    positions.push({
        title: '${a.locationName}',
        latlng: new kakao.maps.LatLng(${a.latitude}, ${a.longitude})
    });
    latitudeCount++; // latitude의 개수 증가
    longitudeCount++; // latitude의 개수 증가
    </c:forEach>
</c:when>
</c:choose>

console.log("갯수: " + latitudeCount);
console.log("갯수: " + longitudeCount);

positions.sort(function(a, b) {
    return a.latlng - b.latlng;
});

let middleIndex = Math.floor(positions.length / 2);
let clatitude;
let clongitude;

if (positions.length % 2 === 0) {
    clatitude = (positions[middleIndex].latlng.getLat() + positions[middleIndex - 1].latlng.getLat()) / 2;
    clongitude = (positions[middleIndex].latlng.getLng() + positions[middleIndex - 1].latlng.getLng()) / 2;
} else {
    clatitude = positions[middleIndex].latlng.getLat();
    clongitude = positions[middleIndex].latlng.getLng();
}

console.log("중앙값 (위도): " + clatitude);
console.log("중앙값 (경도): " + clongitude);
var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
    mapOption = { 
        center: new kakao.maps.LatLng(clatitude, clongitude), // 지도의 중심좌표
        level: 8 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 마커 이미지의 이미지 주소입니다
var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
    
for (var i = 0; i < positions.length; i ++) {
    
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
    
    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        map: map, // 마커를 표시할 지도
        position: positions[i].latlng, // 마커를 표시할 위치
        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
        image : markerImage // 마커 이미지 
    });
}
</script>

</div>
</div>
</div>
</div>



<div class="container pt-5">
   
   
   <p>Total ${locationCount}건</p>
   
       <div class="row justify-content-center bg-light border-top border-dark border-3">
      <!--   <div class="col border-bottom-3 border-lightgray py-4">지역</div> -->
        <div class="col border-bottom-3 border-lightgray py-4" style="font-weight: bold;">&nbsp; 헌혈의집</div>

        <div class="col border-bottom-3 border-lightgray py-4">&nbsp; 주소</div>

        <div class="col border-bottom-3 border-lightgray py-4">&nbsp; 전화번호</div>
       
        <div class="col border-bottom-3 border-lightgray py-4"></div>
<c:choose>
    <c:when test="${not empty locationList}">
        <c:forEach var="l" items="${locationList}" varStatus="status">
            <div class="row pt-3 border-top border-dark border-1">
                <div class="col-3" style="font-weight: bold;">${l.locationName}</div>
                <div class="col-3">${l.locationAddress}</div>
                <div class="col-3">${l.tel}</div>
                  <div class="col-3">
                     <div class="row"><a href="resvBldHousStep3?locationNo=${a.locationNo}" onclick="checkLogin('${l.locationNo}')"><button class="btn btn-danger" type="button">예약</button></a></div>
                  </div>
            </div>
        </c:forEach>
    </c:when>
    
    <c:when test="${not empty areaList}">
        <c:forEach var="a" items="${areaList}" varStatus="status">
            <div class="row">
                <div class="col">${a.locationName}</div>
                <div class="col">${a.locationAddress}</div>
                <div class="col">${a.tel}</div>
                <div class="col">
                    <div class="row">
                    	<div class="col">
                     		 <a href="resvBldHousStep3?locationNo=${a.locationNo}" onclick="checkLogin('${a.locationNo}')"><button class="btn btn-danger" type="button">예약</button></a>
                    	</div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:when>
</c:choose>

       </div>
</div>

<style>

    .pagination .page-link {
        background-color: black; /* 페이징 박스의 배경색을 변경 */
        color: white; /* 페이징 박스의 텍스트 색상을 변경 */
        border-color: black; /* 페이징 박스의 테두리 색상을 변경 */
    }

    .pagination .page-item.active .page-link {
        background-color: gray; /* 활성화된 페이지 칸의 배경색을 변경 */
        color: #33FF33;
    }

</style>

<c:choose>
    <c:when test="${not empty locationList}">
<div class="col pt-5">
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <c:if test="${ startPage > pageGroup }">
                <li class="page-item">
                    <a class="page-link text-white" href="searchMap?pageNum=${ startPage - pageGroup }">Pre</a>
                </li>
            </c:if>
            <c:forEach var="i" begin="${startPage}" end="${endPage}">
                <c:if test="${i == currentPage }">
                    <li class="page-item active" aria-current="page">
                        <span class="page-link bg-dark text-#33FF33">${i}</span>
                    </li>
                </c:if>
                <c:if test="${i != currentPage }">
                    <li class="page-item"><a class="page-link text-#33FF33" href="searchMap?pageNum=${ i }">${i}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${ endPage < pageCount }">
                <li class="page-item">
                    <a class="page-link text-white" href="searchMap?pageNum=${ startPage + pageGroup }">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
   </c:when>
 <c:when test="${searchOption2 and not empty locationList}">
<div class="col pt-5">
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <c:if test="${ startPage2 > pageGroup2 }">
                <li class="page-item">
                    <a class="page-link text-white" href="addressSearch?pageNum=${ startPage2 - pageGroup2 }&type=${type}&locationAddress=${locationAddress}">Pre</a>
                </li>
            </c:if>
            <c:forEach var="i" begin="${startPage2}" end="${endPage2}">
                <c:if test="${i == currentPage2 }">
                    <li class="page-item active" aria-current="page">
                        <span class="page-link bg-dark text-#33FF33">${i}</span>
                    </li>
                </c:if>
                <c:if test="${i != currentPage2 }">
                    <li class="page-item"><a class="page-link text-#33FF33" href="addressSearch?pageNum=${ i }&type=${type}&locationAddress=${locationAddress}">${i}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${ endPage2 < pageCount2 }">
                <li class="page-item">
                    <a class="page-link text-white" href="addressSearch?pageNum=${ startPage2 + pageGroup2 }&type=${type}&locationAddress=${locationAddress}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</div>
   </c:when>
    
 <c:when test="${searchOption and not empty areaList}">
   <div class="col pt-5">
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <c:if test="${ startPage2 > pageGroup2 }">
                <li class="page-item">
                    <a class="page-link text-white" href="areaAction?pageNum=${ startPage2 - pageGroup2 }&type=${ type }&areaNo=${areaNo}">Pre</a>
                </li>
            </c:if>
            <c:forEach var="i" begin="${startPage2}" end="${endPage2}">
                <c:if test="${i == currentPage2 }">
                    <li class="page-item active" aria-current="page">
                        <span class="page-link bg-dark text-#33FF33">${i}</span>
                    </li>
                </c:if>
                <c:if test="${i != currentPage2 }">
                    <li class="page-item"><a class="page-link text-#33FF33" href="areaAction?pageNum=${ i }&type=${ type }&areaNo=${areaNo}">${i}</a></li>
                </c:if>
            </c:forEach>
            <c:if test="${ endPage2 < pageCount2 }">
                <li class="page-item">
                    <a class="page-link text-white" href="areaAction?pageNum=${ startPage2 + pageGroup2 }&type=${ type }&areaNo=${areaNo}">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
    </div>
  </c:when>
</c:choose>

<c:if test="${not sessionScope.isLogin}">
    <script>
    function checkLogin(locationNo) {
        event.preventDefault();
        alert('로그인 후에 예약할 수 있습니다.');
        window.location.href = 'login';  // 로그인 페이지 URL로 이동
        return false;
    }
    </script>
</c:if>
