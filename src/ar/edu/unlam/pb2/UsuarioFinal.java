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
	
	public void sacarFiguStock(Figurita figu) {
		this.stockFiguritas.remove(figu);
	}
	
	public boolean pegarFigurita(Figurita figurita) throws FiguritaRepetidaException {
		if(this.stockFiguritas.contains(figurita)) {
			if(this.album.add(figurita)) {
				this.stockFiguritas.remove(figurita);
				return true;
			}throw new FiguritaRepetidaException();
		} return false;
		
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

	public void figuEstaPegada(Figurita figuA) throws FiguritaRepetidaException {
		if(this.album.contains(figuA)) {
			throw new FiguritaRepetidaException();
		}
	}
		
	public Boolean figuDisponible(Figurita figuA) throws FiguritaNoDisponibleException {
		if(this.stockFiguritas.contains(figuA)) {
			return true;
				
		} throw new FiguritaNoDisponibleException();
		
	}

	
	

}
