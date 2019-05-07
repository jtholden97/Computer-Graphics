package assignment2;

public class Ray {
	public Point origin;
	public Vector direction;
	
	public Ray() {
		origin = new Point();
		direction = new Vector();
	}
	
	public Ray(Point origin, Vector direction) {
		this.origin = new Point(origin);
		this.direction = new Vector(direction);
	}
}
