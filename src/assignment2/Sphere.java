package assignment2;


public class Sphere extends Surface{
	public Point center;
	public double radius;
	
	public Sphere(Point center, double radius, Color color) {
		this.center = new Point(center);
		this.radius = radius;
		this.color = new Color(color);
	}
	
	public HitRecord hit(Ray ray){
		double a = ray.direction.dot(ray.direction);
		double b = 2 * ray.origin.subtract(center).dot(ray.direction);
		double c = ray.origin.subtract(center).dot(ray.origin.subtract(center)) - radius * radius;
		double discriminant = b*b - 4 * a * c;
		HitRecord hr = new HitRecord(0.0, new Color(), new Normal());
		//normal = normalize(P - C). P is vector position on sphere and C is center
		//normal vector at point p is n = 2(p - c) where c is center
		//hr.n = 
		
		//ray did not hit
		if(discriminant < 0.0) {
			hr.t = 0.0;
			return hr;
		}
		//ray did hit
		else {
			double t = (-b - Math.sqrt(discriminant))/(2*a);
			if(t > 10E-9) {
				hr.t = t;
				//p(t) = e + td
				double vx = ray.direction.x * t;
				double vy = ray.direction.y * t;
				double vz = ray.direction.z * t;
				Point td = new Point(vx, vy, vz);
				Point pt = new Point(td.x + ray.origin.x, td.y + ray.origin.y, td.z + ray.origin.z);
				hr.p = pt;
				//normal = normalize (p - c)
				Normal n = new Normal(pt.subtract(center));
//				n.x /= radius;
//				n.y /= radius;
//				n.z /= radius;
				n.normalize();
				hr.n = n;
				hr.eye = ray.origin;
				return hr;
			}
			else{
				hr.t = 0.0;
				return hr;
			}
		}
	}
}
