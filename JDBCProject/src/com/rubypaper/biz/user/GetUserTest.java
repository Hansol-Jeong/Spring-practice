package com.rubypaper.biz.user;

public class GetUserTest {
	public static void main(String[] args) {
	//1. 회원가입 기능 테스트
	UserDAO userDAO = new UserDAO();
	UserVO vo = new UserVO();
	vo.setId("guest");
	vo.setPassword("guest123");
	vo.setName("방문자");
	vo.setRole("USER");
	userDAO.insertUsers(vo);
	//2. 회원 상세조회 기능 테스트
	UserVO user = userDAO.getUser(vo);
	if(user != null) {
		System.out.println(user.getName() + "님 환영합니다. 로그인 성공!!");
	} else {
		System.out.println(vo.getId() + "로그인 실패");
	}
	//보드 테이블에 ID 외부 키 등록하고 users랑 board랑 조인해서 누가 어떤 글을 썻는지 조회해 보기
//		// JDBC API 선언
//		Connection conn = null; // 고속도로
////		Statement stmt = null; //자동차
//		PreparedStatement stmt = null; // 자동차는 자동차인데 페라리 자동차, sql처리속도가 5배 이상 빠르다.
//		ResultSet rs = null; // 검색 결과 저장
//
//		try {
//			// 2. Connection 객체를 획득한다.
//			conn = JDBCUtil.getConnection();
//
//			// 3. Statement 객체를 획득한다
//			String sql = "select * from users where id = ? and password = ?";// b a,b와 같은 문자열만 바뀔 뿐 자바코드는 바뀌지 않는다. 자바코드에
//																				// 종속적이지 않다 = dbms
//			stmt = conn.prepareStatement(sql);
//			// ?(파라미터)에 값 설정
//			stmt.setString(1, "admin");
//			stmt.setString(2, "admin");
//			// prepared가 더 빠른이유, sql은 쿼리문을 받으면 문법부터 확인한다(parsing). 두번째로 오브젝트 확인한다(users라는
//			// 테이블이 있나 없나) 이 두가지를 통과해야 셀렉트가 데이터베이스
//			// 메모리에 올라간다. sql이 전송될때마다 그짓을 하면 느리지 그니까 prepared로 하면 앞의 두 과정을 뛰어넘기 때문에 빠를 수 밖에
//			// 없다(무조건 메모리에 올린다.)
//			// 4. SQL 구문을 DB에 전송한다.
//			rs = stmt.executeQuery();
//			// 5. 검색 결과 처리
//			if (rs.next()) {
//				System.out.println("아이디: " + rs.getNString("ID"));
//				System.out.println("비번: " + rs.getNString("PASSWORD"));
//				System.out.println("이름: " + rs.getNString("NAME"));
//				System.out.println("권한: " + rs.getNString("ROLE"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			// 6. Connection 연결 해제
//			JDBCUtil.close(rs, stmt, conn);
//		}
	}

}