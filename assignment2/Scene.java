package assignment2;

import java.util.ArrayList;

public class Scene {
	public ViewPlane viewplane;
	public ArrayList<Surface> objects;
	public Color background;
	
	public Scene(int width, int height, double size) {
		viewplane = new ViewPlane(width, height, size);
		background = new Color(0.0F, 0.0F, 0.0F, .5);
		objects = new ArrayList<Surface>();
		objects.add(new Sphere(new Point(), 50, new Color(1.0F, 0.0F, 0.0F, .5)));
		objects.add(new Sphere(new Point(-100.0, 0.0, 100.0), 50, new Color(0.0F, 1.0F, 0.0F, .5)));
		objects.add(new Sphere(new Point(100.0, 0.0, -100.0), 50, new Color(0.0F, 0.0F, 1.0F, .5)));
		//objects.add(new Plane(new Point(), new Normal(0.0, 1.0, .25), new Color(1.0F, 1.0F, 0.0F, .5)));
	}
}
