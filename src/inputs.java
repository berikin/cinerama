/**
*Clase que contiene los métodos que solicitan entradas por teclado
*@version 0.2
*@author José Antonio Yáñez Jiménez
*/
public class inputs
	{
	public static int option;
	/**
	*Método que muestra el menú de selección
	*para ejemplos de prueba y solicita por teclado la opción a escoger
	*@return Opción escogida por el usuario
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
				printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
				utils.pause(2000);
				}
			else
				{
				return option;
				}
			} while(1==1);
		}
	/**
	*Método que muestra el menú recauatorio de la aplicación
	*@param rooms Salas de cine de la aplicación
	*@param films Peliculas proyectadas
	*@param seatcounter Contador de asistentes y capacidad de las salas
	*@return True para salir del menú recaudatorio y false si debemos volver a mostrarlo
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
	*Método que muestra el menú principal de la aplicación
	*@param rooms Salas de cine de la aplicación
	*@param films Peliculas proyectadas
	*@param seatcounter Contador de asistentes y capacidad de las salas
	*@return True para salir del menú principal y false si debemos volver a mostrarlo
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
					printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
					utils.pause(2000);				
					break;
				}
			} while(1==1);
		}
	/**
	*Método que muestra el submenú de ocupación
	*@param seatcounter Array con informaciñon sobre asientos libres, ocupados y número de pasillos de la sala
	*@param rooms Array con las salas de cine
	*@param films Array con la información de las peliculas
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
				printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
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
				printers.showInfo("\n\nOperación completada, pulsa intro para volver al menú.\n");
				utils.returnPause();
				}
			} while(1==1);
		}
	/**
	*Método que añade una nueva venta de entradas
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
				printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
				utils.pause(2000);		
				}
			else if (seatcounter[option][0]==seatcounter[option][1])
				{
				printers.showInfo("\nLa sala de esta proyección está llena, prueba de nuevo");
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
			printers.showInfo("\nQuedan "+(seatcounter[option][0]-seatcounter[option][1])+" butacas libres. ¿Cuántas entradas desea?: ");
			filmseats=kread.readInt();
			if (filmseats==0)
				{
				return;
				}
			if (filmseats<1 || filmseats>(seatcounter[option][0]-seatcounter[option][1]))
				{
				printers.showInfo("\nHas escogido un número de entradas no válido, prueba de nuevo");
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