package ragnarok.graficos;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animacion {
	protected Array<TextureRegion> frames;
	protected float maxFrameTime;
	protected float currentFrameTime;
	protected int frameCount;
	protected int frame;
	
	protected boolean animando;
	
	public Animacion(TextureRegion region, int frameCount, float cycleTime) {
		frames = new Array<TextureRegion>();
		int frameWidth = region.getRegionWidth() / frameCount;
		for (int i = 0; i < frameCount; i++) {
			frames.add(new TextureRegion(region,i * frameWidth, 0 , frameWidth, region.getRegionHeight()));
		}
		this.frameCount = frameCount;
		maxFrameTime = cycleTime / frameCount;
		frame = 0;
		
		animando = true;
	}
	
	public void update (float dt) {
		currentFrameTime += dt;
		animando = true;
		if (currentFrameTime > maxFrameTime) {
			frame++;
			currentFrameTime = 0;
			
		}
		if (frame >= frameCount ) {
			frame = 0;
			animando = false;
		}
	}
	
	public boolean midFrame() {
		return currentFrameTime==maxFrameTime/2;
	}
	
	public TextureRegion getFrame() {
		return frames.get(frame); 
	}
	
	public boolean estaAnimando() {
		return animando;
	}
	
}