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
    private static String sql = null;
    
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
    
    private static void closeConnection(){
    	try {
    		if (c != null){
				c.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public static void insertMusica(Musica music) throws SQLException{
    	StringBuilder sb = new StringBuilder();
    	
    	openConnection();
    	
    	stmt = c.createStatement();
    	
    	sb.append("INSERT INTO MUSICAS (idCategoria,dsBanda,dsMusica,vrMusica,dsTempo,isAtivo) VALUES (");
    	sb.append(music.getCategoria());
    	sb.append(",");
    	sb.append(music.getBanda());
    	sb.append(",");
    	sb.append(music.getNome());
    	sb.append(",");
    	sb.append(music.getValor());
    	sb.append(",");
    	sb.append(music.getTempo());
    	sb.append(",");
    	sb.append(music.isActive());
    	sb.append(");");
    	
    	sql = sb.toString();
    	
    	stmt.execute(sql);
    	
    	stmt.close();
    	
    	c.commit();
    	
    	closeConnection();
    }
    
    public static void updateMusica(){
    	openConnection();
    	
    	closeConnection();
    }
    
    public static void deleteMusica(){
    	openConnection();
    	
    	closeConnection();
    }
    
    public static Musica findMusic(String name){
    	openConnection();
    	
    	Musica music = null;
    	
    	// TODO
    	
    	closeConnection();
    	
    	return music;
    }
    
    public static List<Musica> findAll() throws SQLException{
    	openConnection();

    	List<Musica> musics  = null;
    	
    	sql = "SELECT * from MUSICAS;";
    	    	
    	
    	// TODO
    	
    	return musics;
    }
}
