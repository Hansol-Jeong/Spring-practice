package com.rubypaper.biz.board;

public class GetBoardTest {
    public static void main(String[] args) {
    	BoardDAO boardDAO = new BoardDAO();
    	BoardVO vo = new BoardVO();
    	//2. 글 목록 검색 기능 처리
    	vo.setSeq(4);
    	BoardVO board = boardDAO.getBoard(vo);
    	System.out.println(board.getSeq() + "번 게시 글의 상세 정보");
    	System.out.println("제목 : " + board.getTitle());
    	System.out.println("작성자 : " + board.getWriter());
    	System.out.println("내용 : " + board.getContent());
    	System.out.println("등록일 : " + board.getRegDate());
    	System.out.println("조회수 : " + board.getCnt());
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
//            String sql = "Select * from board where seq =1";
////            int cnt = stmt.executeUpdate(sql);//자동차에 sql을 태워서 부산으로 보내라, 몇건의 데이터가 처리됬는지 정수로 반환, 이건 등록 수정 삭제를 위한 execute
//            rs = stmt.executeQuery(sql);//select 전용메소드(executeQuery)
//            //5. 검색결과 처리(SELECT 구문에 한하여,,,)
//            if(rs.next()) {
//                System.out.println("게시 글 상세 정보");
//                System.out.println("번호 : " + rs.getInt("SEQ")); //rs.getInt(1) + " : "이렇게 위치로 뿌려도 실행 된다.
//                System.out.println("제목 : " + rs.getString("TITLE"));
//                System.out.println("작성자 : " + rs.getString("WRITER"));
//                System.out.println("내용 : " + rs.getString("CONTENT"));
//                System.out.println("등록일 : " + rs.getDate("REGDATE"));
//                System.out.println("조회수 : " + rs.getInt("CNT"));
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
//지금까지 crud 했음 create read update delete