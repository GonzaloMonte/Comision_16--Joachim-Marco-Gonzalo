package ragnarok.estados;

import java.util.Stack;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class JuegoEstadosManager {
	
	private Stack<Estado> estados;
	
	public JuegoEstadosManager() {
		estados = new Stack<Estado>();
	}
	
	public void push(Estado estado) {
		estados.push(estado);
	}
	
	public void pop() {
		estados.pop();
		
	}
	
	public void set(Estado estado) {
		estados.pop();
		estados.push(estado);
	}
	
	public void update(float dt) {
		estados.peek().update(dt);
	}
	
	public void render(SpriteBatch sb) {
		estados.peek().render(sb);
	}
}
