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
	
	// BoardDao를 이용해 게시판 테이블에서 no에 해당하는 게시글을 읽어와 반환하는 메소드
	@Override
	public Board getBoard(int no) {
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
