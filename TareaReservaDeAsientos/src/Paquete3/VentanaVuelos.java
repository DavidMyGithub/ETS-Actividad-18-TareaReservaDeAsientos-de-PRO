package Paquete3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Paquete1.Constantes;
import Paquete2.Asiento;
import Paquete2.Vuelo;

public class VentanaVuelos extends JFrame{
	private JButton boton;
	private JButton boton_aux_seleccion;
	private JButton[][] matriz_botones;
	private JButton boton_enviar;
//	private Asiento asiento;
	private Vuelo vuelo_seleccionado;
	private int a; //para sacar posicion de las filas de cada boton
	private int b; //para sacar posicion de las columnas de cada boton
	private boolean consultar;
	private boolean reservar;
	
	

	public VentanaVuelos(Vuelo vuelo_seleccionado) {
		this.setTitle("VentanaVuelos");
		this.vuelo_seleccionado = vuelo_seleccionado;
		JPanel panel_main = new JPanel(new BorderLayout());
		JLabel label_nombrevuelo = new JLabel("Vuelo " + this.vuelo_seleccionado.getNombre() );
		JPanel panel_botonera = new JPanel( new GridLayout(Constantes.num_filas, Constantes.num_columnas));
		this.boton_enviar = new JButton("Enviar");
		this.boton_aux_seleccion = new JButton();
		
		int f = Constantes.getNum_filas();
	    int c = Constantes.getNum_columnas();
	    this.matriz_botones = new JButton[f][c];
	    for(this.a=0; a<f; a++) {
	    	for(this.b=0; b<c; b++) {
	    		String texto_boton = a + ", " + b;   		
	    		this.boton = new JButton(texto_boton);
	    		this.boton.setBackground(Color.GREEN);
	    		panel_botonera.add(boton);
	    		this.matriz_botones[a][b] = boton;
	    		this.matriz_botones[a][b].addActionListener(new OyenteBotonera());
	    	}
	    }   
	    this.boton_enviar.addActionListener(new OyenteBotonEnviar());
	    
	    this.boton_enviar.setVisible(false);
	    panel_main.add(label_nombrevuelo, BorderLayout.NORTH);
		panel_main.add(panel_botonera, BorderLayout.CENTER);
		panel_main.add(this.boton_enviar, BorderLayout.SOUTH);
		
		this.add(panel_main);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(false);
//		frame.isFocused();
	}
	
	public class OyenteBotonEnviar implements ActionListener {
		public void actionPerformed(ActionEvent e) {		
			String persona_nueva = JOptionPane.showInputDialog("Escribe tu nombre", "sdfsdfsdsdf");
			if(persona_nueva != null) {
				String texto_boton_aux_seleccion = boton_aux_seleccion.getText();
				int numfila = devolverFila(texto_boton_aux_seleccion);
				int numcolumna = devolverColumna(texto_boton_aux_seleccion);
				
				vuelo_seleccionado.setAsiento_avion(numfila, numcolumna);
				vuelo_seleccionado.getAsiento_avion(numfila, numcolumna).setOcupado(true);
				vuelo_seleccionado.getAsiento_avion(numfila, numcolumna).setPersona(persona_nueva);
				matriz_botones[numfila][numcolumna].setBackground(Color.RED);
				matriz_botones[numfila][numcolumna].setEnabled(false);
				
			}
			
			pack();		
		}
	}
	
	public class OyenteBotonera implements ActionListener {
		public void actionPerformed(ActionEvent e) {		
			String texto_boton =  ((AbstractButton) e.getSource()).getText();
			int numfila = devolverFila(texto_boton);
			int numcolumna = devolverColumna(texto_boton);
			
			if(consultar) { //muestra dialog persona 
				vuelo_seleccionado.mostrarPersonaAsiento(numfila, numcolumna);
				
			} else if(reservar) { //muestra dialog precio y cambia boton seleccionado a color rojo
				vuelo_seleccionado.mostrarPrecioAsiento(numfila, numcolumna);
				setAsientosLibresVerde(vuelo_seleccionado);
				matriz_botones[numfila][numcolumna].setBackground(Color.RED);
				boton_aux_seleccion = matriz_botones[numfila][numcolumna];
			}
			pack();		
		}
	}
	
	
	public int devolverFila(String texto_boton) {
		int indice_coma = texto_boton.indexOf(",");
		String numfila_string = texto_boton.substring(0, indice_coma);
		int numfila = Integer.parseInt(numfila_string);
			return numfila;
	}
	public int devolverColumna(String texto_boton) {
		int indice_coma = texto_boton.indexOf(",");
		String numcolumna_string = texto_boton.substring(indice_coma +2, texto_boton.length());
		int numcolumna = Integer.parseInt(numcolumna_string);
			return numcolumna;
	}
	
	public void setAsientosLibresVerde(Vuelo vuelo) { // Para actualizar la lista si cambia de asiento
		int f = Constantes.getNum_filas();
	    int c = Constantes.getNum_columnas();
		 for(int fila=0; fila<f; fila++) {
		    	for(int columna=0; columna<c; columna++) {
		    		if(vuelo.getAsiento_avion(fila, columna).isOcupado() == false) {
						matriz_botones[fila][columna].setBackground(Color.GREEN);
		    		}	    		
		    	}
		 }
		 pack();
	}
	
	public void rellenarVueloCero(Vuelo vuelo) { //rellenar persona con nombre y cambiar color
		vuelo.rellenarPersonasVueloCero();
		int f = Constantes.getNum_filas();
	    int c = Constantes.getNum_columnas();
		 for(int fila=0; fila<f; fila++) {
		    	for(int columna=0; columna<c; columna++) {
		    		if(vuelo.getAsiento_avion(fila, columna).isOcupado() == true) {
		    			matriz_botones[fila][columna].setBackground(Color.RED);
		    		}	    		
		    	}
		 }
		 pack();
	}
	
	public void habilitarAsientosOcupados(Vuelo vuelo) {
		int f = Constantes.getNum_filas();
	    int c = Constantes.getNum_columnas();
		 for(int fila=0; fila<f; fila++) {
		    	for(int columna=0; columna<c; columna++) {
		    		if(vuelo.getAsiento_avion(fila, columna).isOcupado() == true) {
						matriz_botones[fila][columna].setEnabled(true);
		    		} else {
		    			matriz_botones[fila][columna].setEnabled(false);
		    		}
		    	}
		 }
		 pack();
	}
	public void deshabilitarAsientosOcupados(Vuelo vuelo) {
		int f = Constantes.getNum_filas();
	    int c = Constantes.getNum_columnas();
		 for(int fila=0; fila<f; fila++) {
		    	for(int columna=0; columna<c; columna++) {
		    		if(vuelo.getAsiento_avion(fila, columna).isOcupado() == true) {
						matriz_botones[fila][columna].setEnabled(false);
		    		} else {
		    			matriz_botones[fila][columna].setEnabled(true);
		    		}   		
		    	}
		 }
		 pack();
	}
	
	public void setVisibleTrue_Boton_enviar() {
		this.boton_enviar.setVisible(true);
		pack();
	}
	public void setVisibleFalse_Boton_enviar() {
		this.boton_enviar.setVisible(false);
		pack();
	}
	
	public boolean isConsultar() {
		return consultar;
	}
	public void setConsultar(boolean consultar) {
		this.consultar = consultar;
	}
	public boolean isReservar() {
		return reservar;
	}
	public void setReservar(boolean reservar) {
		this.reservar = reservar;
	}
	/*
	public static void main(String[] args) {

	}
	*/
}
