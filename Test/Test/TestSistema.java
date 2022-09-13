package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import unlam.pb2.Sistema;
import unlam.pb2.Usuario;

public class TestSistema {

	@Test
	public void QueSeCreaUnSistema() {
		Sistema tacticaSoft = new Sistema ("TacticaSoft", 10);
		assertNotNull(tacticaSoft);
	}
	
	@Test
	public void QueSeAgregaUnUsuarioNuevo() {
		Sistema tacticaSoft = new Sistema ("TacticaSoft", 10);
		Usuario usuario1 = new Usuario ("Lucas", "Turrer", 37931874, "1234hola");
		
		assertTrue(tacticaSoft.agregarUsuario(usuario1));
	}
	
	@Test
	public void QueNoSeAgregaUnUsuarioRepetido() {
		Sistema tacticaSoft = new Sistema ("TacticaSoft", 10);
		Usuario usuario1 = new Usuario ("Lucas", "Turrer", 37931874, "1234hola");
		
		tacticaSoft.agregarUsuario(usuario1);
		assertFalse(tacticaSoft.agregarUsuario(usuario1));
	}
	
	@Test
	public void QueSeCalculeLaCantidadDeUsuariosLogueados() {
		Sistema tacticaSoft = new Sistema ("TacticaSoft", 10);
		Usuario usuario1 = new Usuario ("Lucas", "Turrer", 37931874, "1234hola");
		Usuario usuario2 = new Usuario ("Matias", "Perez", 37931875, "12hola");
		
		tacticaSoft.agregarUsuario(usuario1);
		tacticaSoft.agregarUsuario(usuario2);
		
		tacticaSoft.iniciarSesion(usuario1);
		tacticaSoft.iniciarSesion(usuario2);
		
		Integer valorEsperado = 2;
		Integer valorObtenido = tacticaSoft.cantidadDeUsuariosLogueados();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void QueSeCalculeLaCantidadDeUsuariosBloqueados() {
		Sistema tacticaSoft = new Sistema ("TacticaSoft", 10);
		Usuario usuario1 = new Usuario ("Lucas", "Turrer", 37931874, "1234hola");
		Usuario usuario2 = new Usuario ("Matias", "Perez", 37931875, "12hola");
		
		tacticaSoft.agregarUsuario(usuario1);
		tacticaSoft.agregarUsuario(usuario2);
		
		tacticaSoft.bloquearUsuario(usuario2);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = tacticaSoft.cantidadDeUsuariosBloqueados();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void QueSeCalculeElPorcentajeDeUsuariosLogueados() {
		Sistema tacticaSoft = new Sistema ("TacticaSoft", 10);
		Usuario usuario1 = new Usuario ("Lucas", "Turrer", 37931874, "1234hola");
		Usuario usuario2 = new Usuario ("Matias", "Perez", 37931875, "12hola");
		
		tacticaSoft.agregarUsuario(usuario1);
		tacticaSoft.agregarUsuario(usuario2);
		
		tacticaSoft.iniciarSesion(usuario1);
		
		Integer valorEsperado = 50;
		Integer valorObtenido = tacticaSoft.porcentajeDeUsuariosLogueados();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void QueSePuedeLoguearUnUsuario() {
		Sistema tacticaSoft = new Sistema ("TacticaSoft", 10);
		Usuario usuario1 = new Usuario ("Lucas", "Turrer", 37931874, "1234hola");
		Usuario usuario2 = new Usuario ("Matias", "Perez", 37931875, "12hola");
		
		tacticaSoft.agregarUsuario(usuario1);
		tacticaSoft.agregarUsuario(usuario2);
		
		assertTrue(tacticaSoft.loguearUsuario(usuario1,"1234hola"));
	}
	
	@Test
	public void QueNoSePuedeLoguearUnUsuario() {
		Sistema tacticaSoft = new Sistema ("TacticaSoft", 10);
		Usuario usuario1 = new Usuario ("Lucas", "Turrer", 37931874, "1234hola");
		Usuario usuario2 = new Usuario ("Matias", "Perez", 37931875, "12hola");
		
		tacticaSoft.agregarUsuario(usuario1);
		tacticaSoft.agregarUsuario(usuario2);
		
		assertFalse(tacticaSoft.loguearUsuario(usuario1,"1hola"));
	}

}
