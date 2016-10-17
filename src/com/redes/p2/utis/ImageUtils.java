package com.redes.p2.utis;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageUtils {

	/**
	 * Metodo que despliega la imagen especificada en el JLabel,
	 * modificando su tamaño para que no se vea rara
	 * @param imageArray byteArray que contiene los bytes de la imagen
	 * @param lblImagen JLabel donde desplegar la imagen
	 */
	public static void displayPrettyImage( byte[] imageArray, JLabel lblImagen ){
		BufferedImage originalImage = null;
		ByteArrayInputStream bais = null;
		Image resizedImage = null;
		ImageIcon image = null;
		
		try {
			//Inicializar el flujo con base en los bytes
			bais = new ByteArrayInputStream( imageArray );
			//Leer la imagen
			originalImage = ImageIO.read( bais );
			//Escalar la imagen
			//(Modificar su tamaño de tal forma que ocupe perfectamente el JLabel
			//en el que esta contenida)
			resizedImage = originalImage.getScaledInstance( 
					lblImagen.getWidth(), lblImagen.getHeight( ), Image.SCALE_SMOOTH );			
			//desplegar la imagen en el JLabel
			image = new ImageIcon( resizedImage );
			lblImagen.setIcon( image );
		} catch (IOException e) {
			e.printStackTrace();
		}//end try-catch
	}//end onSelectedImage
}
