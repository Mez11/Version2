package com.aplicaciones.practicas.uno.server;

//import com.aplicaciones.practicas.uno.MyFile;

public class RunnerServer {
	private static final int DEFAULT_PORT = 4070;
	private static EnvioCatalogo envio;
	
	private static void addShutdownHook( ){
		Runtime.getRuntime().addShutdownHook( new Thread( ){
			public void run( ){
				envio.close( );
			}
		});
	}
	
	public static void main( String args[] ){
		int port;
		port = DEFAULT_PORT;
		System.out.println( "Usando el puerto " + port );
		envio = new EnvioCatalogo( );
		if( !envio.init( port ) ){
			System.out.println( "Previos errores, el envio no puede iniciar @.#.." );
		}
		envio.catalogo();
		addShutdownHook( );
	}
	
}
