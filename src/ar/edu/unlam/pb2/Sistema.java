package ar.edu.unlam.pb2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Sistema {
	private String nombre;
	private Set<Usuario>usuariosRegistrados;
	private Map<String,Figurita>stockFiguritasDisponibles;
	
	public Sistema(String nombre) {
		this.nombre = nombre;
		this.usuariosRegistrados=new HashSet<Usuario>();
		this.stockFiguritasDisponibles=new TreeMap<String,Figurita>();
	}

	public void intercambiarFiguritas(Usuario userA,Usuario userB,Figurita figuA,Figurita figuB) throws FiguritaRepetidaException, FiguritaNoDisponibleException {
		((UsuarioFinal)userA).figuEstaPegada(figuA);
		((UsuarioFinal)userB).figuEstaPegada(figuB) ;
        ((UsuarioFinal)userA).figuNoDisponible(figuA);
		((UsuarioFinal)userB).figuNoDisponible(figuB);
        	
		((UsuarioFinal)userA).sacarFiguStock(figuA);
		((UsuarioFinal)userB).agregarFigurita(figuA, this);
		((UsuarioFinal)userB).sacarFiguStock(figuB);
		((UsuarioFinal)userA).agregarFigurita(figuB, this);
		
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

	public Map<String,Figurita> getStockFiguritasDisponibles() {
		return stockFiguritasDisponibles;
	}

	public void setStockFiguritasDisponibles(Map<String,Figurita> stockFiguritasDisponibles) {
		this.stockFiguritasDisponibles = stockFiguritasDisponibles;
	}

	public Boolean agregarFiguritaAlStockDisponile(Figurita figurita) throws CodigoExistenteException {
		if(this.stockFiguritasDisponibles.containsKey(figurita.getCodigoDeFigurita())) {
			throw new CodigoExistenteException();
		}
		return true;
	}

	public boolean figuritaDisponible(Figurita figurita) {
		if(this.stockFiguritasDisponibles.containsValue(figurita)) {
			return true;
		}
		return false;
	}
	
	
	

}
