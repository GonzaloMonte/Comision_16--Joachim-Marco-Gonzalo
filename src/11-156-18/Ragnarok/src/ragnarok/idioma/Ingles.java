package ragnarok.idioma;

public class Ingles extends Idioma{
	
	public Ingles() {
		super();
	}

	protected void iniciarTexto() {
		textoGanarEstado[0] ="You won the game";
		
		textoPuntajeEstado[0] = "Score: ";
		
		textoGameOverEstado[0] = "Game over";
		textoGameOverEstado[1] = "Score: ";
		textoGameOverEstado[2] = "Press escape to return to the menu";
		
		textoNuevoPuntajeEstado[0] = "New highscore";
		textoNuevoPuntajeEstado[1] = "Score: ";
		textoNuevoPuntajeEstado[2] = "Insert name and press enter: ";
		
		textoNivelEstado[0] = "Level ";
		textoNivelEstado[1] = "Score: ";
		textoNivelEstado[2] = "Extra lives: ";
	}
	
	public String getIdioma() {
		return "INGLES";
	}
}
