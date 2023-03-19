package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class Vehiculos {
	private List<Vehiculo> coleccionVehiculos;

	public Vehiculos() {
		coleccionVehiculos = new ArrayList<>();
	}
	
	public List<Vehiculo> get() {
		return Collections.unmodifiableList(coleccionVehiculos);
	}

	public int getCantidad() {
		return coleccionVehiculos.size();
	}

	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede insertar un vehículo nulo.");
		}
		if (coleccionVehiculos.contains(vehiculo)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un vehículo con esa matrícula.");
		} else {
			coleccionVehiculos.add(vehiculo);
		}
	
	}

	public Vehiculo buscar(Vehiculo vehiculo) {
		if(vehiculo == null)
			throw new NullPointerException("ERROR: No se puede buscar un vehículo nulo.");		
		for (Vehiculo vehiculoTemp : coleccionVehiculos) {
			if (vehiculoTemp.equals(vehiculo)) {
				return vehiculoTemp;
			}
		}
		return null;
	}

	public void borrar(Vehiculo vehiculo) throws OperationNotSupportedException {
		if (vehiculo == null) {
			throw new NullPointerException("ERROR: No se puede borrar un vehículo nulo.");
		}
		if (!coleccionVehiculos.contains(vehiculo)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		}
		coleccionVehiculos.remove(vehiculo);
	}

}