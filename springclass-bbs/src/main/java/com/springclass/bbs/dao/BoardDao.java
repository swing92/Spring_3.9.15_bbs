package com.springclass.bbs.dao;

import java.util.List;

import com.springclass.bbs.domain.Board;

public interface BoardDao {
	
//	// 한 페이지에 보여질 게시글 리스트 요청 시 호출되는 메소드
//	// 현재 페이지에 해당하는 글 리스트를 DB에서 읽어와 반환
//	public abstract List<Board> boardList();
	
//	// 한 페이지에 보여질 게시글 리스트 요청 시 호출되는 메소드(수정)
//	// 현재 페이지에 해당하는 게시글 리스트를 DB에서 읽어와 반환
//	public abstract List<Board> boardList(int startRow, int num);
	
	// 한 페이지에 보여질 게시글 리스트 요청 시 호출되는 메소드(수정의 수정)
	// 현재 페이지에 해당하는 게시글 리스트를 DB에서 읽어와 반환
	public abstract List<Board> boardList(int startRow, int num, String type, String keyword);
	
//	// 전체 게시글 수를 계산하기 위해 호출되는 메소드(추가) >>> paging처리에 사용!
//	// DB테이블에 등록된 모든 게시글의 수를 반환
//	public abstract int getBoardCount();
	
	// 전체 게시글 수를 계산하기 위해 호출되는 메소드(추가) >>> paging처리에 사용!(수정)
	// DB테이블에 등록된 모든 게시글의 수를 반환
	public abstract int getBoardCount(String type, String keyword);
	
	// 게시글 상세보기 요청 시 호출되는 메소드
	// no에 해당하는 게시글을 DB에서 읽어와 Board객체로 반환
	public abstract Board getBoard(int no);
	
	// 게시글 쓰기 요청 시 호출되는 메소드
	// 게시글 쓰기 요청 시 게시글 내용을 Board객체로 받아 DB에 추가
	public abstract void insertBoard(Board board);
	
	// 게시글 수정과 삭제 시 비밀번호 체크에서 호출되는 메소드
	// 게시글 수정, 삭제 시 no에 해당하는 pass를 DB에서 읽어와 반환
	public String isPassCheck(int no, String pass);
	
	// 게시글 수정 요청 시 호출되는 메소드
	// 수정된 내용을 Board객체로 받아 DB에 수정
	public abstract void updateBoard(Board board);
	
	// 게시글 삭제 요청 시 호출되는 메소드
	// no에 해당하는 게시글을 DB에서 삭제
	public abstract void deleteBoard(int no);
	
	// 게시글 조회한 횟수 증가시키는 메소드
	public abstract void incrementReadCount(int no);
}
