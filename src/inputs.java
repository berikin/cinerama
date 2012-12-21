import java.io.IOException;
/**
*Clase que contiene los m�todos que solicitan entradas por teclado
*@version 0.2
*@author Jos� Antonio Y��ez Jim�nez
*/
public class inputs
	{
	/**
	*M�todo que muestra el men� de selecci�n
	*para ejemplos de prueba y solicita por teclado la opci�n a escoger
	*@return Opci�n escogida por el usuario
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
	*M�todo que muestra el men� principal de la aplicaci�n
	*@param rooms Salas de cine de la aplicaci�n
	*@param films Peliculas proyectadas
	*@param seatcounter Contador de asistentes y capacidad de las salas
	*@return True para salir del men� principal y false si debemos volver a mostrarlo
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
					printers.showInfo("\nEscogiste una opci�n no v�lida, prueba de nuevo");
					utils.pause(2000);				
					break;
				}
			}while(1==1);
		}
	/**
	*M�todo que a�ade un nuevo cliente al cine
	*/
	}