/**
*Clase que contiene los métodos que solicitan entradas por teclado
*@version 0.3
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
		do
			{
			printers.showLogo();
			printers.showSamples();
			option=kread.readInt();
			if (option<1 || option>4)
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
	*Método para agregar las salas de cine y las películas de forma manual.
	*Se solicita la información del número de salas de cine deseadas, el tamaño
	*de cada sala de cine, los pasillos de las salas de cine yy las películas que
	*serán proyectadas, pudiendo ser éstas 2D o 3D. Toda la información recolectada
	*se transfiere a los arrays principales rooms, films y filminfo
	*/
	public static void manualRooms()
		{
		int rooms;
		/////////////////
		//Número de salas
		/////////////////
		do
			{
			printers.showLogo();
			printers.showInfo("\n¿Cuántas salas deseas (1-20): ");
			rooms=kread.readInt();
			if (rooms<1 || rooms>20)
				{
				printers.showInfo("\nHas escogido un número incorrecto de salas, vuelve a intentarlo.");
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
				printers.showInfo("\n¿Cuántas filas deseas que tenga la sala (1-20)?: ");
				showrooms[i][0]=kread.readInt();
				if (showrooms[i][0]<1 || showrooms[i][0]>20)
					{
					printers.showInfo("\nHas escogido un número incorrecto de filas, vuelve a intentarlo.");
					utils.pause(2000);
					}
				else
					{
					do
						{
						printers.showInfo("\n¿Cuántas butacas por fila deseas que tenga la sala (1-20)?: ");
						showrooms[i][1]=kread.readInt();
						if (showrooms[i][1]<1 || showrooms[i][1]>20)
							{
							printers.showInfo("\nHas escogido un número incorrecto de butacas, vuelve a intentarlo.");
							utils.pause(2000);
							}
						else
							{
							do
								{
								printers.showInfo("\n¿Deseas que la sala tenga un pasillo o dos (1-2)?: ");
								showrooms[i][2]=kread.readInt();
								if (showrooms[i][2]<1 || showrooms[i][2]>2)
									{
									printers.showInfo("\nHas escogido un número incorrecto de pasillos, vuelve a intentarlo.");
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
		//Relleno de arrays de salas e información de las salas
		cinerama.rooms=constructors.makeRooms(max_room,showrooms,cinerama.AVAILABLE);
		cinerama.filminfo=constructors.makeFilmInfo(cinerama.rooms,showrooms);
		///////////
		//Películas
		///////////
		int filmtype, chosenfilm;
		String[][] films=new String[rooms][2];
		for (int i=0; i<rooms; i++)
			{
			do
				{
				printers.showLogo();
				printers.showInfo("\nPelícula para sala "+(i+1)+" de "+rooms+" ("+cinerama.filminfo[i][0]+"plazas)");
				printers.showInfo("\n__________________________________________");
				printers.showInfo("\nEscoge el tipo de proyección:");
				printers.showInfo("\n\t(1) 3D");
				printers.showInfo("\n\t(2) 2D HD\n");
				filmtype=kread.readInt();
				if (filmtype<1 || filmtype>2)
					{
					printers.showInfo("\nHas escogido un tipo de proyección incorrecto, vuelve a intentarlo.");
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
					printers.showInfo("\nPelícula para sala "+(i+1)+" de "+rooms+" ("+cinerama.filminfo[i][0]+"plazas)");
					printers.showInfo("\n__________________________________________");
					printers.showInfo("\nEscoge entre el listado de películas:");
					for (int j=0; j<constructors.AVAILABLE3D; j++)
						{
						printers.showInfo("\n\t("+(j+1)+") "+constructors.FILMS_AVAILABLE[j][0]);
						}
					System.out.print("\n");
					chosenfilm=kread.readInt();
					if (chosenfilm<1 || chosenfilm>constructors.AVAILABLE3D)
						{
						printers.showInfo("\nHas escogido un número de película incorrecto, vuelve a intentarlo.");
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
					printers.showInfo("\nPelícula para sala "+(i+1)+" de "+rooms+" ("+cinerama.filminfo[i][0]+"plazas)");
					printers.showInfo("\n__________________________________________");
					printers.showInfo("\nEscoge entre el listado de películas:");
					for (int j=0; j<constructors.FILMS_AVAILABLE.length; j++)
						{
						printers.showInfo("\n\t("+(j+1)+") "+constructors.FILMS_AVAILABLE[j][0]);
						}
					System.out.print("\n");
					chosenfilm=kread.readInt();
					if (chosenfilm<1 || chosenfilm>constructors.FILMS_AVAILABLE.length)
						{
						printers.showInfo("\nHas escogido un número de película incorrecto, vuelve a intentarlo.");
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
			//Relleno de array de películas
			cinerama.films=films;
			}
		}
	/**
	*Método que muestra el menú recauatorio de la aplicación
	*@return True para salir del menú recaudatorio y false si debemos volver a mostrarlo
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
				printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
				utils.pause(2000);				
				}
			else
				{
				if (option==1)
					{
					printers.showRecaudatoryTable();
					printers.showInfo("\n\nOperación completada, pulsa intro para continuar.\n");
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
	*Método que muestra el menú principal de la aplicación
	*@param rooms Salas de cine de la aplicación
	*@param films Peliculas proyectadas
	*@param filminfo Contador de asistentes y capacidad de las salas
	*@return True para salir del menú principal y false si debemos volver a mostrarlo
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
						printers.showInfo("\nOperación cancelada.");
						}
					utils.pause(2000);
			      return false;
				case 2:
					occupationMenu();
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
	*@param filminfo Array con informaciñon sobre asientos libres, ocupados y número de pasillos de la sala
	*@param rooms Array con las salas de cine
	*@param films Array con la información de las peliculas
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
				printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
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
				printers.showInfo("\n\nOperación completada, pulsa intro para volver al menú.\n");
				utils.returnPause();
				}
			} while(1==1);
		}
	/**
	*Método que añade una nueva venta de entradas. Se encarga de preguntar al cliente
	*que película quiere ver, cuántas entradas desea (en función de estos dos parámetros se
	*comprueba primeramente que haya suficientes plazas libres), solicita el método de ordenación
	*de tickets que deseamos y después se llama a un método que gestiona la ordenación de butacas
	*en función de la opción escogida.
	@param rooms Array con todas las salas de cine
	@param films Array con la información de las películas disponibles
	@param filminfo Array con la información de asientos ocupados y totales de cada sala.
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
					printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
					utils.pause(2000);		
					}
				else if (cinerama.filminfo[option][0]==cinerama.filminfo[option][1])
					{
					printers.showInfo("\nLa sala de esta proyección está llena, prueba de nuevo");
					utils.pause(2000);		
					}
				else
					{
					break;
					}
				}
			} while(1==1);
		////////////////////////////////////
		/////Escoger número de entradas/////
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
			printers.showInfo("\nQuedan "+(cinerama.filminfo[option][0]-cinerama.filminfo[option][1])+" butacas libres. ¿Cuántas entradas desea? (0 para cancelar compra): ");
			filmseats=kread.readInt();
			if (filmseats==0)
				{
				return 0;
				}
			if (filmseats<1 || filmseats>(cinerama.filminfo[option][0]-cinerama.filminfo[option][1]))
				{
				printers.showInfo("\nHas escogido un número de entradas no válido, prueba de nuevo");
				utils.pause(2000);	
				}
			else
				{
				break;
				}
			} while(1==1);
		////////////////////////////////////
		////Escoger método de ordenación////
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
				printers.showInfo("\nHas escogido una opción no válida, prueba de nuevo");
				utils.pause(2000);
				}
			else
				{
				break;
				}
			} while (1==1);
		if (orderMethods(cinerama.rooms[option], filmseats, ordertype, option)==1) //Llamada al sistema de métodos de ordenación
			{
			return 1; //venta correcta
			}
		else
			{
			return 0; //venta cancelada
			}
		}
	/**
	*Método que gestiona la forma de comprar entradas.
	*Recibe por parámetro el método escogido que puede ser:
	*	1-Ordenación aleatoria sin tener en cuenta asientos contiguos.
	*	2-Ordenación manual de cada ticket escogiendo fila y butaca.
	*	3-Ordenación en la zona izquierda (pasillo simple) de la sala escogiendo fila.
	*	4-Ordenación en la derecha (pasillo simple) de la sala escogiendo fila.
	*	5-Ordenación en la zona izquierda (pasillo doble) de la sala escogiendo fila.
	*	6-Ordenación en la zona central (pasillo doble) de la sala escogiendo fila.
	*	7-Ordenación en la zona derecha (pasillo doble) de la sala escogiendo fila.
	*@param room Sala de cine a la sobre la que trabajaremos
	*@param filmseats Número de asientos a ocupar
	*@param ordertype Método de ordenación elegido por el cliente
	*@param option Sala escogieda por el cliente
	*@return 1 Si el proceso se completa de forma satisfactoria.
	*/
	public static int orderMethods(int[][] room,int filmseats, int ordertype, int option)
		{
		int[] availablerows;
		boolean redemption=false;
		switch (ordertype)
			{
		   case 1: //Ordenación aleatoria
				replaces.randomReplaceRoom(room,filmseats,option,false);
				printers.showInfo("Proceso de compra finalizado, disfrute de la película");
				utils.pause(2000);
				return 1;
		   case 2: //Ordenación manual
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
						printers.showInfo("\nOperación cancelada, pulse intro para continuar.");
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
				printers.showInfo("\nEscogiste una fila no válida, inténtalo de nuevo");
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
				printers.showInfo("\nEscogiste un grupo de butacas no válido, inténtalo de nuevo");
				utils.pause(2000);
				}
			else
				{
				break;
				}
			} while (1==1);
		//////////////////////////////////////////
		//Proceso de venta y cambio de ocupación//
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
	*Método para elegir la butaca de forma manual. Se solicita la fila que se desea escoger
	*(el método primero calcula las filas en las que se puede escoger butaca) y después la butaca de esa fila
	*(el método primero calcula las butacas de esa fila que se pueden escoger).
	*Una vez se ha seleccionado la butaca el método llama a un método externo que reemplaza la ocupación de
	*la butaca y después otro mñetodo que imprime el ticket de venta.
	*@param room Array de la sala de cine
	*@param option Número de sala de cine escogida
	*@param filminfo Array que contiene la información sobre butacas ocupadas y totales
	*@param films Array que contiene las películas disponibles
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
				printers.showInfo("\nEscogiste una fila no válida, inténtalo de nuevo");
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
				printers.showInfo("\nEscogiste una butaca no válida, inténtalo de nuevo");
				utils.pause(2000);
				}
			} while (1==1);
		replaces.replaceArray(room, row, col, option); //Modificamos el array de la sala
		printers.buyedTicket(cinerama.films[option], option, row, col, redemption); //Imprimimos el ticket de venta
		return 1;
		}
	}