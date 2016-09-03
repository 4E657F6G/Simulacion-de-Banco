package clases;

import tda.PILA;

public class Caja {
	
	private PILA bi1;
	private PILA bi2;
	private PILA bi5;
	private PILA bi10;
	private	PILA bi20;
	private PILA bi50;
	private PILA bi100;
	private PILA bi500;
	private boolean activa;
	private boolean ocupada; 
	
	public Caja(){
		bi1 = new PILA();
		bi2 = new PILA();
		bi5 = new PILA();
		bi10 = new PILA();
		bi20 = new PILA();
		bi50 = new PILA();
		bi100 = new PILA();
		bi500 = new PILA();
		activa = false;
		ocupada = false;
	}
	
	
	
	public boolean isActiva(){
		return activa;
	}
	
	public void setActiva(boolean activa){
		this.activa = activa;
	}
	
	public boolean isOcupada(){
		return ocupada;
	}
	
	public void setOcupada(boolean ocupada){
		this.ocupada = ocupada;
	}
	
	public int conversorMonto(int monto, String accion){  //true:= deposito ; false:= retiro // retornara 1 si la transaccion fue exitosa o 																								
		PILA bic1 = new PILA();																				//0 si no hubo billetes suficientes para un retiro
		PILA bic2 = new PILA();
		PILA bic5 = new PILA();
		PILA bic10 = new PILA();
		PILA bic20 = new PILA();
		PILA bic50 = new PILA();
		PILA bic100 = new PILA();
		PILA bic500 = new PILA();
		
		while(monto >=500 ){
			monto-=500;
			bic500.METE(1);;
		}
		while(monto >= 100){
			monto-=100;
			bic100.METE(1);;
		}
		while(monto >= 50){
			monto-=50;
			bic50.METE(1);;
		}
		while(monto >= 20){
			monto-=20;
			bic20.METE(1);;
		}
		while(monto >= 10){
			monto-=10;
			bic10.METE(1);;
		}
		while(monto >= 5){
			monto-=5;
			bic5.METE(1);;
		}
		while(monto >= 2){
			monto-=2;
			bic2.METE(1);;
		}
		while(monto >= 1){
			monto-=1;
			bic1.METE(1);;
		}
		if(accion == "Deposito"){
			while(bic1.VACIA() != true){
				bi1.METE(1); 
				bic1.SACA();
			}
			while(bic2.VACIA() != true){
				bi2.METE(1);
				bic2.SACA();
			}
			while(bic5.VACIA() != true){
				bi5.METE(1); 
				bic5.SACA();
			}
			while(bic10.VACIA() != true){
				bi10.METE(1);
				bic10.SACA();
			}
			while(bic20.VACIA() != true){
				bi20.METE(1);
				bic20.SACA();
			}
			while(bic50.VACIA() != true){
				bi50.METE(1);
				bic50.SACA();
			}
			while(bic100.VACIA() != true){
				bi100.METE(1);
				bic100.SACA();
			}
			while(bic500.VACIA() != true){
				bi500.METE(1);
				bic500.SACA();
			}
		}
		else{
			if(bic500.Size() <= bi500.Size()){
				while(bic500.VACIA() != true){
					bi500.SACA();
					bic500.SACA();
				}
			}
			else{
				while(bic500.VACIA() != true){
					bi100.METE(5);
					bic500.SACA();
				}
				if(bic100.Size() <= bi100.Size()){
					while(bic100.VACIA() != true){
						bi100.SACA();
						bic100.SACA();
					}
				}
				else{
					while(bic100.VACIA() != true){
						bi50.METE(2);
						bic100.SACA();
					}
					if(bic50.Size() <= bi50.Size()){
						while(bic50.VACIA() != true){
							bi50.SACA();
							bic50.SACA();
						}
					}
					else{
						while(bic50.Size()*50 >= 20){
							bic20.METE(2);
							bic10.METE(1);
							bic50.SACA();
						}
						if(bic20.Size() <= bi20.Size()){
							while(bic20.VACIA() != true){
								bi20.SACA(); 
								bic20.SACA();
							}
						}
						else{
							while(bic20.VACIA() != true){
								bic10.METE(2);
								bic20.SACA();
							}
							if(bic10.Size() <= bi10.Size()){
								while(bic10.VACIA() != true){
									bi10.SACA();
									bic10.SACA();
								}
							}
							else{
								while(bic10.VACIA() != true){
									bic5.METE(2);
									bic10.SACA();
								}
								if(bic5.Size() <= bi5.Size()){
									bi5.SACA();
									bic5.SACA();
								}
								else{
									while(bic5.Size()*2 >= 2){
										bic2.METE(2);
										bic1.METE(1);
										bic5.SACA();
									}
									if(bic2.Size() <= bi2.Size()){
										while(bic2.VACIA() != true){
											bic2.SACA();
											bi2.SACA();
										}
									}
									else{
										while(bic2.VACIA() != true){
											bic1.METE(2);
											bic2.SACA();
										}
										if(bic1.Size() <= bi1.Size()){
											while(bic1.VACIA() != true){
												bi1.SACA();
												bic1.SACA();
											}
										}
										else{
											System.out.println("No hay billetes suficiente");
											return 0;
										}
									}
								}
							}
						}
					}
				}
			}
			if(bic100.Size() <= bi100.Size()){
				while(bic100.VACIA() != true){
					bi100.SACA();
					bic100.SACA();
				}
			}
			else{
				while(bic100.VACIA() != true){
					bi50.METE(2);
					bic100.SACA();
				}
				if(bic50.Size() <= bi50.Size()){
					while(bic50.VACIA() != true){
						bi50.SACA();
						bic50.SACA();
					}
				}
				else{
					while(bic50.Size()*50 >= 20){
						bic20.METE(2);
						bic10.METE(1);
						bic50.SACA();
					}
					if(bic20.Size() <= bi20.Size()){
						while(bic20.VACIA() != true){
							bi20.SACA(); 
							bic20.SACA();
						}
					}
					else{
						while(bic20.VACIA() != true){
							bic10.METE(2);
							bic20.SACA();
						}
						if(bic10.Size() <= bi10.Size()){
							while(bic10.VACIA() != true){
								bi10.SACA();
								bic10.SACA();
							}
						}
						else{
							while(bic10.VACIA() != true){
								bic5.METE(2);
								bic10.SACA();
							}
							if(bic5.Size() <= bi5.Size()){
								bi5.SACA();
								bic5.SACA();
							}
							else{
								while(bic5.Size()*2 >= 2){
									bic2.METE(2);
									bic1.METE(1);
									bic5.SACA();
								}
								if(bic2.Size() <= bi2.Size()){
									while(bic2.VACIA() != true){
										bic2.SACA();
										bi2.SACA();
									}
								}
								else{
									while(bic2.VACIA() != true){
										bic1.METE(2);
										bic2.SACA();
									}
									if(bic1.Size() <= bi1.Size()){
										while(bic1.VACIA() != true){
											bi1.SACA();
											bic1.SACA();
										}
									}
									else{
										System.out.println("No hay billetes suficiente");
										return 0;
									}
								}
							}
						}
					}
				}
			}
			if(bic50.Size() <= bi50.Size()){
				while(bic50.VACIA() != true){
					bi50.SACA();
					bic50.SACA();
				}
			}
			else{
				while(bic50.Size()*50 >= 20){
					bic20.METE(2);
					bic10.METE(1);
					bic50.SACA();
				}
				if(bic20.Size() <= bi20.Size()){
					while(bic20.VACIA() != true){
						bi20.SACA(); 
						bic20.SACA();
					}
				}
				else{
					while(bic20.VACIA() != true){
						bic10.METE(2);
						bic20.SACA();
					}
					if(bic10.Size() <= bi10.Size()){
						while(bic10.VACIA() != true){
							bi10.SACA();
							bic10.SACA();
						}
					}
					else{
						while(bic10.VACIA() != true){
							bic5.METE(2);
							bic10.SACA();
						}
						if(bic5.Size() <= bi5.Size()){
							bi5.SACA();
							bic5.SACA();
						}
						else{
							while(bic5.Size()*2 >= 2){
								bic2.METE(2);
								bic1.METE(1);
								bic5.SACA();
							}
							if(bic2.Size() <= bi2.Size()){
								while(bic2.VACIA() != true){
									bic2.SACA();
									bi2.SACA();
								}
							}
							else{
								while(bic2.VACIA() != true){
									bic1.METE(2);
									bic2.SACA();
								}
								if(bic1.Size() <= bi1.Size()){
									while(bic1.VACIA() != true){
										bi1.SACA();
										bic1.SACA();
									}
								}
								else{
									System.out.println("No hay billetes suficiente");
									return 0;
								}
							}
						}
					}
				}
			}
			if(bic20.Size() <= bi20.Size()){
				while(bic20.VACIA() != true){
					bi20.SACA(); 
					bic20.SACA();
				}
			}
			else{
				while(bic20.VACIA() != true){
					bic10.METE(2);
					bic20.SACA();
				}
				if(bic10.Size() <= bi10.Size()){
					while(bic10.VACIA() != true){
						bi10.SACA();
						bic10.SACA();
					}
				}
				else{
					while(bic10.VACIA() != true){
						bic5.METE(2);
						bic10.SACA();
					}
					if(bic5.Size() <= bi5.Size()){
						bi5.SACA();
						bic5.SACA();
					}
					else{
						while(bic5.Size()*2 >= 2){
							bic2.METE(2);
							bic1.METE(1);
							bic5.SACA();
						}
						if(bic2.Size() <= bi2.Size()){
							while(bic2.VACIA() != true){
								bic2.SACA();
								bi2.SACA();
							}
						}
						else{
							while(bic2.VACIA() != true){
								bic1.METE(2);
								bic2.SACA();
							}
							if(bic1.Size() <= bi1.Size()){
								while(bic1.VACIA() != true){
									bi1.SACA();
									bic1.SACA();
								}
							}
							else{
								System.out.println("No hay billetes suficiente");
								return 0;
							}
						}
					}
				}
			}
			if(bic10.Size() <= bi10.Size()){
				while(bic10.VACIA() != true){
					bi10.SACA();
					bic10.SACA();
				}
			}
			else{
				while(bic10.VACIA() != true){
					bic5.METE(2);
					bic10.SACA();
				}
				if(bic5.Size() <= bi5.Size()){
					bi5.SACA();
					bic5.SACA();
				}
				else{
					while(bic5.Size()*2 >= 2){
						bic2.METE(2);
						bic1.METE(1);
						bic5.SACA();
					}
					if(bic2.Size() <= bi2.Size()){
						while(bic2.VACIA() != true){
							bic2.SACA();
							bi2.SACA();
						}
					}
					else{
						while(bic2.VACIA() != true){
							bic1.METE(2);
							bic2.SACA();
						}
						if(bic1.Size() <= bi1.Size()){
							while(bic1.VACIA() != true){
								bi1.SACA();
								bic1.SACA();
							}
						}
						else{
							System.out.println("No hay billetes suficiente");
							return 0;
						}
					}
				}
			}
			if(bic5.Size() <= bi5.Size()){
				bi5.SACA();
				bic5.SACA();
			}
			else{
				while(bic5.Size()*2 >= 2){
					bic2.METE(2);
					bic1.METE(1);
					bic5.SACA();
				}
				if(bic2.Size() <= bi2.Size()){
					while(bic2.VACIA() != true){
						bic2.SACA();
						bi2.SACA();
					}
				}
				else{
					while(bic2.VACIA() != true){
						bic1.METE(2);
						bic2.SACA();
					}
					if(bic1.Size() <= bi1.Size()){
						while(bic1.VACIA() != true){
							bi1.SACA();
							bic1.SACA();
						}
					}
					else{
						System.out.println("No hay billetes suficiente");
						return 0;
					}
				}
			}
			if(bic2.Size() <= bi2.Size()){
				while(bic2.VACIA() != true){
					bic2.SACA();
					bi2.SACA();
				}
			}
			else{
				while(bic2.VACIA() != true){
					bic1.METE(2);
					bic2.SACA();
				}
				if(bic1.Size() <= bi1.Size()){
					while(bic1.VACIA() != true){
						bi1.SACA();
						bic1.SACA();
					}
				}
				else{
					System.out.println("No hay billetes suficiente");
					return 0;
				}
			}
			if(bic1.Size() <= bi1.Size()){
				while(bic1.VACIA() != true){
					bi1.SACA();
					bic1.SACA();
				}
			}
			else{
				System.out.println("No hay billetes suficiente");
				return 0;
			}
		}
		return 1;
	}	
}
