package uniquindio.lenguaje.orangeMall.mundo;

import java.io.IOException;
import java.util.ArrayList;

public class OrangeMall 
{
	private Torre[] torres= new Torre[5];
	private ArrayList <Persona> misPersonas = new ArrayList<>();
	private static final int PERSONAS = 100;
	
	public OrangeMall() throws IOException, InterruptedException
	{
		
		crearTorres();
	}
	
	
	
	public void crearTorres() throws IOException, InterruptedException 
	{
		torres[0]=new Torre(TipoTorre.COMERCIAL);
		torres[1]=new Torre(TipoTorre.EPS);
		torres[2]=new Torre(TipoTorre.URGENCIAS);
		torres[3]=new Torre(TipoTorre.MEDICO1);
		torres[4]=new Torre(TipoTorre.MEDICO2);
		
	}
	
	public Persona generarPersona() throws IOException
	{
		Persona personaNueva;
		
		if(misPersonas.size()<PERSONAS)
		{
			personaNueva =  new Persona("Persona "+misPersonas.size()+1,""+misPersonas.size()+1);
			misPersonas.add(personaNueva);
		}
		else
		{
			throw new IOException("No pueden haber mas de "+PERSONAS+" personas en el mall.");
		}
		
		return personaNueva;
	}


	public void verificarDisponible()
	{
		for(int i = 0 ; i < torres.length ; i++)
		{
			Ascensor [] ascensores = torres[i].getAscensores();
			for(int j = 0 ; j < ascensores.length ; i++)
			{
				boolean disponible = ascensores[j].getDisponible();
				
				if(disponible == true)
				{
					
				}
			}
			
		}
	}
	
	public Persona buscarPersonaMayorPeso(TipoTorre tipotorre) 
	{
		Persona personaMayorPeso=null;
		Persona personaTemp=null;
		int mayor=0;
		for(int i=0; i<misPersonas.size(); i++) 
		{
			personaTemp=misPersonas.get(i);
			if(personaTemp.getTorre()==tipotorre) 
			{
				if(personaTemp.getPeso()>mayor) 
				{
					mayor=personaTemp.getPeso();
					personaMayorPeso=personaTemp;
				}
			}
			
		}
		
		
		return personaMayorPeso;
	}
	
	public ArrayList<Persona> generarListadoPersonaTorre(TipoTorre tipotorre) 
	{
		ArrayList<Persona> personasPorTorre= new ArrayList<>();
		
		Persona personaTemp=null;
		for(int i=0; i<misPersonas.size(); i++) 
		{
			personaTemp=misPersonas.get(i);
			if(personaTemp.getTorre()==tipotorre) 
			{
				personasPorTorre.add(personaTemp);
			}
		}
		
		return personasPorTorre;
		
	}
	
	public int verificarPiso(int torre, int piso)
	{
		int personas = 0;
		
		personas = torres[torre].getPisos()[piso].getNumActualesPersonas();	
		
		return personas;
	}

	public Torre[] getTorres() {
		return torres;
	}



	public void setTorres(Torre[] torres) {
		this.torres = torres;
	}



	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}



	public void setMisPersonas(ArrayList<Persona> misPersonas) {
		this.misPersonas = misPersonas;
	}
	
	public String imprimirListadoPersonas(ArrayList<Persona> personas) 
	{
		String msj="";
		for(int i=0; i<personas.size(); i++) 
		{
			msj+="C.C.: "+personas.get(i).getCedula()+", peso: "+personas.get(i).getPeso()+"\n";
		}
		
		return msj;
	}

	
	
}
