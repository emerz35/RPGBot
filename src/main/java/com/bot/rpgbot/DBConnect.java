package com.bot.rpgbot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Charlie
 */
public class DBConnect {
    private String url = System.getenv("JDBC_DATABASE_URL"), user = System.getenv("DBUsername"), pass = System.getenv("DBPass");
    private final Connection conn;

    public DBConnect() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        this.conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DROP TABLE IF EXISTS testTable");
        stmt.execute("CREATE TABLE testTable("
                + "Number int"
                + ");");
        stmt.execute("INSERT INTO testTable VALUES (2);");
    }
    public int databaseTest() throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery("SELECT Number FROM testTable;");
        results.first();
        return results.getInt(1);
    }
}