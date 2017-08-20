package com.col.planets;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Sun extends Planet {

	private float angle;
	private float angleMove;

	public Sun(String name, float x, float y, float radius, int resolution, Color color, ShapeRenderer renderer) {
		super(name, x, y, radius, resolution, color, renderer);
		// TODO Auto-generated constructor stub
		angleMove = (float) Math.PI * 2 / resolution;
		points = createPlanet();
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		points = createPlanet();
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		renderer.setColor(Color.YELLOW);
		renderer.polygon(points);
	}

	@Override
	protected float[] createPlanet() {
		float[] points = new float[(int) resolution * 2];
		angle = 0;
		for(int i = 0; i < points.length; i++) {
			if(i != 0 && (i % 2) == 0) {
				angle += angleMove;
			}
			if((i % 2) == 0) {
				points[i] = (float) (x + (radius * Math.cos(angle)));
			}else {
				points[i] = (float) (y + (radius * Math.sin(angle)));
			}
		}
		
		return points;
	}

}
