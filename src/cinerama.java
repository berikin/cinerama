/**
*Clase que contiene el método main
*@version 0.4
*@author José Antonio Yáñez Jiménez
*/
class Cinerama
	{
	/**
	*Constante para definir las butacas libres
	*/
	static final int AVAILABLE=1;
	/**
	*Constante para definir las butacas ocupadas
	*/
	static final int USED=2;
	/**
	*Constante para definir los precios
	* [0]-Precio base de entrada
	* [1]-Recargo por proyección 3D
	* [2]-Recargo por gafas 3D
	* [3]-Descuento carné joven
	* [4]-Descuento familia numerosa
	*/
	static final int[] PRIZES={6,2,1,2,2};
	/**
	*Constante para definir el precio del suplemento 3D
	*/
	//static final int PRIZE_3D=2;
	/**
	*Variable encargada de almacenar todas las salas de cine de la aplicación
	*Se rellena mediante métodos que contienen muestras o manualmente introduciendo
	*los datos desde un método que lee entradas de teclado. Tiene tres dimensiones para
	*contener información de filas de asientos, butacas de cada fila y diferentes salas.
	*El tamaño del array lo definirán más adelante los métodos de la clase constructors
	*en función de los requerimentos de sala deseados.
	*/
	static int[][][] rooms;
	/**
	*Variable encargada de almacenar la información de las salas de cine
	*Se rellena en función de las salas que creen.
	* [0]-Butacas totales
	* [1]-Butacas ocupadas
	* [2]-Pasillo simple (1) o doble (2)
	* [3]-Butacas gratuitas
	* [4]-Nº gafas 3D vendidas
	* [5]-Nº descuentos carné joven
	* [6]-Nº descuentos familia numerosa
	* [7]-Beneficio bruto
	* [8]-Deducciones totales
	* [9]-Beneficio neto
	*El tamaño del array lo definirán más adelante los métodos de la clase constructors
	*en función de los requerimentos de sala deseados.
	*/
	static int[][] filminfo;
	/**
	*Variable encargada de almacenar las películas que se proyectan
	*Se rellena aleatoriamente con películas guardadas en una constante o con las películas
	*que se escojan de esa constante.
	*Tiene dos dimensiones: una para especificar la sala de cine a la que se refiere y
	*otra para almacenar el título de la película y si ésta es 3D o no.
	*El tamaño del array lo definirán más adelante los métodos de la clase constructors
	*en función de los requerimentos de sala deseados.
	*/
	static String[][] films;
	/**
	*Método principal de la aplicación, desde el que se lanza la misma
	*/
	public static void main(String[] args)
		{
		boolean exitmenu=false;
		int sample=Inputs.selectSample();
		switch (sample)
			{
		   case 1:
				rooms=Samples.cinema1();
				films=Samples.showfilms1();
				Samples.fillrooms(40,60);
		      break;
		   case 2:
				rooms=Samples.cinema1();
				films=Samples.showfilms1();
		      break;
		   case 3:
				rooms=Samples.cinema2();
				films=Samples.showfilms2();
		      break;
			case 4:
				Inputs.manualRooms();
				break;
			default:
				rooms=Samples.cinema1();
				films=Samples.showfilms1();
				break;
			}
		do
			{	
			exitmenu=Inputs.mainMenu();
			}while(exitmenu==false);
		do
			{
			Replaces.replaceBalance();
			exitmenu=Inputs.recaudatoryMenu();
			}while(exitmenu==false);		
		}
	}