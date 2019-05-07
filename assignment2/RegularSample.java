package assignment2;

public class RegularSample extends Sampler{
	public RegularSample(int samples) {
		this.samples = samples;
	}
	
	public Point2D sample(int row, int col, int x, int y) {
		Point2D point = new Point2D();
		point.x = x - Main.scene.viewplane.width/2 + (col + 0.5)/samples;
		point.y = y - Main.scene.viewplane.height/2 + (row + 0.5)/samples;
		return point;
	}
}
