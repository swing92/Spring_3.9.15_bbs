package com.springclass.bbs.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springclass.bbs.domain.Board;
import com.springclass.bbs.service.BoardService;

@Controller // 스프링 MVC의 컨트롤러임을 선언
// Controller는 요청을 처리한 결과데이터를 Model에 담아 view로 전달
// Spring은 Controller에서 Model에 data를 담는 다양한 방법을 제공하는데 파라미터에 Model을 지정하는 방식이 많이 사용됨
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// @RequestMapping은 클래스, 메소드 레벨에 지정할 수 있음
	// @RequestMapping의 ()에 처리할 요청 URI만 지정할 때는 value속성 생략
	// 다른 속성을 같이 지정할 경우에는 value속성에 처리할 요청 URI를 지정해야함
	// method 속성을 생략하면 GET, POST방식 모두 가능
	// @RequestMapping Annotaion이 적용된 메소드의 파라미터에 Model을 지정하면
	// Spring이 이 메소드를 호출하면서 Model타입의 객체를 넘겨줌
	// 그래서 이 Model을 받아 이 객체에 결과 데이터를 담기만 하면 뷰로 전달됨
	
//	// 게시글 리스트 보기 요청을 처리하는 메소드
//	@RequestMapping(value= {"/boardList", "/list"}, method = RequestMethod.GET)
//	public String boardList(Model model) {
//		
//		// Service 클래스를 이용해 게시글 리스트를 가져옴
//		List<Board> bList = boardService.boardList();
//		
//		// 파라미터로 받은 Model객체에 view로 보낼 모델을 저장
//		// Model에는 도메인 객체(Board)나 비즈니스 로직(Service)을 처리한 결과를 저장
//		model.addAttribute("bList", bList);
//		
//		// 
//		return "boardList";
//	}
	
	// Controller 메소드에 요청 파라미터 이름과 동일한 이름의 메소드 파라미터를 지정하면 스프링으로부터 요청 파라미터를 넘겨받을 수 있음
	// 요청 파라미터와 메소드의 파라미터 이름이 다른 경우에는 매소드의 파라미터 앞에 @RequestParam("요청 파라미터 이름")을 써서 지정하면 됨
	
//	// (수정)게시글 리스트 보기 요청을 처리하는 메소드
//	@RequestMapping(value= {"/boardList", "/list"}, method=RequestMethod.GET)
//	public String BoardList(Model model, @RequestParam(value="pageNum", required=false, defaultValue="1")int pageNum) {
//		// Service 클래스를 이용해 게시글 리스트 가져오기
//		Map<String, Object> modelMap = boardService.boardList(pageNum);
//		
//		// 파라미터로 받은 Model객체에 view로 보낼 모델을 저장
//		model.addAllAttributes(modelMap);
//		
//		// 반환
//		return "boardList";
//	}
	
	// (수정의 수정)게시글 리스트 보기 요청을 처리하는 메소드(순수 게시글 리스트, 검색 리스트)
	@RequestMapping(value= {"/boardList", "/list"})
	public String BoardList(Model model, @RequestParam(value="pageNum", required=false, defaultValue="1")int pageNum,
										 @RequestParam(value="type", required=false, defaultValue="null")String type,
										 @RequestParam(value="keyword", required=false, defaultValue="null")String keyword) {
		// Service 클래스를 이용해 게시글 리스트 가져오기
		// 일반 리스트 요청인지, 검색 요청인지를 체크해서 각가에 맞는 필요데이터를 반환하도록 구현
		Map<String, Object> modelMap = boardService.boardList(pageNum, type, keyword);
		
		// 파라미터로 받은 Model객체에 view로 보낼 모델을 저장
		model.addAllAttributes(modelMap);
		
		// 반환
		return "boardList";
	}
	
	
//	// 게시글 상세보기 요청을 처리하는 메서드
//	@RequestMapping("/boardDetail")	// method 지정 안해서 get, post 둘 다 가능
//	public String boardDetail(Model model, int no) {
//		// Service 클래스를 이용해 no에 해당하는 게시글을 가져옴
//		Board board = boardService.getBoard(no);
//		
//		// 파라미터로 받은 Model객체에 view로 보낼 모델을 저장
//		// Model에는 도메인 객체(Board)나 비즈니스 로직(Service)을 처리한 결과를 저장
//		model.addAttribute("board", board);
//		
//		// servlet-context.xml의 ViewResolver에서 prefix와 suffix에 지정한 정보를 제외한 뷰 이름을 문자열로 반환
//		// 뷰 이름을 반환하면 포워드 되어 제어가 뷰 페이지로 이동
//		return "boardDetail";
//	}
	
	// (수정)게시글 상세보기 요청을 처리하는 메서드
	@RequestMapping("/boardDetail")
	public String boardDetail(Model model, int no, @RequestParam(value="pageNum", required=false, defaultValue="1")int pageNum) {
		// Service 클래스의 getBoard 메소드를 이용해 no에 해당하는 게시글 정보를 읽어오는데,
		// 추가로 두 번째 인수에 true를 지정해서 게시글 읽은 횟수를 1 증가시켜서 읽어왕!
		Board board = boardService.getBoard(no, true);
		
		// 파라미터로 받은 모델 객체에 뷰로 보낼 모델을 저장
		model.addAttribute("board", board);
		model.addAttribute("pageNum", pageNum);
		
		// 반환
		return "boardDetail";
	}
	
	
	// 요청 파라미터를 전달받을 때 사용하는 객체 : 커맨드 객체
	// 커맨드 객체는 자바빈 규약에 따라 프로퍼티에 대한 setter를 제공하도록 작성해야 함
	// 파라미터 이름이 커맨드 객체의 프로퍼티와 동일하도록 폼 컨트롤의 name속성을 지정해야 함
	// RequestMapping Annotation이 적용된 컨트롤러 메소드에 커맨드 객체를 파라미터로 지정하면
	// 커맨드 객체의 프로퍼티와 동일한 이름을 가진 요청 파라미터의 데이터를 스프링이 자동으로 설정해줌
	// 이 때 스프링은 자바빈 규약에 따라 적절한 setter메소드를 사용해 값을 설정함
	// 커맨드 개게의 프로퍼티와 일치하는 파라미터 이름이 없다면 기본 값으로 설정되고 프로퍼티의 데이터형에 맞게 형변환해줌
	// 형변환을 할 수 없는 경우 400 에러 발생
	
	// 게시글쓰기 폼에서 들어오는 게시글쓰기 요청을 처리하는 메소드
	@RequestMapping(value="/writeProcess", method=RequestMethod.POST)
	public String insertBoard(Board board) {
		// BoardService 클래스를 이용해 폼에서 넘어온 게시글 정보를 게시글 테이블에 추가
		boardService.insertBoard(board);
		
		// 클라이언트 요청 처리 후 리다이렉트 해야 할 경우에는 'redirect:' 접두어를 붙여 뷰 이름을 반환하면 됨
		// redirect: 뒤에 경로 지정 시 '/'로 시작하면 ContextRoot를 기준으로 절대경로 방식으로 리다이렉트 됨
		// 							   '/'로 시작하지 않으면 현재 경로를 기준으로 상대경로로 리다이렉트 됨
		// 만약 다른 사이트로 리다이렉트 되길 원한다면 "redirect:http://사이트주소" 를 지정해주면 됨
		return "redirect:boardList";
	}
	
	
	// '/update'로 들어오는 GET방식 요청을 처리하는 메소드
	
	// 게시글 수정 폼을 요청하는 것을 처리하는 메소드
	// 파라미터에 HttpServletResponse, PrintWriter와 요청파라미터를 받을 no, pass 지정
	@RequestMapping(value="/update")
//	public String updateBoard(Model model, HttpServletResponse res, PrintWriter out, int no, String pass) {
	// (수정)요청 파라미터에 pageNum 추가
	public String updateBoard(Model model, HttpServletResponse res, PrintWriter out, int no, String pass, @RequestParam(value="pageNum", required=false, defaultValue="1")int pageNum) {
		// BoardService 클래스를 이용해 게시판 테이블에서 비밀번호가 맞는지 체크
		boolean result = boardService.isPassCheck(no, pass);
		
		// 비번 틀리면
		if(! result) {
			res.setContentType("text/html; charset=utf-8");
			out.println("<script>");
			out.println("alert('비번틀림');");
			out.println("history.back();");
			out.println("</script>");
			
			return null;
			// controller에서 null을 반환하거나 메소드의 반환 타입이 void일 경우
			// Writer나 OutputStream을 이용해 응답 결과를 직접 작성할 수 있음
		}
		
//		// Service 클래스를 이용해 게시글 수정 폼에 출력할 no에 해당하는 게시글 가져오기
//		Board board = boardService.getBoard(no);
		
		// (수정)Service 클래스를 이용해 게시글 수정 폼에 출력할 no에 해당하는 게시글 가져오기
		// + 두 번째 인수를 false로 지정해서 조회수를 증가시키지 않는다!
		Board board = boardService.getBoard(no, false);
		
		// 파라미터로 받은 모델 객체에 뷰로 보낼 모델 저장
		// Model에는 도메인 객체(Board)나 비즈니스 로직(Service)을 처리한 결과를 저장
		model.addAttribute("board", board);
		// (추가)pageNum도 저장해서 보내자 수정하고 나면 이전 페이지로 돌아와야하잖아
		model.addAttribute("pageNum", pageNum);
		
		// servlet-context.xml의 ViewResolver에서 prefix와 suffix에 지정한 정보를 제외한 뷰 이름을 문자열로 반환
		// 뷰 이름을 반환하면 포워드 되어 제어가 뷰 페이지로 이동
		return "updateForm";
	}
	
	// '/update'로 들어오는 POST방식의 요청을 처리하는 메소드
	// 게시글 수정 폼'에서' 들어오는 게시글 수정 요청을 처리하는 메소드
	@RequestMapping(value="/update", method=RequestMethod.POST)
//	public String updateBoard(HttpServletResponse res, PrintWriter out, Board board) { 아래처럼 수정
	public String updateBoard(HttpServletResponse res, PrintWriter out, Board board, RedirectAttributes reAttrs, @RequestParam(value="pageNum", required=false, defaultValue="1")int pageNum) {
		// BoardService 클래스를 이용해 게시판 테이블에서 비밀번호가 맞는지 체크
		boolean result = boardService.isPassCheck(board.getNo(), board.getPass());
		
		// 비번 틀리면
		if(! result) {
			res.setContentType("text/html; charset=utf-8");
			out.println("<script>");
			out.println("alert('비번틀림');");
			out.println("history.back();");
			out.println("</script>");
			
			return null;
		}
		
		// Service 클래스를 이용해 게시판 테이블에서 게시글 수정
		boardService.updateBoard(board);
		
		// (추가)RedirectAttributes객체를 이용하면 한 번만 사용할 임시 데이터와 지속적으로 사용할 파라미터를 구분해서 지정 가능 : 스프링프레임워크가 지원하는 객체
		// addAttribute() 메소드를 사용하면 지속적으로 사용할 파라미터로 지정, 주소 뒤에 파라미터로 추가, 페이지를 새로고침해도 주소 뒤에 파라미터로 남음
		// addFlashAttribute() 메소드를 사용하면 한 번만 사용하는 일회용 파라미터, 주소 뒤에 파라미터로 추가 안됨!
		// 추가로 파라미터에 한글이 포함되는 경우에는 URLEncoding을 코드로 구현해야 하지만,
		// web.xml에서 스프링프레임워크가 지원하는 CharacterEncodingFilter를 설정했기 때문에 Filter에 의해 UTF-8로 인코딩 됨
		reAttrs.addAttribute("pageNum", pageNum);
		
		// 클라이언트 요청 처리 후 boardList로 리다이렉트
		return "redirect:boardList";
	}
	
	
	// '/delete'나 '/deleteBoard'로 들어오는 GET방식 요청을 처리
	// method 속성을 생략 >> GET방식 처리
	@RequestMapping({"/delete","deleteBoard"})
//	public String deleteBoard(HttpServletResponse res, PrintWriter out, int no, String pass) { 아래처럼 수정
	public String deleteBoard(HttpServletResponse res, PrintWriter out, int no, String pass, RedirectAttributes reAttrs, @RequestParam(value="pageNum", required=false, defaultValue="1")int pageNum) {
		// BoardService 클래스를 이용해 게시판 테이블에서 비밀번호가 맞는지 체크
		boolean result = boardService.isPassCheck(no, pass);
		
		// 비번 틀리면
		if(! result) {
			res.setContentType("text/html; charset=utf-8");
			out.println("<script>");
			out.println("alert('비번틀림');");
			out.println("history.back();");
			out.println("</script>");
			
			return null;
		}
		
		// BoardService 클래스를 이용해 게시판 테이블에서 no에 해당하는 게시글을 삭제
		boardService.deleteBoard(no);
		
		reAttrs.addAttribute("pageNum", pageNum);
		
		return "redirect:boardList";
	}
}
