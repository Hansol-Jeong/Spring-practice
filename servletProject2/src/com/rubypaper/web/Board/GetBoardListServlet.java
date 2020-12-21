package com.rubypaper.web.Board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rubypaper.biz.board.BoardDAO;
import com.rubypaper.biz.board.BoardVO;
import com.rubypaper.biz.user.UserVO;


public class GetBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 세션 체크
		HttpSession session =request.getSession();//request는 어디까지 정보를담고있는가?
		UserVO user = (UserVO)session.getAttribute("user");
		if(user == null) {
			response.sendRedirect("login.html");
		} else {
		//글 목록 화면을 요청한 브라우저와 매핑된 세션 객체를 얻어낸다.
//		HttpSession session = request.getSession();//request: 요청 프로토콜과 연결된 객체
//		if(session.isNew()) {
//			System.out.println("===> GetBoardListServlet 에서 처음 생성한 세션이다.");
//		} else {
//			System.out.println("---> 이전에 생성된 세션 재사용하는 것이다.");
//		}
		//1. 사용자 입력정보 추출(검색 기능은 숙제...)
//		request.setCharacterEncoding("EUC-KR");
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		
		//null 체크를 해줘야해
		if(searchCondition == null) {
			searchCondition = "TITLE";
		}
		if(searchKeyword == null)
			searchKeyword = "";
		
		//2. DB연동 처리
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);
		
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		//3. 응답 화면 구성
		response.setContentType("text/html; charset=EUC-KR");
		PrintWriter out = response.getWriter();//출력 스트림
//		out.println("<h1>게시판 목록</h1>");
//		for (BoardVO board : boardList) {
//			out.println("--->" + board.toString() + "<br>");
//		} 아래와 같이 업그레이드 시킨다
		out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD HTML 4.01 Transitional//EN' 'http://www.w3.org/TR/html4/loose.dtd'>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='Content-Type' content='text/html; charset=EUC-KR'>");
		out.println("<title>글 목록</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>게시글 목록</h1>");
		out.println("<h3>"+user.getName()+("userName")+"님 로그인 환영합니다......");
		out.println("<a href='logout.do'>Log-out</a></h3>");

		out.println("<!-- 검색 시작 -->");
		out.println("<form action='getBoardList.do' method='post'>");//자기 자신을 한번더 호출
		out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
		out.println("<tr>");
		out.println("<td align='right'>");
		out.println("<select name='searchCondition'>");
		out.println("<option value='TITLE'>제목");
		out.println("<option value='CONTENT'>내용");
		out.println("</select>");
		out.println("<input name='searchKeyword' type='text'/>");
		out.println("<input type='submit' value='검색'/>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("<!-- 검색 종료 -->");

		out.println("<table border='1' cellpadding='0' cellspacing='0' width='700'>");
		out.println("<tr>");
		out.println("<th bgcolor='orange' width='100'>번호</th>");
		out.println("<th bgcolor='orange' width='200'>제목</th>");
		out.println("<th bgcolor='orange' width='150'>작성자</th>");
		out.println("<th bgcolor='orange' width='150'>등록일</th>");
		out.println("<th bgcolor='orange' width='100'>조회수</th>");
		out.println("</tr>");
for(BoardVO board : boardList) {
		out.println("<tr>");
		out.println("<td>"+board.getSeq()+"</td>");
		out.println("<td align='left'><a href='getBoard.do?seq="+board.getSeq()+"'>"+board.getTitle()+"</a></td>");
		out.println("<td>"+board.getWriter()+"</td>");
		out.println("<td>"+board.getRegDate()+"</td>");
		out.println("<td>"+board.getCnt()+"</td>");
		out.println("</tr>");
}
		out.println("</table>");
		out.println("<br>");
		out.println("<a href='insertBoard.html'>새글 등록</a>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}
	}
}
