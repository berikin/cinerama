/**
*Clase que contiene m�todos reutilizables a lo largo
*de toda la aplicaci�n
*@version 1.0
*@author Jos� Antonio Y��ez Jim�nez
*/
class Utils
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
	*M�todo que genera una pausa hasta que se pulsa la tecla intro
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
	*M�todo que calcula el tama�o de una fila en las salas de cine
	*El m�todo es necesario ya que no todas las salas tienen por qu�
	*tener el mismo tama�o, lo que implica que habr� posiciones en el
	*array tridimensional con 0, que no debemos contar para la sala.
	*@param showroom Fila de la que queremos conocer el tama�o
	*@return N�mero de butacas disponibles en la fila
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
	*M�todo que calcula el tama�o de una sala de cine
	*El m�todo es necesario ya que no todas las salas tienen por qu�
	*tener el mismo tama�o, lo que implica que habr� posiciones en el
	*array tridimensional con 0, que no debemos contar para la sala.
	*@param showroom Sala de la que queremos conocer el tama�o
	*@return Array con las dimensiones en filas y columnas de la sala
	*/
	public static int[] roomSize(int[][] showroom)
		{
		boolean rows_limit=false;
		int rows=0;
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
		int cols=rowSize(showroom[0]);
		int[] size={(rows+1),cols}; //Sumamos 1 por la fila 0, que siempre existe
		return size;
		}
	/**
	*M�todo que calcula las filas disponibles de una sala.
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
	*M�todo que calcula las butacas por fila disponibles de una sala.
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
	*M�todo que calcula las agrupaciones de butacas contiguas disponibles en una sala
	*en funci�n del n�mero de butacas contiguas que se soliciten por par�metro.
	*En cada grupo de posiciones del array resultante se guarda la primera butaca del grupo
	*y la �ltima bucata.
	*Los tipos de m�todos se distribuyen as�:
	*	1-Izquierdo en pasillo simple
	*	2-Derecho en pasillo simple
	*	3-Izquierdo en pasillo doble
	*	4-Central en pasillo doble
	*	5-Izquierdo en pasillo doble
	*@param room Array con la fila de la que queremos conocer las butacas disponibles.
	*@param totalfree N�mero de butacas contiguas que se desean.
	*@param methodtype Tipo de ordenaci�n al que hacemos referencia.
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
		//array dando el tama�o una vez lo podemos conocer     //
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
	*M�todo que calcula el n�mero mayor de un array de dos dimensiones entero
	*Es utilizado en la aplicaci�n para conocer el tama�o m�ximo que debemos usar
	*al crear la longitud del array de salas de cine
	*@param array Array de dos dimensiones del que queremos obtener el n�mero mayor
	*@param position Posici�n de la segunda dimensi�n de la que queremos obtener el n�mero mayor
	*@return N�mero mayor del array
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
		//array dando el tama�o una vez lo podemos conocer     //
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