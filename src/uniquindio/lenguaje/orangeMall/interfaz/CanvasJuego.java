package uniquindio.lenguaje.orangeMall.interfaz;

import java.awt.Canvas;

import java.awt.Dimension;

import java.awt.Graphics;

import java.awt.Image;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.awt.image.BufferStrategy;

import java.io.IOException;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

import uniquindio.lenguaje.orangeMall.mundo.Ascensor;

import uniquindio.lenguaje.orangeMall.mundo.NumeroPiso;

import uniquindio.lenguaje.orangeMall.mundo.OrangeMall;

import uniquindio.lenguaje.orangeMall.mundo.Persona;



public class CanvasJuego extends Canvas implements KeyListener 

{
	
	private static final long serialVersionUID = 1L;
	public static final int ANCHO = 400;
	public static final int ALTO = ANCHO / 16 * 9;
	public static final int ESCALA = 3;
	private ArrayList<Ascensor> listaAscensores;
	private ArrayList<Persona> listaPersonas;
	private ArrayList <HiloAscensor>  hilosAscensores ;
	private ArrayList <HiloPersona> hilosPersonas; 
	private OrangeMall orangeMall;
	private VentanaPrincipal vPrincipal;
	int[] torres= new int[5];
	private Image fondo;


	

	public CanvasJuego( OrangeMall orangeMall, VentanaPrincipal vPrincipal) throws InterruptedException, IOException 
	{
		this.orangeMall = orangeMall;
		this.vPrincipal = vPrincipal;
		Dimension dimension = new Dimension( ANCHO * ESCALA, ALTO * ESCALA );
		fondo = new ImageIcon( "res/orangeMall.png" ).getImage();		
		hilosAscensores = new ArrayList <HiloAscensor>();
		hilosPersonas =  new ArrayList <HiloPersona> ();
		setPreferredSize ( dimension ); 
		setMaximumSize   ( dimension );
		setMinimumSize   ( dimension );
		addKeyListener( this );
		listaAscensores = new ArrayList<>();
		listaPersonas = new ArrayList<>();

	}


	public void render() 
	{
		
		BufferStrategy bs = getBufferStrategy();

		if (bs == null)
		{
			createBufferStrategy( 3 );
			return;
		}


		Graphics g = bs.getDrawGraphics();
		g.drawImage( fondo, 0, 0, null);


		for (int a = 0 ; a < listaAscensores.size() ; a++)
		{
			Ascensor ascensor = listaAscensores.get(a);
			ascensor.render( g );
			if(ascensor.getDisponible())
			{
				subirPersonas(ascensor,a);
				bajarPersonas(ascensor,a);
			}
		}
	
	
		
		synchronized (hilosPersonas)
		{

			for (Persona persona : listaPersonas)
			{
				persona.render( g );
			}

				hilosPersonas.notify();
	
		}
		
		vPrincipal.setLabels();
		g.dispose();
		bs.show();

	}

	

	

	public void subirPersonas(Ascensor ascensor, int a)
	{
		for(int i = 0 ;  i < listaPersonas.size() ; i++)
		{
			Persona perTemp = listaPersonas.get(i);
	
			if(perTemp.isEsperandoAscensor())
			{
				if(perTemp.getTorre() == ascensor.getTorre() && perTemp.getNumPisoEntrada() == ascensor.getPisoActual())
				{
					
					int nTorre=perTemp.obtenerPosTorre();
					int nPiso=perTemp.obtenerPosPiso(perTemp.getNumPisoEntrada());
					orangeMall.getTorres()[nTorre].getPisos()[nPiso].eliminarPersona();
					
					
					perTemp.setNumPisoEntrada(NumeroPiso.VIAJE); //Setea la imagen de la persona en un estado de "viaje", fuera de escena para dar la ilusion de que esta en el ascensor
					int cant = ascensor.getCantActualPersonas()+1;
					ascensor.setCantActualPersonas(cant);
					vPrincipal.setAscensores(listaAscensores);
					vPrincipal.refrescarContador(a);
				}
				
			}
		
		}

	}

	public void bajarPersonas(Ascensor ascensor, int a)
	{
		for(int i = 0 ; i < listaPersonas.size() ; i++)
		{
			Persona perTemp =  listaPersonas.get(i);
			
			
			if(perTemp.getNumPisoEntrada()==NumeroPiso.VIAJE)
			{
				if(perTemp.getTorre() == ascensor.getTorre() && perTemp.getNumPisoSalida() == ascensor.getPisoActual())
				{
					int nTorre = perTemp.obtenerPosTorre();
					int nPiso = perTemp.obtenerPosPiso(perTemp.getNumPisoSalida());
					orangeMall.getTorres()[nTorre].getPisos()[nPiso].añadirPersona();
					perTemp.setNumPisoEntrada(perTemp.getNumPisoSalida());
					perTemp.setNumPisoSalida(perTemp.generarPisoAleatorio());
					int cant = ascensor.getCantActualPersonas()-1;
					ascensor.setCantActualPersonas(cant);
					vPrincipal.setAscensores(listaAscensores);
					vPrincipal.refrescarContador(a);
					perTemp.setEsperandoAscensor(false);
					
					
				}				
			}
		}
	}
	
	

	public void init() 
	{	
			
		for(int i = 0; i < orangeMall.getTorres().length ; i++)
		{
			Ascensor [] ascensores = orangeMall.getTorres()[i].getAscensores();
					
			for(Ascensor ascensor : ascensores)
			{
				listaAscensores.add(ascensor);
				HiloAscensor hiloTemp = new HiloAscensor(this,ascensor,20);
				hilosAscensores.add(hiloTemp);
			}
			
		}
		
		requestFocus();
		
		new Thread( new HiloJuego( this ) ).start();
	}

	public void generarPersona() throws IOException
	{
		Persona miPersona =  orangeMall.generarPersona();
		
		
		int nTorre=miPersona.obtenerPosTorre();
		int nPiso=miPersona.obtenerPosPiso(miPersona.getNumPisoEntrada());
		
		orangeMall.getTorres()[nTorre].getPisos()[nPiso].añadirPersona();
		
		HiloPersona hiloTemp =  new HiloPersona(this,miPersona,20);
		hilosPersonas.add(hiloTemp);
		listaPersonas =  orangeMall.getMisPersonas();
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		int key = e.getKeyCode();

		switch ( key ) 
		{
			case KeyEvent.VK_P:
			try 
			{
				synchronized (hilosPersonas) 
				{
					generarPersona();

					hilosPersonas.notify();
				}
				
			} 
			catch (IOException e1) 
			{
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage());
			}
				 break;
			
				 
			case KeyEvent.VK_ESCAPE:
			break;
				
		}
	}

	
	@Override
	public void keyTyped(KeyEvent e) { }

	
	@Override
	public void keyReleased(KeyEvent e) { }
}