package uniquindio.lenguaje.orangeMall.interfaz;

import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.html.ImageView;

import uniquindio.lenguaje.orangeMall.mundo.Ascensor;
import uniquindio.lenguaje.orangeMall.mundo.Piso;

public class HiloAscensor extends Thread 
{
	private Ascensor    ascensor;
	private boolean      activo;
	private long         espera;
	private CanvasJuego  miCanvas;
	private int DELTA_Y = 1;
	
	
	public HiloAscensor ( CanvasJuego c, Ascensor ascensor, long espera )
	{
		this.ascensor      = ascensor;
		activo      = true;
		this.espera = espera;
		miCanvas    = c;
//		ascensor.setDestinoY(ascensor.generarPisoAleatorio());
		ascensor.setDestinoY(600);
		start();
	}
	
	
	@Override
	public void run() 
	{
		
		while ( activo )
		{
			if ( ascensor.getY() > ascensor.getDestinoY())
			{
				ascensor.setY( ascensor.getY() - DELTA_Y );
				
				
				
			}
			if(ascensor.getY() < ascensor.getDestinoY())
			{
				ascensor.setY( ascensor.getY() + DELTA_Y );
			}
			
			if ( ascensor.getY() == ascensor.getDestinoY()) 
			{
//				ascensor.setDestinoY(ascensor.generarPisoAleatorio());
				
				ascensor.setPisoActual(Piso.getNumeroPiso(ascensor.getY()));
				ascensor.setActive(false);
				try 
				{
					reproducirAnimacion();
					
				} 
				catch ( InterruptedException | IOException e ) 
				{
				e.printStackTrace();
				}
			}
			
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
	
	public void reproducirAnimacion() throws IOException, InterruptedException 
	{
			for(int i=0; i<8; i++) 
			{
				Image asc= ascensor.obtenerImagen(i);
				ascensor.setImagen(asc);
				sleep( 100 );
				
				
			}
			
			sleep( 1000 );
			
			
			ascensor.setDisponible(true);
			
			for(int i=7; i>=0; i--)
			{
				Image asc= ascensor.obtenerImagen(i);
				ascensor.setImagen(asc);
				sleep( 100 );
				
				
			}
			ascensor.setImagen(ascensor.obtenerImagen(0));
	}
	
	
	
	
	public Ascensor getAscensor() {
		return ascensor;
	}


	public void setA(Ascensor ascensor) {
		this.ascensor = ascensor;
	}


	public boolean isActivo() {
		return activo;
	}


	public void setActivo(boolean activo) {
		this.activo = activo;
	}


	public long getEspera() {
		return espera;
	}


	public void setEspera(long espera) {
		this.espera = espera;
	}


	public CanvasJuego getMiCanvas() {
		return miCanvas;
	}


	public void setMiCanvas(CanvasJuego miCanvas) {
		this.miCanvas = miCanvas;
	}



	public int getDELTA_Y() {
		return DELTA_Y;
	}


	public void setDELTA_Y(int dELTA_Y) {
		DELTA_Y = dELTA_Y;
	}


	public void detener()
	{
		activo = false;
	}


	
	
	
}