package com.asuscomm.mauker.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.asuscomm.mauker.data.Musica;

public class MusicaDAO {
	private Connection c = null;
    private Statement stmt = null;
    
    private void openConnection(){
    	try {
        	Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:jukebox.db");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    public void insertMusica(){
    	openConnection();
    }
    
    public void updateMusica(){
    	openConnection();
    }
    
    public void deleteMusica(){
    	openConnection();
    }
    
    public Musica findMusic(String name){
    	openConnection();
    	
    	Musica music = null;
    	
    	// TODO
    	
    	return music;
    }
    
    public List<Musica> findAll(){
    	openConnection();
    	
    	List<Musica> musics  = null;
    	
    	// TODO
    	
    	return musics;
    }
}
