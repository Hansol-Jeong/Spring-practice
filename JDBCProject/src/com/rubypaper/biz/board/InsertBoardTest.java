package com.rubypaper.biz.board;

public class InsertBoardTest {
    public static void main(String[] args) {
    	// 1. 글 등록 기능 처리
    	BoardDAO boardDAO = new BoardDAO();
    	BoardVO vo = new BoardVO();
    	vo.setTitle("VO 테스트");
    	vo.setWriter("테스터");
    	vo.setContent("VO 내용....");
    	boardDAO.insertBoard(vo);
    	//2. insert 끝나고 글 목록을 보고 싶어
    	boardDAO.getBoardList();
		/*
		 * Connection conn = null; PreparedStatement stmt = null;
		 * 
		 * try {
		 * 
		 * //2. 커넥션을 획득한다. conn = JDBCUtil.getConnection(); //3. SQL�쟾�떖
		 * 媛앹껜(Statement)瑜� �깮�꽦�븳�떎. String sql =
		 * "insert into board(seq, title, writer, content)" +
		 * "values((select nvl(max(seq), 0) + " + "1 from board),?, ?, ?)"; stmt =
		 * conn.prepareStatement(sql); //파라미터 셋팅 stmt.setString(1,"JDBC 제목");
		 * stmt.setString(2,"테스터"); stmt.setString(3,"JDBC 내용.....");
		 * 
		 * //4. SQL�쓣 �쟾�넚�븳�떎.
		 * 
		 * //seq而щ읆�쓽 理쒕뙎媛믪쓣 援ы뻽�뒗�뜲 洹멸쾶 null�씠 �굹�삤硫� 0 �쑝濡� 諛붽퓭 (nullvalue=nvl) int
		 * cnt = stmt.executeUpdate();//�옄�룞李⑥뿉 sql�쓣 �깭�썙�꽌 遺��궛�쑝濡� 蹂대궡�씪
		 * System.out.println(cnt + "건의 데이터 처리 성공!!"); } catch (Exception e) {
		 * e.printStackTrace(); } finally { JDBCUtil.close(stmt, conn); }
		 */
    }
}
