package com.asuscomm.mauker.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	private static Connection c = null;
    private static Statement stmt = null;
    
    public static void openOrCreateDB(){
        try {
        	Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:jukebox.db");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    public static void createTables(){
    	
    }
    
    public static void closeConnection(){
		try {
			if (c != null){
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}
