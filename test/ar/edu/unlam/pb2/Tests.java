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
	
	@Test (expected = CodigoExistenteException.class)
	public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() throws CodigoExistenteException {
		Usuario admin=new UsuarioAdministrador("admin");
		Sistema sistema=new Sistema("sistema-panini");
		Figurita figu=new Figurita("ARG23", 'C', "Argentina", 1,"Messi", 100.0);
		
		((UsuarioAdministrador)admin).agregarFigurita(figu, sistema);
		((UsuarioAdministrador)admin).agregarFigurita(figu, sistema);
			
	}
	
	@Test
	public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() throws CodigoExistenteException {
		Usuario admin=new UsuarioAdministrador("admin");
		Sistema sistema=new Sistema("sistema-panini");
		Figurita figu=new Figurita("ARG23", 'C', "Argentina", 1,"Messi", 100.0);
		((UsuarioAdministrador)admin).agregarFigurita(figu, sistema);
	
		Usuario usfinal=new UsuarioFinal("final");
		
		((UsuarioFinal)usfinal).agregarFigurita(figu, sistema);
		((UsuarioFinal)usfinal).agregarFigurita(figu, sistema);
		
		Integer deseado=2;
		Integer obtenido=((UsuarioFinal)usfinal).getStockFiguritas().size();
		
		assertEquals(deseado,obtenido);
	}
	
	@Test
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() throws CodigoExistenteException, FiguritaRepetidaException {
		Usuario admin=new UsuarioAdministrador("admin");
		Sistema sistema=new Sistema("sistema-panini");
		Figurita figu=new Figurita("ARG23", 'C', "Argentina", 1,"Messi", 100.0);
		((UsuarioAdministrador)admin).agregarFigurita(figu, sistema);
	
		Usuario usfinal=new UsuarioFinal("final");
		
		((UsuarioFinal)usfinal).agregarFigurita(figu, sistema);
		((UsuarioFinal)usfinal).pegarFigurita(figu);
		
		Integer deseado=1;
		Integer obtenido=((UsuarioFinal)usfinal).getAlbum().size();
		
		assertEquals(deseado,obtenido);
	}
	
	@Test (expected = FiguritaRepetidaException.class)
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws CodigoExistenteException, FiguritaRepetidaException {
		Usuario admin=new UsuarioAdministrador("admin");
		Sistema sistema=new Sistema("sistema-panini");
		Figurita figu=new Figurita("ARG23", 'C', "Argentina", 1,"Messi", 100.0);
		((UsuarioAdministrador)admin).agregarFigurita(figu, sistema);
	
		Usuario usfinal=new UsuarioFinal("final");
		
		((UsuarioFinal)usfinal).agregarFigurita(figu, sistema);
		((UsuarioFinal)usfinal).agregarFigurita(figu, sistema);
		((UsuarioFinal)usfinal).pegarFigurita(figu);
		((UsuarioFinal)usfinal).pegarFigurita(figu);
		
	}
	
	@Test
	public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() throws CodigoExistenteException, FiguritaRepetidaException, FiguritaNoDisponibleException {
		Usuario admin=new UsuarioAdministrador("admin");
		Sistema sistema=new Sistema("sistema-panini");
		Figurita figu1=new Figurita("ARG23", 'C', "Argentina", 1,"Messi", 100.0);
		Figurita figu2=new Figurita("ARG24", 'C', "Argentina", 1,"Tevez", 100.0);
		((UsuarioAdministrador)admin).agregarFigurita(figu1, sistema);
		((UsuarioAdministrador)admin).agregarFigurita(figu2, sistema);
		
		Usuario us1=new UsuarioFinal("finala");
		Usuario us2=new UsuarioFinal("finalb");
		
		((UsuarioFinal)us1).agregarFigurita(figu1, sistema);
		((UsuarioFinal)us2).agregarFigurita(figu2, sistema);
		
		sistema.intercambiarFiguritas(us1, us2, figu1, figu2);
		
		assertTrue(((UsuarioFinal)us1).figuDisponible(figu2));
		assertTrue(((UsuarioFinal)us2).figuDisponible(figu1));
		
	}
	
	@Test (expected = FiguritaNoDisponibleException.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga() throws CodigoExistenteException, FiguritaRepetidaException, FiguritaNoDisponibleException {
		Usuario admin=new UsuarioAdministrador("admin");
		Sistema sistema=new Sistema("sistema-panini");
		Figurita figu1=new Figurita("ARG23", 'C', "Argentina", 1,"Messi", 100.0);
		Figurita figu2=new Figurita("ARG24", 'C', "Argentina", 1,"Tevez", 100.0);
		Figurita figu3=new Figurita("ARG25", 'C', "Argentina", 1,"De Paul", 100.0);
		((UsuarioAdministrador)admin).agregarFigurita(figu1, sistema);
		((UsuarioAdministrador)admin).agregarFigurita(figu2, sistema);
		
		Usuario us1=new UsuarioFinal("finala");
		Usuario us2=new UsuarioFinal("finalb");
		
		((UsuarioFinal)us1).agregarFigurita(figu1, sistema);
		((UsuarioFinal)us2).agregarFigurita(figu2, sistema);
		
		sistema.intercambiarFiguritas(us1, us2, figu1, figu3);
		
	}
	
	@Test (expected = FiguritaNoDisponibleException.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado() throws CodigoExistenteException, FiguritaRepetidaException, FiguritaNoDisponibleException {
		Usuario admin=new UsuarioAdministrador("admin");
		Sistema sistema=new Sistema("sistema-panini");
		Figurita figu1=new Figurita("ARG23", 'C', "Argentina", 1,"Messi", 100.0);
		Figurita figu2=new Figurita("ARG24", 'C', "Argentina", 1,"Tevez", 100.0);
		Figurita figu3=new Figurita("ARG25", 'C', "Argentina", 1,"De Paul", 100.0);
		((UsuarioAdministrador)admin).agregarFigurita(figu1, sistema);
		((UsuarioAdministrador)admin).agregarFigurita(figu2, sistema);
		
		Usuario us1=new UsuarioFinal("finala");
		Usuario us2=new UsuarioFinal("finalb");
		
		((UsuarioFinal)us1).agregarFigurita(figu1, sistema);
		((UsuarioFinal)us2).agregarFigurita(figu2, sistema);
		
		((UsuarioFinal)us1).pegarFigurita(figu1);
		
		sistema.intercambiarFiguritas(us1, us2, figu1, figu3);
		
	}
	
}
