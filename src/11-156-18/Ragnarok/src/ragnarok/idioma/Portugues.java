package ragnarok.idioma;

public class Portugues extends Idioma {
	
	public Portugues() {
		super();
	}

	protected void iniciarTexto() {
		textoGanarEstado[0] ="Voce completou o jogo";
		
		textoPuntajeEstado[0] = "Partitura:";
		
		textoGameOverEstado[0] = "Fim de jogo";
		textoGameOverEstado[1] = "Partitura: ";
		textoGameOverEstado[2] = "Pressione escape para retornar ao menu";
		
		textoNuevoPuntajeEstado[0] = "Novo recorde";
		textoNuevoPuntajeEstado[1] = "Partitura: ";
		textoNuevoPuntajeEstado[2] = "Insira o nome e pressione enter: ";
		
		textoNivelEstado[0] = "Nivel ";
		textoNivelEstado[1] = "Partitura: ";
		textoNivelEstado[2] = "Vidas extras: ";
	}
	
	public String getIdioma() {
		return "PORTUGUES";
	}

}
