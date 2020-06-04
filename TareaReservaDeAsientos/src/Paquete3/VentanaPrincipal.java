package Paquete3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Paquete2.Vuelo;

public class VentanaPrincipal extends JFrame{
	private JComboBox<String> cb_num_vuelos;
	private JButton boton_consultar;
	private JButton boton_reservar;
	private static Vuelo vuelo_cero;
	private static Vuelo vuelo_uno;
	private static Vuelo vuelo_dos;
	private VentanaVuelos ventana_vuelo_cero;
	private VentanaVuelos ventana_vuelo_uno;
	private VentanaVuelos ventana_vuelo_dos;
	
	public VentanaPrincipal(Vuelo array_vuelos_cero, Vuelo array_vuelos_uno, Vuelo array_vuelos_dos) {
		this.setTitle("Ventana Principal");
		JPanel panel_main = new JPanel(new BorderLayout());
		JPanel panel_sur = new JPanel();
		JLabel label_selecciona = new JLabel("Selecciona un vuelo");
		this.cb_num_vuelos = new JComboBox<String>();
		this.vuelo_cero = array_vuelos_cero;
		this.vuelo_uno = array_vuelos_uno;
		this.vuelo_dos = array_vuelos_dos;
		cb_num_vuelos.addItem(array_vuelos_cero.getNombre());
		cb_num_vuelos.addItem(array_vuelos_uno.getNombre());
		cb_num_vuelos.addItem(array_vuelos_dos.getNombre());
		this.boton_consultar = new JButton("Consultar");
		this.boton_reservar = new JButton("Reservar");
		
		
		//Creando ventanas vuelos
		this.ventana_vuelo_cero = new VentanaVuelos(vuelo_cero);
		this.ventana_vuelo_uno = new VentanaVuelos(vuelo_uno);
		this.ventana_vuelo_dos = new VentanaVuelos(vuelo_dos);
		
		ventana_vuelo_cero.rellenarVueloCero(vuelo_cero);
		
		
		ventana_vuelo_cero.setVisible(false);
		ventana_vuelo_uno.setVisible(false);
		ventana_vuelo_dos.setVisible(false);
		
		
		//Listeners implementados
		this.boton_consultar.addActionListener(new OyenteBoton());
		this.boton_reservar.addActionListener(new OyenteBoton());
		
		//Annadiendo los paneles
		panel_sur.add(this.boton_consultar);
		panel_sur.add(this.boton_reservar);
		panel_main.add(label_selecciona, BorderLayout.NORTH);
		panel_main.add(this.cb_num_vuelos, BorderLayout.CENTER);
		panel_main.add(panel_sur, BorderLayout.SOUTH);
		this.add(panel_main);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
//		frame.isFocused();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public class OyenteBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == boton_consultar) {				
				switch(cb_num_vuelos.getSelectedIndex()) {
				case 0:
					ventana_vuelo_cero.setConsultar(true);
					ventana_vuelo_cero.setReservar(false);
					ventana_vuelo_cero.setVisibleFalse_Boton_enviar();
					ventana_vuelo_cero.habilitarAsientosOcupados(vuelo_cero);
					ventana_vuelo_cero.setVisible(true);	
					break;
				case 1:
					ventana_vuelo_uno.setConsultar(true);
					ventana_vuelo_uno.setReservar(false);
					ventana_vuelo_uno.setVisibleFalse_Boton_enviar();
					ventana_vuelo_uno.habilitarAsientosOcupados(vuelo_uno);
					ventana_vuelo_uno.setVisible(true);
					break;
				case 2:
					ventana_vuelo_dos.setConsultar(true);
					ventana_vuelo_dos.setReservar(false);
					ventana_vuelo_dos.setVisibleFalse_Boton_enviar();
					ventana_vuelo_dos.habilitarAsientosOcupados(vuelo_dos);
					ventana_vuelo_dos.setVisible(true);
					break;
				}
			}
			if(e.getSource() == boton_reservar) {
				switch(cb_num_vuelos.getSelectedIndex()) {
				case 0:
					ventana_vuelo_cero.setConsultar(false);
					ventana_vuelo_cero.setReservar(true);
					ventana_vuelo_cero.setVisibleTrue_Boton_enviar();
					ventana_vuelo_cero.deshabilitarAsientosOcupados(vuelo_cero);
					ventana_vuelo_cero.setVisible(true);
					break;
				case 1:
					ventana_vuelo_uno.setConsultar(false);
					ventana_vuelo_uno.setReservar(true);
					ventana_vuelo_uno.setVisibleTrue_Boton_enviar();
					ventana_vuelo_uno.deshabilitarAsientosOcupados(vuelo_uno);
					ventana_vuelo_uno.setVisible(true);
					break;
				case 2:
					ventana_vuelo_dos.setConsultar(false);
					ventana_vuelo_dos.setReservar(true);
					ventana_vuelo_dos.setVisibleTrue_Boton_enviar();
					ventana_vuelo_dos.deshabilitarAsientosOcupados(vuelo_dos);
					ventana_vuelo_dos.setVisible(true);
					break;
				}
			}
			pack();		
		}
	}
	
}
