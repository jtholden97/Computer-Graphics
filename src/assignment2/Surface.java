package assignment2;

public abstract class Surface {
	
	public Color color;
	public abstract HitRecord hit(Ray ray);
}
