package assignment2;

//import java.awt.image.BufferedImage;
//import java.io.File;
//import javax.imageio.ImageIO;

public class Main {
	public static Scene scene;
	public static ScreenImage image;
	public static RayTracer rayTracer;
	public static Sampler sampler;
	public static Projection projection;
	public static LightSource light;
	public static void main(String[] args) {
//		for each pixel do
//			  compute viewing ray
//			  if ray hits an object with t in [0,inf) then
//			    compute normal vector n
//			    evaluate shading model and set pixel to the resulting color
//			  else
//			    set pixel to the background color
		
		long start = System.nanoTime();
		scene = new Scene(1280, 720, 1.0);
		image = new ScreenImage("JTImage.png");
		rayTracer = new RayTracer();
		sampler = new RegularSample(4);
		//projection = new Orthographic();
		projection = new Perspective(new Point(-200.0, 200.0, 600.0), new Point(), 30);
		//projection = new Perspective(new Point(400.0, 0.0, 400.0), new Point(), 30);
		light = new LightSource(new Point(0.0, 400.0, 400.0), new Color(255, 255, 255, 1));
		
		int width = scene.viewplane.width;
		int height = scene.viewplane.height;
		
		//for each vertical pixel
		for (int y = 0; y < height; y++) {
			//for each horizontal pixel
			for (int x = 0; x <width; x++) {
				rayTracer.trace(x, y);
			}
		}
		image.write("PNG");
		
		
		long end = System.nanoTime();
		System.out.println("Loop time = " + (end/start)/1000000000.0F);
		
	}

}
