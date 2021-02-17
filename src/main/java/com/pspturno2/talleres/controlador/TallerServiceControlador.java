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

import com.pspturno2.talleres.modelo.Monitor;
import com.pspturno2.talleres.modelo.Taller;

/**
 * <h1>Controlador clase Taller y Monitor</h1>
 *
 * <p>
 * Esta clase se encarga de inicializar una lista de Talleres con monitores
 * inscritos.
 * </p>
 *
 * <p>
 * Los metodos de mapeo de esta clase cumplen con los requisitos de un crud
 * basico, permitiendonos listar todos los talleres, crear un nuevo taller,
 * obtener un taller por su id, actualizar un taller y borrarlo.
 * </p>
 *
 * <p>
 * La clase Monitor es un recurso de nivel 2, el cual se accede desde el recurso
 * de talleres, cumpliendo tambien con los requisitos de un crud basico,
 * permitiendonos listar todos los talleres, crear un nuevo taller, obtener un
 * taller por su id, actualizar un taller y borrarlo.
 * </p>
 * 
 * @author Angel Mulero
 * @version 1.0
 */
@RestController
public class TallerServiceControlador {
	/**
	 *
	 * <p>
	 * Este metodo se encarga de crear un hashmap de Talleres con Monitores dentro,
	 * e inicializarla con datos.
	 * </p>
	 *
	 */
	private static Map<String, Taller> talleres = new HashMap<>();
	static {
		Taller taller = new Taller();
		taller.setNombre("CienciaConLasMates");
		taller.setFecha("08/02/2021");
		taller.setDuracionMin(60);
		taller.setMateria("Ciencia");
		taller.setMinAlumnos(8);
		taller.setMaxAlumnos(30);
		Monitor monitor = new Monitor();
		monitor.setNombre("Adolfo");
		monitor.setDni("10102222Q");
		monitor.setTitulo("Ingeniero Matematico");
		taller.addMonitor(monitor);
		talleres.put(taller.getNombre(), taller);

		taller = new Taller();
		taller.setNombre("BiologiaParaTodos");
		taller.setFecha("09/02/2021");
		taller.setDuracionMin(120);
		taller.setMateria("Biologia");
		taller.setMinAlumnos(10);
		taller.setMaxAlumnos(60);
		monitor = new Monitor();
		monitor.setNombre("Maria Jose");
		monitor.setDni("20203333W");
		monitor.setTitulo("Ingeniera Biologa");
		taller.addMonitor(monitor);
		talleres.put(taller.getNombre(), taller);

		taller = new Taller();
		taller.setNombre("CienciaDiminuta");
		taller.setFecha("10/02/2021");
		taller.setDuracionMin(30);
		taller.setMateria("Ciencia");
		taller.setMinAlumnos(5);
		taller.setMaxAlumnos(10);
		monitor = new Monitor();
		monitor.setNombre("Jose");
		monitor.setDni("30304444E");
		monitor.setTitulo("Ingeniero Cientifico");
		taller.addMonitor(monitor);
		talleres.put(taller.getNombre(), taller);

	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de borrar talleres, introduciendo su nombre.
	 * </p>
	 *
	 * @param nombre Cada taller es identificado por un nombre.
	 * @return Devuelve un mensaje de estado en caso de completarse la funcion
	 *         correctamente.
	 */
	@DeleteMapping(value = "/talleres/{nombre}")
	public ResponseEntity<Object> deleteTaller(@PathVariable("nombre") String nombre) {
		talleres.remove(nombre);
		return new ResponseEntity<>("Taller borrado satisfactoriamente", HttpStatus.OK);
	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de actualizar talleres, introduciendo su
	 * nombre.
	 * </p>
	 *
	 * @param nombre Cada taller es identificado por un nombre.
	 * @param taller Datos nuevos del taller a actualizar.
	 * @return Devuelve un mensaje de estado en caso de completarse la funcion
	 *         correctamente.
	 */
	@PutMapping(value = "/talleres/{nombre}")
	public ResponseEntity<Object> updateTaller(@PathVariable("nombre") String nombre, @RequestBody Taller taller) {
		talleres.remove(nombre);
		taller.setNombre(nombre);
		talleres.put(nombre, taller);
		return new ResponseEntity<>("Taller actualizado satisfactoriamente", HttpStatus.OK);
	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de crear talleres.
	 * </p>
	 *
	 * @param taller Datos del taller nuevo a crear.
	 * @return Devuelve un mensaje de estado en caso de completarse la funcion
	 *         correctamente.
	 */
	@PostMapping(value = "/talleres")
	public ResponseEntity<Object> createTaller(@RequestBody Taller taller) {
		talleres.put(taller.getNombre(), taller);
		return new ResponseEntity<>("Taller creado satisfactoriamente", HttpStatus.CREATED);
	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de devolver talleres.
	 * </p>
	 *
	 * @return Devuelve una lista con todos los talleres.
	 */
	@RequestMapping(value = "/talleres")
	public ResponseEntity<Object> getTalleres() {
		return new ResponseEntity<>(talleres.values(), HttpStatus.OK);
	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de devolver un taller, introduciendo su
	 * nombre.
	 * </p>
	 *
	 * @param nombre Cada taller es identificado por un nombre.
	 * @return Devuelve un taller por su nombre en caso de que exista.
	 */
	@RequestMapping(value = "/talleres/{nombreTaller}")
	public ResponseEntity<Object> getAlumnoId(@PathVariable("nombreTaller") String nombre) {
		return new ResponseEntity<>(talleres.get(nombre), HttpStatus.OK);
	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de borrar monitores de un taller, introduciendo el nombre del taller y
	 * el id del monitor.
	 * </p>
	 *
	 * @param nombreTaller Cada taller es identificado por un nombre.
	 * @param dni Cada Monitor es identificado por un dni.
	 * @return Devuelve un mensaje de estado en caso de completarse la funcion
	 *         correctamente.
	 */
	@DeleteMapping(value = "/talleres/{nombreTaller}/monitores/{dni}")
	public ResponseEntity<Object> deleteTallerMonitor(@PathVariable("nombreTaller") String nombreTaller,
			@PathVariable("dni") String dni) {
		talleres.get(nombreTaller).removeMonitor(dni);
		return new ResponseEntity<>("Monitor del Taller borrado satisfactoriamente", HttpStatus.OK);
	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de actualizar monitores de un taller, introduciendo el nombre del taller y
	 * el id del monitor.
	 * </p>
	 *
	 * @param nombreTaller Cada taller es identificado por un nombre.
	 * @param dni Cada Monitor es identificado por un dni.
	 * @param monitor Datos nuevos del monitor a actualizar.
	 * @return Devuelve un mensaje de estado en caso de completarse la funcion
	 *         correctamente.
	 */
	@PutMapping(value = "/talleres/{nombreTaller}/monitores/{dni}")
	public ResponseEntity<Object> updateTallerMonitor(@PathVariable("nombreTaller") String nombreTaller,
			@PathVariable("dni") String dni, @RequestBody Monitor monitor) {
		talleres.get(nombreTaller).removeMonitor(dni);
		monitor.setDni(dni);
		talleres.get(nombreTaller).addMonitor(monitor);
		return new ResponseEntity<>("Monitor del Taller actualizado satisfactoriamente", HttpStatus.OK);
	}
	
	/**
	 * <p>
	 * Este metodo de mapeo se encarga de crear monitores de un taller, introduciendo el nombre del taller.
	 * </p>
	 *
	 * @param nombreTaller Cada taller es identificado por un nombre.
	 * @param monitor Datos del monitor nuevo a crear.
	 * @return Devuelve un mensaje de estado en caso de completarse la funcion
	 *         correctamente.
	 */
	@PostMapping(value = "/talleres/{nombreTaller}/monitores")
	public ResponseEntity<Object> createTallerMonitor(@PathVariable("nombreTaller") String nombreTaller,
			@RequestBody Monitor monitor) {
		talleres.get(nombreTaller).addMonitor(monitor);
		return new ResponseEntity<>("Monitor del Taller creado satisfactoriamente", HttpStatus.CREATED);
	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de devolver una lista monitores de un taller, introduciendo el nombre del taller.
	 * </p>
	 *
	 * @param nombreTaller Cada taller es identificado por un nombre.
	 * @return Devuelve la lista con todos los monitores de un taller.
	 */
	@RequestMapping(value = "/talleres/{nombreTaller}/monitores")
	public ResponseEntity<Object> getTalleresMonitores(@PathVariable("nombreTaller") String nombreTaller) {
		return new ResponseEntity<>(talleres.get(nombreTaller).getMonitores().values(), HttpStatus.OK);
	}

	/**
	 * <p>
	 * Este metodo de mapeo se encarga de devolver un monitor de un taller, introduciendo el nombre del taller y
	 * el id del monitor.
	 * </p>
	 *
	 * @param nombreTaller Cada taller es identificado por un nombre.
	 * @param dni Cada Monitor es identificado por un dni.
	 * @return Devuelve un monitor en caso de existir un monitor con ese dni en ese taller.
	 */
	@RequestMapping(value = "/talleres/{nombreTaller}/monitores/{dni}")
	public ResponseEntity<Object> getTallerMonitorDni(@PathVariable("nombreTaller") String nombreTaller,
			@PathVariable("dni") String dni) {
		return new ResponseEntity<>(talleres.get(nombreTaller).getMonitores().get(dni), HttpStatus.OK);
	}
}