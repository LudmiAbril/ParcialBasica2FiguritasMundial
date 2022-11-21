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
        Usuario usfinal =new UsuarioFinal("admin");
		
		assertNotNull(usfinal);
	}

}
