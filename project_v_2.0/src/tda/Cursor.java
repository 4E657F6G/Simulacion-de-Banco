package tda;

public class Cursor {

	int[] memoria = new int[1000];
	Nodo[] datos = new Nodo[1000];
	private int cabeza;
	private int size;
	private int posicionActual;   //Posicion actual del cursor
	private Object datoActual; //Dato de la posicion actual del cursor
	
	public Cursor(){
		cabeza = -1;
		size = 0;
		posicionActual = cabeza;
		datoActual = null;
		for(int i=0; i<1000;i++){
			memoria[i] = 0;
			datos[i] = new Nodo();
		}
	}
	
	public int Disponible(){ //Localiza una zona vacia en el arreglo
		for(int i=0; i<datos.length; i++){
			if(memoria[i] == 0)
				return i;
		}
		return -1;
	}
	
	public void Siguiente(){ //Coloca el cursor en la posicion Siguiente de la posicion ingresada
		try{
			posicionActual = datos[posicionActual].getEncadenamiento(); // Cambiara el valor de posicionActual a la posicion que encadena dicha posicion
			datoActual = datos[posicionActual].getDato();						// Y asignara el dato de la posicion a datoActual
		}catch(Exception e){}
	}
	
	public void Anterior(){ //Coloca el cursor en la posicion Anterior de la posicion ingresada
		for(int i=0; i<size; i++)
			if(datos[i].getEncadenamiento() == posicionActual) //Cuando encuentre el dato cuyo encadenamiento sea la posicion actual
				posicionActual = i;									   	// Asignara la posicion de dicho dato a posicionActual
		datoActual = datos[posicionActual].getDato();			// Y asignara el dato de la posicion a datoAcutal
	}

	public int getSize(){
		return size;
	}
	
	public void setSize(int  size) {
		this.size = size;
	}

	public int getCabeza() {
		return cabeza;
	}

	public void setCabeza(int cabeza) {
		this.cabeza = cabeza;
	}

	public void setPosicionActual(int posicionLista){
		try{
		if(posicionLista == 1)
			posicionActual = cabeza;
		else if(posicionLista == size+1){
			posicionActual = cabeza;
			int conteoPosicion = 1;
			while(conteoPosicion < size){
				posicionActual = datos[posicionActual].getEncadenamiento();
				conteoPosicion++;
			}
		}
		else
			posicionActual = posicionLista;
		datoActual = datos[posicionActual].getDato();
		}catch(Exception e){}
	}
	
	public int getPosicionActual(){
		return posicionActual;
	}
	
	public Object getDatoActual() {
		return datoActual;
	}
}
