package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sistema {
	private String nombre;
	private Set<Usuario>usuariosRegistrados;
	private Set<Figurita>stockFiguritasDisponibles;
	
	public Sistema(String nombre) {
		this.nombre = nombre;
		this.usuariosRegistrados=new HashSet<Usuario>();
		this.stockFiguritasDisponibles=new TreeSet<Figurita>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Usuario> getUsuariosRegistrados() {
		return usuariosRegistrados;
	}

	public void setUsuariosRegistrados(Set<Usuario> usuariosRegistrados) {
		this.usuariosRegistrados = usuariosRegistrados;
	}

	public Set<Figurita> getStockFiguritasDisponibles() {
		return stockFiguritasDisponibles;
	}

	public void setStockFiguritasDisponibles(Set<Figurita> stockFiguritasDisponibles) {
		this.stockFiguritasDisponibles = stockFiguritasDisponibles;
	}
	
	
	

}