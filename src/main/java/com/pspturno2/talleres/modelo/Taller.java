package com.pspturno2.talleres.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h1>Clase Taller</h1>
 *
 * <p>
 * Esta clase se encarga de almacenar los datos de un taller.
 * </p>
 *
 * @author Angel Mulero
 * @version 1.0
 */
public class Taller {
	private String nombre;
	private String materia;
	private int maxAlumnos;
	private int minAlumnos;
	private int duracionMin;
	private String fecha;
	private HashMap<String, Monitor> monitores;
	
	public Taller() {
		this.monitores = new HashMap<>();
	}
	
	/**
	 * <p>
	 * Metodo para devolver el nombre del taller.
	 * </p>
	 * @return nombre Nombre del taller.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * <p>
	 * Metodo para establecer el nombre del taller.
	 * </p>
	 * @param nombre Nombre del taller.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * <p>
	 * Metodo para devolver la materia del taller.
	 * </p>
	 * @return materia Materia del taller.
	 */
	public String getMateria() {
		return materia;
	}

	/**
	 * <p>
	 * Metodo para establecer la materia del taller.
	 * </p>
	 * @param materia Materia del taller.
	 */
	public void setMateria(String materia) {
		this.materia = materia;
	}

	/**
	 * <p>
	 * Metodo para devolver el maximo de alumnos del taller.
	 * </p>
	 * @return maxAlumnos Número maximo de alumnos del alumno.
	 */
	public int getMaxAlumnos() {
		return maxAlumnos;
	}

	/**
	 * <p>
	 * Metodo para establecer el maximo de alumnos del taller.
	 * </p>
	 * @param maxAlumnos Número maximo de alumnos del alumno.
	 */
	public void setMaxAlumnos(int maxAlumnos) {
		this.maxAlumnos = maxAlumnos;
	}

	/**
	 * <p>
	 * Metodo para devolver el minimo de alumnos del taller.
	 * </p>
	 * @return minAlumnos Número minimo de alumnos del alumno.
	 */
	public int getMinAlumnos() {
		return minAlumnos;
	}

	/**
	 * <p>
	 * Metodo para establecer el minimo de alumnos del taller.
	 * </p>
	 * @param minAlumnos Número minimo de alumnos del alumno.
	 */
	public void setMinAlumnos(int minAlumnos) {
		this.minAlumnos = minAlumnos;
	}

	/**
	 * <p>
	 * Metodo para devolver la fecha del taller.
	 * </p>
	 * @return fecha Fecha del taller.
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * <p>
	 * Metodo para establecer la fecha del taller.
	 * </p>
	 * @param fecha Fecha del taller.
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * <p>
	 * Metodo para devolver la duración minima del taller.
	 * </p>
	 * @return duracionMin Duración minima del taller.
	 */
	public int getDuracionMin() {
		return duracionMin;
	}

	/**
	 * <p>
	 * Metodo para establecer la duración minima de un taller.
	 * </p>
	 * @param duracionMin Duración minima de un taller.
	 */
	public void setDuracionMin(int duracionMin) {
		this.duracionMin = duracionMin;
	}

	/**
	 * <p>
	 * Metodo para devolver la lista de monitores de un taller.
	 * </p>
	 * @return monitores Lista con los monitores del taller.
	 */
	public Map<String, Monitor> getMonitores() {
		return monitores;
	}

	/**
	 * <p>
	 * Metodo para añadir un monitor al taller.
	 * </p>
	 * @param monitor Monitor a añadir en el taller.
	 */
	public void addMonitor(Monitor monitor) {
		this.monitores.put(monitor.getDni(),monitor);
	}
	
	/**
	 * <p>
	 * Metodo para eliminar un monitor del taller.
	 * </p>
	 * @param dni Dni del monitor.
	 */
	public void removeMonitor(String dni) {
		this.monitores.remove(dni);
	}
	
}
