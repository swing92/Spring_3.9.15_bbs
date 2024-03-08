package com.springclass.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springclass.bbs.domain.Board;

// BoardDao를 구현(implements BoardDao(인터페이스))
// 게시글 리스트를 MyBatis의 SessionTemplate을 이용해 DB로부터 읽어와 반환

@Repository	//이 class가 데이터 액세스(데이터 저장소) 계층의 컴포넌트(Bean)임을 선언
public class BoardDaoImpl implements BoardDao{
	
	// BoardMapper.xml에 정의한 Mapper namespace를 상수로 정의
	private final String NAME_SPACE = "com.springclass.bbs.mapper.BoardMapper";
	
	// MyBatis-spring은 MyBatis의 SqlSession 기능과 스프링 DB 지원 기능을 연동해주는 SqlSessionTemplate클래스 제공
	// SqlSessionTemplaet은 SqlSession 을 구현해 스프링 연동부부을 구현
	private SqlSessionTemplate sqlSession;
	
	
	// 컴파일러에 의해 기본 생성자 만들어짐
	@Autowired	//필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다.(생성자, setter, 필드)
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
//	// 한 페이지에 보여질 게시글 리스트 요청 시 호출되는 메소드
//	// 현재 페이지에 해당하는 게시글 리스트를 DB에서 읽어와 반환
//	@Override
//	public List<Board> boardList() {
//		return sqlSession.selectList(NAME_SPACE + ".boardList");
//	}
	
//	// 한 페이지에 보여질 게시글 리스트 요청 시 호출되는 메소드(수정)
//	public List<Board> boardList(int startRow, int num) {
//		// SQL 파라미터가 여러개일 경우 Map을 이용하여 지정
//		Map<String, Integer> params = new HashMap<String, Integer>();
//		params.put("startRow", startRow);
//		params.put("num", num);
//		
//		// BoardMapper.xml에서 맵핑 구문을 작성하고 sqlSession 객체의 메소드를 호출하면서 맵핑 설정을 지정하게되면
//		// 해당 메소드 안에서 PreparedStatement 객체를 생성하고 PreparedStatement 객체에 필요한 파라미터가 설정됨
//		
//		// SqlSessionTemplate 객체의 select(), selectOne(), selectList() 메소드를 호출하면
//		// PreparedStatement 객체의 executeQuery() 메소드를 실행하고,
//		// 쿼리를 발행한 결과인 ResultSet 객체에서 데이터를 읽어와 모델 클래스인 Board객체를 생성해 이 객체에 값을 설정하게 됨
//		
//		// 고로, 얘처럼 SqlSessionTemplate의 메소드가 호출되면
//		// repository/mappers/BoardMapper.xml 파일에서 mapper태그의 namespace 속성에 지정한 com.springclass.bbs.mapper.BoardMapper인 맵퍼가 선택,
//		// 그 하부에 <select> 태그의 id속성에 지정한 boardList인 맵핑 구문이 선택됨
//		// >>>>>>> MyBatis 내부에서 JDBC 코드로 변환되어 실행됨
//		
//		// 매핑 구문의 resultType 속성에 Board를 지정했기 때문에 페이지에 해당하는 게시글 리스트가 담긴 List<Board> 객체가 반환
//		// Board 테이블에 게시글 정보가 하나도 없으면 null 반환
//		
//		// SQL 파라미터를 지정해야한다면 두 번째 인수에 필요한 파라미터를 지정하면 됨
//		// 파라미터가 여러개일 경우 Map 객체에 담아 두 번째 인수로 지정하면 됨
//		
//		return sqlSession.selectList(NAME_SPACE + ".boardList", params);
//	}
	
	// 한 페이지에 보여질 게시글 리스트 요청 시 호출되는 메소드(수정의 수정)
	public List<Board> boardList(int startRow, int num, String type, String keyword) {
		// SQL 파라미터가 여러개일 경우 Map을 이용하여 지정
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("startRow", startRow);
		params.put("num", num);
		params.put("type", type);
		params.put("keyword", keyword);
		
		// BoardMapper.xml에서 맵핑 구문을 작성하고 sqlSession 객체의 메소드를 호출하면서 맵핑 설정을 지정하게되면
		// 해당 메소드 안에서 PreparedStatement 객체를 생성하고 PreparedStatement 객체에 필요한 파라미터가 설정됨
		
		// SqlSessionTemplate 객체의 select(), selectOne(), selectList() 메소드를 호출하면
		// PreparedStatement 객체의 executeQuery() 메소드를 실행하고,
		// 쿼리를 발행한 결과인 ResultSet 객체에서 데이터를 읽어와 모델 클래스인 Board객체를 생성해 이 객체에 값을 설정하게 됨
		
		// 고로, 얘처럼 SqlSessionTemplate의 메소드가 호출되면
		// repository/mappers/BoardMapper.xml 파일에서 mapper태그의 namespace 속성에 지정한 com.springclass.bbs.mapper.BoardMapper인 맵퍼가 선택,
		// 그 하부에 <select> 태그의 id속성에 지정한 boardList인 맵핑 구문이 선택됨
		// >>>>>>> MyBatis 내부에서 JDBC 코드로 변환되어 실행됨
		
		// 매핑 구문의 resultType 속성에 Board를 지정했기 때문에 페이지에 해당하는 게시글 리스트가 담긴 List<Board> 객체가 반환
		// Board 테이블에 게시글 정보가 하나도 없으면 null 반환
		
		// SQL 파라미터를 지정해야한다면 두 번째 인수에 필요한 파라미터를 지정하면 됨
		// 파라미터가 여러개일 경우 Map 객체에 담아 두 번째 인수로 지정하면 됨
		
		return sqlSession.selectList(NAME_SPACE + ".boardList", params);
	}
	
	
//	// 전체 게시글 수를 계산하기 위해 호출되는 메소드(추가) - paging
//	public int getBoardCount() {
//		return sqlSession.selectOne(NAME_SPACE + ".getBoardCount");
//	}
	
	// 전체 게시글 수를 계산하기 위해 호출되는 메소드(추가) - paging(수정)
	public int getBoardCount(String type, String keyword) {
		// SQL 파라미터가 여러개 : Map을 이용해 지정
		Map<String, String> params = new HashMap<String, String>();
		params.put("type", type);
		params.put("keyword", keyword);
		
		return sqlSession.selectOne(NAME_SPACE + ".getBoardCount", params);
	}
	
	
	// 게시글 상세보기 요청 시 호출되는 메소드
	// no에 해당하는 게시글을 DB에서 읽어와 Board 객체로 반환
	@Override
	public Board getBoard(int no) {
		// getBoard 맵핑 구문 호출, 게시글 번호인 no를 파라미터로 지정
		return sqlSession.selectOne(NAME_SPACE + ".getBoard", no);
	}
	
	// 게시글 쓰기 요청 시 호출되는 메소드
	// 게시글 내용을 Board 객체로 받아 DB에 추가하는 메소드
	@Override
	public void insertBoard(Board board) {
		sqlSession.insert(NAME_SPACE + ".insertBoard", board);
	}
	
	// 게시글 수정, 삭제 시 비밀번호 체크에서 호출되는 메소드
	// no에 해당하는 pass를 DB에서 읽어와 반환
	public String isPassCheck(int no, String pass) {
		// isPassCheck 맵핑 구문을 호출하면서 게시글번호인 no를 파라미터로 지정함
		return sqlSession.selectOne(NAME_SPACE + ".isPassCheck", no);
	}
	
	// 게시글 수정 요청 시 호출되는 메소드
	// 수정된 내용을 Board 객체로 받아 DB에 수정하는 메소드
	public void updateBoard(Board board) {
		// updateBoard 맵핑 구문을 호출, Board 객체를 파라미터로 지정
		sqlSession.update(NAME_SPACE + ".updateBoard", board);
	}
	
	// 게시글 삭제 요청 시 호출되는 메소드
	// no에 해당하는 게시글을 DB에서 삭제
	public void deleteBoard(int no) {
		// deleteBoard 맵핑 구문을 호출, no를 파라미터로 지정
		sqlSession.delete(NAME_SPACE + ".deleteBoard", no);
	}
	
	// 게시글 조회수 증가시키는 메소드
	// 게시글 상세보기 요청 시 조회수를 DB에서 증가시켜주는 메소드
	public void incrementReadCount(int no) {
		// incrementReadCount 맵핑 구문을 호출, no를 파라미터로 지정
		sqlSession.update(NAME_SPACE + ".incrementReadCount", no);
	}
	
}
