package uniquindio.lenguaje.orangeMall.mundo;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Methods
{
	public static void imprimirPorConsola(String msj) 
	{
		System.out.println(msj);
	}
	
	public static void imprimirPorConsola(boolean msj) 
	{
		System.out.println(msj);
	}
	
	public static void imprimirPorConsola(int msj) 
	{
		System.out.println(msj);
	}
	
	public static void imprimirPorConsola(double msj) 
	{
		System.out.println(msj);
	}
	
	public static void imprimirEnVentana(String msj) 
	{
		JOptionPane.showMessageDialog(null, msj);
	}
	
	public static void imprimirEnVentana(int msj) 
	{
		JOptionPane.showMessageDialog(null, msj);
	}
	
	public static void imprimirEnVentana(double msj) 
	{
		JOptionPane.showMessageDialog(null, msj);
	}
	
	public static int[][] clonarMatriz(int matriz[][]) 
	{
		int[][] nuevaMatriz=new int[matriz.length][matriz[0].length];
		
		for(int i=0; i<matriz.length; i++) 
		{
			System.arraycopy(matriz[i], 0, nuevaMatriz[i], 0, matriz[i].length);
		}
		
		return nuevaMatriz;
	}
	
	public static String[][] clonarMatriz(String matriz[][]) 
	{
		String[][] nuevaMatriz=new String[matriz.length][matriz[0].length];
		
		for(int i=0; i<matriz.length; i++) 
		{
			System.arraycopy(matriz[i], 0, nuevaMatriz[i], 0, matriz[i].length);
		}
		
		return nuevaMatriz;
	}
	
	
	/**
	 * Me verifica si el String es apto para hacer una convercion a numero 
	 * @param msj el String a verificar
	 * @return isNumbers un boolean false(no es apto) true(es apto)
	 */
	public static boolean isNumbers(String msj) 
	{
		boolean isNumbers=true;
		for(int i=0; i<msj.length() && isNumbers==true; i++) 
		{
			char num=msj.charAt(i);
			
			if(!(num>=45 && num<=57)) 
			{
				isNumbers=false;
			}
		}
		
		return isNumbers;
		
	}
	
	public static boolean isArrayNumbers(String[] msj) 
	{
		boolean isNumbers=true;
		
		for(int j=0; j<msj.length && isNumbers==true; j++) 
		{
			for(int i=0; i<msj[j].length() && isNumbers==true; i++) 
			{
				char num=msj[j].charAt(i);
				
				if(!(num>=45 && num<=57)) 
				{
					isNumbers=false;
				}
			}
			
		}
		
		return isNumbers;
		
	}
	
	public static String imprimirArraylistString(ArrayList<String> array) 
	{
		String msj="";
		for(int i=0; i<array.size(); i++) 
		{
			msj+=array.get(i);
			msj+="\n";
		}
		return msj;
	}
	
	public static String imprimirArraylistInteger(ArrayList<Integer> array) 
	{
		String msj="";
		for(int i=0; i<array.size(); i++) 
		{
			msj+=array.get(i);
			msj+="\n";
		}
		return msj;
	}
	
	
	/**
	 * Metodo para transformar los datos de un arreglo en un String 
	 * con los datos en serie con saltos de linea entre datos
	 * @param arreglo el arreglo de tipo int a imprimir
	 * @return el arreglo convertido en String
	 */
	public static String imprimirArregloVerticalmente(int[] arreglo) 
	{
		String msj="";
		for(int i=0; i<arreglo.length; i++) 
		{
			msj+=arreglo[i];
			msj+="\n";
		}
		return msj;
	}
	
	/**
	 * Metodo para transformar los datos de un arreglo en un String 
	 * con los datos en serie con saltos de linea entre datos
	 * @param arreglo el arreglo de tipo String a imprimir
	 * @return el arreglo convertido en String
	 */
	public static String imprimirArregloVerticalmente(String[] arreglo) 
	{
		String msj="";
		for(int i=0; i<arreglo.length; i++) 
		{
			msj+=arreglo[i];
			msj+="\n";
		}
		return msj;
	}
	
	/**
	 * Metodo para transformar los datos de un arreglo en un String 
	 * con los datos en serie con espacios entre medios
	 * @param arreglo el arreglo de tipo int a imprimir
	 * @return el arreglo convertido en String
	 */
	public static String imprimirArregloHorizontalmente(int[] arreglo) 
	{
		String msj="";
		for(int i=0; i<arreglo.length; i++) 
		{
			msj+=arreglo[i]+" ";
		}
		return msj;
	}
	
	/**
	 * Metodo para transformar los datos de un arreglo en un String 
	 * con los datos en serie con espacios entre medios
	 * @param arreglo el arreglo de tipo String a imprimir
	 * @return el arreglo convertido en String
	 */
	public static String imprimirArregloHorizontalmente(String[] arreglo) 
	{
		String msj="";
		for(int i=0; i<arreglo.length; i++) 
		{
			msj+=arreglo[i]+" ";
		}
		return msj;
	}
	
	/**
	 * Metodo para determinar si un charracter(char) es una vocal
	 * @param letra char a determinar;
	 * @return true o false si es vocal o no respectivamente.
	 */
	public static boolean isVocal(char letra) 
	{
		boolean isVocal = false;
		
		String a = letra+"";
		
		a = a.toUpperCase();
		
		letra= a.charAt(0);
		
		
		if(letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U') 
		{
			isVocal = true;
		}
		
		return isVocal;
	}
	
	/**
	 * Metodo para transformar los datos de una matriz en un String 
	 * con los datos en serie para poder imprimirlo como un String normal
	 * @param matriz la matriz de tipo int a imprimir
	 * @return la matriz convertida en String
	 */
	public static String imprimirMatriz(int[][]matriz) 
	{
		String msj="";
		
		for(int i=0; i<matriz.length; i++) 
		{
			for(int j=0; j<matriz[0].length; j++) 
			{
				msj+=matriz[i][j]+" ";
			}
			msj+="\n";
		}
		return msj;
	}
	
	/**
	 * Metodo para transformar los datos de una matriz en un String 
	 * con los datos en serie para poder imprimirlo como un String normal
	 * @param matriz la matriz de tipo char a imprimir
	 * @return la matriz convertida en String
	 */
	public static String imprimirMatriz(char[][]matriz) 
	{
		String msj="";
		
		for(int i=0; i<matriz.length; i++) 
		{
			for(int j=0; j<matriz[0].length; j++) 
			{
				msj+=matriz[i][j]+" ";
			}
			msj+="\n";
		}
		return msj;
	}
	
	/**
	 * Metodo para transformar los datos de una matriz en un String 
	 * con los datos en serie para poder imprimirlo como un String normal
	 * @param matriz la matriz de tipo String a imprimir
	 * @return la matriz convertida en String
	 */
	public static String imprimirMatriz(String[][]matriz) 
	{
		String msj="";
		
		for(int i=0; i<matriz.length; i++) 
		{
			for(int j=0; j<matriz[0].length; j++) 
			{
				msj+=matriz[i][j]+" ";
			}
			msj+="\n";
		}
		return msj;
	}
	
	
	/**
	 * Método para generar numeros entre [a-(a+b)).
	 * @NOTA no toma el valor de (a+b) solo numeros menores a (a+b).
	 * @param a rango inicial.
	 * @param b+a rango final 
	 * @return Numero Aleatorio segun el rango.
	 */
	public static int generarNumeroRandom(int a, int b) 
	{
		Random random=new Random();
		return (random.nextInt(b)+a);
		
		
	}

	/**
	 * Convierte un mensaje ingresado por el usuario a un dato int.
	 * @param msj, Donde el mensaje debe de ser solo numeros.
	 * @return El mensaje con tipo int.
	 */
	public static int leerEntero(String msj) 
	{
		return Integer.parseInt(JOptionPane.showInputDialog(msj));
	}
	/**
	 * Lee un mensaje ingresado por el usuario.
	 * @param msj.
	 * @return El mensaje.
	 */
	public static String leerMensaje(String msj) 
	{
		return JOptionPane.showInputDialog(msj);
	}
	/**
	 * Metodo para ordenar los numeros de una matriz por columnas en orden ascendente
	 * @param matriz la matriz a ordenar
	 */
	public static void ordenarAscendentementeMatriz(int[][] matriz) 
	{
		for(int j=0; j<matriz.length; j++) 
		{
			ordenarAscendentementeMatrizColumna(matriz, j);
		}
	}
	/**
	 * Metodo para ordenarlos numeros en orden ascendente de solo una columna de la matriz
	 * @param matriz la matriz a ordenar
	 * @param j la columna que se desea ordenar
	 */
	public static void ordenarAscendentementeMatrizColumna(int [][]matriz, int j)
	{
		int aux=0;
		for(int i=0; i<matriz.length-1; i++) 
		{
			if(matriz[i+1][j]<matriz[i][j]) 
			{
				aux=matriz[i][j];
				matriz[i][j]=matriz[i+1][j];
				matriz[i+1][j]=aux;
			}
		}
		
	}
	
	/**
	 * Metodo para ordenar el arreglo de forma ascendente
	 * @param arreglo el arreglo a ordenar
	 */
	public static void ordenarAscendentementeArreglo(int[] arreglo)
	{
		int aux=0;
		for(int i=0; i<arreglo.length-1; i++) 
		{
			if(arreglo[i+1]<arreglo[i]) 
			{
				aux=arreglo[i];
				arreglo[i]=arreglo[i+1];
				arreglo[i+1]=aux;
			}
		}
		
	}
	

	/**
	 * Metodo para ordenar el arreglo de forma descendente
	 * @param arreglo el arreglo a ordenar
	 */
	public static void ordenarDescendentementeArreglo(int[] arreglo)
	{
		int aux=0;
		for(int i=0; i<arreglo.length-1; i++) 
		{
			if(arreglo[i+1]>arreglo[i]) 
			{
				aux=arreglo[i];
				arreglo[i]=arreglo[i+1];
				arreglo[i+1]=aux;
			}
		}
		
	}
	
	/**
	 * Metodo para borrar un dato de tipo String de un arreglo
	 * @param arreglo
	 * @param aBorrar
	 * @exception aBorrar debe ser diferente de null
	 * @return nuevo arreglo con el dato borrado
	 */
	public static String[] borrarDatosArreglo(String[] arreglo, String aBorrar) 
	{
		String[] datos2;
		int cont=0;
		for(int i=0; i<arreglo.length; i++) 
		{
			if(arreglo[i].equals(aBorrar))
			{
				cont++;
			}
		}
		
		datos2= new String[arreglo.length-cont];
		int j=0;
		for(int i=0; i<arreglo.length; i++) 
		{
			if(!(arreglo[i].equals(aBorrar)))
			{
				datos2[j]=arreglo[i];
				j++;
			}
		}
		
		return datos2;
	}
	
	/**
	 * Metodo para borrar un dato de tipo int de un arreglo
	 * @param arreglo
	 * @param aBorrar
	 * @return nuevo arreglo con el dato borrado
	 */
	public static int[] borrarDatosArreglo(int[] arreglo, int aBorrar) 
	{
		int [] datos2;
		int cont=0;
		for(int i=0; i<arreglo.length; i++) 
		{
			if(arreglo[i] == aBorrar)
			{
				cont++;
			}
		}
		
		datos2= new int[arreglo.length-cont];
		int j=0;
		for(int i=0; i<arreglo.length; i++) 
		{
			if(!(arreglo[i]==aBorrar))
			{
				datos2[j]=arreglo[i];
				j++;
			}
		}
		
		return datos2;
	}
	
	/**
	 * Metodo para borrar un dato de tipo char de un arreglo
	 * @param arreglo
	 * @param aBorrar
	 * @return nuevo arreglo con el dato borrado
	 */
	public static char[] borrarDatosArreglo(char[] arreglo, char aBorrar) 
	{
		char [] datos2;
		int cont=0;
		for(int i=0; i<arreglo.length; i++) 
		{
			if(arreglo[i] == aBorrar)
			{
				cont++;
			}
		}
		
		datos2= new char[arreglo.length-cont];
		int j=0;
		for(int i=0; i<arreglo.length; i++) 
		{
			if(!(arreglo[i] == aBorrar))
			{
				datos2[j]=arreglo[i];
				j++;
			}
		}
		
		return datos2;
	}
	
	/**
	 * llena un arreglo con numeros al azar de [0 hasta arreglo.length)sin repetirse
	 * @NOTA no toma el ultimo valor por lo que solo llega hasta arreglo.length-1
	 * @exception solo para arreglos de tamaño menor a 100
	 * @param arreglo el arreglo a llenar
	 */
	public static void llenarArregloNumerosRandomSinRepeticion(int[]arreglo) 
	{
		llenarArregloNumerosRandomConRepeticion(arreglo);
		for(int i=0; i<arreglo.length; i++) 
		{
			for(int j=0; j<arreglo.length; j++) 
			{
				if(i!=j) 
				{
					
					if(i<j) 
					{
						if(arreglo[i]==arreglo[j]) 
						{
							arreglo[j]=generarNumeroRandom(0, arreglo.length);
							j=0;
						}
						
					}
					else 
					{
						if(arreglo[i]==arreglo[j]) 
						{
							arreglo[i]=generarNumeroRandom(0, arreglo.length);
							i=0;
						}
					}
				}
			}
			
		}
		
	}
	
	/**
	 * llena un arreglo con numeros al azar de [nInicio hasta nFinal)sin repetirse.
	 * @Ejmp si tenemos una matriz de 5 datos y el inicio es el 3 y el nFinal es 5.
	 * El rango ser de[3-8) generara numeros del 3 al 7.
	 * @NOTA no toma el ultimo valor por lo que solo llega hasta (nFinal)-1.
	 * @exception solo para arreglos de tamaño menor a 100,
	 * El rango de numeros debe ser mayor o igual al tamaño del arreglo.
	 * @param arreglo el arreglo a llenar.
	 * @param nInicio el rango inferior cerrado(Lo toma).
	 * @param nFinal el rango superior abierto(No lo toma).
	 * 
	 */
	public static void llenarArregloNumerosRandomSinRepeticion(int[]arreglo, int nInicio, int nFinal) 
	{
		for(int i=0; i<arreglo.length; i++) 
		{
			for(int j=0; j<arreglo.length; j++) 
			{
				if(i!=j) 
				{
					
					if(i<j) 
					{
						if(arreglo[i]==arreglo[j]) 
						{
							arreglo[j]=generarNumeroRandom(nInicio, nFinal);
							j=0;
						}
						
					}
					else 
					{
						if(arreglo[i]==arreglo[j]) 
						{
							arreglo[i]=generarNumeroRandom(nInicio, nFinal);
							i=0;
						}
					}
				}
			}
			
		}
		
	}
	/**
	 * Metodo para llenar un arreglo con numeros al azar de [0 a tamaño del arreglo)
	 * @NOTA se pueden repetir
	 * @param arreglo
	 */
	public static void llenarArregloNumerosRandomConRepeticion(int[] arreglo) 
	{
		for(int i=0; i<arreglo.length; i++) 
		{
			arreglo[i]=generarNumeroRandom(0, arreglo.length);
				
		}
	}
	
	/**
	 * Metodo para convertir un arreglo de String a int
	 * @param arreglo
	 * @exception arreglo debe estar lleno de numeros en String de tal manera que se pueda hacer una conversión de string a int
	 * @return arreglo de int
	 */
	public static int[] convertirArregloAInt(String[] arreglo) 
	{
		int[] arregloNuevo=new int[arreglo.length];
		
		for(int i=0; i<arreglo.length; i++) 
		{
			arregloNuevo[i]=Integer.parseInt(arreglo[i]);
		}
		
		return arregloNuevo;
	}
	
	
	/**
	 * Metodo para llenar un arreglo con numeros al azar en rango de [nInicio hasta nFinal)
	 * sin tomar el valor de nFinal
	 * @NOTA se pueden repetir numeros
	 * @param arreglo
	 */
	public static void llenarArregloNumerosRandomConRepeticion(int[]arreglo, int nInicio, int nFinal) 
	{
		for(int i=0; i<arreglo.length; i++) 
		{
			arreglo[i]=generarNumeroRandom(nInicio, nFinal);
		}
	}
}
