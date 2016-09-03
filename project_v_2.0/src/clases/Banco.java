package clases;

import tda.COLA;

public class Banco {

	private boolean abierto;
	private COLA clientes;
	private Caja caja1;
	private Caja caja2;
	private Caja caja3;
	
	public Banco(){
		abierto = false;
		clientes = new COLA();
		caja1 = new Caja();
		caja2 = new Caja();
		caja3 = new Caja();
		loop();
	}
	
	public void abrirBanco(){
		caja1.setActiva(true);
		caja2.setActiva(true);
		caja3.setActiva(true);
		abierto = true;
	}
	
	public void loop(){
		/*
		 Metodos de apertura del banco, apertura de las cajas y creacion de clientes
		 */
		abrirBanco();
		
		while(abierto){
			try{
				Thread.sleep(60000);
				clientes.PONE_EN_COLA(new Cliente());
		     }catch(InterruptedException e){}     		     	
	   	}
		
		if (caja1.isActiva() == true){
			if (caja1.isOcupada() == false){
				clientes.FRENTE();
			}
		}
	}
	
}


