package tda;

public class Nodo {
	private Object dato;
	private int encadenamiento;
	
	public Nodo(){
		dato = null;
		encadenamiento = -1;
	}
	
	public Nodo(Object dato, int encadenamiento){
		this.dato = dato;
		this.encadenamiento = encadenamiento;
	}

	public Object getDato() {
		return dato;
	}

	public void setDato(Object dato) {
		this.dato = dato;
	}

	public int getEncadenamiento() {
		return encadenamiento;
	}

	public void setEncadenamiento(int encadenamiento) {
		this.encadenamiento = encadenamiento;
	}
}
