package com.asuscomm.mauker.db;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.Test;

import com.asuscomm.mauker.data.Musica;

public class MusicaDAOUTest {

	@Test
	public void test() {
		Musica mus;
		Musica retMus;
		
		mus = new Musica(0, Musica.CATEGORIA_ROCK, "We will rock you", "Queen", 100, "3 min", true);
		
		try {
			mus.setID(MusicaDAO.insertMusica(mus));
			
			retMus = MusicaDAO.findMusic(mus.getNome());
			
			Assert.assertEquals(mus, retMus);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

}
