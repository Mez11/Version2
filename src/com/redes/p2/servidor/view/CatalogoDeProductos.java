package com.redes.p2.servidor.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.redes.p2.model.Productos;
public class CatalogoDeProductos {

	private JFrame frmCatalogoDeProductos;


	/**
	 * Metodo para inicializar la vista de catalogos
	 * @param productosList Lista obtenida de la base de datos
	 * @wbp.parser.entryPoint
	 */
	public void init( List<Productos> productosList ) {
		frmCatalogoDeProductos = new JFrame();
		frmCatalogoDeProductos.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		frmCatalogoDeProductos.setForeground(Color.BLACK);
		frmCatalogoDeProductos.setTitle("Catalogo de productos");
		frmCatalogoDeProductos.setBounds(100, 100, 450, 383);
		frmCatalogoDeProductos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCatalogoDeProductos.getContentPane().setLayout(null);
		
		//como prueba, desplegar el ultimo producto agregado
		ProductoPanel prueba = new ProductoPanel( productosList.get( productosList.size( ) - 1 ) );
		prueba.setBounds( 35, 39, 228, 283 );
		frmCatalogoDeProductos.getContentPane( ).add( prueba );
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setBounds(275, 25, 159, 25);
		frmCatalogoDeProductos.getContentPane().add(btnAgregarProducto);
		btnAgregarProducto.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				AgregarProducto miProducto = new AgregarProducto();
				miProducto.init( );
			}
		});
		
		JLabel lblCatalogoDeProductos = new JLabel("Catalogo de Productos");
		lblCatalogoDeProductos.setBackground(SystemColor.info);
		lblCatalogoDeProductos.setBounds(25, 12, 193, 15);
		frmCatalogoDeProductos.getContentPane().add(lblCatalogoDeProductos);
		frmCatalogoDeProductos.setVisible(true);
	}

    
}
