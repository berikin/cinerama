/**
*Clase que contiene m�todos reutilizables a lo largo
*de toda la aplicaci�n
*@version 0.2
*@author Jos� Antonio Y��ez Jim�nez
*/
class utils
	{
	/**
	*M�todo que genera un n�mero aleatorio a partir de un intervalo
	*Los n�meros recibidos no tienen por qu� ir ordenados, el m�todo se�
	*encarga de diferenciar el menor del mayor.
	*@param n1 N�mero menor o mayor para fijar el intervalo
	*@param n2 N�mero menor o mayor para fijar el intervalo
	*@return N�mero aleatorio generado
	*/
	static int random(int n1, int n2)
	{
		int min=Math.min(n1, n2);
		int max=Math.max(n1, n2);
		return ((int) (Math.random()*(max-min+1)+min));
	}
	/**
	*M�todo que genera una pausa en el flujo de desarrollo
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
	*M�todo que calcula el tama�o de una sala de cine
	*El m�todo es necesario ya que no todas las salas tienen por qu�
	*tener el mismo tama�o, lo que implica que habr� posiciones en el
	*array tridimensional con 0, que no debemos contar para la sala.
	*@param showroom Sala de la que queremos conocer el tama�o
	*@return Array con las dimensiones en filas y columnas de la sala
	*/
	public static int[] roomSize(int[][] showroom)
		{
		boolean rows_limit=false, cols_limit=false;
		int rows=0, cols=0;
		for (int j=0; j<showroom.length;j++)
			{
			if (showroom[j][0]==0)//Si nos encontramos un 0 llegamos al l�mite de asientos de la sala
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