package assignment2;

public class Vector {
	public double x;
	public double y;
	public double z;
	
	public Vector() {
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Vector(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector(Vector vector) {
		x = vector.x;
		y = vector.y;
		z = vector.z;
	}
	public Vector add(Vector vector) {
		return new Vector(x + vector.x, y + vector.y, z + vector.z);
	}
	public Vector sub(Vector vector) {
		return new Vector(x - vector.x, y - vector.y, z - vector.z);
	}
	
	public double dot(Vector vector) {
		return x * vector.x + y * vector.y + z * vector.z;
	}
	
	public double dot(Point point) {
		return x * point.x + y * point.y + z * point.z;
	}
	
	public double dot(Normal normal) {
		return x * normal.x + y * normal.y + z * normal.z;
	}
	public void normalize() {
		double magnitude = Math.sqrt(x*x + y*y + z*z);
		x /= magnitude;
		y /= magnitude;
		z /= magnitude;
	}

	public Vector cross(Vector vector) {
		return new Vector(this.y * vector.z - this.z * vector.y, this.z * vector.x - this.x * vector.z, this.x * vector.y - this.y * vector.x);
	}
	public Vector mult(double scalar) {
		return new Vector(x*scalar, y * scalar, z * scalar);
	}
	
//	public static Vector cross(Vector a, Vector b) {
//		double tempx;
//		double tempy;
//		double tempz;
//		
//		tempx = (a.y * b.z) - (a.z * b.y);
//		tempy = (a.z * b.x) - (a.x * b.z);
//		tempz = (a.x * b.y) - (a.y * b.x);
//		a.x = tempx;
//		a.y = tempy;
//		a.z = tempz;
//		return a;
//	}
}
