package com.rubypaper.biz.board;

import java.sql.*;

public class GetBoardListTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;//결과 집합

        try {
            DriverManager.registerDriver(new org.h2.Driver());
            String url = "jdbc:h2:tcp://localhost/~/test";
            conn = DriverManager.getConnection(url, "sa", "");
            stmt = conn.createStatement();
            String sql = "Select * from board order by seq desc";
            rs = stmt.executeQuery(sql);
            System.out.println("[ BOARD LIST ]");
            while(rs.next()) {
                System.out.print(rs.getInt("SEQ") + " : ");
                System.out.print(rs.getString("TITLE") + " : ");
                System.out.print(rs.getString("WRITER") + " : ");
                System.out.print(rs.getString("CONTENT") + " : ");
                System.out.print(rs.getDate("REGDATE") + " : ");
                System.out.print(rs.getInt("CNT") + " : ");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                rs = null;
            }
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
