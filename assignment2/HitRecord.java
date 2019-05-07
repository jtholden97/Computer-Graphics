package assignment2;

public class HitRecord {
	public double t;
	public Color color;
	public Normal n;
	public Point eye;
	public LightSource Light;
	public Point p;
	
	public HitRecord(double t, Color color, Normal n) {
		this.t = t;
		this.color = color;
		this.n = n;
	}
	
}
