package ar.edu.unlam.tp9;

import java.util.Scanner;

public class tp9 {

	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		// ejercicio 8
		/*
		 * registrarse, va a guardarse en el array
		 * 
		 */

		Sistema sistema = CrearSistema();

		int opcion = 0;
		do {
			System.out.println("MENU");
			System.out.println("\n1. REGISTRARSE" + "\n2. LOGIN" + "\n0. SALIR");
			System.out.println("\n.Ingrese la opcion de menu: ");
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				crearUsuario(sistema);
				break;
			case 2:
				login(sistema);
				break;
			case 0:
				break;

			default:
				break;
			}
		} while (opcion != 0);
	}

	private static void login(Sistema sistema) {
		System.out.println("Ingrese nombre de usuario");
		String nombre = teclado.next();
		System.out.println("Ingrese contraseña");
		String pass = teclado.next();

		if (sistema.iniciarSesion(nombre, pass)) {
			System.out.println("La sesion se inicio correctamente");
		} else {
			System.out.println("Usuario y/o contraseña invalido, intente nuevamente");
		}

	}

	private static Sistema CrearSistema() {
		System.out.println("\nIngrese el nombre del sistema");
		teclado.next();
		System.out.println("\nIngrese la cantidad de usuarios que quiera ingresar en el sistema");
		Integer cantidadUsuarios = teclado.nextInt();
		Sistema sistema = new Sistema(cantidadUsuarios);
		return sistema;
	}

	private static void crearUsuario(Sistema sistema) {
		System.out.println("cree su nombre de usuario");
		String nombre = teclado.next();

		String contraseña = "";
		do {
			System.out.println("cree su contraseña");
			System.out.println("esta debe contener, 1 letra en mayuscula, 1 letra en minusccula y 6 numeros");
			contraseña = teclado.next();

		} while (sistema.verificarContraseña(contraseña) == false);

		Usuario usuario = new Usuario(nombre, contraseña);
		if (sistema.registrarUsuario(usuario)) {
			System.out.println("el usuario se creo correctamente");
		} else {
			System.out.println("no se pudo crear el usuario, intente nuevamente");
		}
	}

}
