/**
*Clase que contiene los m�todos que solicitan entradas por teclado
*@version 0.2
*@author Jos� Antonio Y��ez Jim�nez
*/
public class inputs
	{
	public static int option;
	/**
	*M�todo que muestra el men� de selecci�n
	*para ejemplos de prueba y solicita por teclado la opci�n a escoger
	*@return Opci�n escogida por el usuario
	*/
	public static int selectSample()
		{
		printers.showLogo();
		do
			{
			printers.showSamples();
			option=kread.readInt();
			if (option<1 || option>3)
				{
				printers.showInfo("\nEscogiste una opci�n no v�lida, prueba de nuevo");
				utils.pause(2000);
				}
			else
				{
				return option;
				}
			} while(1==1);
		}
	/**
	*M�todo que muestra el men� recauatorio de la aplicaci�n
	*@param rooms Salas de cine de la aplicaci�n
	*@param films Peliculas proyectadas
	*@param seatcounter Contador de asistentes y capacidad de las salas
	*@return True para salir del men� recaudatorio y false si debemos volver a mostrarlo
	*/
	public static boolean recaudatoryMenu(int[][][] rooms,String[][] films,int[][] seatcounter)
		{
		do 
			{
			printers.showLogo();
			//printers.showRecaudatoryMenu();
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////////
			//////////////////////////////////////////////////////////////////////////////CONTINUAR AQUI
			//////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			return false;
			} while(1==1);
		}
	/**
	*M�todo que muestra el men� principal de la aplicaci�n
	*@param rooms Salas de cine de la aplicaci�n
	*@param films Peliculas proyectadas
	*@param seatcounter Contador de asistentes y capacidad de las salas
	*@return True para salir del men� principal y false si debemos volver a mostrarlo
	*/
	public static boolean mainMenu(int[][][] rooms,String[][] films,int[][] seatcounter)
		{
		boolean allrooms;
		do
			{
			allrooms=true;
			for (int i=0;i<seatcounter.length;i++)
				{
				if (seatcounter[i][0]!=seatcounter[i][1])
					{
					allrooms=false;
					}
				}
			if (allrooms)
				{
				return true;
				}
			printers.showLogo();
			printers.showMainMenu();
			option=kread.readInt();
			switch (option)
				{
			   case 1:
					newClient(rooms,films,seatcounter);
			      return false;
				case 2:
					occupationMenu(seatcounter, rooms, films);
					return false;
				case 3:
					return true;
				default:
					printers.showInfo("\nEscogiste una opci�n no v�lida, prueba de nuevo");
					utils.pause(2000);				
					break;
				}
			} while(1==1);
		}
	/**
	*M�todo que muestra el submen� de ocupaci�n
	*@param seatcounter Array con informaci�on sobre asientos libres, ocupados y n�mero de pasillos de la sala
	*@param rooms Array con las salas de cine
	*@param films Array con la informaci�n de las peliculas
	*/
	public static void occupationMenu(int[][] seatcounter, int[][][] rooms, String[][] films)
		{
		do
			{
			printers.showLogo();
			printers.showRoomOccupation(seatcounter, films);
			option=kread.readInt();
			if (option==0)
				{
				return;
				}
			else if (option<0 || option>seatcounter.length)
				{
				printers.showInfo("\nEscogiste una opci�n no v�lida, prueba de nuevo");
				utils.pause(2000);				
				}
			else
				{
				printers.showLogo();
				if (seatcounter[(option-1)][2]==1)
					{
					printers.oneAisle(rooms[(option-1)],seatcounter[(option-1)], films[(option-1)]);
					}
				else
					{
					printers.twoAisle(rooms[(option-1)],seatcounter[(option-1)], films[(option-1)]);
					}
				printers.showInfo("\n\nOperaci�n completada, pulsa intro para volver al men�.\n");
				utils.returnPause();
				}
			} while(1==1);
		}
	/**
	*M�todo que a�ade una nueva venta de entradas
	*/
	public static void newClient(int[][][] rooms,String[][] films,int[][] seatcounter)
		{
		int filmseats;
		do
			{
			printers.showLogo();
			printers.showFilmList(seatcounter,films);
			option=kread.readInt();
			if (option==0)//Saliendo de la venta
				{
				return;
				}
			option--;
			if (option<0 || option>(seatcounter.length-1))
				{
				printers.showInfo("\nEscogiste una opci�n no v�lida, prueba de nuevo");
				utils.pause(2000);		
				}
			else if (seatcounter[option][0]==seatcounter[option][1])
				{
				printers.showInfo("\nLa sala de esta proyecci�n est� llena, prueba de nuevo");
				utils.pause(2000);		
				}
			else
				{
				break;
				}
			} while(1==1);
		do
			{
			printers.showLogo();
			if (seatcounter[(option)][2]==1)
				{
				printers.oneAisle(rooms[option],seatcounter[option], films[option]);
				}
			else
				{
				printers.twoAisle(rooms[option],seatcounter[option], films[option]);
				}
			printers.showInfo("\nQuedan "+(seatcounter[option][0]-seatcounter[option][1])+" butacas libres. �Cu�ntas entradas desea?: ");
			filmseats=kread.readInt();
			if (filmseats==0)
				{
				return;
				}
			if (filmseats<1 || filmseats>(seatcounter[option][0]-seatcounter[option][1]))
				{
				printers.showInfo("\nHas escogido un n�mero de entradas no v�lido, prueba de nuevo");
				utils.pause(2000);	
				}
			else
				{
				break;
				}
			} while(1==1);
		printers.showTicketsMode(seatcounter[option][2]);
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////////////////CONTINUAR AQUI
		/////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		}
	}