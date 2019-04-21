package assignment2;

public class Perspective extends Projection{
	public Perspective(Point camera, Point lookat, double FOV) {
		this.camera = new Point(camera);
		this.lookat = new Point(lookat);
		this.distance = Main.scene.viewplane.height/2/Math.tan(Math.toRadians(FOV));
		compute_uvw();
	}
	
	public Ray createRay(Point2D point) {
		Ray ray = new Ray(new Point(camera), u.mult(point.x).add(v.mult(point.y).sub(w.mult(distance))));
		ray.direction.normalize();
		return ray;
		}
	
}

