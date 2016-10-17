package com.redes.p2.servidor.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.redes.p2.model.Productos;

public class ProductoPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6789727953580545184L;
	
	/**
	 * Metodo que despliega la imagen especificada en el JLabel,
	 * modificando su tamaño para que no se vea rara
	 * @param imageArray byteArray que contiene los bytes de la imagen
	 * @param lblImagen JLabel donde desplegar la imagen
	 */
	private void displayImage( byte[] imageArray, JLabel lblImagen ){
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
	
	
	
	/**
	 * Clase para visualizar un producto en especifico
	 * @param producto El producto a desplegar
	 */
	public ProductoPanel( Productos producto ) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel( );
		lblNewLabel.setBounds(35, 25, 94, 93);
		displayImage( producto.getImagen(), lblNewLabel );
		add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre: " + producto.getNombre( ) );
		lblNombre.setBounds(25, 130, 196, 15);
		add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio: " + producto.getPrecio( ) );
		lblPrecio.setBounds(25, 149, 196, 15);
		add(lblPrecio);
		
		JLabel lblExistencia = new JLabel("Existencias: " + producto.getExistencias( ) );
		lblExistencia.setBounds(25, 163, 196, 15);
		add(lblExistencia);
		
		JButton btnNewButton = new JButton( "Editar" );
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cuando se de clic en "editar", llamar a la ventanita
				//de editar
				new EditarProducto( ).init( producto );
			}
		});
		btnNewButton.setBounds(25, 190, 117, 25);
		add(btnNewButton);
		
		JButton btnCancelar = new JButton("Eliminar");
		btnCancelar.setBounds(25, 227, 117, 25);
		add(btnCancelar);
		
	}

	

}
