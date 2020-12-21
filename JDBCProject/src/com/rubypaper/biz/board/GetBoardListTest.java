package com.rubypaper.biz.board;

import java.util.List;

public class GetBoardListTest {
    public static void main(String[] args) {
    	BoardDAO boardDAO = new BoardDAO();
    	//getBoardList() 메소드가 리턴한 글 목록을 원하는 형태로 사용한다.
    	//select 는 절대로 지가 타입을 결정해선 안된다.
    	List<BoardVO> boardList = boardDAO.getBoardList();
    	
//    	//1.case
//    	System.out.println("[ BOARD LIST ]");
//    	for (BoardVO board : boardList) {
//			System.out.println("--->" + board.toString());
//		}
    	//2.case
    	System.out.println("검색된 게시글 수: " + boardList.size());
    	//클라이언트: 어떤 객체가 가지고있는 메소드를 호출하는 프로그램(상대적인 개념)
    	
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;//결과 집합
//
//        try {
//            //1. 드라이버 객체를 메모리에 로딩한다.
//            DriverManager.registerDriver(new org.h2.Driver());
//            //2. 커넥션을 획득한다.
//            String url = "jdbc:h2:tcp://localhost/~/test";
//            conn = DriverManager.getConnection(url, "sa", "");//connection은 고속도로
//            //3. SQL전달 객체(Statement)를 생성한다.
//            stmt = conn.createStatement();//statement는 자동차
//            //등록이든 삭제든 이 위까지는 똑같다.
//            //4. SQL을 전송한다.
//            String sql = "Select * from board order by seq desc";
////            int cnt = stmt.executeUpdate(sql);//자동차에 sql을 태워서 부산으로 보내라, 몇건의 데이터가 처리됬는지 정수로 반환, 이건 등록 수정 삭제를 위한 execute
//            rs = stmt.executeQuery(sql);//select 전용메소드(executeQuery)
//            //5. 검색결과 처리(SELECT 구문에 한하여,,,)
//            System.out.println("[ BOARD LIST ]");
//            while(rs.next()) {//굉장히 중요하다. 커서를 밑으로 한칸 내린다(next())* Before First, After Last
//                System.out.print(rs.getInt("SEQ") + " : "); //rs.getInt(1) + " : "이렇게 위치로 뿌려도 실행 된다.
//                System.out.print(rs.getString("TITLE") + " : ");
//                System.out.print(rs.getString("WRITER") + " : ");
//                System.out.print(rs.getString("CONTENT") + " : ");
//                System.out.print(rs.getDate("REGDATE") + " : ");
//                System.out.print(rs.getInt("CNT") + " : ");
//                System.out.println();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                //close 순서 ResultSet -> Statement -> Connection
////                rs.close();//여기서 exeption이 일어나면 아래는 실행조차 안된다.
////                stmt.close();
////                conn.close(); 그래서 아래처럼 한다
//                if(rs != null)
//                    rs.close();
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                rs = null;
//            }
//            try {
//                if(stmt != null)
//                    stmt.close();
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                stmt = null;
//            }
//            try {
//                if(!conn.isClosed() && conn != null )//커넥션이 닫힌 상태가 아니라면
//                    conn.close();
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                conn = null;
//            }
//        }
    }
}
