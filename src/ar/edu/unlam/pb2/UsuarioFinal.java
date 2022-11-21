package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class UsuarioFinal extends Usuario {
	private List<Figurita> stockFiguritas;

	public UsuarioFinal(String nombre) {
		super(nombre);
		this.stockFiguritas=new ArrayList<Figurita>();
	}

	@Override
	Boolean agregarFigurita() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Figurita> getStockFiguritasDisponibles() {
		return stockFiguritas;
	}

	public void setStockFiguritasDisponibles(List<Figurita> stockFiguritasDisponibles) {
		this.stockFiguritas = stockFiguritasDisponibles;
	}

}
