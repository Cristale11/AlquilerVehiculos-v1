package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class Vehiculos {
	private List<Vehiculo> coleccionVehiculos;

	public Vehiculos() {
		super();
		coleccionVehiculos = new ArrayList<>();
	}

	public List<Vehiculo> get() {
		return new ArrayList<>(coleccionVehiculos);
	}

	public int getCantidad() {
		return coleccionVehiculos.size();
	}

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		if (turismo != null && !coleccionVehiculos.contains(turismo)) {
			coleccionVehiculos.add(turismo);
		} else {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}
	
	}

	public Vehiculo buscar(Vehiculo turismo) {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}
		int indice = coleccionVehiculos.indexOf(turismo);
		if (indice != -1) {
			return coleccionVehiculos.get(indice);
		}
		return null;
	}

	public void borrar(Vehiculo turismo) throws OperationNotSupportedException {
		if (turismo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}
		if (!coleccionVehiculos.remove(turismo)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		}
	}

}