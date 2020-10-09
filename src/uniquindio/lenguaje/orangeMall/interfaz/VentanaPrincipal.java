package uniquindio.lenguaje.orangeMall.interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.w3c.dom.css.RGBColor;

import uniquindio.lenguaje.orangeMall.mundo.Ascensor;
import uniquindio.lenguaje.orangeMall.mundo.OrangeMall;
import uniquindio.lenguaje.orangeMall.mundo.Persona;
import uniquindio.lenguaje.orangeMall.mundo.Piso;
import uniquindio.lenguaje.orangeMall.mundo.TipoTorre;
import uniquindio.lenguaje.orangeMall.mundo.Torre;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;

public class VentanaPrincipal extends JFrame implements ActionListener
{
	private OrangeMall orangeMall;
	private JPanel contentPane;
	private JPanel panelFondo;
	
	private Border borde = BorderFactory.createLineBorder(Color.BLACK,2);
	
	private ArrayList<Ascensor> ascensores = new ArrayList<>();
	private JButton botones[][] = new JButton[10][5];
	private JLabel paneles[][] = new JLabel[10][5];
	private JLabel cantPersonas[] = new JLabel[7];
	private	JLabel masa[] = new JLabel[7];
	private JButton btnHallarPeso;
	
	

	/**
	 * Create the frame.
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public VentanaPrincipal(OrangeMall orangeMall) throws InterruptedException, IOException 
	{
	
		this.orangeMall=orangeMall;
		setBounds(100, 100, 636, 321);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnHallarPeso=new JButton("Hallar Peso");
		btnHallarPeso.setBounds(10, 100, 150, 20);
		btnHallarPeso.addActionListener(this);
		contentPane.add(btnHallarPeso);
		
		generarContadores();
		generarBotones();
		generarPaneles();
		
		
		pack();
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
					
	}
	
	public void generarContadores()
	{
		int x = 22;
		int y = 5;
		int pos = 0;
		
		for(int i = 0 ; i < 3 ; i++)
		{
			JPanel nuevoPanel = new JPanel();
			nuevoPanel.setBounds(x, y, 370, 50);
			nuevoPanel.setBackground(new Color(134, 146, 165));
			nuevoPanel.setBorder(borde);
			nuevoPanel.setLayout(null);
			
			int n = 0;
			int separacion = 0;
			int x1 = 5;
			
			if(i == 0)
			{
				n = 3;
				separacion = 60;
			}
			else
			{
				n = 2;
				separacion = 150;
			}
			
			for(int k = 0 ; k < n ; k++)
			{
				JLabel label1 = new JLabel("Personas");
				label1.setBounds(x1, 1, 55, 10);
				label1.setForeground(new Color(0, 15, 40));
				
				JLabel contPersonas = new JLabel("####");
				contPersonas.setBounds(x1,12,55,10);
				contPersonas.setForeground(new Color(0,0, 0));
				cantPersonas[pos] =  contPersonas;
				
				
				JLabel label2 = new JLabel("Masa");
				label2.setBounds(x1, 25, 55, 10);
				label2.setForeground(new Color(0, 15, 40));
				
				JLabel masaTemp = new JLabel("KG");
				masaTemp.setBounds(x1,36,55,10);
				masaTemp.setForeground(new Color(0,0,0));
				masa[pos] = masaTemp;	
				
				nuevoPanel.add(contPersonas);
				nuevoPanel.add(label1);
				nuevoPanel.add(masaTemp);
				nuevoPanel.add(label2);
				
				
				x1 = x1+55+separacion;
				pos++;
			}
			
			contentPane.add(nuevoPanel);
			
			x += 400; 
			
			
		}
		
		panelFondo = new JPanel();
		panelFondo.setBounds(0, 0, 1500, 60);
		panelFondo.setBackground(new Color(6, 39, 91));
		contentPane.add(panelFondo);
		
				
	}
	
	public void generarBotones() 
	{
		int x=320;
		int y=75;
		for(int i=0; i<botones.length; i++) 
		{
			for(int j=0; j<botones[i].length; j++) 
			{
				JButton boton= new JButton("^ v");
				
				boton.setBounds(x, y, 50, 20);
				boton.addActionListener(this);
				contentPane.add(boton);
				botones[i][j]=boton;
				if(x==320 || x==720) 
				{
					x+=230;
				}
				else 
				{
					x+=170;
					
				}
			}
			x=320;
			y+=65;
		}
	}
	
	public void generarPaneles() 
	{
		int x=320;
		int y=100;
		for(int i=0; i<botones.length; i++) 
		{
			for(int j=0; j<botones[i].length; j++) 
			{
				JLabel panel= new JLabel(" ");
				panel.setBounds(x, y, 50, 20);
			    contentPane.add(panel);
				paneles[i][j]=panel;
				if(x==320 || x==720) 
				{
					x+=230;
				}
				else 
				{
					x+=170;
					
				}
			}
			x=320;
			y+=65;
		}
	}
	
	public void setLabels() 
	{
		Torre[] torres= orangeMall.getTorres();
		
		for(int i=0; i<torres.length; i++) 
		{
			Piso[] pisos = orangeMall.getTorres()[i].getPisos();
			for(int j=0; j<pisos.length; j++) 
			{
				paneles[j][i].setText(pisos[j].getNumActualesPersonas()+"");
			}
		}
	}
	
	public void setCanvas(CanvasJuego canvasJuego) throws InterruptedException, IOException 
	{
		canvasJuego.setBounds(5, 60, 1200, 675);
		contentPane.add(canvasJuego);
		canvasJuego.init();
		
		setBounds(50, -30, 1220, 800);
	}

	public void refrescarContador(int a)
	{
		cantPersonas[a].setText("["+ascensores.get(a).getCantActualPersonas()+"]");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if(e.getSource()==btnHallarPeso) 
		{
			ArrayList<Persona> personaPorTorre= new ArrayList<>();
			Persona perMayorPeso=orangeMall.buscarPersonaMayorPeso(TipoTorre.COMERCIAL);
			personaPorTorre= orangeMall.generarListadoPersonaTorre(TipoTorre.COMERCIAL);
			if(perMayorPeso != null) 
			{
				System.out.println(TipoTorre.COMERCIAL);
				System.out.println(orangeMall.imprimirListadoPersonas(personaPorTorre));
				
				System.out.println("La Persona con el mayor peso de la torre "+ perMayorPeso.getTorre().toString()+" esta identificado con "+perMayorPeso.getCedula()+" y tiene un peso de "+perMayorPeso.getPeso()+"\n");
				
			}
			perMayorPeso=orangeMall.buscarPersonaMayorPeso(TipoTorre.EPS);
			personaPorTorre= orangeMall.generarListadoPersonaTorre(TipoTorre.EPS);
			if(perMayorPeso != null) 
			{
				System.out.println(TipoTorre.EPS);
				System.out.println(orangeMall.imprimirListadoPersonas(personaPorTorre));
				
				System.out.println("La Persona con el mayor peso de la torre "+ perMayorPeso.getTorre().toString()+" esta identificado con "+perMayorPeso.getCedula()+" y tiene un peso de "+perMayorPeso.getPeso()+"\n");
				
			}
			
			perMayorPeso=orangeMall.buscarPersonaMayorPeso(TipoTorre.URGENCIAS);
			personaPorTorre= orangeMall.generarListadoPersonaTorre(TipoTorre.URGENCIAS);
			if(perMayorPeso != null) 
			{
				System.out.println(TipoTorre.URGENCIAS);
				System.out.println(orangeMall.imprimirListadoPersonas(personaPorTorre));
				
				System.out.println("La Persona con el mayor peso de la torre "+ perMayorPeso.getTorre().toString()+" esta identificado con "+perMayorPeso.getCedula()+" y tiene un peso de "+perMayorPeso.getPeso()+"\n");
				
			}
			
			perMayorPeso=orangeMall.buscarPersonaMayorPeso(TipoTorre.MEDICO1);
			personaPorTorre= orangeMall.generarListadoPersonaTorre(TipoTorre.MEDICO1);
			if(perMayorPeso != null) 
			{
				System.out.println(TipoTorre.MEDICO1);
				System.out.println(orangeMall.imprimirListadoPersonas(personaPorTorre));
				
				System.out.println("La Persona con el mayor peso de la torre "+ perMayorPeso.getTorre().toString()+" esta identificado con "+perMayorPeso.getCedula()+" y tiene un peso de "+perMayorPeso.getPeso()+"\n");
				
			}
			
			
			perMayorPeso=orangeMall.buscarPersonaMayorPeso(TipoTorre.MEDICO2);
			personaPorTorre= orangeMall.generarListadoPersonaTorre(TipoTorre.MEDICO2);
			if(perMayorPeso != null) 
			{
				System.out.println(TipoTorre.MEDICO2);
				System.out.println(orangeMall.imprimirListadoPersonas(personaPorTorre));
				
				System.out.println("La Persona con el mayor peso de la torre "+ perMayorPeso.getTorre().toString()+" esta identificado con "+perMayorPeso.getCedula()+" y tiene un peso de "+perMayorPeso.getPeso()+"\n");
				
			}
		}
		
		for(int i=0; i<botones.length; i++) 
		{
			for(int j=0; j<botones[i].length; j++) 
			{
				
				if(e.getSource()==botones[i][j]) 
				{
					int distanciaActual;
					int menorDistancia=10000;
					int posAscensor=-1;
					Ascensor[] ascensores = orangeMall.getTorres()[j].getAscensores();
					
					
					if(ascensores.length!=1) 
					{
						for(int k=0; k<ascensores.length; k++) 
						{
							Ascensor ascTemp= ascensores[k];
							if(ascTemp.isActive()==false) 
							{
								distanciaActual = Math.abs(botones[i][j].getY()-Piso.getCoordenadasPiso(ascTemp.getPisoActual())); 
								
								if(distanciaActual<menorDistancia) 
								{
									menorDistancia=distanciaActual;
									posAscensor=k;
								}
							}
							
							
							
						}
						
						
						if(posAscensor!=-1) 
						{
							ascensores[posAscensor].setDestinoY(botones[i][j].getY()-66);
							ascensores[posAscensor].setActive(true);
							
						}
						
					}
					else 
					{
						ascensores[0].setDestinoY(botones[i][j].getY()-66);
					}
				}
			}
		}
	}

	public ArrayList<Ascensor> getAscensores() {
		return ascensores;
	}

	public void setAscensores(ArrayList<Ascensor> ascensores) {
		this.ascensores = ascensores;
	}


	
	
}
