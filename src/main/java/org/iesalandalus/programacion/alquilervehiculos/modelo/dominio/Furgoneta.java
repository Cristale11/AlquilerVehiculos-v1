package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

public class Furgoneta extends Vehiculo {
	private static int FACTOR_PMA = 100;
	private static int FACTOR_PLAZAS = 1;
	private int pma;
	private int plazas;

	public Furgoneta(String marca, String modelo, String matricula, int pma, int plazas) {
		super(marca, modelo, matricula);
		this.pma = pma;
		this.plazas = plazas;
	}

	public Furgoneta(Furgoneta furgoneta) {
		super(furgoneta);
		if (furgoneta == null) {
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
		setPlazas(furgoneta.plazas);
		setPma(furgoneta.pma);
	}

	public int getPma() {
		return pma;
	}

	private void setPma(int pma) {
		this.pma = pma;
	}

	public int getPlazas() {
		return plazas;
	}

	private void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	@Override
	public int getFactorPrecio() {
		// TODO Auto-generated method stub
		return pma / FACTOR_PMA + plazas * FACTOR_PLAZAS;
	}

	@Override
	public String toString() {
		return String.format("Furgoneta [pma=%s, plazas=%s]", pma, plazas);
	}

}
