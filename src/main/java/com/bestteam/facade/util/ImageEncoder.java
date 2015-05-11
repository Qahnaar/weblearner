package com.bestteam.facade.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

public class ImageEncoder {
	public static String imageToBase64String(File imageFile) throws Exception {

		String image = null;
		BufferedImage buffImage = ImageIO.read(imageFile);

		if (buffImage != null) {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(buffImage, "jpg", os);
			byte[] data = os.toByteArray();
			image = MyBase64.encode(data);
		}
		return image;
	}
}
