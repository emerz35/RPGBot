package com.bot.rpgbot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charlie
 */
public class DBConnect {
    private final String url = System.getenv("JDBC_DATABASE_URL");
    private final Connection conn;
    private static DBConnect instance;

    private DBConnect() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        this.conn = DriverManager.getConnection(url);
    }
    public int databaseTest() throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery("SELECT Number FROM testTable;");
        results.first();
        return results.getInt(1);
    }
    public static DBConnect getInstance(){
        if(instance == null) try {
            instance = new DBConnect();
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instance;
    }
}