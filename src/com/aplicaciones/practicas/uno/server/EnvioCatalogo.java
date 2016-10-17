/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones.practicas.uno.server;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import com.redes.dao.ProductosDao;
import com.redes.p2.servidor.view.AgregarProducto;
import com.redes.p2.servidor.view.CatalogoDeProductos;
import com.redes.p2.servidor.view.EditarProducto;

import java.io.ObjectOutputStream;
import java.util.List;
/**
 *
 * @author 
 */
public class EnvioCatalogo {
    private ServerSocket serverSocket;
	
	/**
	 *  Cierra la conexion con el socket }. 
	**/
	public void close( ){
		if( serverSocket == null ){
			System.out.println( "El servidor no se a inicializado" );
		}
		try {
			serverSocket.close( );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
        
        public void catalogo(){
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
                ObjectOutputStream oos = null;
		ProductosDao miProducto = new ProductosDao();
                List list = null;
                CatalogoDeProductos catalogoDeProductos = new CatalogoDeProductos();
                AgregarProducto agregarProducto = new AgregarProducto();
                EditarProducto editarProducto = new EditarProducto();	
                
                
		
		if( serverSocket == null ){
			System.out.println( "El servidor no a sido inicializado" );
			return ;
		}
		
		try {
                    
			System.out.println( "Esperando conexion @.%..." );
                   
                         System.out.println("Conectando a la base de datos");
                        miProducto.inicializarConexion();
                        
                        System.out.println("Obteniendo catalogo");
                        list = miProducto.getProductos();
                        System.out.println("Agregando productos");
                        
                        
                        System.out.println("Editando productos");
                        
		



                     //CARGA CATALOGO DE PRODUCTOS
                    
                    
                    
                      catalogoDeProductos.CatalogoDeProductos();
                      agregarProducto.AgregarProducto();
                      editarProducto.getImagen();
                      
			socket = serverSocket.accept( );
                        
                       
                       
                       
                        
			System.out.println( "Conexion aceptada " + socket.getInetAddress( ).getHostAddress( ) );
			oos= new ObjectOutputStream(socket.getOutputStream());
                        dis = new DataInputStream( socket.getInputStream( ) );
			dos = new DataOutputStream( socket.getOutputStream( ) );
			
                          System.out.println(list);
                     
			//Request the number of files being transfered...
			oos.writeObject(list);
                        System.out.println("Catalogo enviado");
                        
			dis.close( );
			//socket.close( );
			
		} catch (IOException e) {
			e.printStackTrace( );
			return;
		}
		
	}
        
        
        
        
        public boolean init( int port ){
		try {
			serverSocket = new ServerSocket( port );
                      
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
