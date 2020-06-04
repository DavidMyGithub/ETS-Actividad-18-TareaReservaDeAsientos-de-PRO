package Paquete2;

public class Asiento {
	private String persona;
	private Double precio;
	private boolean ocupado;
	
	public Asiento() {
		this.persona = null;
		this.precio = 15.5;
		this.ocupado = false;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
}
