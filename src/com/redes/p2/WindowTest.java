package com.redes.p2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WindowTest {

	private JFrame frame;
	private JTextField tfDireccion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowTest window = new WindowTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDireccionDelServidor = new JLabel("Direccion del servidor");
		lblDireccionDelServidor.setBounds(42, 33, 200, 15);
		frame.getContentPane().add(lblDireccionDelServidor);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(270, 31, 114, 19);
		frame.getContentPane().add(tfDireccion);
		tfDireccion.setColumns(10);
		
		JButton btnConectarse = new JButton("Conectarse");
		btnConectarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println( "Aqui conectate..." );
			}
		});
		btnConectarse.setBounds(174, 142, 117, 25);
		frame.getContentPane().add(btnConectarse);
	}
}
