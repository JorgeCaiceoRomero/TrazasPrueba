package modelo;


import java.util.Random;

public interface Moveable {

	public default boolean visitarSuper() {
		int porcentaje = 10;
		boolean infectado = false;

		Random r = new Random();
		int numero = r.nextInt(100) + 1;

		if (numero <= porcentaje) {
			infectado = true;
		}

		return infectado;
	}

	public default boolean visitarTrabajo() {
		int porcentaje = 12;
		boolean infectado = false;

		Random r = new Random();
		int numero = r.nextInt(100) + 1;

		if (numero <= porcentaje) {
			infectado = true;
		}

		return infectado;
	}

	public default boolean cogerTransporte() {
		int porcentaje = 16;

		boolean infectado = false;

		Random r = new Random();
		int numero = r.nextInt(100) + 1;

		if (numero <= porcentaje) {
			infectado = true;
		}

		return infectado;
	}

}
