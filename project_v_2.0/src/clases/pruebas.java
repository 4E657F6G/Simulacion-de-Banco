package clases;

import tda.COLA;

public class pruebas {
	
	COLA clientes = new COLA();
	
	public pruebas(){
		ingresar();
	}
	
	public void ingresar(){
		while(true){
			try{
				Thread.sleep(2000);
				clientes.PONE_EN_COLA(new Cliente());
				System.out.println(clientes.FRENTE());
				clientes.QUITA_DE_COLA();
		     }catch(InterruptedException e){}     		     	
	   	}
	}
	
	public static void main(String args[]){
		new pruebas();
	}
}
