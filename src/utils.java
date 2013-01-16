/**
*Clase que contiene métodos reutilizables a lo largo
*de toda la aplicación
*@version 1.0
*@author José Antonio Yáñez Jiménez
*/
class Utils
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
	*Método que genera una pausa hasta que se pulsa la tecla intro
	*/
	static void returnPause()
		{
		try
			{
			int a=System.in.read();
			}
		catch (java.io.IOException e)
			{
			}
		}
	/**
	*Método que calcula el tamaño de una fila en las salas de cine
	*El método es necesario ya que no todas las salas tienen por qué
	*tener el mismo tamaño, lo que implica que habrá posiciones en el
	*array tridimensional con 0, que no debemos contar para la sala.
	*@param showroom Fila de la que queremos conocer el tamaño
	*@return Número de butacas disponibles en la fila
	*/
	public static int rowSize(int[] showroom)
		{
		boolean cols_limit=false;
		int cols=0;
		for (int j=0; j<showroom.length;j++)
			{
			if (showroom[j]==0)
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
		return cols+1; //Sumamos 1 por la butaca 0 de cada fila, que siempre existe
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
		boolean rows_limit=false;
		int rows=0;
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
		int cols=rowSize(showroom[0]);
		int[] size={(rows+1),cols}; //Sumamos 1 por la fila 0, que siempre existe
		return size;
		}
	/**
	*Método que calcula las filas disponibles de una sala.
	*@param room Array con sala de la que queremos conocer las filas disponibles.
	*@return filas disponibles.
	*/
	public static int[] rowsAvailable(int[][] room)
		{
		int available=0, availablecounter=0;
		for (int i=0; i<room.length; i++)
			{
			for (int j=0; j<room[0].length; j++)
				{
				if (room[i][j]==1)
					{
					available++;
					break;
					}
				}
			}
		int[] rows=new int[available];
		for (int i=0; i<room.length; i++)
			{
			for (int j=0; j<room[0].length; j++)
				{
				if (room[i][j]==1)
					{
					rows[availablecounter]=i;
					availablecounter++;
					break;
					}
				}
			}
		return rows;
		}
	/**
	*Método que calcula las butacas por fila disponibles de una sala.
	*@param room Array con la fila de la que queremos conocer las butacas disponibles.
	*@return butacas dentro de una fila disponibles.
	*/
	public static int[] seatsAvailable(int[] room)
		{
		int available=0, availablecounter=0;
		for (int i=0; i<room.length; i++)
			{
			if (room[i]==1)
				{
				available++;
				}
			}
		int[] cols=new int[available];
		for (int i=0; i<room.length; i++)
			{
			if (room[i]==1)
				{
				cols[availablecounter]=i;
				availablecounter++;
				}
			}
		return cols;
		}
	/**
	*Método que calcula las agrupaciones de butacas contiguas disponibles en una sala
	*en función del número de butacas contiguas que se soliciten por parámetro.
	*En cada grupo de posiciones del array resultante se guarda la primera butaca del grupo
	*y la última bucata.
	*Los tipos de métodos se distribuyen así:
	*	1-Izquierdo en pasillo simple
	*	2-Derecho en pasillo simple
	*	3-Izquierdo en pasillo doble
	*	4-Central en pasillo doble
	*	5-Izquierdo en pasillo doble
	*@param room Array con la fila de la que queremos conocer las butacas disponibles.
	*@param totalfree Número de butacas contiguas que se desean.
	*@param methodtype Tipo de ordenación al que hacemos referencia.
	*@return Array con principio y fin de butacas libres dentro de una fila.
	*/
	public static int[][] multiSeatsAvailable(int[] room,int totalfree,int methodtype)
		{
		int sizecols=rowSize(room);
		int min_for=0, max_for=room.length;
		int available=0, availablecounter=0, availarraycounter=0;
		boolean validmulti=true;
		switch (methodtype)
			{
		   case 1:
				min_for=0;
				max_for=sizecols/2;
		      break;
		   case 2:
				min_for=sizecols/2;
				max_for=sizecols;
		      break;
		   case 3:
				min_for=0;
				max_for=sizecols/3;
		      break;
		   case 4:
				min_for=sizecols/3;
				max_for=sizecols-(sizecols/3);
		      break;
		   case 5:
				min_for=sizecols-(sizecols/3);
				max_for=sizecols;
		      break;
			}
		for (int i=min_for; i<max_for; i++)
			{
			if (room[i]==1)
				{
				validmulti=true;
				if ((i+totalfree)<=max_for)
					{
					for (int j=i;j<(i+totalfree);j++)
						{
						if (room[j]!=1)
							{
							validmulti=false;
							}
						}
					if (validmulti)
						{
						available++;
						}
					}
				else
					{
					break;
					}
				}
			}
		/////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////
		//Nos interesa que solo se pase un array con las filas //
		//que se pueden utilizar, por eso construimos un nuevo //
		//array dando el tamaño una vez lo podemos conocer     //
		/////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////
		int[][] cols=new int[available][2];
		available=0;
		for (int i=min_for; i<max_for; i++)
			{
			if (room[i]==1)
				{
				if (available==cols.length) //ya hemos alcanzado todas las posibilidades, salimos del for
					{
					break;
					}
				cols[available][0]=i;
				validmulti=true;
				if ((i+totalfree)<=max_for)
					{
					for (int j=i;j<(i+totalfree);j++)
						{
						if (room[j]!=1)
							{
							validmulti=false;
							}
						}
					if (validmulti)
						{
						cols[available][1]=((i+totalfree)-1);
						available++;
						}
					}
				else
					{
					break;
					}
				}
			}
		return cols;
		}
	/**
	*Método que calcula el número mayor de un array de dos dimensiones entero
	*Es utilizado en la aplicación para conocer el tamaño máximo que debemos usar
	*al crear la longitud del array de salas de cine
	*@param array Array de dos dimensiones del que queremos obtener el número mayor
	*@param position Posición de la segunda dimensión de la que queremos obtener el número mayor
	*@return Número mayor del array
	*/
	public static int maxOfArray(int[][] array,int position)
		{
		int aux;
		int max=array[0][position];
		for (int i=0; i<array.length; i++)
			{
			aux=Math.max(max,array[i][position]);
			if (aux>max)
				{
				max=aux;
				}
			}
		return max;
		}
	/**
	*
	*	1-Izquierdo en pasillo simple
	*	2-Derecho en pasillo simple
	*	3-Izquierdo en pasillo doble
	*	4-Central en pasillo doble
	*	5-Izquierdo en pasillo doble
	*/
	public static int[] aisleTickets(int[][] room, int seats, int methodtype)
		{
		int[] size=roomSize(room);
		int min_for=0, max_for=room.length, aux=0, availscounter=0;
		switch (methodtype)
			{
		   case 1:
				min_for=0;
				max_for=size[1]/2;
		      break;
		   case 2:
				min_for=size[1]/2;
				max_for=size[1];
		      break;
		   case 3:
				min_for=0;
				max_for=size[1]/3;
		      break;
		   case 4:
				min_for=size[1]/3;
				max_for=size[1]-(size[1]/3);
		      break;
		   case 5:
				min_for=size[1]-(size[1]/3);
				max_for=size[1];
		      break;
			}
		int[] optionalrows=new int[size[0]];
		for (int i=0; i<optionalrows.length; i++)
			{
			optionalrows[i]= Integer.MAX_VALUE;
			}
		for (int i=0; i<room.length;i++)
			{
			for (int j=min_for; j<max_for; j++)
				{
				if (room[i][j]==1)
					{
					availscounter++;
					}
				else
					{
					availscounter=0;
					}
				if (availscounter==seats)
					{
					optionalrows[aux]=i;
					aux++;
					break;
					}
				}
			availscounter=0;
			}
		/////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////
		//Nos interesa que solo se pase un array con las filas //
		//que se pueden utilizar, por eso construimos un nuevo //
		//array dando el tamaño una vez lo podemos conocer     //
		/////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////
		aux=0;
		for (int i=0; i<optionalrows.length; i++)
			{
			if (optionalrows[i]!=Integer.MAX_VALUE)
				{
				aux++;
				}
			else
				{
				break;
				}
			}
		if (aux!=0)
			{
			int[] returnrows=new int[aux];
			for (int i=0; i<returnrows.length; i++)
				{
				returnrows[i]=optionalrows[i];
				}
			return returnrows;
			}
		else
			{
			return optionalrows;
			}
		}
	}