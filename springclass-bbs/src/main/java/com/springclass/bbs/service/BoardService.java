package com.springclass.bbs.service;

import java.util.List;

import com.springclass.bbs.domain.Board;

public interface BoardService {
	
	// BoardDao를 이용해 게시판 테이블에서 현재 페이지에 해당하는 게시글 리스트를 읽어와 반환하는 메소드
	public abstract List<Board> boardList();
	
	// 게시판 테이블에서 no에 해당하는 게시글을 읽어와 반환하는 메소드
	public abstract Board getBoard(int no);
	
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
