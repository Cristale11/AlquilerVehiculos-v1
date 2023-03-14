package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos extends Vehiculos {
	List<Turismo> coleccionTurismos;

	public Turismos() {
		super();
		coleccionTurismos = new ArrayList<>();
	}
}
