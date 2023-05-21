package ar.edu.unlam.tp9;

public class Sistema {

	private Usuario[] usuarios;

	public Sistema(Integer cantidadUsuarios) {
		this.usuarios = new Usuario[cantidadUsuarios];
	}

	public boolean iniciarSesion(String nombre, String pass) {

		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] != null && usuarios[i].getNombre().equals(nombre)
					&& usuarios[i].getContraseña().equals(pass)) {
				return true;
			}
		}
		return false;

	}

	public boolean registrarUsuario(Usuario usuario) {
		// verificar si no hay ya una cuenta existente con el mismo nombre
		if (verificarSiElUsuarioExiste(usuario)) {
			guardarUsuario(usuario);
			return true;
		}
		return false;
	}

	private boolean guardarUsuario(Usuario usuario) {
		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null) {
				usuarios[i] = usuario;
				return true;
			}
		}
		return false;

	}

	private boolean verificarSiElUsuarioExiste(Usuario usuario) {
		for (int i = 0; i < usuarios.length; i++) {
			if (this.usuarios[i] != null) {
				if (this.usuarios[i].getNombre().equals(usuario.getNombre())) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean verificarContraseña(String pass) {
		// requisitos contraseña valida

		boolean maximo = caracterMaximo(pass);
		boolean mayuscula = caracterMayuscula(pass);
		boolean minuscula = caracterMinuscula(pass);
		boolean numero = caracterNumero(pass);

		return maximo && mayuscula && minuscula && numero;

	}

	private boolean caracterNumero(String pass) {
		final int NUM_Digits = 6;
		int digitCounter = 0;
		for (int i = 0; i < pass.length(); i++) {
			char c = (char) pass.charAt(i);
			if (Character.isDigit(c)) {
				digitCounter++;
			}
		}
		if (digitCounter >= NUM_Digits) {
			return true;
		} else {

		}
		return false;

	}

	private boolean caracterMinuscula(String pass) {
		final int MIN_Lowercase = 1;
		int lowercaseCounter = 0;
		for (int i = 0; i < pass.length(); i++) {
			char letra = pass.charAt(i);
			if (Character.isLowerCase(letra)) {
				lowercaseCounter++;
			}
		}
		if (lowercaseCounter >= MIN_Lowercase) {
			return true;
		} else {
			return false;
		}

	}

	private boolean caracterMayuscula(String pass) {
		final int MIN_Uppercase = 1;
		int uppercaseCounter = 0;

		for (int i = 0; i < pass.length(); i++) {
			char letra = pass.charAt(i);
			if (Character.isUpperCase(letra)) {
				uppercaseCounter++;
			}
		}
		if (uppercaseCounter >= MIN_Uppercase) {
			return true;
		} else {

		}
		return false;

	}

	private boolean caracterMaximo(String pass) {
		return pass.length() >= 8;
	}

}
