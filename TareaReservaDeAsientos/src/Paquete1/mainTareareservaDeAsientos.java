package Paquete1;

import Paquete2.Vuelo;
import Paquete3.VentanaPrincipal;
import Paquete3.VentanaVuelos;

//Esto es el main
public class mainTareareservaDeAsientos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vuelo[] array_vuelos = new Vuelo[3];
		array_vuelos[0] = new Vuelo("001");
		array_vuelos[1] = new Vuelo("002");
		array_vuelos[2] = new Vuelo("003");
		VentanaPrincipal ventana_principal =
				new VentanaPrincipal(array_vuelos[0], array_vuelos[1], array_vuelos[2]);

	}

}
