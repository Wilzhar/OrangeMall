package uniquindio.lenguaje.orangeMall.mundo;

import java.io.IOException;

public class Torre 
{
	private int cantidadAscensores;
	private int pesoMax;
	private int cantPersonasMax;
	private String horarios;
	private TipoTorre tipoTorre;
	private Ascensor[] ascensores;
	private Piso [] pisos; 
	private String pisosTrabajo;
	private String etiqueta; 
	private int ubicacionX;
	
	public Torre(TipoTorre tipoTorre) throws IOException, InterruptedException 
	{
		pisos= new Piso[10];
		this.tipoTorre=tipoTorre;
		definirTipoTorre();
		crearAscensores();
		generarPisos();
	}
	
	public void generarPisos() 
	{
		NumeroPiso[] numeroPisos= NumeroPiso.values();
		for(int i=0; i<pisos.length; i++) 
		{
			pisos[i]= new Piso(numeroPisos[i]);
		}
	}
	
	public void crearAscensores() throws IOException, InterruptedException
	{
		int cont=1;
		int separacion = 0;
		for(int i = 0 ; i < ascensores.length ; i++) 
		{
			if(tipoTorre==TipoTorre.MEDICO1|tipoTorre==TipoTorre.MEDICO2)
			{
				Ascensor ascensorTemp= new Ascensor(etiqueta,cantPersonasMax,pesoMax,"ascensor.png",ubicacionX+separacion,600,tipoTorre);
				ascensores[i] = ascensorTemp;
				separacion = separacion+100;
			}
			else
			{
				Ascensor ascensorTemp= new Ascensor(etiqueta+cont,cantPersonasMax,pesoMax,"ascensor.png",ubicacionX+separacion,600,tipoTorre);
				ascensores[i] = ascensorTemp;
				separacion = separacion+100;
				cont++;
			}
			
		}
	}
	
	public void definirTipoTorre() 
	{
		switch(tipoTorre) 
		{
			case COMERCIAL:
				
				cantPersonasMax=20;
				pesoMax=1000;
				horarios="9-22";
				pisosTrabajo="1,2,3,4,5,6,7,8,9,10";
				cantidadAscensores=3;
				etiqueta="COM";
				ubicacionX = 35;
				
				
				break;
			case EPS:
				
				cantPersonasMax=20;
				pesoMax=1000;
				horarios="6,3-9";
				pisosTrabajo="1,2,3,4,5,6,7,8";
				cantidadAscensores=1;
				etiqueta="EPS";
				ubicacionX = 450;
				
				break;
			case URGENCIAS:
				
				cantPersonasMax=7;
				pesoMax=1000;
				horarios="1-24";
				pisosTrabajo="1,2,3";
				cantidadAscensores=1;
				etiqueta="URG";
				ubicacionX = 625;
				
				break;
			case MEDICO1:
				
				cantPersonasMax=20;
				pesoMax=1000;
				horarios="7-22";
				pisosTrabajo="2,4,6,8,10";
				cantidadAscensores=1;
				etiqueta="MD1";
				ubicacionX =840;
				
				break;
			case MEDICO2:
				
				cantPersonasMax=20;
				pesoMax=1000;
				horarios="7-22";
				pisosTrabajo="1,3,5,7,9";
				cantidadAscensores=1;
				etiqueta="MD2";
				ubicacionX = 1025;
				
				break;
				
		}
		
		ascensores= new Ascensor[cantidadAscensores];
	}

	public static TipoTorre getTipoTorre (int n)
	{
		TipoTorre torre = null;
		
		switch(n)
		{
		case 1:
			torre = TipoTorre.COMERCIAL;
			break;
		case 2:
			torre = TipoTorre.EPS;
			break;
		case 3:
			torre =  TipoTorre.URGENCIAS;
			break;
		case 4:
			torre = TipoTorre.MEDICO1;
			break;
			
		case 5:
			torre = TipoTorre.MEDICO2;
			break;
			
		}
		
		return torre;
	}
	
	public static int getCoordenadasTorre(TipoTorre torre)
	{
		int coordenadasTorre = 0;
		
		switch(torre)
		{
			case COMERCIAL:
				coordenadasTorre=60;
				break;
			case EPS:
				coordenadasTorre=500;
				break;
			case URGENCIAS:
				coordenadasTorre=625;
				break;
			case MEDICO1:
				coordenadasTorre=900;
				break;
			case MEDICO2:
				coordenadasTorre=1025;
				break;
				
		}
		
		return coordenadasTorre;
	}
	
	public int getCantidadAscensores() {
		return cantidadAscensores;
	}


	public void setCantidadAscensores(int cantidadAscensores) {
		this.cantidadAscensores = cantidadAscensores;
	}


	public int getPesoMax() {
		return pesoMax;
	}


	public void setPesoMax(int pesoMax) {
		this.pesoMax = pesoMax;
	}


	public int getCantPersonasMax() {
		return cantPersonasMax;
	}


	public void setCantPersonasMax(int cantPersonasMax) {
		this.cantPersonasMax = cantPersonasMax;
	}


	public String getHorarios() {
		return horarios;
	}


	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}


	public TipoTorre getTipoTorre() {
		return tipoTorre;
	}


	public void setTipoTorre(TipoTorre tipoTorre) {
		this.tipoTorre = tipoTorre;
	}


	public Ascensor[] getAscensores() {
		return ascensores;
	}


	public void setAscensores(Ascensor[] ascensores) {
		this.ascensores = ascensores;
	}


	public String getPisosTrabajo() {
		return pisosTrabajo;
	}


	public void setPisosTrabajo(String pisosTrabajo) {
		this.pisosTrabajo = pisosTrabajo;
	}

	public Piso[] getPisos() {
		return pisos;
	}

	public void setPisos(Piso[] pisos) {
		this.pisos = pisos;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public int getUbicacionX() {
		return ubicacionX;
	}

	public void setUbicacionX(int ubicacionX) {
		this.ubicacionX = ubicacionX;
	}
	
	
	
	

}
