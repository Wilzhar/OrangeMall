package uniquindio.lenguaje.orangeMall.aplicacion;
 
import java.io.IOException;

import uniquindio.lenguaje.orangeMall.interfaz.CanvasJuego;
import uniquindio.lenguaje.orangeMall.interfaz.VentanaPrincipal;
import uniquindio.lenguaje.orangeMall.mundo.OrangeMall;


public class Aplicacion
{
	
	public static void main( String[] args ) throws InterruptedException, IOException 
	{	
		OrangeMall orangeMall= new OrangeMall();
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(orangeMall);
		CanvasJuego canvasJuego= new CanvasJuego(orangeMall,ventanaPrincipal);
		ventanaPrincipal.setCanvas(canvasJuego);
	
	}

}

