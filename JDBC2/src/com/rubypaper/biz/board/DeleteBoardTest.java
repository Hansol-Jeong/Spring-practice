package com.rubypaper.biz.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteBoardTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            DriverManager.registerDriver(new org.h2.Driver());
            String url = "jdbc:h2:tcp://localhost/~/test";
            conn = DriverManager.getConnection(url,"sa","");
            stmt = conn.createStatement();
            String sql = "delete board";
            int cnt = stmt.executeUpdate(sql);
            System.out.println(cnt + "건의 데이터 처리 성공!!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                stmt = null;
            }
            try {
                if(!conn.isClosed() && conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                conn = null;
            }
        }
    }
}
