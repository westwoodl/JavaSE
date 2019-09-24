package com.xu.day28__JDBC;

import org.junit.Test;

import java.sql.*;

public class JDBC {
    @Test
    public void test() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/news?serverTimezone=UTC",
                "root",
                "123456");

        /**
         * 预编译
         */
        String sql = "SELECT * FROM tbl_user where username = ? and password = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, "1\"#");
        stmt.setString(2, "1");
        ResultSet rs = stmt.executeQuery();

//        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            String x = rs.getString("id");
            String s = rs.getString("password");
            String f = rs.getString("username");
            System.out.println(x + s + f);
        }

        rs.close();
        stmt.close();
        con.close();
    }
}
