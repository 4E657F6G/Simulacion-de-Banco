package tda;

public class PILA{

	private LISTA contenedor;
	private Object TOPE;
	private int size;
	
	public PILA(){
		contenedor = new LISTA();
		TOPE = null;
	}
	
	public void ANULA(){
		contenedor.ANULA();
	}
	
	public Object TOPE(){
		return TOPE;
	}
	
	public void METE(Object dato){
		contenedor.INSERTA(dato, contenedor.PRIMERO());
		TOPE = dato;
		size++;
	}
	
	public void SACA(){
		contenedor.SUPRIME(contenedor.PRIMERO());
		TOPE = contenedor.RECUPERA(contenedor.PRIMERO());
		size--;
	}
	
	public boolean VACIA(){
		return contenedor.VACIA();
	}
	
	public int Size(){
		return size;
	}
}
