package com.pspturno2.talleres.modelo;

/**
 * <h1>Clase Monitor</h1>
 *
 * <p>
 * Esta clase se encarga de almacenar los datos de un monitor.
 * </p>
 *
 * @author Angel Mulero
 * @version 1.0
 */
public class Monitor {
	private String nombre;
	private String dni;
	private String titulo;
	
	/**
	 * <p>
	 * Metodo para devolver el nombre del monitor.
	 * </p>
	 * @return nombre Nombre del monitor.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * <p>
	 * Metodo para establecer el nombre del monitor.
	 * </p>
	 * @param nombre Nombre del monitor.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * <p>
	 * Metodo para devolver el dni del monitor.
	 * </p>
	 * @return dni Dni del alumno.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * <p>
	 * Metodo para establecer el dni del monitor.
	 * </p>
	 * @param dni Dni del alumno.
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * <p>
	 * Metodo para devolver el titulo del monitor.
	 * </p>
	 * @return titulo Titulo del monitor.
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * <p>
	 * Metodo para establecer el nombre del alumno.
	 * </p>
	 * @param titulo Titulo del monitor.
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
	