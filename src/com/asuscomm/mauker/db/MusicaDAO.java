package com.asuscomm.mauker.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    
    public static int insertMusica(Musica music) throws SQLException{
    	int ret = 0;
    	StringBuilder sb = new StringBuilder();
    	openConnection();
    	c.setAutoCommit(false);
    	
    	stmt = c.createStatement();
    	
    	// TODO trocar por preparedStatement.
    	
    	sb.append("INSERT INTO MUSICAS (idCategoria,dsBanda,dsMusica,vrMusica,dsTempo,isAtivo) VALUES (");
    	sb.append(music.getCategoria());
    	sb.append(",");
    	sb.append("'");
    	sb.append(music.getBanda());
    	sb.append("'");
    	sb.append(",");
    	sb.append("'");
    	sb.append(music.getNome());
    	sb.append("'");
    	sb.append(",");
    	sb.append(music.getValor());
    	sb.append(",");
    	sb.append("'");
    	sb.append(music.getTempo());
    	sb.append("'");
    	sb.append(",");
    	sb.append(1);
    	sb.append(");");
    	
    	sql = sb.toString();
    	
    	System.out.println(sql);
    	
    	
    	stmt.execute(sql);
    	
    	stmt.close();
    	
    	stmt = c.createStatement();
    	
    	ResultSet rs = stmt.executeQuery("SELECT last_insert_rowid()");
    	
    	if (rs.next()){
    		ret = rs.getInt(1);
    		System.out.println("Generated ID: "  + ret);
    	}
    	
    	c.commit();
    	
    	closeConnection();
    	
    	return ret;
    }
    
    public static void updateMusica(){
    	openConnection();
    	
    	closeConnection();
    }
    
    public static void deleteMusica(){
    	openConnection();
    	
    	closeConnection();
    }
    
    public static Musica findMusic(String name) throws SQLException{
    	openConnection();
    	c.setAutoCommit(false);
    	stmt = c.createStatement();
    	
    	Musica music = null;
    	
    	
    	sql = "SELECT * FROM MUSICAS m WHERE m.dsMusica = " + "'" + name + "'";
    	
    	System.out.println(sql);
    	
    	ResultSet rs = stmt.executeQuery(sql);
    	
    	rs.next();
    	
    	int id = rs.getInt("idMusica");
		int categoria = rs.getInt("idCategoria");
		String nome = rs.getString("dsMusica");
		String banda = rs.getString("dsBanda");
		int valor = rs.getInt("vrMusica");
		String tempo = rs.getString("dsTempo");
		boolean active = rs.getBoolean("isAtivo");
    	
		music = new Musica(id, categoria, nome, banda, valor, tempo, active);
		
		rs.close();
		stmt.close();
    	closeConnection();
    	
    	return music;
    }
    
    public static List<Musica> findAll() throws SQLException{
    	openConnection();
    	c.setAutoCommit(false);
    	stmt = c.createStatement();

    	List<Musica> musics  = new ArrayList<Musica>();
    	
    	sql = "SELECT * from MUSICAS;";
    	    	
    	ResultSet rs = stmt.executeQuery(sql);
    	
    	while (rs.next()){
    		Musica mus;
    		int id = rs.getInt("idMusica");
    		int categoria = rs.getInt("idCategoria");
    		String nome = rs.getString("dsMusica");
    		String banda = rs.getString("dsBanda");
    		int valor = rs.getInt("vrMusica");
    		String tempo = rs.getString("dsTempo");
    		boolean active = rs.getBoolean("isAtivo");
    		
    		mus = new Musica(id, categoria, nome, banda, valor, tempo, active);
    		
    		musics.add(mus);
    	}
    	
    	rs.close();
    	stmt.close();
    	closeConnection();
    	
    	return musics;
    }
}
