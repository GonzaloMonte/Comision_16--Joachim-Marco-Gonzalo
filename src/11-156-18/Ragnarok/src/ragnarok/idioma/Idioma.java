package ragnarok.idioma;

public abstract class Idioma {
	
	protected String[] textoGanarEstado;
	protected String[] textoPuntajeEstado;
	protected String[] textoNuevoPuntajeEstado;
	protected String[] textoGameOverEstado;
	protected String[] textoNivelEstado;
	
	public Idioma() {
		textoGanarEstado = new String[1];
		textoPuntajeEstado = new String[1];
		textoNuevoPuntajeEstado = new String[3];
		textoGameOverEstado = new String[3];
		textoNivelEstado = new String[3];
		iniciarTexto();
	}
	
	protected abstract void iniciarTexto();
	
	public String[] getTextoGanarEstado() {
		return textoGanarEstado;
	}

	public String[] getTextoGameOverEstado() {
		return textoGameOverEstado;
	}

	public String[] getTextoNuevoPuntajeEstado() {
		return textoNuevoPuntajeEstado;
	}

	public String[] getTextoPuntajeEstado() {
		return textoPuntajeEstado;
	}

	public String[] getTextoNivelEstado() {
		return textoNivelEstado;
	}
	
	public abstract String getIdioma();
}
