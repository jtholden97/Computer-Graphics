package assignment2;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ScreenImage {
	public BufferedImage buffer;
	public File image;
	
	public ScreenImage(String fileName) {
		image = new File(fileName);
		buffer = new BufferedImage(Main.scene.viewplane.width, Main.scene.viewplane.height, BufferedImage.TYPE_INT_RGB);
	}
	
	public void write(String fileType) {
		try {
			ImageIO.write(buffer, fileType, image);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
