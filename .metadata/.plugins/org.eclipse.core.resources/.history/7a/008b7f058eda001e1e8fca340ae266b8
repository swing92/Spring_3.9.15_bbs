package com.springclass.bbs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springclass.bbs.dao.BoardDao;
import com.springclass.bbs.domain.Board;



// BoardService를 구현(implements BoardService(인터페이스))
@Service	// 해당 클래스가 서비스 계층(비즈니스 로직)의 컴포넌트(Bean)임을 선언
public class BoardServiceImpl implements BoardService {
	
	// 인스턴스 필드에 @Autowired Annotaion을 사용하면 접근지정자가 private이고 setter메소드가 없어도 문제업이 주입됨
	@Autowired
	private BoardDao boardDao;
	
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	// BoardDao를 이용해 게시판 테이블에서 현재 페이지에 해당하는 게시글 리스트를 읽어와 반환하는 메소드
	@Override
	public List<Board> boardList() {
		return boardDao.boardList();
	}
}
