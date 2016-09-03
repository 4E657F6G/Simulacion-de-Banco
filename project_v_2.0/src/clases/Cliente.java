package clases;

import java.util.Random;


public class Cliente {
	private String ID ="";
	private int monto;
	private String accion;
	//private Boolean servicio;
	
	public Cliente() {
		this.ID = getID();
		this.monto = getMonto();
		this.accion = getAccion();
		//this.servicio= getServicio();
	}

	public String getAccion(){
		int ac = (int)(Math.random()*(1-0+1)+0);
		if (ac== 0){
			accion = "Retiro";
		}else if (ac == 1){
			accion = "Deposito";
		}
		return accion;
	}
	
	public String getID() {
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i1 = 0;
		while ( i1 < 7){
			char c1 = (char)r.nextInt(255);
			if ( (c1 >= '0' && c1 <='9') || (c1 >='A' && c1 <='Z') ){
				ID += c1;
				i1 ++;
			}
		};
		return ID;
	}
	
	public int getMonto(){
		return monto =	(int) (Math.random()*(5000-50+1)+50);
	}
	
//	public boolean getServicio() {
//		if (getAccion() == "Deposito"){
//				servicio = true;
//		}else if (getAccion() == "Retiro"){
//			servicio = false;
//		}
//		return servicio;
//	}
//	
	@Override
	public String toString() {
		return "Cliente [ID=" + ID + ", monto=" + monto + ", accion=" + accion + "]";
	}
	
	
}
