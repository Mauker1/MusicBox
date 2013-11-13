package com.asuscomm.mauker.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.asuscomm.mauker.data.Musica;

public class MusicaDAO {
	private static Connection c = null;
    private static Statement stmt = null;
    
    private static void openConnection(){
    	try {
        	Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:jukebox.db");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    public static void insertMusica(){
    	openConnection();
    }
    
    public static void updateMusica(){
    	openConnection();
    }
    
    public static void deleteMusica(){
    	openConnection();
    }
    
    public static Musica findMusic(String name){
    	openConnection();
    	
    	Musica music = null;
    	
    	// TODO
    	
    	return music;
    }
    
    public static List<Musica> findAll(){
    	openConnection();
    	
    	List<Musica> musics  = null;
    	
    	// TODO
    	
    	return musics;
    }
}
