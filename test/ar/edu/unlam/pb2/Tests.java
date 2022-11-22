package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
		
		((UsuarioAdministrador)admin).agregarFigurita(figu, sistema);
		
		Integer esperado=1;
		Integer obtenido=sistema.getStockFiguritasDisponibles().size();
		
		assertEquals(esperado,obtenido);
		
	}
	
	@Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita() throws CodigoExistenteException {
		Usuario admin=new UsuarioAdministrador("admin");
		Sistema sistema=new Sistema("sistema-panini");
		Figurita figu=new Figurita("ARG23", 'C', "Argentina", 1,"Messi", 100.0);
		((UsuarioAdministrador)admin).agregarFigurita(figu, sistema);
		
		Usuario usfinal=new UsuarioFinal("final");
		((UsuarioFinal)usfinal).agregarFigurita(figu, sistema);
		Integer esperado=1;
		Integer obtenido=((UsuarioFinal)usfinal).getStockFiguritas().size();
		
		assertEquals(esperado,obtenido);
		
	}
	
	@Test
	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() throws CodigoExistenteException {
		Usuario admin=new UsuarioAdministrador("admin");
		Sistema sistema=new Sistema("sistema-panini");
		Figurita figu1=new Figurita("ARG23", 'A', "Argentina", 23,"Messi", 100.0);
		Figurita figu2=new Figurita("ARG24", 'B', "Argentina", 24,"Dibu", 100.0);
		Figurita figu3=new Figurita("ARG25", 'C', "Argentina", 25,"De Paul", 100.0);
		((UsuarioAdministrador)admin).agregarFigurita(figu1, sistema);
		((UsuarioAdministrador)admin).agregarFigurita(figu2, sistema);
		((UsuarioAdministrador)admin).agregarFigurita(figu3, sistema);
		
		Usuario usfinal=new UsuarioFinal("final");
		((UsuarioFinal)usfinal).agregarFigurita(figu1, sistema);
		((UsuarioFinal)usfinal).agregarFigurita(figu2, sistema);
		((UsuarioFinal)usfinal).agregarFigurita(figu3, sistema);
		
		List<Figurita>listaOrdenada=new ArrayList<Figurita>();
		listaOrdenada.add(figu1);
		listaOrdenada.add(figu2);
		listaOrdenada.add(figu3);
		
		List<Figurita>listaObtenida=((UsuarioFinal)usfinal).getStockFiguritas();
		
		assertEquals(listaOrdenada,listaObtenida);
		
	}
	
	@Test(expected = CodigoExistenteException.class)
	public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() throws CodigoExistenteException {
		Usuario admin=new UsuarioAdministrador("admin");
		Sistema sistema=new Sistema("sistema-panini");
		Figurita figu=new Figurita("ARG23", 'C', "Argentina", 1,"Messi", 100.0);
		
		((UsuarioAdministrador)admin).agregarFigurita(figu, sistema);
		((UsuarioAdministrador)admin).agregarFigurita(figu, sistema);
			
	}
	
	
	
}
