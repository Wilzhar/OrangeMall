package uniquindio.lenguaje.orangeMall.mundo;

public class Piso 
{
	private int numActualesPersonas;
	NumeroPiso numeroPiso;
	
	public Piso(NumeroPiso numeroPiso) 
	{
		this.numeroPiso=numeroPiso;
		numActualesPersonas=0;
	}
	
	public static NumeroPiso getNumeroPiso(int y)
	{
		NumeroPiso piso = null;
		
		if(y > 580 && y < 620)
			piso = NumeroPiso.PISO_1;
		
		if(y > 500 && y < 540)
			piso = NumeroPiso.PISO_2;	
		
		if(y > 430 && y < 470)
			piso = NumeroPiso.PISO_3;
		
		if(y > 370 && y < 410)
			piso = NumeroPiso.PISO_4;
		
		if(y > 300 && y < 340)
			piso = NumeroPiso.PISO_5;
		
		if(y > 240 && y < 280)
			piso = NumeroPiso.PISO_6;	
		
		if(y > 170 && y < 210)
			piso = NumeroPiso.PISO_7;
		
		if(y > 110 && y < 150)
			piso = NumeroPiso.PISO_8;
		
		if(y > 40 && y < 80)
			piso = NumeroPiso.PISO_9;
		
		if(y > 0 && y < 30)
			piso = NumeroPiso.PISO_10;
		
		
		
		return piso;
	}
	
	public static int getCoordenadasPiso(NumeroPiso n)
	{
		int coordenadasPiso = 0;
		switch(n)
		{
			case VIAJE:
			coordenadasPiso = 1500;
				break;
			case PISO_1:
				coordenadasPiso=600;
				break;
			case PISO_2:
				coordenadasPiso=523;
				break;
			case PISO_3:
				coordenadasPiso=458;
				break;
			case PISO_4:
				coordenadasPiso=393;
				break;
			case PISO_5:
				coordenadasPiso=328;
				break;
			case PISO_6:
				coordenadasPiso=263;
				break;
			case PISO_7:
				coordenadasPiso=198;
				break;
			case PISO_8:
				coordenadasPiso=133;
				break;
			case PISO_9:
				coordenadasPiso=68;
				break;
			case PISO_10:
				coordenadasPiso=3;
				break;
		}
		return coordenadasPiso;
	}
	
	public void añadirPersona() 
	{
		numActualesPersonas++;
	}
	
	public void eliminarPersona() 
	{
		numActualesPersonas--;
	}
	
	public static NumeroPiso setNumeroPiso(int n)
	{
		NumeroPiso piso = null;
		
		switch(n)
		{
		case 1:
			piso = NumeroPiso.PISO_1;
			break;
		case 2:
			piso = NumeroPiso.PISO_2;
			break;
		case 3:
			piso = NumeroPiso.PISO_3;
			break;
		case 4:
			piso = NumeroPiso.PISO_4;
			break;
		case 5:
			piso = NumeroPiso.PISO_5;
			break;
		case 6:
			piso = NumeroPiso.PISO_6;
			break;
		case 7:
			piso = NumeroPiso.PISO_7;
			break;
		case 8:
			piso = NumeroPiso.PISO_8;
			break;
		case 9:
			piso = NumeroPiso.PISO_9;
			break;
		case 10:
			piso = NumeroPiso.PISO_10;
			break;
		}
		
		return piso;
	}

	public int getNumActualesPersonas() {
		return numActualesPersonas;
	}

	public void setNumActualesPersonas(int numActualesPersonas) {
		this.numActualesPersonas = numActualesPersonas;
	}

	public NumeroPiso getNumeroPiso() {
		return numeroPiso;
	}

	public void setNumeroPiso(NumeroPiso numeroPiso) {
		this.numeroPiso = numeroPiso;
	}

	
}
