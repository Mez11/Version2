/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplicaciones.practicas.uno.server;
import java.util.List;

import com.redes.p2.dao.ProductosDao;
import com.redes.p2.model.Productos;
import com.redes.p2.servidor.view.CatalogoDeProductos;
/**
 *
 * @author 
 */
public class EnvioCatalogo {
	//En esta clase no se interactua con ningun cliente
    //private ServerSocket serverSocket;
	
    //EnvioCatalogo se convierte en clase principal...
    public static void main( String [] args ){
		ProductosDao miProducto = new ProductosDao();
        List<Productos> list = null;
        CatalogoDeProductos catalogoDeProductos = new CatalogoDeProductos();
        
        System.out.println("Conectando a la base de datos");
        miProducto.inicializarConexion();
        
        System.out.println("Obteniendo catalogos");
        list = miProducto.getProductos();
        
        //CARGA CATALOGO DE PRODUCTOS
        //EDIT: Al inicio, solo se debe mostrar el catalogo de productos
        //(No los otros frames)
        System.out.println( "Cargando vista de catalogos..." );
        catalogoDeProductos.init( list );
        //agregarProducto.AgregarProducto();
        //editarProducto.getImagen();
		
        System.out.println( list );
	}
}
