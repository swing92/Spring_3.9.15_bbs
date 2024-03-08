package com.springclass.bbs.service;

import java.util.Map;

import com.springclass.bbs.domain.Board;

public interface BoardService {
	
//	// BoardDao를 이용해 게시판 테이블에서 현재 페이지에 해당하는 게시글 리스트를 읽어와 반환하는 메소드
//	public abstract List<Board> boardList();
	
//	// (수정)BoardDao를 이용해 게시판 테이블에서 한 페이지에 해당하는 게시글 리스트와, 페이징 처리에 필요한 데이터를 Map 객체로 반환하는 메소드
//	public abstract Map<String, Object> boardList(int pageNum);
	
	// (수정의 수정)BoardDao를 이용해 게시판 테이블에서 한 페이지에 해당하는 게시글 리스트와,
	// 페이징 처리에 필요한 데이터를 Map 객체로 반환하는 메소드
	public abstract Map<String, Object> boardList(int pageNum, String type, String keyword);
	
//	// 게시판 테이블에서 no에 해당하는 게시글을 읽어와 반환하는 메소드
//	public abstract Board getBoard(int no);
	
	// (수정)게시판 테이블에서 no에 해당하는 게시글의 조회수를 증가시키고 읽어와 반환하는 메소드
	// isCount == true면 게시글 상세보기, false면 게시글 수정 폼 요청
	public abstract Board getBoard(int no, boolean isCount);
	
	// 새로운 게시글을 추가하는 메소드
	public abstract void insertBoard(Board board);
	
	// 게시글 수정/삭제 시 비번 체크 메소드
	// 맞으면 true, 틀리면 false 반환
	public boolean isPassCheck(int no, String pass);
	
	// 게시글 수정하는 메소드
	public abstract void updateBoard(Board board);
	
	// no에 해당하는 게시글 삭제 메소드
	public abstract void deleteBoard(int no);
}
