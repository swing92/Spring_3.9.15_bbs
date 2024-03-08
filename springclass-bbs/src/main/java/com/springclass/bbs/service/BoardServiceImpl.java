package com.springclass.bbs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springclass.bbs.dao.BoardDao;
import com.springclass.bbs.domain.Board;



// BoardService를 구현(implements BoardService(인터페이스))
@Service	// 해당 클래스가 서비스 계층(비즈니스 로직)의 컴포넌트(Bean)임을 선언
public class BoardServiceImpl implements BoardService {
	
	// 한 페이지에 보여줄 게시글의 수 선언
	private static final int PAGE_SIZE = 10;
	
	// 한 페이지에 보여질 페이지 그룹의 수를 상수로 선언
	// [이전] 1 2 3 4 5 6 7 8 9 10 [다음]
	private static final int PAGE_GROUP = 10;
	
	// 인스턴스 필드에 @Autowired Annotaion을 사용하면 접근지정자가 private이고 setter메소드가 없어도 문제없이 주입됨
	@Autowired
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
//	// BoardDao를 이용해 게시판 테이블에서 현재 페이지에 해당하는 게시글 리스트를 읽어와 반환하는 메소드
//	@Override
//	public List<Board> boardList() {
//		return boardDao.boardList();
//	}
	
//	// (수정)BoardDao를 이용해 게시판 테이블에서 한 페이지에 해당하는 게시글 리스트와,
//	// 페이징 처리에 필요한 데이터를 Map 객체로 반환하는 메소드
//	public Map<String, Object> boardList(int pageNum){
//		// 요청 파라미터 pageNum을 현재 페이지로 설정
//		int currentPage = pageNum;
//		
//		// MySQL에서 row의 index는 0부터 시작한다.
//		// 1페이지의 startRow는 0, 2페이지의 startRow는 10, 3페이지의 startRow는 20
//		// 산식화하면 startRow = (페이지번호 - 1) * 10(PAGE_SIZE)
//		int startRow = (currentPage - 1) * PAGE_SIZE;
//		
//		// BoardDao를 이용해 전체 게시글 수를 가져옴
//		int listCount = boardDao.getBoardCount();
//		
//		// 현재 페이지에 해당하는 게시글 리스트를 BoardDao를 이용해 DB에서 읽어옴
//		List<Board> boardList = boardDao.boardList(startRow, PAGE_SIZE);
//		
//		// 페이지 그룹 이동 처리를 위해 전체 페이지 계산
//		// [이전] 11 12 13 ... //// ... 8 9 10 [다음] 처럼 페이징 처리 하기 위해
//		// 전체페이지는 전체 게시글수를 한 페이지에 표시되는 게시글 수로 나누면 되는데 만약 나머지가 있다면 전체 페이지 수는 +1이 됨
//		// 산식화하면 전체페이지 수 = 전체 게시글 수 / 한 페이지에 표시할 게시글 수 + (만약 나머지 있으면 +1)
//		int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
//		
//		// 그룹 별 시작페이지와 마지막페이지 필요
//		// currentPage가 1~10 사이면 페이지 리스트는 1~10, startPage(startRow아님)는 1, endPage는 10
//		// 				 11~20 						 11~20,							 11,		  20
//		// 정수형 연산의 특징 이용
//		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1 - (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
//		int endPage = startPage + PAGE_GROUP - 1;
//		
//		// 하지만 저러케하면 마지막에 전체페이지가 10단위가 안돼도 10단위로 endPage가 만들어짐... 조정 필요
//		if(endPage > pageCount) {
//			endPage = pageCount;
//		}
//		
//		// 휴 여기까지 햇따면 이제 데이터들을 Map에 저장하자
//		// 현재페이지(currentPage), 전체페이지 수(pageCount), 페이지 그룹의 시작 페이지(startPage), 페이지 그룹의 마지막 페이지(endPage),
//		// 전체 게시글 수(listCount), 한 페이지에 보여줄 게시글 리스트(boardList)
//		// 저장해서 컨트롤러로 토스!
//		Map<String, Object> modelMap = new HashMap<String, Object>();
//		modelMap.put("currentPage", currentPage);
//		modelMap.put("pageCount", pageCount);
//		modelMap.put("startPage", startPage);
//		modelMap.put("endPage", endPage);
//		modelMap.put("listCount", listCount);
//		modelMap.put("boardList", boardList);
//		modelMap.put("pageGroup", PAGE_GROUP);
//		
//		return modelMap;
//	}
	
	// (수정의 수정)BoardDao를 이용해 게시판 테이블에서 한 페이지에 해당하는 게시글 리스트와,
	// 페이징 처리에 필요한 데이터를 Map 객체로 반환하는 메소드
	public Map<String, Object> boardList(int pageNum, String type, String keyword){
		// 요청 파라미터 pageNum을 현재 페이지로 설정
		int currentPage = pageNum;
		
		// MySQL에서 row의 index는 0부터 시작한다.
		// 1페이지의 startRow는 0, 2페이지의 startRow는 10, 3페이지의 startRow는 20
		// 산식화하면 startRow = (페이지번호 - 1) * 10(PAGE_SIZE)
		int startRow = (currentPage - 1) * PAGE_SIZE;
		
		// BoardDao를 이용해 전체 게시글 수를 가져옴
		int listCount = 0;
		
		// 요청 파라미터에서 type이나 keyword가 비어있으면 일반 게시글 리스트를 요청하는 것으로 간주, false값을 갖도록
		// Controller에 type이나 keyword의 요청파라미터가 없으면 기본값을 "null"로 지정
		boolean searchOption = (type.equals("null") || keyword.equals("null") ? false : true);
		
		// 맵핑 구문 안에서 (where절)동적쿼리를 사용해 type이 없으면 전체게시글 수를,
		// type이 있으면 해당하는 기준으로 검색어가 포함된 게시글 수를 반환
		listCount = boardDao.getBoardCount(type, keyword);
		System.out.println("listCount : " + listCount + ", type : " + type + ", keyword : " + keyword);
		
		// 현재 페이지에 해당하는 게시글 리스트를 BoardDao를 이용해 DB에서 읽어옴
		List<Board> boardList = boardDao.boardList(startRow, PAGE_SIZE, type, keyword);
		
		// 페이지 그룹 이동 처리를 위해 전체 페이지 계산
		// [이전] 11 12 13 ... //// ... 8 9 10 [다음] 처럼 페이징 처리 하기 위해
		// 전체페이지는 전체 게시글수를 한 페이지에 표시되는 게시글 수로 나누면 되는데 만약 나머지가 있다면 전체 페이지 수는 +1이 됨
		// 산식화하면 전체페이지 수 = 전체 게시글 수 / 한 페이지에 표시할 게시글 수 + (만약 나머지 있으면 +1)
		int pageCount = listCount / PAGE_SIZE + (listCount % PAGE_SIZE == 0 ? 0 : 1);
		
		// 그룹 별 시작페이지와 마지막페이지 필요
		// currentPage가 1~10 사이면 페이지 리스트는 1~10, startPage(startRow아님)는 1, endPage는 10
		// 				 11~20 						 11~20,							 11,		  20
		// 정수형 연산의 특징 이용
		int startPage = (currentPage / PAGE_GROUP) * PAGE_GROUP + 1 - (currentPage % PAGE_GROUP == 0 ? PAGE_GROUP : 0);
		int endPage = startPage + PAGE_GROUP - 1;
		
		// 하지만 저러케하면 마지막에 전체페이지가 10단위가 안돼도 10단위로 endPage가 만들어짐... 조정 필요
		if(endPage > pageCount) {
			endPage = pageCount;
		}
		
		// 휴 여기까지 햇따면 이제 데이터들을 Map에 저장하자
		// 현재페이지(currentPage), 전체페이지 수(pageCount), 페이지 그룹의 시작 페이지(startPage), 페이지 그룹의 마지막 페이지(endPage),
		// 전체 게시글 수(listCount), 한 페이지에 보여줄 게시글 리스트(boardList)
		// 저장해서 컨트롤러로 토스!
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("currentPage", currentPage);
		modelMap.put("pageCount", pageCount);
		modelMap.put("startPage", startPage);
		modelMap.put("endPage", endPage);
		modelMap.put("listCount", listCount);
		modelMap.put("boardList", boardList);
		modelMap.put("pageGroup", PAGE_GROUP);
		modelMap.put("searchOption", searchOption);
		
		// 검색 요청이면 추가로 type과 keyword를 modelMap에 저장
		if(searchOption) {
			modelMap.put("type", type);
			modelMap.put("keyword", keyword);
		}
		
		return modelMap;
	}
	
	
//	// BoardDao를 이용해 게시판 테이블에서 no에 해당하는 게시글을 읽어와 반환하는 메소드
//	@Override
//	public Board getBoard(int no) {
//		return boardDao.getBoard(no);
//	}
	
	// (수정)게시판 테이블에서 no에 해당하는 게시글의 조회수를 증가시키고 읽어와 반환하는 메소드
	// isCount == true면 게시글 상세보기, false면 게시글 수정 폼 요청
	public Board getBoard(int no, boolean isCount) {
		// 게시글 상세보기 요청한 게시글 조회수를 증가시킨다
		if(isCount) {
			boardDao.incrementReadCount(no);
		}
		return boardDao.getBoard(no);
	}
	
	
	// BoardDao를 이용해 새로운 게시글을 추가하는 메소드
	@Override
	public void insertBoard(Board board) {
		boardDao.insertBoard(board);
	}
	
	// 게시글 수정, 삭제 시 비밀번호가 맞는지 체크하는 메소드
	// 맞으면 true, 틀리면 false반환
	public boolean isPassCheck(int no, String pass) {
		boolean result = false;
		
		// BoardDao를 이용해 DB에서 no에 해당하는 비밀번호 읽어옴
		String dbPass = boardDao.isPassCheck(no, pass);
		
		if(dbPass.equals(pass)) {
			result = true;
		}
		return result;
	}
	
	// BoardDao를 이용해 게시글을 수정하는 메소드
	public void updateBoard(Board board) {
		boardDao.updateBoard(board);
	}
	
	// BoardDao를 이용해 no에 해당하는 게시글을 삭제하는 메소드
	public void deleteBoard(int no) {
		boardDao.deleteBoard(no);
	}
}
