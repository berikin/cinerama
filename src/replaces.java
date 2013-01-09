/**
*Clase que contiene los m�todos que modifican nuestros arrays
*@version 0.4
*@author Jos� Antonio Y��ez Jim�nez
*/
class Replaces
	{
	/**
	*M�todo que modifica una sala de cine de forma aleatoria rellenando
	*tantas butacas como especiquemos en los par�metros. Adicionalmente muestra
	*el ticket de venta en caso de que no se haya invocado el m�todo para realizar
	*rellenos de p�blico de muestra si no que sea una invocaci�n por una entrada vendida.
	*@param showroom Array con la sala de cine a modificar
	*@param seats Tiene dos usos: Si se trata de una venta a un cliente se utiliza para saber el
	*n�mero de tickets y asientos a modificar. Si se trata de un relleno aleatorio de clientes de
	*muestra se utiliza para conocer el porcentaje de clientes que tendr� la sala sobre el tama�o total
	*@param roomnumber Indica el n�mero de sala que vamos a modificar
	*@param percent Indica si la invocaci�n del m�todo es para un relleno de p�blico de muestra aleatorio
	*o para una compra de tickets.
	*/
	public static void randomReplaceRoom(int[][] showroom,int seats, int roomnumber, boolean percent)
		{
		int max_people=seats, random_row=0, random_col=0;
		boolean repeated=false;
		int randompeoplecounter=0;
		int[] roomsize=Utils.roomSize(showroom);
		/////////////////////////////////////////////////////////////////////////////////////
		//Si nos encontramos realizando un relleno de p�blico calculamos el n�mero final
		//de butacas a rellenar en funci�n del porcentaje recibido por par�metro y el tama�o
		//de la sala
		/////////////////////////////////////////////////////////////////////////////////////
		if (percent)
			{
			max_people=((roomsize[0]*roomsize[1])*seats)/100;
			}
		int[][] randompeople=Constructors.makeRandomCounter(max_people,2);
		Printers.showInfo("\nRellenando la sala "+(roomnumber+1)+" con "+max_people+" asistentes. Por favor espere... ");
		for (int i=0;i<max_people; i++)
			{
			randompeoplecounter++;
			do
				{
				random_row=Utils.random(0,(roomsize[0]-1));
				random_col=Utils.random(0,(roomsize[1]-1));
				for (int j=0; j<randompeoplecounter; j++)
					{
					repeated=false;
					if (randompeople[j][0]==random_row & randompeople[j][1]==random_col)
						{
						repeated=true;
						break;
						}
					if (percent==false)
						{
						if (showroom[random_row][random_col]==2)
						repeated=true;
						break;
						}
					}
				}while(repeated);
			randompeople[i][0]=random_row;
			randompeople[i][1]=random_col;
			if (percent==false)
				{
				Printers.buyedTicket(Cinerama.films[roomnumber], roomnumber, random_row, random_col, false);
				Printers.showInfo("\nRecoja su ticket, pulse intro para continuar.");
				Utils.returnPause();
				}
			}
		for (int i=0;i<randompeople.length;i++)
			{
			replaceArray(showroom, randompeople[i][0], randompeople[i][1], roomnumber);
			}
		}
	/**
	*M�todo que modifica los array de salas de cine e informaci�n de las salas.
	*Se encarga de rellenar una butaca indicada por par�metro y sumar una butaca
	*al array de butacas ocupadas
	*@param showroom Array que contiene la sala de cine a modificar
	*@param row Fila a modificar del array de sala de cine
	*@param col Columna a modificar del array de sala de cine
	*@param roomnumber N�mero de sala de cine que queremos modificar
	*/
	public static void replaceArray(int[][] showroom, int row, int col, int roomnumber)
		{
		showroom[row][col]=2;
		Cinerama.filminfo[roomnumber][1]++;
		}
	}