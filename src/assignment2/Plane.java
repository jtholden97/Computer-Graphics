package assignment2;

public class Plane extends Surface{
	Point point;
	Normal normal;
	
	public Plane(Point point, Normal normal, Color color) {
		this.point = new Point(point);
		this.normal = new Normal(normal);
		this.color = new Color(color);
	}
	
	public HitRecord hit(Ray ray)
	{
		// t = (a - c) * n / d * n
		HitRecord hr = new HitRecord(0.0, new Color(), new Normal());
		double t = point.subtract(ray.origin).dot(normal)/ray.direction.dot(normal);
		if(t > 10E-9){
			hr.t = t;
			hr.p = point;
			return hr;
		}
		else {
			hr.t = 0.0;
			return hr;
		}
	}
}
