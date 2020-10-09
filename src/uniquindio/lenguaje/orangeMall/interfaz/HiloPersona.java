package uniquindio.lenguaje.orangeMall.interfaz;

import uniquindio.lenguaje.orangeMall.mundo.Ascensor;
import uniquindio.lenguaje.orangeMall.mundo.Persona;

public class HiloPersona extends Thread {
	
	private Persona    p;
	private boolean      activo;
	private long         espera;
	private CanvasJuego  miCanvas;
	private int destinoY = 600;
	
	private int DELTA_X = 1;
	private int DELTA_Y = 1;
	
	public HiloPersona( CanvasJuego c, Persona p, long espera )
	{
		this.p      = p;
		activo      = true;
		this.espera = espera;
		miCanvas    = c;
		
		start();
	}
	
	
	@Override
	public void run() 
	{
		while ( activo )
		{
//			if (p.getY() > destinoY )
//			{
//				p.setY( p.getY() - DELTA_Y );
//			}
//			else if(p.getY() < destinoY)
//			{
//				p.setY( p.getY() + DELTA_Y );
//			}
			
//			if(p.getY()<miCanvas.getHeight()-88)
//			{
//				p.setY(p.getY()-DELTA_Y);
//			}
			
			try 
			{
				sleep( espera );
			} 
			catch ( InterruptedException e ) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public void detener()
	{
		activo = false;
	}	
	

}
