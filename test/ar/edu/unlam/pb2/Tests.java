package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {

	@Test
	public void queSePuedaCrearUnaFigurita() {
		Figurita figu=new Figurita("ARG23", 'C', "Argentina", 1,"Messi", 100.0);
		
		assertNotNull(figu);
	}
	
	@Test
	public void queSePuedaCrearUnAdministrador() {
		Usuario admin=new UsuarioAdministrador("admin");
		
		assertNotNull(admin);
	}
	
	@Test
	public void queSePuedaCrearUnUsuarioFinal() {
        Usuario usfinal =new UsuarioFinal("final");
		
		assertNotNull(usfinal);
	}

	@Test
	public void queUnAdministradorPuedaAgregarUnaFigurita() throws CodigoExistenteException {
		Usuario admin=new UsuarioAdministrador("admin");
		Sistema sistema=new Sistema("sistema-panini");
		Figurita figu=new Figurita("ARG23", 'C', "Argentina", 1,"Messi", 100.0);
		
		assertTrue(((UsuarioAdministrador)admin).agregarFigurita(figu, sistema));
	}
	
	@Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita() throws CodigoExistenteException {
		Usuario admin=new UsuarioAdministrador("admin");
		Sistema sistema=new Sistema("sistema-panini");
		Figurita figu=new Figurita("ARG23", 'C', "Argentina", 1,"Messi", 100.0);
		((UsuarioAdministrador)admin).agregarFigurita(figu, sistema);
		
		Usuario usfinal=new UsuarioFinal("final");
		assertTrue(((UsuarioFinal)usfinal).agregarFigurita(figu, sistema));
	}
	
	
	
}
