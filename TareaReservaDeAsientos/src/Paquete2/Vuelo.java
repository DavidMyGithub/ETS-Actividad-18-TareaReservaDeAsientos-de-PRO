package Paquete2;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Paquete1.Constantes;
import Paquete3.VentanaVuelos.OyenteBotonera;

public class Vuelo {
	private  String nombre;
	private  Asiento[][]  asiento_avion;
	
	public Vuelo(String nombre) {
		this.nombre = nombre;
		this.asiento_avion = new Asiento [Constantes.num_filas][Constantes.num_columnas];
		//asignando asientos a la matriz
		int f = Constantes.getNum_filas();
	    int c = Constantes.getNum_columnas();
	    this.asiento_avion = new Asiento[f][c];
	    for(int a=0; a<f; a++) {
	    	for(int b=0; b<c; b++) {
	    		this.asiento_avion[a][b] = new Asiento();
	    		if(a%2 == 0 || b == 0) {
	    			asiento_avion [a][b].setPrecio(31.0);
	    		}
	    	}
	    }
	}
	
	
	public void mostrarPrecioAsiento(int numfila, int numcolumna) {		
		if(asiento_avion [numfila][numcolumna].isOcupado() == false) {
		JOptionPane.showMessageDialog
		(null, asiento_avion [numfila][numcolumna].getPrecio() + " € ", "Precio", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void mostrarPersonaAsiento(int numfila, int numcolumna) {
		if(asiento_avion [numfila][numcolumna].isOcupado() == true) {
			JOptionPane.showMessageDialog
			(null, asiento_avion [numfila][numcolumna].getPersona(), "Viajero", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void rellenarPersonasVueloCero() {
		int f = Constantes.getNum_filas();
	    int c = Constantes.getNum_columnas();
	    for(int a=0; a<f; a++) {
	    	for(int b=0; b<c; b++) {
	    		this.asiento_avion[a][b].setOcupado(true);
	    		this.asiento_avion[a][b].setPersona("Operador Turístico");
	    	}
	    }
	}
	
	public Asiento getAsiento_avion(int filas, int columnas) {
		return asiento_avion[filas][columnas];
	}

	public void setAsiento_avion(int filas, int columnas) {
		this.asiento_avion[filas][columnas] = new Asiento();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
