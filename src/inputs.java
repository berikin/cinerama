import java.io.IOException;
/**
*Clase que contiene los métodos que solicitan entradas por teclado
*@version 0.2
*@author José Antonio Yáñez Jiménez
*/
public class inputs
	{
	/**
	*Método que muestra el menú de selección
	*para ejemplos de prueba y solicita por teclado la opción a escoger
	*@return Opción escogida por el usuario
	*/
	public static int selectSample()
		{
		int option;
		printers.showLogo();
			printers.showSamples();
			java_console.a=1;
			do{utils.pause(1000);}while(java_console.a==1);
			option=Integer.parseInt(java_console.textField1.getText());
			java_console.textField1.setText("");
			//option=kread.readInt();
			do{
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
	*Método que muestra el menú principal de la aplicación
	*@param rooms Salas de cine de la aplicación
	*@param films Peliculas proyectadas
	*@param seatcounter Contador de asistentes y capacidad de las salas
	*@return True para salir del menú principal y false si debemos volver a mostrarlo
	*/
	public static boolean mainMenu(int[][][] rooms,String[][] films,int[][] seatcounter)
		{
		int option;
		do
			{
			printers.showLogo();
			printers.showMainMenu();
			java_console.a=1;
			do{utils.pause(1000);}while(java_console.a==1);
			option=Integer.parseInt(java_console.textField1.getText());
			java_console.textField1.setText("");
			switch (option)
				{
			   case 1:
					//newclient(rooms,films,seatcounter);
			      return false;
				case 2:
					printers.showLogo();
					printers.showRoomOccupation(seatcounter);
					return false;
				case 3:
					return true;
				default:
					printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
					utils.pause(2000);				
					break;
				}
			}while(1==1);
		}
	/**
	*Método que añade un nuevo cliente al cine
	*/
	}