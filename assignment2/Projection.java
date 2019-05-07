package assignment2;



public abstract class Projection {
	public Point camera;
	public Point lookat;
	public double distance;
	public Vector u, v, w;
	
	public abstract Ray createRay(Point2D point);
	
	public void compute_uvw() {
		w = camera.subtract_vec(lookat);
		w.normalize();
		
		Vector up = new Vector(0.00424, 1.0, 0.00764);
		u = up.cross(w);		
		u.normalize();
		
		v = w.cross(u);
		v.normalize();
	}
}
