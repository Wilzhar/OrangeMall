package uniquindio.lenguaje.orangeMall.mundo;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Ascensor
{
	
	private Image imagen;
	private int   x, y;
	private int   ancho, alto;
	private String id;
	private ArrayList <Persona> personasActuales ;
	
	private int cantMax;
	private int pesoMaximo;
	private int cantActualPersonas = 0;
	private int pesoActual;
	private NumeroPiso pisoActual;
	private boolean disponible;
	private TipoTorre torre;

	private int destinoY;
	private boolean isActive; 
	
	
	public Ascensor(String id, int cantMax, int pesoMaximo, String nombre, int x, int y, TipoTorre torre ) throws InterruptedException, IOException
	{
		this.id = id;
		this.cantMax = cantMax;
		this.personasActuales = new ArrayList<>();
		this.pesoMaximo = pesoMaximo;
		this.torre =  torre ;
		this.x = x;
		this.y = y;
		
//		imagen = new ImageIcon( "res/"+nombre ).getImage();
		
		imagen = obtenerImagen(0);
		ancho = imagen.getWidth( null );
		alto  = imagen.getHeight( null );
		
		
	}
	
	public void subirPersona(Persona miP) throws IOException
	{
		if(verificarPersona(miP) == -1)							//Se verifica que la persona no exista en el ascensor (ID duplicados)
		{
			if(cantActualPersonas <= cantMax)					//Se verifica que la cantidad de personas en el ascensor sea menor a la maxima
			{
				personasActuales.add(miP);
				this.cantActualPersonas++;			
			}
			else
			{
				throw new IOException("Cupo completo.\nNo pueden subir mas personas!!");
			}
		}
		else
		{
			throw new IOException("La persona ya existe :O\nNo pueden haber dos personas con igual identificacion!");
		}
		
	}


	public void bajarPersona(Persona miP)
	{
			if(verificarPersona(miP) != -1)
			{
				personasActuales.remove(0);				// Se elimina la persona del ascensor
				cantActualPersonas--;
				
			}
		
	}
	
	public int verificarPersona(Persona miP)
	{
		int posicion = -1;
		
		for(int i = 0 ; i < cantActualPersonas && posicion == -1 ; i++)
		{
			Persona personaTemp = personasActuales.get(i);
			
			if(miP == personaTemp)
			{
				posicion = i;
			}
		}
		return posicion;
	}
	
	
	
	public int generarPisoAleatorio() 
	{
		int numeroRD= Methods.generarNumeroRandom(1, 10);
		int coordenadasPiso=0;
		switch(numeroRD)
		{
			case 1:
				coordenadasPiso=600;
				break;
			case 2:
				coordenadasPiso=532;
				break;
			case 3:
				coordenadasPiso=470;
				break;
			case 4:
				coordenadasPiso=402;
				break;
			case 5:
				coordenadasPiso=340;
				break;
			case 6:
				coordenadasPiso=272;
				break;
			case 7:
				coordenadasPiso=210;
				break;
			case 8:
				coordenadasPiso=142;
				break;
			case 9:
				coordenadasPiso=80;
				break;
			case 10:
				coordenadasPiso=12;
				break;
		}
		
		return coordenadasPiso;
	}
	
	

	
	public Image obtenerImagen(int n) throws IOException 
	{
		int fil, col;
		BufferedImage ascensores;
		ImageIcon ascensor;

		col = n % 4;
		fil = (n - col) / 4;
		
		
		ascensores = ImageIO.read(new File("res/ascensor.png"));
		
		ascensor = new ImageIcon(ascensores.getSubimage(col * 39, fil * 65, 39, 65));
		
		
		return ascensor.getImage();
	}

	public int getPesoActual() {
		return pesoActual;
	}


	public void setPesoActual(int pesoActual) {
		this.pesoActual = pesoActual;
	}
	

	public void render( Graphics g )
	{
		g.drawImage( imagen, x, y, ancho, alto, null);
		g.drawString(""+pisoActual, x, y);
	}

	public int getX() 
	{
		return x;
	}
	
	

	public void setX(int x) 
	{
		this.x = x;
	}

	
	public int getY() 
	{
		return y;
	}

	
	public void setY( int y ) 
	{
		this.y = y;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPesoMaximo() {
		return pesoMaximo;
	}

	public void setPesoMaximo(int pesoMaximo) {
		this.pesoMaximo = pesoMaximo;
	}

	public int getDestinoY() {
		return destinoY;
	}

	public void setDestinoY(int destinoY) {
		
		this.destinoY = destinoY;
	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public ArrayList<Persona> getPersonasActuales() {
		return personasActuales;
	}

	public void setPersonasActuales(ArrayList<Persona> personasActuales) {
		this.personasActuales = personasActuales;
	}

	public int getCantMax() {
		return cantMax;
	}

	public void setCantMax(int cantMax) {
		this.cantMax = cantMax;
	}

	public int getCantActualPersonas() {
		return cantActualPersonas;
	}

	public void setCantActualPersonas(int cantActualPersonas) {
		this.cantActualPersonas = cantActualPersonas;
	}

	public NumeroPiso getPisoActual() {
		return pisoActual;
	}

	public void setPisoActual(NumeroPiso pisoActual) {
		
		this.pisoActual = pisoActual;
	}

	public boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
		
	}

	public TipoTorre getTorre() {
		return torre;
	}

	public void setTorre(TipoTorre torre) {
		this.torre = torre;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	

}