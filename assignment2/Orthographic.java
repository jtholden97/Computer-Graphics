package assignment2;

public class Orthographic extends Projection {
	public Ray createRay(Point2D point) {
		Ray ray = new Ray();
		
		ray.origin.x = Main.scene.viewplane.size * point.x;
		ray.origin.y = Main.scene.viewplane.size * point.y;
		ray.origin.z = 100;
		
		ray.direction.x = 0.0;
		ray.direction.y = 0.0;
		ray.direction.z = -1.0;
		
		return ray;
	}

}
