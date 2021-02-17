package com.pspturno2.talleres.controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pspturno2.talleres.modelo.Alumno;

/**
 * <h1>Controlador clase alumno</h1>
 *
 * <p>
 * Esta clase se encarga de inicializar una lista de la clase Alumnos con datos.
 * </p>
 *
 * <p>
 * Los metodos de mapeo de esta clase cumplen con los requisitos de un crud
 * basico, permitiendonos listar todos los alumnos, crear un nuevo alumno,
 * obtener un alumno por su id, actualizar un alumno y borrarlo.
 * </p>
 *
 * @author Angel Mulero
 * @version 1.0
 */

@RestController
public class AlumnoServiceControlador {
	/**
	 *
	 * <p>
	 * Este metodo se encarga de crear un hashmap de Alumnos, e inicializarla con
	 * datos.
	 * </p>
	 *
	 */
	private static Map<String, Alumno> alumnos = new HashMap<>();
	static {
		Alumno alu = new Alumno();
		alu.setIdentificador("001");
		alu.setNombre("Angel");
		alu.setApellidos("Mulero Regidor");
		alu.setGrupo("1esoa");
		alumnos.put(alu.getIdentificador(), alu);

		alu = new Alumno();
		alu.setIdentificador("002");
		alu.setNombre("Rafa");
		alu.setApellidos("Sanchez");
		alu.setGrupo("1esoa");
		alumnos.put(alu.getIdentificador(), alu);

		alu = new Alumno();
		alu.setIdentificador("003");
		alu.setNombre("Miguel");
		alu.setApellidos("Parejo");
		alu.setGrupo("1esob");
		alumnos.put(alu.getIdentificador(), alu);

		alu = new Alumno();
		alu.setIdentificador("004");
		alu.setNombre("Pablo");
		alu.setApellidos("Meca");
		alu.setGrupo("2eso");
		alumnos.put(alu.getIdentificador(), alu);

		alu = new Alumno();
		alu.setIdentificador("005");
		alu.setNombre("David");
		alu.setApellidos("S");
		alu.setGrupo("2eso");
		alumnos.put(alu.getIdentificador(), alu);

	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de borrar alumnos, introduciendo su id.
	 * </p>
	 *
	 * @param id Cada alumno es identificado por un identificador.
	 * @return Devuelve un mensaje de estado en caso de completarse la funcion
	 *         correctamente.
	 */
	@DeleteMapping(value = "/alumnos/{id}")
	public ResponseEntity<Object> deleteAlumno(@PathVariable("id") String id) {
		alumnos.remove(id);
		return new ResponseEntity<>("Alumno borrado satisfactoriamente", HttpStatus.OK);
	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de actualizar alumnos, introduciendo su id.
	 * </p>
	 *
	 * @param id Cada alumno es identificado por un identificador.
	 * @param alumno Datos nuevos del alumno a actualizar.
	 * @return Devuelve un mensaje de estado en caso de completarse la funcion
	 *         correctamente.
	 */
	@PutMapping(value = "/alumnos/{id}")
	public ResponseEntity<Object> updateAlumno(@PathVariable("id") String id, @RequestBody Alumno alumno) {
		alumnos.remove(id);
		alumno.setIdentificador(id);
		alumnos.put(id, alumno);
		return new ResponseEntity<>("Alumno actualizado satisfactoriamente", HttpStatus.OK);
	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de crear alumnos.
	 * </p>
	 *
	 * @param alumno Datos del nuevo alumno a crear.
	 * 
	 * @return Devuelve un mensaje de estado en caso de completarse la funcion
	 *         correctamente.
	 */
	@PostMapping(value = "/alumnos")
	public ResponseEntity<Object> createAlumno(@RequestBody Alumno alumno) {
		alumnos.put(alumno.getIdentificador(), alumno);
		return new ResponseEntity<>("Alumno creado satisfactoriamente", HttpStatus.CREATED);
	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de devolver la lista con todos los alumnos.
	 * </p>
	 *
	 * @return Devuelve la lista con todos los alumnos.
	 */
	@RequestMapping(value = "/alumnos")
	public ResponseEntity<Object> getAlumno() {
		return new ResponseEntity<>(alumnos.values(), HttpStatus.OK);
	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de devolver un alumno, introduciendo su id.
	 * </p>
	 *
	 * @param id Cada alumno es identificado por un identificador.
	 * @return Devuelve el alumno con la id introducida en el caso de existir.
	 */
	@RequestMapping(value = "/alumnos/{id}")
	public ResponseEntity<Object> getAlumnoId(@PathVariable("id") String id) {
		return new ResponseEntity<>(alumnos.get(id), HttpStatus.OK);
	}
}