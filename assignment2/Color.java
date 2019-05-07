package assignment2;

public class Color {
	public float r, g, b;
	public double shininess;
	
	public Color() {
		r = 0.0F;
		g = 0.0F;
		b = 0.0F;
	}
	
	public Color(float r, float g, float b, double shininess) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.shininess = shininess;
	}
	
	public Color(Color color) {
		r = color.r;
		g = color.g;
		b = color.b;
		shininess = color.shininess;
	}
	
	public void add(Color color) {
		this.r += color.r;
		this.g += color.g;
		this.b += color.b;
		this.shininess = (this.shininess + color.shininess)/2;
	}
	
	public void divide(int scalar) {
		r /= scalar;
		g /= scalar;
		b /= scalar;
	}
	
	public int toInteger() {
		return (int)(r * 255) << 16 | (int)(g * 255)<<8 | (int)(b * 255);
	}
	
	public Color mult(Color color) {
		float newR = (r * color.r)/ (255);
		float newG = (g * color.g)/ (255);
		float newB = (b * color.b)/ (255);
		return new Color(newR, newG, newB, .5);
	}
}
