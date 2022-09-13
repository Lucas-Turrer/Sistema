package unlam.pb2;

import java.util.ArrayList;

public class Sistema {
	private String nombreDelSistema;
	private Integer cantidadMaximaDeUsuarios;
	private ArrayList <Usuario> usuariosRegistrados = new ArrayList ();
	private ArrayList <Usuario> usuariosLogueados = new ArrayList ();
	private ArrayList <Usuario> usuariosBloqueados = new ArrayList ();

	public Sistema(String nomnbreDelSistema,Integer cantidadMaximaDeUsuarios) {
		this.nombreDelSistema = nombreDelSistema;
		this.cantidadMaximaDeUsuarios = cantidadMaximaDeUsuarios;
	}

	public Boolean agregarUsuario(Usuario usuarioParaAgregar) {
		if(usuariosRegistrados.contains(usuarioParaAgregar)) {
			return false;
		} else {
			usuariosRegistrados.add(usuarioParaAgregar);
			return true;
		}
	}

	public void iniciarSesion(Usuario usuarioParaLoguearse) {
		if(usuariosRegistrados.contains(usuarioParaLoguearse)) {
			usuariosLogueados.add(usuarioParaLoguearse);
		} 
	}

	public Integer cantidadDeUsuariosLogueados() {
		return usuariosLogueados.size();
	}

	public void bloquearUsuario(Usuario usuarioParaBloquear) {
		usuariosRegistrados.remove(usuarioParaBloquear);
		usuariosBloqueados.add(usuarioParaBloquear);
	}

	public Integer cantidadDeUsuariosBloqueados() {
		return usuariosBloqueados.size();
	}

	public Integer porcentajeDeUsuariosLogueados() {
		Integer cantidadDeUsuariosRegistrados = usuariosRegistrados.size();
		Integer cantidadDeUsuariosLogueados = usuariosLogueados.size();
		
		Integer porcentaje = (cantidadDeUsuariosLogueados*100)/cantidadDeUsuariosRegistrados;
		
		return porcentaje;
	}

	public Boolean loguearUsuario(Usuario usuarioParaLoguearse, String contraseniaIngresada) {
		if(usuariosRegistrados.contains(usuarioParaLoguearse)) {
			if(usuarioParaLoguearse.contrasenia == contraseniaIngresada) {
				return true;
			}
		} return false;
	}
	

}
