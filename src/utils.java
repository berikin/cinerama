/**
*Clase que contiene métodos reutilizables a lo largo
*de toda la aplicación
*@version 0.2
*@author José Antonio Yáñez Jiménez
*/
class utils
	{
	/**
	*Método que genera un número aleatorio a partir de un intervalo
	*Los números recibidos no tienen por qué ir ordenados, el método seç
	*encarga de diferenciar el menor del mayor.
	*@param n1 Número menor o mayor para fijar el intervalo
	*@param n2 Número menor o mayor para fijar el intervalo
	*@return Número aleatorio generado
	*/
	static int random(int n1, int n2)
	{
		int min=Math.min(n1, n2);
		int max=Math.max(n1, n2);
		return ((int) (Math.random()*(max-min+1)+min));
	}
	/**
	*Método que genera una pausa en el flujo de desarrollo
	*@param miliseconds Tiempo en milisegundos de la pausa
	*/
	static void pause(int miliseconds)
		{
		try
			{
			Thread.sleep(miliseconds);
			}
		catch(InterruptedException e)
			{}
		}
	/**
	*Método que calcula el tamaño de una sala de cine
	*El método es necesario ya que no todas las salas tienen por qué
	*tener el mismo tamaño, lo que implica que habrá posiciones en el
	*array tridimensional con 0, que no debemos contar para la sala.
	*@param showroom Sala de la que queremos conocer el tamaño
	*@return Array con las dimensiones en filas y columnas de la sala
	*/
	public static int[] roomSize(int[][] showroom)
		{
		boolean rows_limit=false, cols_limit=false;
		int rows=0, cols=0;
		for (int j=0; j<showroom.length;j++)
			{
			if (showroom[j][0]==0)//Si nos encontramos un 0 llegamos al límite de asientos de la sala
				{
				rows_limit=true;
				}
			else
				{
				rows=j;
				}
			if (rows_limit)
				break;
			}
		for (int j=0; j<showroom[0].length;j++)
			{
			if (showroom[0][j]==0)
				{
				cols_limit=true;
				}
			else
				{
				cols=j;
				}
			if (cols_limit)
				break;
			}
		int[] size={rows,cols};
		return size;
		}
	}