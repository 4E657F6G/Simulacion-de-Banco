package tda;

public class COLA {
	
	private LISTA contenedor;
	private Object cabeza;
	private int size;
	
	public COLA(){
		contenedor = new LISTA();
		cabeza = null;
		size = 0;
	}
	
	public void ANULA(){
		contenedor.ANULA();
	}
	
	public Object FRENTE(){
		return cabeza;
	}
	
	public void PONE_EN_COLA(Object dato){
		contenedor.INSERTA(dato, contenedor.FIN());
		cabeza = contenedor.RECUPERA(contenedor.PRIMERO());
		size++;
	}
	
	public void QUITA_DE_COLA(){
		contenedor.SUPRIME(contenedor.PRIMERO());
		cabeza = contenedor.RECUPERA(contenedor.PRIMERO());
		size--;
	}
	
	public boolean VACIA(){
		return contenedor.VACIA();
	}
	
	public int Size(){
		return size;
	}
}
