package tda;

public class LISTA {

	private Cursor contenedor;
	
	public LISTA(){
		contenedor = new Cursor();
	}
	
	public int INSERTA(Object dato, int posicionLista){
		int posicion = contenedor.Disponible();
		if(VACIA() == true){
			contenedor.memoria[posicion] = 1;
			contenedor.datos[posicion].setDato(dato);
			contenedor.datos[posicion].setEncadenamiento(-1);
			contenedor.setCabeza(posicion);
			contenedor.setSize(contenedor.getSize() + 1);
			contenedor.setPosicionActual(posicion);
			return 1;
		}
		else if(posicionLista>=1 && posicionLista <=FIN()){
			if(posicionLista == PRIMERO()){														//Sentencia para acomodar de nuevo la cabeza al dato ingresado
				contenedor.datos[posicion].setDato(dato);
				contenedor.datos[posicion].setEncadenamiento(contenedor.getCabeza());
				contenedor.memoria[posicion] = 1;
				//contenedor.datos[contenedor.getCabeza()].setEncadenamiento(posicion);
				contenedor.setCabeza(posicion);
				contenedor.setSize(contenedor.getSize() + 1);
				contenedor.setPosicionActual(posicion);
			} 
			else if(posicionLista == FIN()){															//Sentencia para acomodar un nuevo dato al final de la lista
				contenedor.datos[posicion].setDato(dato);			
				contenedor.datos[posicion].setEncadenamiento(-1);
				contenedor.memoria[posicion] = 1;
				ANTERIOR(posicionLista);
				contenedor.datos[contenedor.getPosicionActual()].setEncadenamiento(posicion);
				contenedor.setSize(contenedor.getSize() + 1);
				contenedor.setPosicionActual(posicion);
				return FIN()-1;
			} 
			else{																								//Caso contrario unicamente ubica el dato y acomoda los encadenamientos
				contenedor.datos[posicion].setDato(dato);
				ANTERIOR(posicionLista);
				contenedor.datos[posicion].setEncadenamiento(contenedor.datos[contenedor.getPosicionActual()].getEncadenamiento());
				ANTERIOR(posicionLista);
				contenedor.datos[contenedor.getPosicionActual()].setEncadenamiento(posicion);
				contenedor.memoria[posicion] = 1;
				contenedor.setSize(contenedor.getSize() + 1);
				contenedor.setPosicionActual(posicion);
			}
			return posicionLista;																		//En cualquier caso retorna la posicion ingresada
		}
		System.out.println("No puede ingresar datos en posiciones que excedan el largo actual de la lista, debe ser +1 que el largo actual o dentro del mismo");
		return -1;
	}
	
	public int LOCALIZA(Object dato){
		int conteoPosicionLista = 1;
		contenedor.setPosicionActual(PRIMERO());          	//Se posiciona el cursor al inicio de la lista
		
		while(dato != contenedor.getDatoActual()){ 				//mientras el dato ingresado sea diferente al dato en la posicion actual 
			contenedor.Siguiente();										//pasara el cursor a la siguiente posicion
			conteoPosicionLista++;										//sumara las posiciones que pasan
		}
		if(dato == contenedor.getDatoActual())
			return conteoPosicionLista;									//y retornara la posicion en la que cuyo dato sea igual al ingresado
		else
			return -1;
	}
	
	public Object RECUPERA(int posicionLista){
		if(posicionLista >= 1 && posicionLista <= FIN()){ 	//Se verifica si la posicion ingresada esta entre el 0 y el largo de la lista
			int conteoPosicionLista = 1;
			contenedor.setPosicionActual(PRIMERO());
			while(conteoPosicionLista < posicionLista){				//mientras el contador de posicion no llegue a la posicion ingresada
				contenedor.Siguiente();				//el cursor se movera a la siguiente posicion
				conteoPosicionLista++;										//se sumara el contador + 1
			}
		
			return contenedor.getDatoActual();						//y retornara el dato de la posicion actual del cursor, la cual debe ser la posicion ingresada
			
		}
		else{
			System.out.println("La posicion ingresada no esta comprendida en el largo de la lista");
			return null;
		}
	}
	
	public void SUPRIME(int posicionLista){
		if(posicionLista == PRIMERO()){
			int temporal = contenedor.datos[contenedor.getCabeza()].getEncadenamiento();
			contenedor.datos[contenedor.getCabeza()].setDato(null);
			contenedor.datos[contenedor.getCabeza()].setEncadenamiento(-1);
			contenedor.setCabeza(temporal);
		}
		else if(posicionLista == FIN()){
			contenedor.setPosicionActual(FIN());
			contenedor.datos[contenedor.getPosicionActual()].setDato(null);
			contenedor.datos[contenedor.getPosicionActual()].setEncadenamiento(-1);
			ANTERIOR(FIN());
			contenedor.datos[contenedor.getPosicionActual()].setEncadenamiento(-1);
		}
		else if(posicionLista >= 1 && posicionLista <= FIN()){ 	//Se verifica si la posicion ingresada esta entre 0 y el largo de la lista
			int conteoPosicionLista = 1;
			contenedor.setPosicionActual(PRIMERO());			//Se posiciona el cursor al inicio de la lista
			
			while(conteoPosicionLista < posicionLista){
				contenedor.Siguiente();
				conteoPosicionLista++;
			}
			int temporal = contenedor.getPosicionActual();
			ANTERIOR(posicionLista);
			contenedor.datos[contenedor.getPosicionActual()].setEncadenamiento(contenedor.datos[temporal].getEncadenamiento());			
			contenedor.datos[temporal].setDato(null);
			contenedor.datos[temporal].setEncadenamiento(-1);
			contenedor.memoria[temporal] = 0;
			contenedor.setSize(contenedor.getSize()-1);
		}else{
			System.out.println("La posicion ingresada no esta comprendida en el largo de la lista");
		}
	}
	
	public int SIGUIENTE(int posicionLista){
		if(posicionLista >= 1 && posicionLista <= FIN()){
			if(posicionLista != FIN()){														//Si la posicion ingresada no es la final, movera el cursor a la posicion siguiente
				int conteoPosicion = 1;
				contenedor.setPosicionActual(PRIMERO());
				
				while(conteoPosicion <= posicionLista){
					contenedor.Siguiente();
					conteoPosicion++;
				}
				return posicionLista+1 ;
			}
			else{
				System.out.println("No hay mas datos");
				return FIN();
			}
		}
		System.out.print("La posicion ingresada no esta comprendida en el largo de la lista");
		return -1;
	}
	
	public int ANTERIOR(int posicionLista){
		if(posicionLista >= 1 && posicionLista <= FIN()){
			if(posicionLista != PRIMERO()){											//Si la posicion ingresada no es la primera, movera el cursor a la posicion anterior
				int conteoPosicion = 1;
				contenedor.setPosicionActual(PRIMERO());
				
				while(conteoPosicion < posicionLista-1){
					contenedor.Siguiente();
					conteoPosicion++;
				}
				return posicionLista-1;
			}
			else{
				System.out.println("Este es el primer dato");
				return PRIMERO();
			}
		}
		System.out.println("La posicion ingresada no esta comprendida en el largo de la lista");
		return -1;
	}
	
	public void ANULA(){
		for(int i=0; i<contenedor.getSize(); i++){
			contenedor.datos[i].setDato(null);
			contenedor.memoria[i] = 0;
		}
	}
	
	public int PRIMERO(){
		return 1;
	}
	
	public int FIN(){
		return contenedor.getSize()+1;
	}
	
	public boolean VACIA(){
		if(contenedor.getCabeza() == -1)
			return true;
		return false;
	}
}
