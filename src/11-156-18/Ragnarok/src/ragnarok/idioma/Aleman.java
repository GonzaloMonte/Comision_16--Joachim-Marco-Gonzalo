package ragnarok.idioma;

public class Aleman extends Idioma{
	
	public Aleman() {
		super();
	}

	protected void iniciarTexto() {
		textoGanarEstado[0] ="Du hast gewonnen";
		
		textoPuntajeEstado[0] = "Ergebnis:";
		
		textoGameOverEstado[0] = "Spiel ist aus";
		textoGameOverEstado[1] = "Ergebnis: ";
		textoGameOverEstado[2] = "drücken Sie die Escape-Taste";
		
		textoNuevoPuntajeEstado[0] = "neuer Highscore";
		textoNuevoPuntajeEstado[1] = "Puntaje: ";
		textoNuevoPuntajeEstado[2] = "Namen eingeben und Enter drücken: ";
		
		textoNivelEstado[0] = "Niveau ";
		textoNivelEstado[1] = "Ergebnis: ";
		textoNivelEstado[2] = "Extraleben: ";
	}
	
	public String getIdioma() {
		return "ALEMAN";
	}
}
