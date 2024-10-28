package org.webterminal.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JDBCTest {

    @Test
    public void testMySQLConnection() {
        String url = "jdbc:mysql://localhost:3306/webTerminal_user";
        String user = "user";
        String password = "userooopklj";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT 1")) {

            assertTrue(resultSet.next(), "MySQL 연결 실패: 결과가 없습니다.");
            System.out.println("MySQL 연결 성공: " + resultSet.getInt(1));
        } catch (SQLException e) {
            System.err.println("MySQL 연결 실패: " + e.getMessage());
        }
    }

    @Test
    public void testWebTerminal_testConnection() {
        String url = "jdbc:mysql://localhost:3306/webTerminal_test";
        String user = "user";
        String password = "userooopklj";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT 1")) {

            assertTrue(resultSet.next(), "MySQL 연결 실패: 결과가 없습니다.");
            System.out.println("MySQL 연결 성공: " + resultSet.getInt(1));
        } catch (SQLException e) {
            System.out.println("MySQL 연결 실패: " + e.getMessage());
        }
    }
}
