package com.rubypaper.biz.board;

public class UpdateBoardTest {
    public static void main(String[] args) {
    	// 1. 글 수정 기능 처리
    	BoardDAO boardDAO = new BoardDAO();
    	BoardVO vo = new BoardVO();
    	vo.setContent("수정내용");
    	vo.setTitle("수정 내용");
    	vo.setSeq(4);
    	boardDAO.updateBoard(vo);
//    	//2. 글 목록 검색 기능 처리
//    	boardDAO.getBoardList();
    	//2. 글 상세 조회 기능 처리
    	boardDAO.getBoard(vo);//먼가 잘못됫다
//        Connection conn = null;
//        Statement stmt = null;
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
//            String sql = "update board set title = '제목수정', content = '내용 수정' where seq = 1";
//            int cnt = stmt.executeUpdate(sql);//자동차에 sql을 태워서 부산으로 보내라, 몇건의 데이터가 처리됬는지 정수로 반환
//            System.out.println(cnt + "건의 데이터 처리 성공!!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
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
