package com.redes.p2.servidor.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class CatalogoDeProductos {

	private JFrame frmCatalogoDeProductos;


	public void init() {
		frmCatalogoDeProductos = new JFrame();
		frmCatalogoDeProductos.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 17));
		frmCatalogoDeProductos.setForeground(Color.BLACK);
		frmCatalogoDeProductos.setTitle("Catalogo de productos");
		frmCatalogoDeProductos.setBounds(100, 100, 450, 300);
		frmCatalogoDeProductos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCatalogoDeProductos.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Imagen");
		lblNewLabel.setBounds(35, 25, 94, 93);
		frmCatalogoDeProductos.getContentPane().add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(25, 130, 70, 15);
		frmCatalogoDeProductos.getContentPane().add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(25, 149, 70, 15);
		frmCatalogoDeProductos.getContentPane().add(lblPrecio);
		
		JLabel lblExistencia = new JLabel("Existencia");
		lblExistencia.setBounds(25, 163, 85, 15);
		frmCatalogoDeProductos.getContentPane().add(lblExistencia);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(25, 190, 117, 25);
		frmCatalogoDeProductos.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Eliminar");
		btnCancelar.setBounds(25, 227, 117, 25);
		frmCatalogoDeProductos.getContentPane().add(btnCancelar);
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setBounds(257, 25, 159, 25);
		frmCatalogoDeProductos.getContentPane().add(btnAgregarProducto);
                btnAgregarProducto.addActionListener(new ActionListener(){
               
                    public void actionPerformed(ActionEvent e) {
                       AgregarProducto miProducto = new AgregarProducto();
                       miProducto.AgregarProducto();
                    }
                    
                });
		
		JLabel lblCatalogoDeProductos = new JLabel("Catalogo de Productos");
		lblCatalogoDeProductos.setBackground(SystemColor.info);
		lblCatalogoDeProductos.setBounds(25, 12, 193, 15);
		frmCatalogoDeProductos.getContentPane().add(lblCatalogoDeProductos);
                frmCatalogoDeProductos.setVisible(true);
	}

    
}
