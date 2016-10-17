package com.redes.p2.servidor.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.redes.p2.dao.ProductosDao;
import com.redes.p2.model.Productos;

public class AgregarProducto {

	private JFrame frmAgregarProducto;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblImagen;
	/**
	 * variable para guardar el archivo que el usuario haya elegido
	 */
	private File imageFile;
	
	/**
	 * Metodo para extraer la imagen seleccionada por el usuario
	 * 
	 * @param producto
	 */
	private void extractImage( Productos producto ){
		//donde vamos a guardar los bytes de la imagen
		byte [] imageBytes = null;
		
		//validar que haya una imagen
		if( imageFile == null ){
			return;
		}
		
		//extraer los bytes de la imagen
		try {
			imageBytes = Files.readAllBytes( imageFile.toPath( ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//comprobar si hubo algun error en la lectura de bytes
		if( imageBytes == null ){
			System.out.println( "Hubo un error en la lectura de la imagen" );
			return;
		}
		
		//si todo fue bien, colocar los bytes en el bean
		producto.setImagen( imageBytes );
		//Listo!
		
	}//end extractImage
	
	/**
	 * Metodo que se ejecuta cuando
	 * el usuario presiona el boton de "Aceptar" 
	 */
	private void onAcceptPressed( ){
		//AGREGAR PRODUCTOS
        Productos producto = new Productos();
        String nombre =textField_1.getText() ;
        String precio=textField_2.getText();
        String Existencias=textField_3.getText();
        String Descripcion=textField_4.getText();
        String Origen=textField_5.getText();
        if(nombre.replaceAll(" ", "").length()==0||precio.replaceAll(" ", "").length()==0||Existencias.replaceAll(" ", "").length()==0||Descripcion.replaceAll(" ", "").length()==0||Origen.replaceAll(" ", "").length()==0){
            JOptionPane.showMessageDialog( null, "Se detectaron campos vacios","ERROR",JOptionPane.ERROR_MESSAGE);
        }
        else{
	        producto.setNombre(nombre);
	        producto.setPrecio(Double.parseDouble(precio));
	        producto.setExistencias(Integer.parseInt(Existencias));
	        producto.setDescripcion(Descripcion);
	        producto.setOrigen(Origen);
	        //****EXTRAER LA IMAGEN*****
	        extractImage( producto );
	        
	        ProductosDao miProducto = new ProductosDao();
	        miProducto.inicializarConexion();
	        miProducto.create(producto);
	        int res=JOptionPane.showConfirmDialog( null, "¿Desea agregar otro producto?",null,JOptionPane.YES_NO_OPTION);
	        frmAgregarProducto.dispose();
	        if( res == 0 ){
	            init( );
	        }
        }//end if-else
	}//end onAcceptPressed

	/**
	 * @wbp.parser.entryPoint
	 */
	public void init() {
		frmAgregarProducto = new JFrame();
		frmAgregarProducto.setTitle("Agregar producto");
		frmAgregarProducto.setBounds(100, 100, 450, 300);
		frmAgregarProducto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgregarProducto.getContentPane().setLayout(null);
				
		lblImagen = new JLabel("Imagen");
		lblImagen.setBounds(181, 12, 70, 45);
		frmAgregarProducto.getContentPane().add( lblImagen );
		
		JButton btnEleguirImagen = new JButton("Eleguir imagen");
		btnEleguirImagen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getImagen( );
			}
		});
		btnEleguirImagen.setBounds(146, 69, 144, 25);
		frmAgregarProducto.getContentPane().add(btnEleguirImagen);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(22, 103, 70, 15);
		frmAgregarProducto.getContentPane().add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(22, 130, 70, 15);
		frmAgregarProducto.getContentPane().add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("Precio");
		lblNewLabel.setBounds(22, 157, 70, 15);
		frmAgregarProducto.getContentPane().add(lblNewLabel);
		
		JLabel lblExistencias = new JLabel("Existencias");
		lblExistencias.setBounds(22, 184, 96, 15);
		frmAgregarProducto.getContentPane().add(lblExistencias);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion");
		lblNewLabel_1.setBounds(22, 211, 106, 15);
		frmAgregarProducto.getContentPane().add(lblNewLabel_1);
		
		JLabel lblOrigen = new JLabel("Origen");
		lblOrigen.setBounds(22, 238, 70, 15);
		frmAgregarProducto.getContentPane().add(lblOrigen);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(319, 206, 117, 25);
		frmAgregarProducto.getContentPane().add(btnCancelar);
                btnCancelar.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
                           frmAgregarProducto.dispose();
			}
		});
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(319, 147, 117, 25);
		frmAgregarProducto.getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//cuando el usuario presione "aceptar",
				//llamar al metodo "onAcceptPressed"
				onAcceptPressed( );
			}
		});
		
		textField = new JTextField();
		textField.setBounds(110, 106, 124, 19);
		frmAgregarProducto.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
                
		textField_1 = new JTextField();
		textField_1.setBounds(110, 128, 124, 19);
		frmAgregarProducto.getContentPane().add(textField_1);
		textField_1.setColumns(10);
              
		
		textField_2 = new JTextField();
		textField_2.setBounds(110, 155, 124, 19);
		frmAgregarProducto.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(110, 182, 124, 19);
		frmAgregarProducto.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(110, 209, 124, 19);
		frmAgregarProducto.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(110, 236, 124, 19);
		frmAgregarProducto.getContentPane().add(textField_5);
		textField_5.setColumns(10);
        frmAgregarProducto.setVisible(true);
	}
	
	private void getImagen(){
		JFileChooser chooser = new JFileChooser( );
		FileNameExtensionFilter filtroImagen= new FileNameExtensionFilter("JPG, PNG","jpg","png");
		chooser.setFileFilter(filtroImagen);
		int r = chooser.showOpenDialog( null );
		if( r == JFileChooser.APPROVE_OPTION ){
			//llamamos al manejador del evento "Imagen seleccionada",
			//enviandole el archivo que el usuario elijio
			onSelectedImage( chooser.getSelectedFile( ) );
		}//end if approved
	}//end getImagen
	
	/**
	 * Metodo a ejecutar cuando el usuario elije una imagen
	 * @param selectedFile Archivo que el usuario escogio a traves
	 * del {@link JFileChooser}
	 */
	private void onSelectedImage( File selectedFile ){
		BufferedImage originalImage = null;
		Image resizedImage = null;
		ImageIcon image = null;
		
		try {
			//guardar el archivo elegido en la variable global
			imageFile = selectedFile;
			//Leer la imagen
			originalImage = ImageIO.read( imageFile );
			//Escalar la imagen
			//(Modificar su tamaño de tal forma que ocupe perfectamente el JLabel
			//en el que esta contenida)
			resizedImage = originalImage.getScaledInstance( 
					lblImagen.getWidth(), lblImagen.getHeight( ), Image.SCALE_SMOOTH );			
			//desplegar la imagen en el JLabel
			image = new ImageIcon( resizedImage );
			paintModel( image );
		} catch (IOException e) {
			e.printStackTrace();
		}//end try-catch
	}//end onSelectedImage
	
	
	private void paintModel(ImageIcon img){
		lblImagen.removeAll( );
		lblImagen.setIcon( img );
		frmAgregarProducto.getContentPane( ).add( lblImagen );
	}//end paintModel
}
