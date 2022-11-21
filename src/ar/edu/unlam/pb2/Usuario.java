package ar.edu.unlam.pb2;

public abstract class Usuario {
	protected String nombre;
	
	public Usuario(String nombre) {
		this.nombre=nombre;
		
	}
	
	abstract Boolean agregarFigurita(Figurita figurita, Sistema sistema) throws CodigoExistenteException;

}
