package assignment2;

public abstract class Sampler {
	public int samples;
	
	public abstract Point2D sample(int row, int col, int x, int y);
	
}
