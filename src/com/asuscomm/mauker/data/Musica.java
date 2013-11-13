package com.asuscomm.mauker.data;

public class Musica {
	public static int CATEGORIA_ROCK = 1;
	public static int CATEGORIA_POP = 2;
	public static int CATEGORIA_HOUSE = 3;
	public static int CATEGORIA_MBP = 4;
	
	private int _id;
	private int categoria;
	private String nome;
	private String banda;
	private int valor;
	private String tempo;
	private boolean active;
	
	public Musica(){
		
	}
	
	public Musica(int id, int categoria, String nome, String banda, int valor, String tempo, boolean active){
		this._id = id;
		this.categoria = categoria;
		this.nome = nome;
		this.banda = banda;
		this.valor = valor;
		this.tempo = tempo;
		this.active = active;
	}
	
	public int getID(){
		return _id;
	}
	
	public int getCategoria(){
		return categoria;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getBanda(){
		return banda;
	}
	
	public int getValor(){
		return valor;
	}

	public void setTempo(String tempo){
		this.tempo = tempo;
	}
	
	public String getTempo() {
		return tempo;
	}
	
	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}
	
	
}
