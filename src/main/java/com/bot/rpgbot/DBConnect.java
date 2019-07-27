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
    private String url = System.getenv("CLEARDB_DATABASE_URL"), user = System.getenv("DBUsername"), pass = System.getenv("DBPass");
    private final Connection conn;

    public DBConnect() throws SQLException{
        this.conn = DriverManager.getConnection(url, user, pass);
        Statement stmt = conn.createStatement();
        stmt.executeQuery("CREATE DATABASE test;");
        stmt.executeQuery("CREATE TABLE testTable("
                + "Number int"
                + ");");
        stmt.executeQuery("INSERT INTO testTable VALUES (2);");
    }
    public int databaseTest() throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery("SELECT Number FROM testTable;");
        return results.getInt(1);
    }
}