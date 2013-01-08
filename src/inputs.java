/**
*Clase que contiene los m�todos que solicitan entradas por teclado
*@version 0.3
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
		do
			{
			printers.showLogo();
			printers.showSamples();
			option=kread.readInt();
			if (option<1 || option>4)
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
	*M�todo para agregar las salas de cine y las pel�culas de forma manual.
	*Se solicita la informaci�n del n�mero de salas de cine deseadas, el tama�o
	*de cada sala de cine, los pasillos de las salas de cine yy las pel�culas que
	*ser�n proyectadas, pudiendo ser �stas 2D o 3D. Toda la informaci�n recolectada
	*se transfiere a los arrays principales rooms, films y filminfo
	*/
	public static void manualRooms()
		{
		int rooms;
		/////////////////
		//N�mero de salas
		/////////////////
		do
			{
			printers.showLogo();
			printers.showInfo("\n�Cu�ntas salas deseas (1-20): ");
			rooms=kread.readInt();
			if (rooms<1 || rooms>20)
				{
				printers.showInfo("\nHas escogido un n�mero incorrecto de salas, vuelve a intentarlo.");
				utils.pause(2000);
				}
			else
				{
				break;
				}
			} while(1==1);
		/////////////////////////////////////////
		//Filas, columnas y pasillos de las salas
		/////////////////////////////////////////
		int[][] showrooms=new int[rooms][3]; //Filas, columnas, pasillo simple o doble
		for (int i=0; i<rooms; i++)
			{
			do
				{
				printers.showLogo();
				printers.showInfo("\nSala "+(i+1)+" de "+rooms);
				printers.showInfo("\n_________________________________");
				printers.showInfo("\n�Cu�ntas filas deseas que tenga la sala (1-20)?: ");
				showrooms[i][0]=kread.readInt();
				if (showrooms[i][0]<1 || showrooms[i][0]>20)
					{
					printers.showInfo("\nHas escogido un n�mero incorrecto de filas, vuelve a intentarlo.");
					utils.pause(2000);
					}
				else
					{
					do
						{
						printers.showInfo("\n�Cu�ntas butacas por fila deseas que tenga la sala (1-20)?: ");
						showrooms[i][1]=kread.readInt();
						if (showrooms[i][1]<1 || showrooms[i][1]>20)
							{
							printers.showInfo("\nHas escogido un n�mero incorrecto de butacas, vuelve a intentarlo.");
							utils.pause(2000);
							}
						else
							{
							do
								{
								printers.showInfo("\n�Deseas que la sala tenga un pasillo o dos (1-2)?: ");
								showrooms[i][2]=kread.readInt();
								if (showrooms[i][2]<1 || showrooms[i][2]>2)
									{
									printers.showInfo("\nHas escogido un n�mero incorrecto de pasillos, vuelve a intentarlo.");
									utils.pause(2000);
									}
								else
									{
									break; //Salimos de pasillos
									}
								} while(1==1);
							break; //Salimos de columnas
							}
						} while(1==1);
					break; //salimos de filas
					}
				} while(1==1);
			}
		int max_rows=utils.maxOfArray(showrooms,0);
		int max_cols=utils.maxOfArray(showrooms,1);
		int[] max_room={max_rows,max_cols};
		//Relleno de arrays de salas e informaci�n de las salas
		cinerama.rooms=constructors.makeRooms(max_room,showrooms,cinerama.AVAILABLE);
		cinerama.filminfo=constructors.makeFilmInfo(cinerama.rooms,showrooms);
		///////////
		//Pel�culas
		///////////
		int filmtype, chosenfilm;
		String[][] films=new String[rooms][2];
		for (int i=0; i<rooms; i++)
			{
			do
				{
				printers.showLogo();
				printers.showInfo("\nPel�cula para sala "+(i+1)+" de "+rooms+" ("+cinerama.filminfo[i][0]+"plazas)");
				printers.showInfo("\n__________________________________________");
				printers.showInfo("\nEscoge el tipo de proyecci�n:");
				printers.showInfo("\n\t(1) 3D");
				printers.showInfo("\n\t(2) 2D HD\n");
				filmtype=kread.readInt();
				if (filmtype<1 || filmtype>2)
					{
					printers.showInfo("\nHas escogido un tipo de proyecci�n incorrecto, vuelve a intentarlo.");
					utils.pause(2000);
					}
				else
					{
					break;
					}		
				}while(1==1);
			if (filmtype==1)
				{
				do
					{
					printers.showLogo();
					printers.showInfo("\nPel�cula para sala "+(i+1)+" de "+rooms+" ("+cinerama.filminfo[i][0]+"plazas)");
					printers.showInfo("\n__________________________________________");
					printers.showInfo("\nEscoge entre el listado de pel�culas:");
					for (int j=0; j<constructors.AVAILABLE3D; j++)
						{
						printers.showInfo("\n\t("+(j+1)+") "+constructors.FILMS_AVAILABLE[j][0]);
						}
					System.out.print("\n");
					chosenfilm=kread.readInt();
					if (chosenfilm<1 || chosenfilm>constructors.AVAILABLE3D)
						{
						printers.showInfo("\nHas escogido un n�mero de pel�cula incorrecto, vuelve a intentarlo.");
						utils.pause(2000);
						}
					else
						{
						break;
						}
					}while(1==1);
				}
			else
				{
				do
					{
					printers.showLogo();
					printers.showInfo("\nPel�cula para sala "+(i+1)+" de "+rooms+" ("+cinerama.filminfo[i][0]+"plazas)");
					printers.showInfo("\n__________________________________________");
					printers.showInfo("\nEscoge entre el listado de pel�culas:");
					for (int j=0; j<constructors.FILMS_AVAILABLE.length; j++)
						{
						printers.showInfo("\n\t("+(j+1)+") "+constructors.FILMS_AVAILABLE[j][0]);
						}
					System.out.print("\n");
					chosenfilm=kread.readInt();
					if (chosenfilm<1 || chosenfilm>constructors.FILMS_AVAILABLE.length)
						{
						printers.showInfo("\nHas escogido un n�mero de pel�cula incorrecto, vuelve a intentarlo.");
						utils.pause(2000);
						}
					else
						{
						break;
						}
					}while(1==1);
				}
			chosenfilm--;
			if (filmtype==1)
				{
				films[i][0]=constructors.FILMS_AVAILABLE[chosenfilm][0];
				films[i][1]="yes";
				}
			else
				{
				films[i][0]=constructors.FILMS_AVAILABLE[chosenfilm][0];
				films[i][1]="no";
				}
			//Relleno de array de pel�culas
			cinerama.films=films;
			}
		}
	/**
	*M�todo que muestra el men� recauatorio de la aplicaci�n
	*@return True para salir del men� recaudatorio y false si debemos volver a mostrarlo
	*/
	public static boolean recaudatoryMenu()
		{
		do 
			{
			printers.showLogo();
			printers.showRecaudatoryMenu();
			option=kread.readInt();
			if (option<1 || option>2)
				{
				printers.showInfo("\nEscogiste una opci�n no v�lida, prueba de nuevo");
				utils.pause(2000);				
				}
			else
				{
				if (option==1)
					{
					printers.showRecaudatoryTable();
					printers.showInfo("\n\nOperaci�n completada, pulsa intro para continuar.\n");
					utils.returnPause();
					return false;
					}
				else
					{
					printers.showInfo("\nGracias por utilizar Cinerama.");
					return true;
					}
				}
			} while(1==1);
		}
	/**
	*M�todo que muestra el men� principal de la aplicaci�n
	*@param rooms Salas de cine de la aplicaci�n
	*@param films Peliculas proyectadas
	*@param filminfo Contador de asistentes y capacidad de las salas
	*@return True para salir del men� principal y false si debemos volver a mostrarlo
	*/
	public static boolean mainMenu()
		{
		boolean allrooms;
		do
			{
			allrooms=true;
			for (int i=0;i<cinerama.filminfo.length;i++)
				{
				if (cinerama.filminfo[i][0]!=cinerama.filminfo[i][1])
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
					if (newClient()==0)
						{
						printers.showInfo("\nOperaci�n cancelada.");
						}
					utils.pause(2000);
			      return false;
				case 2:
					occupationMenu();
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
	*@param filminfo Array con informaci�on sobre asientos libres, ocupados y n�mero de pasillos de la sala
	*@param rooms Array con las salas de cine
	*@param films Array con la informaci�n de las peliculas
	*/
	public static void occupationMenu()
		{
		do
			{
			printers.showLogo();
			printers.showRoomOccupation();
			option=kread.readInt();
			if (option==0)
				{
				return;
				}
			else if (option<0 || option>cinerama.filminfo.length)
				{
				printers.showInfo("\nEscogiste una opci�n no v�lida, prueba de nuevo");
				utils.pause(2000);				
				}
			else
				{
				printers.showLogo();
				if (cinerama.filminfo[(option-1)][2]==1)
					{
					printers.oneAisle(cinerama.rooms[(option-1)],cinerama.filminfo[(option-1)],cinerama.films[(option-1)]);
					}
				else
					{
					printers.twoAisle(cinerama.rooms[(option-1)],cinerama.filminfo[(option-1)],cinerama.films[(option-1)]);
					}
				printers.showInfo("\n\nOperaci�n completada, pulsa intro para volver al men�.\n");
				utils.returnPause();
				}
			} while(1==1);
		}
	/**
	*M�todo que a�ade una nueva venta de entradas. Se encarga de preguntar al cliente
	*que pel�cula quiere ver, cu�ntas entradas desea (en funci�n de estos dos par�metros se
	*comprueba primeramente que haya suficientes plazas libres), solicita el m�todo de ordenaci�n
	*de tickets que deseamos y despu�s se llama a un m�todo que gestiona la ordenaci�n de butacas
	*en funci�n de la opci�n escogida.
	@param rooms Array con todas las salas de cine
	@param films Array con la informaci�n de las pel�culas disponibles
	@param filminfo Array con la informaci�n de asientos ocupados y totales de cada sala.
	@return 1 si la venta se realiza correctamente, 0 si la venta se interrumpe.
	*/
	public static int newClient()
		{
		int filmseats, ordertype;
		////////////////////////////////////
		////////////Escoger sala////////////
		////////////////////////////////////
		do
			{
			printers.showLogo();
			printers.showFilmList();
			option=easter.read();
			if (option!=Integer.MAX_VALUE) //Si es MAX_VALUE es Easter Egg
				{
				if (option==0)//Saliendo de la venta
					{
					return 0;
					}
				option--;
				if (option<0 || option>(cinerama.filminfo.length-1))
					{
					printers.showInfo("\nEscogiste una opci�n no v�lida, prueba de nuevo");
					utils.pause(2000);		
					}
				else if (cinerama.filminfo[option][0]==cinerama.filminfo[option][1])
					{
					printers.showInfo("\nLa sala de esta proyecci�n est� llena, prueba de nuevo");
					utils.pause(2000);		
					}
				else
					{
					break;
					}
				}
			} while(1==1);
		////////////////////////////////////
		/////Escoger n�mero de entradas/////
		////////////////////////////////////
		do
			{
			printers.showLogo();
			if (cinerama.filminfo[(option)][2]==1)
				{
				printers.oneAisle(cinerama.rooms[option],cinerama.filminfo[option],cinerama.films[option]);
				}
			else
				{
				printers.twoAisle(cinerama.rooms[option],cinerama.filminfo[option],cinerama.films[option]);
				}
			printers.showInfo("\nQuedan "+(cinerama.filminfo[option][0]-cinerama.filminfo[option][1])+" butacas libres. �Cu�ntas entradas desea? (0 para cancelar compra): ");
			filmseats=kread.readInt();
			if (filmseats==0)
				{
				return 0;
				}
			if (filmseats<1 || filmseats>(cinerama.filminfo[option][0]-cinerama.filminfo[option][1]))
				{
				printers.showInfo("\nHas escogido un n�mero de entradas no v�lido, prueba de nuevo");
				utils.pause(2000);	
				}
			else
				{
				break;
				}
			} while(1==1);
		////////////////////////////////////
		////Escoger m�todo de ordenaci�n////
		////////////////////////////////////
		int[] availableorder;
		boolean validtype=false;
		do
			{
			printers.showLogo();
			availableorder=printers.showTicketsMode(option,filmseats);
			ordertype=kread.readInt();
			if (ordertype==0)
				{
				return 0;
				}
			for (int i=0; i<availableorder.length; i++)
				{
				if (ordertype==availableorder[i])
					{
					validtype=true;
					break;
					}
				}	
			if (validtype==false)
				{
				printers.showInfo("\nHas escogido una opci�n no v�lida, prueba de nuevo");
				utils.pause(2000);
				}
			else
				{
				break;
				}
			} while (1==1);
		if (orderMethods(cinerama.rooms[option], filmseats, ordertype, option)==1) //Llamada al sistema de m�todos de ordenaci�n
			{
			return 1; //venta correcta
			}
		else
			{
			return 0; //venta cancelada
			}
		}
	/**
	*M�todo que gestiona la forma de comprar entradas.
	*Recibe por par�metro el m�todo escogido que puede ser:
	*	1-Ordenaci�n aleatoria sin tener en cuenta asientos contiguos.
	*	2-Ordenaci�n manual de cada ticket escogiendo fila y butaca.
	*	3-Ordenaci�n en la zona izquierda (pasillo simple) de la sala escogiendo fila.
	*	4-Ordenaci�n en la derecha (pasillo simple) de la sala escogiendo fila.
	*	5-Ordenaci�n en la zona izquierda (pasillo doble) de la sala escogiendo fila.
	*	6-Ordenaci�n en la zona central (pasillo doble) de la sala escogiendo fila.
	*	7-Ordenaci�n en la zona derecha (pasillo doble) de la sala escogiendo fila.
	*@param room Sala de cine a la sobre la que trabajaremos
	*@param filmseats N�mero de asientos a ocupar
	*@param ordertype M�todo de ordenaci�n elegido por el cliente
	*@param option Sala escogieda por el cliente
	*@return 1 Si el proceso se completa de forma satisfactoria.
	*/
	public static int orderMethods(int[][] room,int filmseats, int ordertype, int option)
		{
		int[] availablerows;
		boolean redemption=false;
		switch (ordertype)
			{
		   case 1: //Ordenaci�n aleatoria
				replaces.randomReplaceRoom(room,filmseats,option,false);
				printers.showInfo("Proceso de compra finalizado, disfrute de la pel�cula");
				utils.pause(2000);
				return 1;
		   case 2: //Ordenaci�n manual
				if (filmseats==Integer.MAX_VALUE) //Compra de entrada con Easter Egg, es gratuita
					{
					filmseats=1;
					redemption=true;
					}
				for (int i=0; i<filmseats; i++)
					{
					if (manualMethod(room,option,redemption)==1)
						{
						printers.showInfo("\nRecoja su ticket, pulse intro para continuar.");
						}
					else
						{
						printers.showInfo("\nOperaci�n cancelada, pulse intro para continuar.");
						}
					utils.returnPause();
					}
				return 1;
			case 3:
				semiautomaticMethod(room,option,1,filmseats);
				return 1;
			case 4:
				semiautomaticMethod(room,option,2,filmseats);
				return 1;
			case 5:
				semiautomaticMethod(room,option,3,filmseats);
				return 1;
			case 6:
				semiautomaticMethod(room,option,4,filmseats);
				return 1;
			case 7:
				semiautomaticMethod(room,option,5,filmseats);
				return 1;
			default:
				return 0;
			}
		}
	/**
	*
	*/
	public static int semiautomaticMethod(int[][] room, int option, int methodtype, int filmseats)
		{
		int row, col;
		boolean validrow=false, validcol=false;
		int[] availablerows=utils.aisleTickets(cinerama.rooms[option],filmseats,methodtype);
		printers.showLogo();
		//////////////////
		//Escogemos fila//
		//////////////////
		do
			{
			if (cinerama.filminfo[(option)][2]==1)
				{
				printers.oneAisle(room,cinerama.filminfo[option],cinerama.films[option]);
				}
			else
				{
				printers.twoAisle(room,cinerama.filminfo[option],cinerama.films[option]);
				}
			printers.showElement(availablerows, "fila");
			row=kread.readInt();
			if (row==0)
				{
				return 0;
				}
			row--;
			for (int i=0; i<availablerows.length; i++)
				{
				if (row==availablerows[i])
					{
					validrow=true;
					break;
					}
				}
			if (validrow)
				{
				break;
				}
			else
				{
				printers.showInfo("\nEscogiste una fila no v�lida, int�ntalo de nuevo");
				utils.pause(2000);
				}
			} while (1==1);
		int[][] seatgroups=utils.multiSeatsAvailable(room[row],filmseats,methodtype);
		////////////////////
		//Escogemos butaca//
		////////////////////
		do
			{
			printers.multiShowElement(seatgroups);
			col=kread.readInt();
			if (col==0)
				{
				return 0;
				}
			col--;
			if (col<0 || (col>seatgroups.length-1))
				{
				printers.showInfo("\nEscogiste un grupo de butacas no v�lido, int�ntalo de nuevo");
				utils.pause(2000);
				}
			else
				{
				break;
				}
			} while (1==1);
		//////////////////////////////////////////
		//Proceso de venta y cambio de ocupaci�n//
		//////////////////////////////////////////
		for (int i=seatgroups[col][0];i<=seatgroups[col][1];i++)
			{
			replaces.replaceArray(room, row, i, option); //Modificamos el array de la sala
			printers.buyedTicket(cinerama.films[option], option, row, i, false); //Imprimimos el ticket de venta			
			printers.showInfo("\nRecoja su ticket, pulse intro para continuar.");
			utils.returnPause();
			}
		return 1;
		}	
	/**
	*M�todo para elegir la butaca de forma manual. Se solicita la fila que se desea escoger
	*(el m�todo primero calcula las filas en las que se puede escoger butaca) y despu�s la butaca de esa fila
	*(el m�todo primero calcula las butacas de esa fila que se pueden escoger).
	*Una vez se ha seleccionado la butaca el m�todo llama a un m�todo externo que reemplaza la ocupaci�n de
	*la butaca y despu�s otro m�etodo que imprime el ticket de venta.
	*@param room Array de la sala de cine
	*@param option N�mero de sala de cine escogida
	*@param filminfo Array que contiene la informaci�n sobre butacas ocupadas y totales
	*@param films Array que contiene las pel�culas disponibles
	*@param redemption Booleana que indica si el ticket de venta es grauito por un easter egg o no.
	*@return 1 si el proceso de compra de entrada se realiza satisfactoriamente, 2 si el proceso
	*es interrumpido por el usuario y por tanto la compra es cancelada.
	*/
	public static int manualMethod(int[][] room, int option, boolean redemption)
		{
		int row, col;
		boolean validrow=false, validcol=false;
		int[] rowsfree=utils.rowsAvailable(room);
		//////////////////
		//Escogemos fila//
		//////////////////
		do
			{
			printers.showLogo();
			if (cinerama.filminfo[(option)][2]==1)
				{
				printers.oneAisle(room,cinerama.filminfo[option],cinerama.films[option]);
				}
			else
				{
				printers.twoAisle(room,cinerama.filminfo[option],cinerama.films[option]);
				}
			printers.showElement(rowsfree, "fila");
			row=kread.readInt();
			if (row==0)
				{
				return 0;
				}
			row--;
			for (int i=0; i<rowsfree.length; i++)
				{
				if (row==rowsfree[i])
					{
					validrow=true;
					break;
					}
				}
			if (validrow)
				{
				break;
				}
			else
				{
				printers.showInfo("\nEscogiste una fila no v�lida, int�ntalo de nuevo");
				utils.pause(2000);
				}
			} while (1==1);
		int[] colsfree=utils.seatsAvailable(room[row]);
		////////////////////
		//Escogemos butaca//
		////////////////////
		do
			{
			printers.showElement(colsfree, "butaca");
			col=kread.readInt();
			if (col==0)
				{
				return 0;
				}
			col--;
			for (int i=0; i<colsfree.length; i++)
				{
				if (col==colsfree[i])
					{
					validcol=true;
					break;
					}
				}
			if (validcol)
				{
				break;
				}
			else
				{
				printers.showInfo("\nEscogiste una butaca no v�lida, int�ntalo de nuevo");
				utils.pause(2000);
				}
			} while (1==1);
		replaces.replaceArray(room, row, col, option); //Modificamos el array de la sala
		printers.buyedTicket(cinerama.films[option], option, row, col, redemption); //Imprimimos el ticket de venta
		return 1;
		}
	}