package assignment2;

public class LightSource {
	public Point location;
	public Color color;
	//diffuse color (cd and ld)
	//specular color (cs and ls)
	// ambient color (ca and la)
	//emit color (ce and le)
	
	//cd * ld = [cd.r * ld.r, cd.g * ld.g, cd.b * ld.b] //R,G,B
	
	//l - incoming light vector
	//n - the normal of the plane/vertex
	//r - the reflection vector
	//v - the viewpoint (camera)
	//h = v + l
	//s - shininess
	//final color = (n * h)^s * cs * ls
	
	
	public LightSource(Point loc, Color color) {
		this.location = loc;
		this.color = color;
	}

//	public Color calcColor(LightSource light, ) {
//		
//	}
}
