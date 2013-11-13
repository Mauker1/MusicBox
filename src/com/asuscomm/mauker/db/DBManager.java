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
    	try {
			stmt = c.createStatement();

			String sql = "CREATE TABLE IF NOT EXISTS `Musicas` (" +
					"`idMusica` INTEGER PRIMARY KEY AUTOINCREMENT ," +
					"`idCategoria` INT NOT NULL ," +
					"`dsBanda` VARCHAR(45) NULL DEFAULT NULL ," +
					"`dsMusica` VARCHAR(45) NULL DEFAULT NULL ," +
					"`vrMusica` INTEGER NULL DEFAULT NULL ," +
					"`dsTempo` VARCHAR(45) NULL DEFAULT NULL ," +
					"`isAtivo` BOOLEAN NULL DEFAULT NULL)";
	      stmt.executeUpdate(sql);
	      
	      sql =  "CREATE TABLE IF NOT EXISTS `Musicas_Categorias` (" +
	    		     "`idMusicaCategoria` INTEGER PRIMARY KEY AUTOINCREMENT ," +
	    		     "`dsCategoria` VARCHAR(45) NULL DEFAULT NULL ," +
	    		     "`isAtivo` BOOLEAN NULL DEFAULT NULL)";
	      
	      stmt.execute(sql);
	      
	      sql = "CREATE TABLE IF NOT EXISTS `Musicas_Historico` (" +
	    		     "`idMusicaMoeda` INTEGER PRIMARY KEY AUTOINCREMENT ," +
	    		     "`idMusica` INTEGER NULL DEFAULT NULL," +
	    		     "`idMoeda` INTEGER NULL DEFAULT NULL," +
	    		     "`qtdTroco` FLOAT(8,2) NULL DEFAULT NULL ," +
	    		     "`dtMusica` TIMESTAMP NULL DEFAULT NULL ," +
	    		     "`isAtivo` BOOLEAN NULL DEFAULT NULL)";
	      
	      stmt.execute(sql);
	      
	      sql =  "CREATE TABLE IF NOT EXISTS `Moedas` (" +
	    		   "`idMoeda` INTEGER PRIMARY KEY AUTOINCREMENT ," +
	    		   "`tpMoeda` VARCHAR(45) NULL DEFAULT NULL ," +
	    		   "`vrMoeda` FLOAT(8,2) NULL DEFAULT NULL ," +
	    		   "`isAtivo` BOOLEAN NULL DEFAULT NULL)";
	      
	      stmt.execute(sql);
	      
	      stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	      
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
