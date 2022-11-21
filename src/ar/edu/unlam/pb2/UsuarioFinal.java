package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UsuarioFinal extends Usuario {
	private List<Figurita> stockFiguritas;
	private Set<Figurita>album;

	public UsuarioFinal(String nombre) {
		super(nombre);
		this.stockFiguritas=new ArrayList<>();
		this.album=new TreeSet<Figurita>();
	}

	@Override
	Boolean agregarFigurita(Figurita figurita, Sistema sistema)  {
    if(sistema.figuritaDisponible(figurita)) {
    	stockFiguritas.add(figurita);
    	Collections.sort(stockFiguritas);
    	return true;
    }
		return false;
	}

	public List<Figurita> getStockFiguritas() {
		return stockFiguritas;
	}

	public void setStockFiguritas(List<Figurita> stockFiguritas) {
		this.stockFiguritas = stockFiguritas;
	}

	public Set<Figurita> getAlbum() {
		return album;
	}

	public void setAlbum(Set<Figurita> album) {
		this.album = album;
	}

	
	

}
