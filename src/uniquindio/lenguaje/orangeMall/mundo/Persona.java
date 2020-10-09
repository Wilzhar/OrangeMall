package uniquindio.lenguaje.orangeMall.mundo;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class Persona 
{
	private Image imagen;
	private String nombre;
	private int peso;
	private int edad;
	private String cedula;
	private NumeroPiso numPisoSalida;
	private NumeroPiso numPisoEntrada;
	private int   ancho, alto;
	private TipoTorre torre;
	private boolean esperandoAscensor;
	
	
	
	public Persona(String nombre, String cedula) 
	{
		this.nombre = nombre;
		this.cedula = cedula;
		edad=generarEdad();
		peso=generarPeso();
		
		imagen = new ImageIcon( "res/persona.png").getImage();
		ancho = imagen.getWidth( null );
		alto  = imagen.getHeight( null );
		validarPiso();
		torre = generarTorreRespawn();
		esperandoAscensor = true;
		
	}
	
	public Persona() 
	{
		edad=generarEdad();
		peso=generarPeso();
		
	}
	
	public void validarPiso() 
	{
		numPisoEntrada=generarPisoAleatorio();
		numPisoSalida=generarPisoAleatorio();
		
		if(numPisoEntrada==numPisoSalida) 
		{
			validarPiso();
		}
	}
	
	public TipoTorre generarTorreRespawn() 
	{
		int numeroRD= Methods.generarNumeroRandom(1, 5);
		TipoTorre torre = Torre.getTipoTorre(numeroRD);		
		return torre;
	}
	
	public NumeroPiso generarPisoAleatorio() 
	{
		int numeroRD= Methods.generarNumeroRandom(1, 10);
		NumeroPiso pisoAleatorio = Piso.setNumeroPiso(numeroRD);
		return pisoAleatorio;
	}
	
	
	public int obtenerPosTorre() 
	{
		int nTorre=-1;
		switch(torre)
		{
			case COMERCIAL:
				nTorre=0;
				break;
			case EPS:
				nTorre=1;
				break;
			case URGENCIAS:
				nTorre=2;
				break;
			case MEDICO1:
				nTorre=3;
				break;
			case MEDICO2:
				nTorre=4;
				break;
		}
		
		return nTorre;
	}
	
	public int obtenerPosPiso(NumeroPiso numeroPiso) 
	{
		int nPiso=-1;
		NumeroPiso[] numeroPisos=NumeroPiso.values();
		for(int i=0; i<numeroPisos.length-1; i++) 
		{
			if(numeroPisos[i]==numeroPiso) 
			{
				nPiso=i;
			}
		}
		
		return 10-(nPiso+1);
	}
	
	
	
	public int generarEdad() 
	{
		Random rb=new Random();
		
		return (rb.nextInt(81)+5);
	}
	
	public int generarPeso() 
	{
		Random rb= new Random();
		
		return rb.nextInt(100)+20;
	}
	
	
	/*
	 * Getters
	 */

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public NumeroPiso getNumPisoSalida() {
		return numPisoSalida;
	}

	public void setNumPisoSalida(NumeroPiso numPisoSalida) {
		this.numPisoSalida = numPisoSalida;
	}

	public NumeroPiso getNumPisoEntrada() {
		return numPisoEntrada;
	}

	public void setNumPisoEntrada(NumeroPiso numPisoEntrada) {
		this.numPisoEntrada = numPisoEntrada;
	}
	
	public void render( Graphics g )
	{
		g.drawImage( imagen, Torre.getCoordenadasTorre(torre)+10, Piso.getCoordenadasPiso(numPisoEntrada)+10, ancho, alto, null);
	}

	public TipoTorre getTorre() {
		return torre;
	}

	public void setTorre(TipoTorre torre) {
		this.torre = torre;
	}

	public boolean isEsperandoAscensor() {
		return esperandoAscensor;
	}

	public void setEsperandoAscensor(boolean esperandoAscensor) {
		this.esperandoAscensor = esperandoAscensor;
	}

	
	
	
	
}
