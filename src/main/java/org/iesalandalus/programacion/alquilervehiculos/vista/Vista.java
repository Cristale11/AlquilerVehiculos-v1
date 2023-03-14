package org.iesalandalus.programacion.alquilervehiculos.vista;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class Vista {

	private Controlador controlador;

	public void setControlador(Controlador controlador) {
		if (controlador == null) {
			throw new NullPointerException("El controlador es nulo");
		}
		this.controlador = controlador;
	}

	public void comenzar() {
		Consola.mostrarMenu();
		ejecutar(Consola.elegirOpcion());
	}

	public void terminar() {
		System.out.println("Se ha terminado la vista");
	}

	private void ejecutar(Opcion opcion) {
		switch (opcion.ordinal()) {
		case 0:
			controlador.terminar();
			break;
		case 1:
			insertarCliente();
			comenzar();
			break;
		case 2:
			insertarTurismo();
			comenzar();
			break;
		case 3:
			insertarAlquiler();
			comenzar();
			break;
		case 4:
			buscarCliente();
			comenzar();
			break;
		case 5:
			buscarTurismo();
			comenzar();
			break;
		case 6:
			buscarAlquiler();
			comenzar();
			break;
		case 7:
			modificarCliente();
			comenzar();
			break;
		case 8:
			devolverAlquiler();
			comenzar();
			break;
		case 9:
			borrarCliente();
			comenzar();
			break;
		case 10:
			borrarTurismo();
			comenzar();
			break;
		case 11:
			borrarAlquiler();
			comenzar();
			break;
		case 12:
			listarClientes();
			comenzar();
			break;
		case 13:
			listarTurismos();
			comenzar();
			break;
		case 14:
			listarAlquileres();
			comenzar();
			break;
		case 15:
			listarAlquileresCliente();
			comenzar();
			break;
		case 16:
			listarAlquileresTurismo();
			comenzar();
			break;
		}
	}

	private void insertarCliente() {
		Consola.mostrarCabecera("Inserta Cliente:");
		try {
			controlador.insertar(Consola.leerCliente());
			System.out.printf("El cliente ha sido introducido de manera correcta");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}

	}

	private void insertarTurismo() {
		Consola.mostrarCabecera("Inserta turismo:");
		try {
			controlador.insertar(Consola.leerTurismo());
			System.out.printf("Se ha introducido un turismo de manera correcta.");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void insertarAlquiler() {
		Consola.mostrarCabecera("Inserta alquiler:");
		try {
			controlador.insertar(Consola.leerAlquiler());
			System.out.printf("Se ha introducido un alquiler de manera correcta.");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void buscarCliente() {
		Consola.mostrarCabecera("Buscar cliente:");
		try {
			System.out.printf("%n%s%n", controlador.buscar(Consola.leerCliente()));
			System.out.printf("Se ha encontrado el cliente correctamente.");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void buscarTurismo() {
		Consola.mostrarCabecera("Buscar turismo:");
		try {
			System.out.printf("%n%s%n", controlador.buscar(Consola.leerTurismo()));
			System.out.printf("Se ha encontrado el turismo correctamente.");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void buscarAlquiler() {
		Consola.mostrarCabecera("Buscar alquiler:");
		try {
			System.out.printf("%n%s%n", controlador.buscar(Consola.leerAlquiler()));
			System.out.printf("Se ha buscado de manera correcta.");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void modificarCliente() {
		Consola.mostrarCabecera("Modificar clientes:");
		try {
			controlador.modificar(Consola.leerCliente(), Consola.leerNombre(), Consola.leerTelefono());
			System.out.printf("Se ha modificado el cliente de manera correcta.");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void devolverAlquiler() {
		Consola.mostrarCabecera("Devolver alquiler:");
		try {
			controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
			System.out.printf("Se ha devuelto el turismo");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void borrarCliente() {
		Consola.mostrarCabecera("Borrar cliente:");
		try {
			controlador.borrar(Consola.leerCliente());
			System.out.printf("Se ha borrado el cliente.");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void borrarTurismo() {
		Consola.mostrarCabecera("Borrar turismo:");
		try {
			controlador.borrar(Consola.leerTurismo());
			System.out.printf("Se ha borrado el turismo.");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void borrarAlquiler() {
		Consola.mostrarCabecera("Borrar alquiler:");
		try {
			controlador.borrar(Consola.leerAlquiler());
			System.out.printf("Se ha borrado el alquiler.");
		} catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarClientes() {
		Consola.mostrarCabecera("Lista cliente:");
		try {
			for (Cliente cliente : controlador.getClientes()) {
				System.out.printf("%s%n", cliente);
			}
			System.out.printf("Se han listado todos los clientes.");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarTurismos() {
		Consola.mostrarCabecera("Lista turismos:");
		try {
			for (Vehiculo turismo : controlador.getTurismos()) {
				System.out.printf("%s%n", turismo);
			}
			System.out.printf("Se han listado todos los turismos.");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarAlquileres() {
		Consola.mostrarCabecera("Lista alquileres:");
		try {
			for (Alquiler alquiler : controlador.getAlquileres()) {
				System.out.printf("%s%n", alquiler);
			}
			System.out.printf("Se han listado todos los alquileres.");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarAlquileresCliente() {
		Consola.mostrarCabecera("Listas de alquileres clientes");
		try {
			for (Alquiler alquilerCliente : controlador.getAlquileres(Consola.leerCliente())) {
				System.out.printf("%s%n", alquilerCliente);
			}
			System.out.printf("Se ha listado todos los alquileres de clientes.");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}

	private void listarAlquileresTurismo() {
		Consola.mostrarCabecera("Lista alquiler turismo");
		try {
			for (Alquiler alquilerTurismo : controlador.getAlquileres(Consola.leerTurismo())) {
				System.out.printf("%s%n", alquilerTurismo);
			}
			System.out.printf("Se ha listado todos los alquileres de turismo.");
		} catch (NullPointerException | IllegalArgumentException e) {
			System.out.printf("%s", e.getMessage());
		}
	}
}
