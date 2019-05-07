package assignment2;

public class Point {
	public double x,y,z;
	
	public Point() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}
	
	public Point(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Point(Point point) {
		x = point.x;
		y = point.y;
		z = point.z;
	}
	
	public Point add(Point point) {
		return new Point(x + point.x, y + point.y, z + point.z);
	}
	
	public Point subtract(Point point) {
		return new Point(x - point.x, y - point.y, z - point.z);
	}
	
	public Vector subtract_vec(Point point) {
		return new Vector(x - point.x, y - point.y, z - point.z);
	}
	
	public double dot(Point point) {
		return x * point.x + y * point.y + z * point.z;
	}
	
	public double dot(Vector vector) {
		return x * vector.x + y * vector.y + z * vector.z;
	}
	
	public double dot(Normal normal) {
		return x * normal.x + y * normal.y + z * normal.z;
	}
}
