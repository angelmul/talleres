package com.pspturno2.talleres.modelo;

/**
 * <h1>Clase Alumno</h1>
 *
 * <p>
 * Esta clase se encarga de almacenar los datos de un alumno.
 * </p>
 *
 * @author Angel Mulero
 * @version 1.0
 */
public class Alumno {
	private String nombre;
	private String apellidos;
	private String identificador;
	private String grupo;

	/**
	 * <p>
	 * Metodo para devolver el nombre del alumno.
	 * </p>
	 * @return nombre Nombre del alumno.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * <p>
	 * Metodo para establecer el nombre del alumno.
	 * </p>
	 * @param nombre Nombre del alumno.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * <p>
	 * Metodo para devolver los apellidos del alumno.
	 * </p>
	 * @return apellidos Apellidos del alumno.
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * <p>
	 * Metodo para establecer los apellidos del alumno.
	 * </p>
	 * @param apellidos Apellidos del alumno.
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * <p>
	 * Metodo para devolver el identificador del alumno.
	 * </p>
	 * @return identificador Identificador del alumno.
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * <p>
	 * Metodo para establecer el identificador del alumno.
	 * </p>
	 * @param identificador Identificador del alumno.
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	/**
	 * <p>
	 * Metodo para devolver el grupo del alumno.
	 * </p>
	 * @return grupo Grupo del alumno.
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * <p>
	 * Metodo para establecer el grupo del alumno.
	 * </p>
	 * @param grupo Grupo del alumno.
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	
}
