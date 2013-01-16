/**
*Clase que contiene los métodos que solicitan entradas por teclado
*@version 1.0
*@author José Antonio Yáñez Jiménez
*/
public class Inputs
	{
	/**
	*Variable global utilizada en la mayoría de métodos.
	*Comunmente se utiliza para almacenar la selección de sala de cine
	*del cliente, por lo que es útil declararla en este punto para no tener
	*que pasarla por los distintos métodos como parámetro.
	*/
	public static int option;
	/**
	*Método que muestra el menú inicial.
	*Desde el menú inicial podemos acceder al menú de 
	*administración, lanzar la pantalla "acerca de" y lanzar
	*el menú principal
	*/
	public static void firstMenu()
		{
		int firstopt=0;
		boolean showadmin=true;
		do
			{
			Printers.showLogo();
			Printers.showFirstMenu(showadmin);
			firstopt=Kread.readInt();
			if (firstopt<1 || firstopt>3)
				{
				Printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
				Utils.pause(2000);
				}	
			else
				{
				switch (firstopt)
					{
					case 3:
						Printers.showInfo("NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN\nNNNNN/     \\NNNNN/     \\NNNNN/     \\NNNNN/     \\NNNN/     \\NNNNN/     \\NNNNN/     \\NNNN/     \\NNNNNN\nNNNNN       NNNNN       NNNNN       NNNNN       NNNN       NNNNN       NNNNN       NNNN       NNNNNN\nNNNNN       NNNNN       NNNNN       NNNNN       NNNN       NNNNN       NNNNN       NNNN       NNNNNN\nNNNNN       NNNNN       NNNNN       NNNNN       NNNN       NNNNN       NNNNN       NNNN       NNNNNN\nNNNNN\\     /NNNNN\\     /NNNNN\\     /NNNNN\\     /NNNN\\     /NNNNN\\     /NNNNN\\     /NNNN\\     /NNNNNN\nNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN\nNNNNN~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~NNNNNN\nNNNNN~=====================+=~===============================================================~NNNNNN\nNNNNN~================7NNNN8INNN7:===========================================================~NNNNNN\nNNNNN~==============~DN8NNN===8NNN~==========================================================~NNNNNN\nNNNNN~=============?N$=~~8NNNNNNNNN~=========================================================~NNNNNN\nNNNNN~=============NNN~=8N8NNNZ===NN=========================================================~NNNNNN\nNNNNN~============?NNNNNNNN88NN~=NNN=========================================================~NNNNNN\nNNNNN~==NNN8~=====7N===8NN=N?N8ONNND=========================================================~NNNNNN\nNNNNN$NNN~=~NN+~===N~=INN8INN~===NN==========================================================~NNNNNN\nNNNNNN==DNNNNNN====?NNNN~===NN=~NN~=====================================        =============~NNNNNN\nNNNNNNNNNN+N=~N8====~NNNN~IDNNNN8==~I==================?N8=~========                =========~NNNNNN\nNNNNN~=NNONN~NNI=======7NNNNN$7NNNNNNNI============~:NNNNNN======     Cinerama 1.0     ======~NNNNNN\nNNNNNNN8~=N~=NN=======~NNNNNNNNNNNNNNN8==========~8NNNNNNNNN=====  José Antonio Yáñez  ======~NNNNNN\nNNNNN$NN~ZNNNN======$NNNNNNNNNNNNNNNNNN~=======~DNNNNNNNNNNN=====      Enero 2013      ======~NNNNNN\nNNNNN~==7NNNNNNNNNNNNNNNNNNNNNNNNNNNNNN$~====ZNNNNNNNNNNNNNNN=======                =========~NNNNNN\nNNNNN~=NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN+NNNNNNNNNNNNNNNNNN===========        =============~NNNNNN\nNNNNN~NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN===============================~NNNNNN\nNNNNN~=NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN==============================~NNNNNN\nNNNNN~=NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN==============================~NNNNNN\nNNNN8~=NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN==============================~NNNNNN\nNNNN8~==NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN===============================================~NNNNNN\nNNNN8~===NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN================================================~NNNNNN\nNNNN8~===NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN================================================~NNNNNN\nNNNNO~====NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN===============================================~NNNNNN\nNNNN$~====NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNMM==============================================~NNNNNN\nNNNN$~=====NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNM===============================================~NNNNNN\nNNNN$~=====NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN===================================================~NNNNNN\nNNNN$~======NNNNNNNNNNNNNNNNNNNNNNN==========================================================~NNNNNN\nNNNNN~=======NNNNNNNNNNNNNNNNN===============================================================~NNNNNN\nNNNNN~~~~~~~~~~NNNNNNNNNNNNN~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~NNNNNN\nNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN\nNNNNN/     \\NNNNN/     \\NNNNN/     \\NNNNN/     \\NNNN/     \\NNNNN/     \\NNNNN/     \\NNNN/     \\NNNNNN\nNNNNN       NNNNN       NNNNN       NNNNN       NNNN       ZNNND       NNNNN       NNNN       NNNNNN\nNNNNN       NNNNN       NNNNN       NNNNN       NNNN       8NNNO       NNNNN       NNNN       NNNNNN\nNNNNN       NNNNN       NNNNN       NNNNN       NNNN       NNNNN       NNNNN       NNNN       NNNNNN\nNNNNN\\     /NNNNN\\     /NNNNN\\     /NNNNN\\     /NNNN\\     /NNNND\\     /NNNNN\\     /NNNN\\     /NNNNNN\nNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN\n");
						Utils.pause(1500);
						Printers.showInfo("\nCinerama es una aplicación desarrollada en Java utilizando el IDE\njGRASP por José Antonio Yáñez Jiménez como proyecto de navidades\ndel curso 2012-2013 de Desarrollo de aplicaciones Web en el centro\nIES Galileo de Valladolid.\n\nLa peculiaridad del proyecto radica en\nla restricción del uso de Java como un lenguaje de objetos, por lo\nque no se pueden realizar llamadas a ficheros externos ni crear\nobjetos (salvo por las matrices).\n\n\nVersión 1.0, Enero de 2013.\n");
				  		Printers.showInfo("\nPulsa intro para volver al menú");
						Utils.returnPause(); 	
						break;
					case 1:
				      showadmin=adminMenu();
						break;
					case 2: //LANZAMOS LA APLICACIÓN
				      switch (Cinerama.samplenum)
							{
						   case 1:
								Cinerama.rooms=Samples.cinema1();
								Cinerama.films=Samples.showfilms1();
								Samples.fillrooms(40,60);
						      break;
						   case 2:
								Cinerama.rooms=Samples.cinema1();
								Cinerama.films=Samples.showfilms1();
						      break;
						   case 3:
								Cinerama.rooms=Samples.cinema2();
								Cinerama.films=Samples.showfilms2();
						      break;
							case 4:
								Inputs.manualRooms();
								break;
							default:
								Cinerama.rooms=Samples.cinema1();
								Cinerama.films=Samples.showfilms1();
								break;
							}
						return;
					}
				}
			}while(1==1);
		}
	/**
	*Método que muestra el menú de administración
	*/
	public static boolean adminMenu()
		{
		String[] access={"admin","admin"};
		String[] typeaccess=new String[2];
		int accesscount=0;
		int admoption=0;
		do
			{
			Printers.showInfo("\nTeclea el usuario: ");
			typeaccess[0]=Kread.readString();
			Printers.showInfo("\nTeclea la clave: ");
			typeaccess[1]=Kread.readString();
			if (!typeaccess[0].equals(access[0]) || !typeaccess[1].equals(access[1]))
				{
				accesscount++;
				Printers.showInfo("\nDatos incorrectos, prueba de nuevo (Intento "+accesscount+" de 3).");
				}
			else
				{
				do
					{
					Printers.showLogo();
					Printers.showInfo("\nEscoge una opción a modificar (Pulsa 0 para salir del menú de administración)\n\n");
					Printers.showAdminTable();
					admoption=Kread.readInt();
					if (admoption<0 || admoption>7)
						{
						Printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
						Utils.pause(2000);
						}
					else
						{
						switch (admoption)
							{
						   case 1:
						  		Cinerama.samplenum=Inputs.selectSample();
								break;
						   case 2:
								Replaces.replaceAdm("\nNuevo precio para las entradas (1-40): ", 0, 1, 40);
						      break;
						   case 3:
								Replaces.replaceAdm("\nNuevo precio para el recargo 3D (1-10): ", 1, 1, 10);
						      break;
						   case 4:
								Replaces.replaceAdm("\nNuevo precio para las gafas 3D (1-5): ", 2, 1, 5);
						      break;
						   case 5:
								Replaces.replaceAdm("\nNuevo descuento para el carné joven (1-6): ", 3, 1, 6);
						      break;
						   case 6:
								Replaces.replaceAdm("\nNuevo descuento para familia numerosa (1-6): ", 4, 1, 6);
						      break;
						   case 7:
								Replaces.replacePromo("\nNuevo código promocional\n(El código que introduzcas será automáticamente pasado a mayúsculas): ");
						      break;
							default: //SALIDA
								return true;
							}
						}
					} while(1==1);
				}
			} while (accesscount!=3);
		Printers.showInfo("\nHas sobrepasado el límite de intentos. Como medida de seguridad el");
		Printers.showInfo("\nmenú de administración queda deshabilitado.");
		Utils.pause(2000);
		return false;
		}
	/**
	*Método que muestra el menú de selección
	*para ejemplos de prueba y solicita por teclado la opción a escoger
	*@return Opción escogida por el usuario
	*/
	public static int selectSample()
		{
		do
			{
			Printers.showLogo();
			Printers.showSamples();
			option=Kread.readInt();
			if (option<1 || option>4)
				{
				Printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
				Utils.pause(2000);
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
			Printers.showLogo();
			Printers.showInfo("\n¿Cuántas salas deseas (1-20): ");
			rooms=Kread.readInt();
			if (rooms<1 || rooms>20)
				{
				Printers.showInfo("\nHas escogido un número incorrecto de salas, vuelve a intentarlo.");
				Utils.pause(2000);
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
				Printers.showLogo();
				Printers.showInfo("\nSala "+(i+1)+" de "+rooms);
				Printers.showInfo("\n_________________________________");
				Printers.showInfo("\n¿Cuántas filas deseas que tenga la sala (1-20)?: ");
				showrooms[i][0]=Kread.readInt();
				if (showrooms[i][0]<1 || showrooms[i][0]>20)
					{
					Printers.showInfo("\nHas escogido un número incorrecto de filas, vuelve a intentarlo.");
					Utils.pause(2000);
					}
				else
					{
					do
						{
						Printers.showInfo("\n¿Cuántas butacas por fila deseas que tenga la sala (1-20)?: ");
						showrooms[i][1]=Kread.readInt();
						if (showrooms[i][1]<1 || showrooms[i][1]>20)
							{
							Printers.showInfo("\nHas escogido un número incorrecto de butacas, vuelve a intentarlo.");
							Utils.pause(2000);
							}
						else
							{
							do
								{
								Printers.showInfo("\n¿Deseas que la sala tenga un pasillo o dos (1-2)?: ");
								showrooms[i][2]=Kread.readInt();
								if (showrooms[i][2]<1 || showrooms[i][2]>2)
									{
									Printers.showInfo("\nHas escogido un número incorrecto de pasillos, vuelve a intentarlo.");
									Utils.pause(2000);
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
		int max_rows=Utils.maxOfArray(showrooms,0);
		int max_cols=Utils.maxOfArray(showrooms,1);
		int[] max_room={max_rows,max_cols};
		//Relleno de arrays de salas e información de las salas
		Cinerama.rooms=Constructors.makeRooms(max_room,showrooms);
		Cinerama.filminfo=Constructors.makeFilmInfo(Cinerama.rooms,showrooms);
		///////////
		//Películas
		///////////
		int filmtype, chosenfilm;
		String[][] films=new String[rooms][2];
		for (int i=0; i<rooms; i++)
			{
			do
				{
				Printers.showLogo();
				Printers.showInfo("\nPelícula para sala "+(i+1)+" de "+rooms+" ("+Cinerama.filminfo[i][0]+" plazas)");
				Printers.showInfo("\n__________________________________________");
				Printers.showInfo("\nEscoge el tipo de proyección:");
				Printers.showInfo("\n\t(1) 3D");
				Printers.showInfo("\n\t(2) 2D HD\n");
				filmtype=Kread.readInt();
				if (filmtype<1 || filmtype>2)
					{
					Printers.showInfo("\nHas escogido un tipo de proyección incorrecto, vuelve a intentarlo.");
					Utils.pause(2000);
					}
				else
					{
					break;
					}		
				}while(1==1);
			if (filmtype==1) //Proyección 3D
				{
				do
					{
					Printers.showLogo();
					Printers.showInfo("\nPelícula para sala "+(i+1)+" de "+rooms+" ("+Cinerama.filminfo[i][0]+" plazas)");
					Printers.showInfo("\n__________________________________________");
					Printers.showInfo("\nEscoge entre el listado de películas:");
					for (int j=0; j<Constructors.AVAILABLE3D; j++)
						{
						Printers.showInfo("\n\t("+(j+1)+") "+Constructors.FILMS_AVAILABLE[j][0]);
						}
					System.out.print("\n");
					chosenfilm=Kread.readInt();
					if (chosenfilm<1 || chosenfilm>Constructors.AVAILABLE3D)
						{
						Printers.showInfo("\nHas escogido un número de película incorrecto, vuelve a intentarlo.");
						Utils.pause(2000);
						}
					else
						{
						break;
						}
					}while(1==1);
				}
			else //Proyección 2D
				{
				do
					{
					Printers.showLogo();
					Printers.showInfo("\nPelícula para sala "+(i+1)+" de "+rooms+" ("+Cinerama.filminfo[i][0]+" plazas)");
					Printers.showInfo("\n__________________________________________");
					Printers.showInfo("\nEscoge entre el listado de películas:");
					for (int j=0; j<Constructors.FILMS_AVAILABLE.length; j++)
						{
						Printers.showInfo("\n\t("+(j+1)+") "+Constructors.FILMS_AVAILABLE[j][0]);
						}
					System.out.print("\n");
					chosenfilm=Kread.readInt();
					if (chosenfilm<1 || chosenfilm>Constructors.FILMS_AVAILABLE.length)
						{
						Printers.showInfo("\nHas escogido un número de película incorrecto, vuelve a intentarlo.");
						Utils.pause(2000);
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
				films[i][0]=Constructors.FILMS_AVAILABLE[chosenfilm][0];
				films[i][1]="yes";
				}
			else
				{
				films[i][0]=Constructors.FILMS_AVAILABLE[chosenfilm][0];
				films[i][1]="no";
				}
			//Relleno de array de películas
			Cinerama.films=films;
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
			Printers.showLogo();
			Printers.showRecaudatoryMenu();
			option=Kread.readInt();
			if (option<1 || option>5)
				{
				Printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
				Utils.pause(2000);				
				}
			else
				{
				switch (option)
					{
				   case 1:
						Printers.showInfo("\n________Beneficios brutos___________________________________________________________________________\n");						
						Printers.showGrossProfit();
						Printers.showInfo("\n\nOperación completada, pulsa intro para continuar.\n");
						Utils.returnPause();
						return false;
				   case 2:
						Printers.showInfo("\n________Deducciones_________________________________________________________________________________\n");						
						Printers.showDiscount();
						Printers.showInfo("\n\nOperación completada, pulsa intro para continuar.\n");
						Utils.returnPause();
						return false;
				   case 3:
						Printers.showInfo("\n________Beneficios netos____________________________________________________________________________\n");
						Printers.showNetProfit();
						Printers.showInfo("\n\nOperación completada, pulsa intro para continuar.\n");
						Utils.returnPause();
						return false;
				   case 4:
						Printers.showInfo("\n________Beneficios brutos___________________________________________________________________________\n");						
						Printers.showGrossProfit();
						Printers.showInfo("\n\n________Deducciones_________________________________________________________________________________\n");						
						Printers.showDiscount();
						Printers.showInfo("\n\n________Beneficios netos____________________________________________________________________________\n");
						Printers.showNetProfit();
						Printers.showInfo("\n\nOperación completada, pulsa intro para continuar.\n");
						Utils.returnPause();
						return false;
					default:
						Printers.showInfo("\nGracias por utilizar Cinerama.");
						return true;
					}
				}
			} while(1==1);
		}
	/**
	*Método que muestra el menú principal de la aplicación
	*@return True para salir del menú principal y false si debemos volver a mostrarlo
	*/
	public static boolean mainMenu()
		{
		boolean allrooms;
		do
			{
			allrooms=true;
			for (int i=0;i<Cinerama.filminfo.length;i++)
				{
				if (Cinerama.filminfo[i][0]!=Cinerama.filminfo[i][1])
					{
					allrooms=false;
					}
				}
			if (allrooms)
				{
				return true;
				}
			Printers.showLogo();
			Printers.showMainMenu();
			option=Kread.readInt();
			switch (option)
				{
			   case 1:
					if (newClient()==0)
						{
						Printers.showInfo("\nOperación cancelada.");
						Utils.pause(2000);
						}
			      return false;
				case 2:
					occupationMenu();
					return false;
				case 3:
					return true;
				default:
					Printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
					Utils.pause(2000);				
					break;
				}
			} while(1==1);
		}
	/**
	*Método que muestra el submenú de ocupación
	*/
	public static void occupationMenu()
		{
		do
			{
			Printers.showLogo();
			Printers.showRoomOccupation();
			option=Kread.readInt();
			if (option==0)
				{
				return;
				}
			else if (option<0 || option>Cinerama.filminfo.length)
				{
				Printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
				Utils.pause(2000);				
				}
			else
				{
				Printers.showLogo();
				if (Cinerama.filminfo[(option-1)][2]==1)
					{
					Printers.oneAisle(Cinerama.rooms[(option-1)],Cinerama.filminfo[(option-1)],Cinerama.films[(option-1)]);
					}
				else
					{
					Printers.twoAisle(Cinerama.rooms[(option-1)],Cinerama.filminfo[(option-1)],Cinerama.films[(option-1)]);
					}
				Printers.showInfo("\n\nOperación completada, pulsa intro para volver al menú.\n");
				Utils.returnPause();
				}
			} while(1==1);
		}
	/**
	*Método que añade una nueva venta de entradas. Se encarga de preguntar al cliente
	*que película quiere ver, cuántas entradas desea (en función de estos dos parámetros se
	*comprueba primeramente que haya suficientes plazas libres), solicita el método de ordenación
	*de tickets que deseamos y después se llama a un método que gestiona la ordenación de butacas
	*en función de la opción escogida.
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
			Printers.showLogo();
			Printers.showFilmList();
			option=Easter.read();
			if (option!=Integer.MAX_VALUE) //Si es MAX_VALUE es Easter Egg
				{
				if (option==0)//Saliendo de la venta
					{
					return 0;
					}
				option--;
				if (option<0 || option>(Cinerama.filminfo.length-1))
					{
					Printers.showInfo("\nEscogiste una opción no válida, prueba de nuevo");
					Utils.pause(2000);		
					}
				else if (Cinerama.filminfo[option][0]==Cinerama.filminfo[option][1])
					{
					Printers.showInfo("\nLa sala de esta proyección está llena, prueba de nuevo");
					Utils.pause(2000);		
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
			Printers.showLogo();
			if (Cinerama.filminfo[(option)][2]==1)
				{
				Printers.oneAisle(Cinerama.rooms[option],Cinerama.filminfo[option],Cinerama.films[option]);
				}
			else
				{
				Printers.twoAisle(Cinerama.rooms[option],Cinerama.filminfo[option],Cinerama.films[option]);
				}
			Printers.showInfo("\nQuedan "+(Cinerama.filminfo[option][0]-Cinerama.filminfo[option][1])+" butacas libres. ¿Cuántas entradas desea? (0 para cancelar compra): ");
			filmseats=Kread.readInt();
			if (filmseats==0)
				{
				return 0;
				}
			if (filmseats<1 || filmseats>(Cinerama.filminfo[option][0]-Cinerama.filminfo[option][1]))
				{
				Printers.showInfo("\nHas escogido un número de entradas no válido, prueba de nuevo");
				Utils.pause(2000);	
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
			Printers.showLogo();
			availableorder=Printers.showTicketsMode(option,filmseats);
			ordertype=Kread.readInt();
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
				Printers.showInfo("\nHas escogido una opción no válida, prueba de nuevo");
				Utils.pause(2000);
				}
			else
				{
				break;
				}
			} while (1==1);
		if (orderMethods(Cinerama.rooms[option], filmseats, ordertype, option)==1) //Llamada al sistema de métodos de ordenación
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
	*Recibe por parámetro el método escogido que puede ser:<br>
	*&nbsp;&nbsp;&nbsp;&nbsp;1-Ordenación aleatoria sin tener en cuenta asientos contiguos.<br>
	*&nbsp;&nbsp;&nbsp;&nbsp;2-Ordenación manual de cada ticket escogiendo fila y butaca.<br>
	*&nbsp;&nbsp;&nbsp;&nbsp;3-Ordenación en la zona izquierda (pasillo simple) de la sala escogiendo fila.<br>
	*&nbsp;&nbsp;&nbsp;&nbsp;4-Ordenación en la derecha (pasillo simple) de la sala escogiendo fila.<br>
	*&nbsp;&nbsp;&nbsp;&nbsp;5-Ordenación en la zona izquierda (pasillo doble) de la sala escogiendo fila.<br>
	*&nbsp;&nbsp;&nbsp;&nbsp;6-Ordenación en la zona central (pasillo doble) de la sala escogiendo fila.<br>
	*&nbsp;&nbsp;&nbsp;&nbsp;7-Ordenación en la zona derecha (pasillo doble) de la sala escogiendo fila.<br>
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
				Replaces.randomReplaceRoom(room,filmseats,option,false);
				Printers.showInfo("Proceso de compra finalizado, disfrute de la película.");
				Utils.pause(2000);
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
						Printers.showInfo("\nRecoja su ticket, pulse intro para continuar.");
						}
					else
						{
						Printers.showInfo("\nOperación cancelada, pulse intro para continuar.");
						}
					Utils.returnPause();
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
	*Método para elegir un grupo de butacas de forma manual. El método busca y muestra las 
	*posibilidades para vender varios tickets utilizando butacas contínuas. Estas butacas
	*van dividas en 2 ó 3 secciones de sala (en función del tipo de sala, de pasillo simple o doble).
	*Se escoge la fila (entre las filas que disponen de grupos de butacas suficientes) y después
	*el rango de butacas a escoger. Una vez escogido el rango se imprimen los tickets uno por uno.
	*@param room Array de la sala de cine
	*@param option Número de sala de cine escogida
	*@param methodtype Indica el grupo de butacas al que se refiere (pasillo simple o doble, 
	*izquierda, centro o derecha).
	*@param filmseats Número de asientos que se deben ocupar.
	*@return 1 si el proceso de compra de entrada se realiza satisfactoriamente, 2 si el proceso
	*es interrumpido por el usuario y por tanto la compra es cancelada.
	*/
	public static int semiautomaticMethod(int[][] room, int option, int methodtype, int filmseats)
		{
		int row, col, addonmode=0;
		boolean validrow=false, validcol=false;
		int combinedpayment=0, totalmoney=0;
		int[] availablerows=Utils.aisleTickets(Cinerama.rooms[option],filmseats,methodtype);
		Printers.showLogo();
		//////////////////
		//Escogemos fila//
		//////////////////
		do
			{
			if (Cinerama.filminfo[(option)][2]==1)
				{
				Printers.oneAisle(room,Cinerama.filminfo[option],Cinerama.films[option]);
				}
			else
				{
				Printers.twoAisle(room,Cinerama.filminfo[option],Cinerama.films[option]);
				}
			Printers.showElement(availablerows, "fila");
			row=Kread.readInt();
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
				Printers.showInfo("\nEscogiste una fila no válida, inténtalo de nuevo");
				Utils.pause(2000);
				}
			} while (1==1);
		int[][] seatgroups=Utils.multiSeatsAvailable(room[row],filmseats,methodtype);
		////////////////////
		//Escogemos butaca//
		////////////////////
		do
			{
			Printers.multiShowElement(seatgroups);
			col=Kread.readInt();
			if (col==0)
				{
				return 0;
				}
			col--;
			if (col<0 || (col>seatgroups.length-1))
				{
				Printers.showInfo("\nEscogiste un grupo de butacas no válido, inténtalo de nuevo");
				Utils.pause(2000);
				}
			else
				{
				break;
				}
			} while (1==1);
		//////////////////////////////////////////
		//               GAFAS 3D               //
		//////////////////////////////////////////
		if (Cinerama.films[option][1].equals("yes"))
			{
			glasses3D(filmseats,option);
			}
		//////////////////////////////////////////
		//Proceso de venta y cambio de ocupación//
		//////////////////////////////////////////
		for (int i=seatgroups[col][0];i<=seatgroups[col][1];i++)
			{
			Replaces.replaceArray(room, row, i, option); //Modificamos el array de la sala
			if (addonmode!=4 & addonmode!=5 & addonmode!=6)
				{
				//////////////////////////////////////////////////////////
				//Si i es 0 nos encontramos en la primera pasada,       //
				//por lo que debemos mostrar todas las opciones.        //
				//Pero si no lo es y llegamos a este punto es porque    //
				//ya se ha elegido un método de descuento no combinado, //
				//por lo que ya no debemos mostrar las opciones de      // 
				//método de descuento combinado                         //
				//////////////////////////////////////////////////////////
				if (i==0)
					{
					addonmode=Inputs.addons(filmseats,true);
					}
				else
					{
					addonmode=Inputs.addons(filmseats,false);
					}
				}
			////////////////////////////
			//Método de pago combinado//
			////////////////////////////
			if (combinedpayment==0) //Escogemos el método de pago combinado o individual
				{
				combinedpayment=paymentMethod();
				}
			if (combinedpayment==1) //Pago combinado muestra todos los tickets y al final el importe total y la pausa
				{
				totalmoney=totalmoney+Printers.buyedTicket(Cinerama.films[option], option, row, i, addonmode);
				}
			else //Pago individual
				{
				Printers.buyedTicket(Cinerama.films[option], option, row, i, addonmode); //Imprimimos el ticket de venta			
				Printers.showInfo("\nRecoja su ticket, pulse intro para continuar.");
				Utils.returnPause();
				}
			}
		if (combinedpayment==1)
			{
			Printers.showInfo("\nAbone el importe de "+totalmoney+" euros, recoja sus tickets y pulse intro para finalizar.");
			Utils.returnPause();
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
	*@param redemption Booleana que indica si el ticket de venta es grauito por un easter egg o no.
	*@return 1 si el proceso de compra de entrada se realiza satisfactoriamente, 2 si el proceso
	*es interrumpido por el usuario y por tanto la compra es cancelada.
	*/
	public static int manualMethod(int[][] room, int option, boolean redemption)
		{
		int row, col,addonmode;
		boolean validrow=false, validcol=false;
		int[] rowsfree=Utils.rowsAvailable(room);
		//////////////////
		//Escogemos fila//
		//////////////////
		do
			{
			Printers.showLogo();
			if (Cinerama.filminfo[(option)][2]==1)
				{
				Printers.oneAisle(room,Cinerama.filminfo[option],Cinerama.films[option]);
				}
			else
				{
				Printers.twoAisle(room,Cinerama.filminfo[option],Cinerama.films[option]);
				}
			Printers.showElement(rowsfree, "fila");
			row=Kread.readInt();
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
				Printers.showInfo("\nEscogiste una fila no válida, inténtalo de nuevo");
				Utils.pause(2000);
				}
			} while (1==1);
		int[] colsfree=Utils.seatsAvailable(room[row]);
		////////////////////
		//Escogemos butaca//
		////////////////////
		do
			{
			Printers.showElement(colsfree, "butaca");
			col=Kread.readInt();
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
				Printers.showInfo("\nEscogiste una butaca no válida, inténtalo de nuevo");
				Utils.pause(2000);
				}
			} while (1==1);
		Replaces.replaceArray(room, row, col, option); //Modificamos el array de la sala
		//////////////////////////////////////////
		//               GAFAS 3D               //
		//////////////////////////////////////////
		if (Cinerama.films[option][1].equals("yes"))
			{
			glasses3D(1,option);
			}
		////////////////////////////////////////////////////
		//  Si estamos regalando la entrada asignamos el  //
		//número correspondiente sin preguntar al usuario)//
		////////////////////////////////////////////////////
		if (redemption)
			{
			addonmode=7;
			}
		else
			{
			addonmode=Inputs.addons(1,false);
			}
		Printers.buyedTicket(Cinerama.films[option], option, row, col,addonmode); //Imprimimos el ticket de venta
		return 1;
		}
	/**
	*Método para administrar descuentos en los tickets de venta
	*Se activa en el momento inmediatamente anterior a la impresión del ticket
	*Se pregunta si se desea una entrada estándar, una con descuento por carné joven
	*o una con descuento por familia numerosa. El precio varía en función del tipo de ticket
	*@return 1->Estándar ind.<br> 2->C. joven ind<br> 3->F. Núm. ind.<br> 4->Estándar grupo<br>
	*5->C. Joven grupo<br>6-> F. Núm. grupo.
	*/	
	public static int addons(int filmseats, boolean showall)
		{
		int addonopt;
		do
			{
			Printers.showAddonsMenu(filmseats, showall);
			addonopt=Kread.readInt();
			if (addonopt<1 || (addonopt>6 & filmseats>1) || (addonopt>3 & filmseats<2))
				{
				Printers.showInfo("\nEscogiste una opción no válida, inténtalo de nuevo");
				Utils.pause(2000);
				}
			else
				{
				break;
				}
			} while (1==1);
		switch (addonopt)
			{
		   case 2:
		      Cinerama.filminfo[option][5]++;
				return 2;
		   case 3:
		      Cinerama.filminfo[option][6]++;
				return 3;
			case 4:
				return 4;
			case 5:
				Cinerama.filminfo[option][5]=Cinerama.filminfo[option][5]+filmseats;
				return 5;
			case 6:
		 		Cinerama.filminfo[option][6]= Cinerama.filminfo[option][6]+filmseats;
				return 6;
			default:
				return 1;
			}
		}
	/**
	*Método para administrar el modo de pago
	*Actualmente el pago de entradas puede realizarse de forma individual
	*o unificando todo el pago a la vez. Este método se invoca cuando se compran
	*varias entradas con un sistema de ordenación diferente al manual individual.
	*@return 1 para sistema individual y 2 para compra conjunta de tickets.
	*/	
	public static int paymentMethod()
		{
		int payopt;
		do
			{
			Printers.showLogo();
			Printers.showPaymentMethod();
			payopt=Kread.readInt();
			if (payopt<1 || (payopt>2))
				{
				Printers.showInfo("\nEscogiste una opción no válida, inténtalo de nuevo");
				Utils.pause(2000);
				}
			else
				{
				return payopt;
				}
			} while (1==1);
		}
	/**
	*Método para comprar gafas 3D cuando la proyección es 3D
	*Se consulta al usuario si desea algún par de gafas 3D. Puede escogerse 
	*la opción 0 para no comprar nada o hasta un máximo de pares equivalente
	*a las entradas que se van a comprar.
	*/	
	public static void glasses3D(int filmseats,int option)
		{
		int glassesopt;
		String glassesascii="\n                                    ~+O88O$$$$Z$77$~==\n                               +7NNNDDD$      ,$$$$$7777777~?+\n                              NDDNNDD             777777777Z777II7:?+\n                               8NNZ                    88$77II7III7$III77:=+\n                                                                .77IIII7=+OO~\n                                                                    +.,..+ZOOO7\n                                                                 ,.?.:Z~ ~ OOO:\n                                                                .,.Z~ ~ ~ ~O8\n                                                              .?,~ ~ ~ ~ ~ 8O\n~DNNNNDD$D+                                                   ,O~ ~ ~ ~ ~ ~N$\n:ONN.  ~DDDID$                                        ,,:.~.:~O~ ~ ~ ~ ~ ~ N\n.+$      ONN8D$$8                                .,+++OOO8OOOOZ ~ ~ ~ ~ ~ +D\n           NDNDDD8~DO                         .,,OO~ ~ ~Z88O88$~ ~ ~ ~ ~ ~M\n            NDNNDDDDD8=OO                  .:.Z ~ ~ ~ ~ ODO  N8 ~ ~ ~ ~ .I:\n               =DDDD.D.888?.O7..        .$.I ~ ~ ~ ~ ~ ~DD   8N~ ~ ~ ~,.O\n                    DDDZ8,8ODDON7=+8O+.I.88 ~ ~ ~ ~ ~ ~ NO    ODI.~++~?\n                         8DDD88NO~=8ON~88Z ~ ~ ~ ~ ~ ~ ~IM       7$$=\n                               :8NOMND888 ~ ~ ~ ~ ~ ~ ~8O\n                                 ?NNNN8D8~ ~ ~ ~ ~ ~ ~MD\n                                       ND ~ ~ ~ ~ ~ ~,O\n                                       DN? ~ ~ ~ ~ ~:Z\n                                       IDD~ ~ ~ ~,:O\n                                        $DD ~ ~:O~\n                                         ,$ZZ7:\n";
		do
			{
			Printers.showLogo();
			Printers.showGlassesMenu(filmseats);
			glassesopt=Kread.readInt();
			if (glassesopt<0 || (glassesopt>filmseats))
				{
				Printers.showInfo("\nEscogiste una opción no válida, inténtalo de nuevo");
				Utils.pause(2000);
				}
			else
				{
				Cinerama.filminfo[option][4]=(Cinerama.filminfo[option][4]+glassesopt);
				if (glassesopt!=0)
					{
					Printers.showInfo(glassesascii);
					Printers.showInfo("\nRecoja ");
					Printers.showInfo((glassesopt>1)?"sus":"su par");
					Printers.showInfo((glassesopt>1)?" "+glassesopt+" ":"");
					Printers.showInfo((glassesopt>1)?"pares":"");
					Printers.showInfo(" de gafas. Abone "+(Cinerama.prizes[2]*glassesopt));
					Printers.showInfo(((Cinerama.prizes[2]*glassesopt)>1)?" Euros.":" Euro.");
					Utils.returnPause();
					return;
					}
				return;
				}
			} while (1==1);
		}
	}