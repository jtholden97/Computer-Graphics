package assignment2;
public class RayTracer {
	
	public void trace(int x, int y) {
		//background color by default
		Color color = new Color(0.0F, 0.0F, 0.0F, .5);
		boolean hit = false;
		for (int row = 0; row  < Main.sampler.samples; row++) {
			for (int col = 0; col < Main.sampler.samples; col ++) {
				Point2D point = Main.sampler.sample(row, col, x, y);
				Ray ray = Main.projection.createRay(point);
			
				//pseudo infinity
				double min = Double.MAX_VALUE;
				Color tempColor = Main.scene.background;
				Color shadedColor;
				Color finalColor = Main.scene.background;;
				//if the ray hits an object it takes the closest objects color and calculates the pixel
				for(int i = 0; i < Main.scene.objects.size(); i++) {
					HitRecord hr = Main.scene.objects.get(i).hit(ray);
					double temp = hr.t;
					hr.Light = Main.light;
					if(temp != 0.0 && temp < min) {
						min = temp;
						hit = true;
						tempColor = Main.scene.objects.get(i).color;
						hr.color = tempColor;
						Vector lightVector = new Vector(hr.Light.location.x - hr.p.x, hr.Light.location.y - hr.p.y, hr.Light.location.z - hr.p.z);
						//this part figures out h which is viewpoint vector + light vector, normalized
						//Vector v = new Vector(Main.projection.camera.subtract_vec(Main.projection.lookat));
						//Vector v = new Vector(Main.projection.camera.subtract_vec(hr.p));
						Vector v = new Vector(Main.projection.camera.subtract_vec(hr.p));
						
						v.normalize();

						lightVector.normalize();
						Vector h = new Vector(v.add(lightVector));
						h.normalize();

						
						//Vector nl = new Vector(hr.n.x * lightVector.x, hr.n.y * lightVector.y, hr.n.z * lightVector.z);
						double dot = lightVector.dot(hr.n);
						if(dot < 0)
							dot = 0;
						
						double nhDot = h.dot(hr.n);
						if(nhDot < 0) {
							nhDot = 0;
						}
						Color white = new Color(1.0F, 1.0F, 1.0F, 100);
						nhDot = Math.pow(nhDot, 100);

						// need ambient
						Color ambient = new Color(tempColor.r * .1F, tempColor.g * .1F, tempColor.b * .1F, 1); 
						Color diffuse = new Color((float)(tempColor.r * dot), (float)(tempColor.g * dot), (float)(tempColor.b  * dot), .5);
						Color phong = new Color((float)(nhDot * white.r), (float)(nhDot * white.g), (float)(nhDot * white.b), .5);

						finalColor = new Color(0, 0, 0, 1);
						// then add each component
						diffuse.add(ambient);
						diffuse.add(phong);
						finalColor.add(diffuse);
					}
				}
				color.add(finalColor);
			}
		}
		color.divide(Main.sampler.samples * Main.sampler.samples);
		if (color.r > 1) color.r = 1;
		if (color.g > 1) color.g = 1;
		if (color.b > 1) color.b = 1;
		if(hit)
			Main.image.buffer.setRGB(x, Main.scene.viewplane.height - y - 1, color.toInteger());
		else
			Main.image.buffer.setRGB(x, Main.scene.viewplane.height - y - 1, Main.scene.background.toInteger());
	}
	
}	