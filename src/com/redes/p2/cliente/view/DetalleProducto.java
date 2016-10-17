package com.redes.p2.cliente.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;

public class DetalleProducto {

	private JFrame frmDetalleDelProducto;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DetalleProducto window = new DetalleProducto();
					window.frmDetalleDelProducto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DetalleProducto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDetalleDelProducto = new JFrame();
		frmDetalleDelProducto.setTitle("Detalle del producto");
		frmDetalleDelProducto.setBounds(100, 100, 450, 300);
		frmDetalleDelProducto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDetalleDelProducto.getContentPane().setLayout(null);
		
		JLabel lblId = new JLabel("id");
		lblId.setBounds(12, 22, 70, 15);
		frmDetalleDelProducto.getContentPane().add(lblId);
		
		textField = new JTextField();
		textField.setBounds(146, 20, 114, 19);
		frmDetalleDelProducto.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setBounds(12, 43, 70, 15);
		frmDetalleDelProducto.getContentPane().add(lblNombre);
		
		JLabel lblNewLabel = new JLabel("precio");
		lblNewLabel.setBounds(12, 70, 70, 15);
		frmDetalleDelProducto.getContentPane().add(lblNewLabel);
		
		JLabel lblDescripcion = new JLabel("descripcion");
		lblDescripcion.setBounds(12, 97, 88, 15);
		frmDetalleDelProducto.getContentPane().add(lblDescripcion);
		
		JLabel lblOrigen = new JLabel("origen");
		lblOrigen.setBounds(12, 122, 70, 15);
		frmDetalleDelProducto.getContentPane().add(lblOrigen);
		
		JLabel lblExistencias = new JLabel("existencias");
		lblExistencias.setBounds(12, 149, 88, 15);
		frmDetalleDelProducto.getContentPane().add(lblExistencias);
		
		JLabel lblCantidadAComprar = new JLabel("cantidad a comprar");
		lblCantidadAComprar.setBounds(12, 176, 143, 15);
		frmDetalleDelProducto.getContentPane().add(lblCantidadAComprar);
		
		JButton btnCancelar = new JButton("cancelar");
		btnCancelar.setBounds(38, 234, 117, 25);
		frmDetalleDelProducto.getContentPane().add(btnCancelar);
		
		JButton btnComprar = new JButton("comprar");
		btnComprar.setBounds(246, 234, 117, 25);
		frmDetalleDelProducto.getContentPane().add(btnComprar);
		
		textField_1 = new JTextField();
		textField_1.setBounds(146, 41, 114, 19);
		frmDetalleDelProducto.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 68, 114, 19);
		frmDetalleDelProducto.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 95, 114, 19);
		frmDetalleDelProducto.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(146, 120, 114, 19);
		frmDetalleDelProducto.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(146, 147, 114, 19);
		frmDetalleDelProducto.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(186, 174, 28, 20);
		frmDetalleDelProducto.getContentPane().add(spinner);
	}
}
