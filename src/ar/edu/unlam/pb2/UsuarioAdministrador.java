package ar.edu.unlam.pb2;


public class UsuarioAdministrador extends Usuario {

	public UsuarioAdministrador(String nombre) {
		super(nombre);
		
	}

	@Override
	Boolean agregarFigurita(Figurita figurita, Sistema sistema) throws CodigoExistenteException {
	return sistema.agregarFiguritaAlStockDisponile(figurita);
		
	}

	
	

}
