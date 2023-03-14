package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Vehiculos;

public class Modelo {
	private Clientes clientes;
	private Alquileres alquileres;
	private Vehiculos turismos;

	public Modelo() {
		
	}

	public void comerzar() {
		clientes = new Clientes();
		turismos = new Turismos();
		alquileres = new Alquileres();
	}

	public void terminar() {
		System.out.println("AVISO: El modelo ha terminado");
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		clientes.insertar(new Cliente(cliente));
	}

	public void insertar(Vehiculo turismo) throws OperationNotSupportedException {
		turismos.insertar(new Turismo(turismo));
	}

	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if (alquiler == null) {
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}

		Cliente cliente = buscar(alquiler.getCliente());
		Vehiculo turismo = buscar(alquiler.getTurismo());

		if (cliente == null) {
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}
		if (turismo == null) {
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}

		alquileres.insertar(new Alquiler(new Cliente(cliente), new Turismo(turismo), alquiler.getFechaAlquiler()));
	}

	public Cliente buscar(Cliente cliente) {
		Cliente clienteBuscar = clientes.buscar(cliente);
		return (clienteBuscar == null) ? null : new Cliente(clienteBuscar);
	}

	public Vehiculo buscar(Vehiculo turismo) {
		Vehiculo turismoBuscar = turismos.buscar(turismo);
		return (turismoBuscar == null) ? null : new Turismo(turismoBuscar);
	}

	public Alquiler buscar(Alquiler alquiler) {
		return new Alquiler(alquileres.buscar(alquiler));
	}

	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		clientes.modificar(cliente, nombre, telefono);
	}

	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		alquiler = alquileres.buscar(alquiler);

		if (alquiler == null) {
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}

		alquiler.devolver(fechaDevolucion);
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		for (Alquiler alquilerBucle : alquileres.get(cliente)) {
			borrar(alquilerBucle);
		}
		clientes.borrar(cliente);
	}

	public void borrar(Vehiculo turismo) throws OperationNotSupportedException {
		for (Alquiler alquilerBucle : alquileres.get(turismo)) {
			borrar(alquilerBucle);
		}
		turismos.borrar(turismo);
	}

	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		alquileres.borrar(alquiler);
	}

	public List<Cliente> getClientes() {
		List<Cliente> listaCliente = new ArrayList<>();
		for (Cliente cliente : clientes.get()) {
			listaCliente.add(new Cliente(cliente));
		}
		return listaCliente;
	}

	public List<Turismo> getTurismos() {
		List<Turismo> listaTurismo = new ArrayList<>();
		for (Vehiculo turismo : turismos.get()) {
			listaTurismo.add(new Turismo(turismo));
		}
		return listaTurismo;
	}

	public List<Alquiler> getAlquileres() {
		List<Alquiler> listaAlquiler = new ArrayList<>();
		for (Alquiler alquiler : alquileres.get()) {
			listaAlquiler.add(new Alquiler(alquiler));
		}
		return listaAlquiler;
	}

	public List<Alquiler> getAlquileres(Cliente cliente) {
		ArrayList<Alquiler> alquilerArray = new ArrayList<>();
		for (Alquiler alquilerBucle : alquileres.get(cliente)) {
			alquilerArray.add(new Alquiler(alquilerBucle));
		}
		return alquilerArray;
	}

	public List<Alquiler> getAlquileres(Vehiculo turismo) {
		ArrayList<Alquiler> alquilerArray = new ArrayList<>();
		for (Alquiler alquilerBucle : alquileres.get(turismo)) {
			alquilerArray.add(new Alquiler(alquilerBucle));
		}
		return alquilerArray;
	}
}
