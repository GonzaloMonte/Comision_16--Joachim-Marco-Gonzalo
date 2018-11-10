package ragnarok.idioma;

public class Español extends Idioma{
	
	public Español() {
		super();
	}

	protected void iniciarTexto() {
		textoGanarEstado[0] ="Has ganado el juego";
		
		textoPuntajeEstado[0] = "Puntajes:";
		
		textoGameOverEstado[0] = "Fin del juego";
		textoGameOverEstado[1] = "Puntaje: ";
		textoGameOverEstado[2] = "Presione la tecla escape para ir al menu";
		
		textoNuevoPuntajeEstado[0] = "Nuevo puntaje record";
		textoNuevoPuntajeEstado[1] = "Puntaje: ";
		textoNuevoPuntajeEstado[2] = "Ingrese nombre y presione enter: ";
		
		textoNivelEstado[0] = "Nivel ";
		textoNivelEstado[1] = "Puntaje: ";
		textoNivelEstado[2] = "Vidas extra: ";
	}
	
	public String getIdioma() {
		return "ESPAÑOL";
	}
}
