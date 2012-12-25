class printers
/**
*Cinerama for IES Galileo
*version 0.3
*Author Jos� Antonio Y��ez Jim�nez
*/
	{
	/**
	*M�todo que muestra el logo de la aplicaci�n
	*/
	public static void showLogo()
		{
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print("\n--------------------------");
		System.out.print("\n   Cinerama IES Galileo");
		System.out.print("\n--------------------------\n");
		}
	/**
	*M�todo que muestra el men� de ejemplos
	*/
	public static void showSamples()
		{
		System.out.print("\nEscoge entre uno de los siguientes rellenos:");
		System.out.print("\n\t(1) Relleno Express:");
		System.out.print("\n\t\tCine con 4 salas de tama�o variable");
		System.out.print("\n\t\t4 proyecciones aleatorias, 2 de ellas en 3D");
		System.out.print("\n\t\tLas salas comienzan al con una asistencia que var�a");
		System.out.print("\n\t\tentre el 5% y el 60% de su capacidad total");
		System.out.print("\n\t(2) Relleno 1:");
		System.out.print("\n\t\tCine con 4 salas de tama�o variable");
		System.out.print("\n\t\t4 proyecciones aleatorias, 2 de ellas en 3D");
		System.out.print("\n\t(3) Relleno 2:");
		System.out.print("\n\t\tCine con 2 salas de tama�o variable");
		System.out.print("\n\t\t2 proyecciones aleatorias");
		System.out.print("\nRelleno (1-3):");
		}
	/**
	*M�todo para realizar prints desde otras partes de la aplicaci�n
	*que no sean la clase printers
	*/
	public static void showInfo(String info)
		{
		System.out.print(info);
		}
	/**
	*
	*/
	public static void showTicketsMode(int roomtype)
		{
		System.out.print("\n(1) Orden autom�tico (Aleatorio, no se aseguran asientos contiguos).");
		if (roomtype==2)
			{
			System.out.print("\n(2) Orden autom�tico en Zona Izquierda (escogiendo fila, asientos contiguos).");
			System.out.print("\n(3) Orden autom�tico en Zona Central (escogiendo fila, asientos contiguos).");
			System.out.print("\n(4) Orden autom�tico en Zona Derecha (escogiendo fila, asientos contiguos).");
			System.out.print("\n(5) Orden manual (escogiendo fila y butaca).");
			}
		else
			{
			System.out.print("\n(2) Orden autom�tico en Zona Izquierda (escogiendo fila, asientos contiguos).");
			System.out.print("\n(3) Orden autom�tico en Zona Derecha (escogiendo fila, asientos contiguos).");
			System.out.print("\n(4) Orden manual (escogiendo fila y butaca).");
			}
		}
	/**
	*M�todo que muestra el men� principal de la aplicaci�n
	*/
	public static void showMainMenu()
		{
		System.out.print("\nEscoge entre una de las siguientes opciones:");
		System.out.print("\n\t(1) Nuevo cliente");
		System.out.print("\n\t(2) Ocupaci�n actual de las salas");
		System.out.print("\n\t(3) Cerrar caja\n");
		}
	/**
	*M�todo que muestra la ocupaci�n de las salas de cine y da la opci�n para ver
	*dicha ocupaci�n de forma gr�fica
	*@param seatcounter Array que contiene la informaci�n de ocupaci�n de las salas
	*@param films Array que contiene las peliculas
	*/
	public static void showRoomOccupation(int[][] seatcounter, String[][] films)
		{
		System.out.print("\nOcupaci�n actual de las salas (Pulsa 0 para salir cuando lo desees):");
		for (int i=0;i<seatcounter.length;i++)
			{
			System.out.print("\n\tProyecci�n "+(i+1)+", "+films[i][0]);
			if (films[i][1].equals("yes"))
				{
				System.out.print("(3D)");
				}
			System.out.print(": "+seatcounter[i][1]+" de "+seatcounter[i][0]);
			System.out.print(" ("+(seatcounter[i][1]*100)/seatcounter[i][0]+"%) (Pulsa "+(i+1)+" para ver la ocupaci�n gr�ficamente)\n");
			}
		}	
	/**
	*M�todo que muestra las proyecciones disponibles as� como la ocupaci�n de la sala
	*@param seatcounter Array que contiene la informaci�n de ocupaci�n de las salas
	*@param films Array que contiene las peliculas
	*/
	public static void showFilmList(int[][] seatcounter, String[][] films)
		{
		System.out.print("\nEste es el listado de peliculas que se proyectan hoy en Cinerama.");
		System.out.print("\nSelecciona uno de los n�meros disponibles para comprar tu entrada:\n");
		for (int i=0; i<seatcounter.length;i++)
			{
			if (seatcounter[i][0]!=seatcounter[i][1])
				{
				System.out.print("\n\t("+(i+1)+")");
				}
			else
				{
				System.out.print("\n\tSala llena. ");
				}
			System.out.print(films[i][0]);
			if (films[i][1].equals("yes"))
				{
				System.out.print("(Proyecci�n 3D)");
				}
			if (seatcounter[i][2]==1)
				{
				System.out.print(". Sala regular (1 pasillo central) ");
				}
			else
				{
				System.out.print(". Sala amplia (2 pasillos centrales) ");
				}
			System.out.print("con "+seatcounter[i][0]+" plazas totales.");
			}
		System.out.print("\n");
		}
	/**
	*M�todo que dibuja nuestra sala de cine almacenada utilizando un solo pasillo central
	*@param room Sala de cine que dibujaremos
	*@param seatcounter Array con informaci�n sobre plazas totales de la sala, plazas utilizadas y tipo de sala
	*@param film Array con informaci�n de la pelicula
	*/
	public static void oneAisle(int[][] room, int[] seatcounter, String[] film)
		{
		int[] size=utils.roomSize(room);
		System.out.print("Proyecci�n: "+film[0]);
		if (film[1].equals("yes"))
			{
			System.out.print(" (Proyeccion en 3D).\n\n");
			}
		else
			{
			System.out.print(" (Proyeccion en 2D HD).\n\n");
			}
		//***************************************************************
		//Comienzo de escritura de los asteriscos que representan
		//la pantalla
		//***************************************************************
		//Primera fila, 11 espacios de los Fl. X, eliminando un espacio para dar
		//el aspecto de la pantalla final
		System.out.printf("%-11s"," ");
		for (int i=0; i<size[1];i++)
			{
				{
				System.out.printf("%-7s","*******");
				}
			}
		System.out.print("**"); //Asteriscos de relleno para equiparar ambos lados
		System.out.print("\n");
		//Segunda fila fila
		System.out.printf("%-12s"," ");
		for (int i=0; i<size[1];i++)
			{
			System.out.printf("%-7s","*******");
			}
		System.out.print("\n");
		//***************************************************************
		//Fila del pasillo de entrada
		//***************************************************************
		//PRIMERA FILA
		System.out.printf("%-8s","________"); //Primera columna
		for (int j=0; j<size[1]; j++)
			{
			if (j==(size[1]/2)) //Columna central, pasillo
				{
				System.out.printf("%-8s","________");	
				}
			System.out.printf("%7s","_______");//L�neas del pasillo de primera l�nea
			}
		System.out.printf("%-8s","________"); //�ltima columna
		System.out.print("\n\n\n");//ESPACIADO DEL PASILLO
		//FILA CIERRE PASILLO
		System.out.printf("%8s"," "); //Primera columna
		for (int j=0; j<size[1]; j++)
			{
			if (j==(size[1]/2)) //Columna central, pasillo
				{
				System.out.printf("%-8s","_|     |");	
				}
			System.out.printf("%7s","_______");//L�neas del pasillo de primera l�nea
			}
		System.out.printf("%-8s"," "); //�ltima columna
		System.out.print("\n");		
		//FILA DE N�MEROS DE BUTACA
		System.out.printf("%8s","|"); //Primera columna
		System.out.printf("%2s%-3s%2s","  "," 1 ","  ");//L�neas del pasillo de primera l�nea
		for (int j=1; j<size[1]; j++)
			{
			if (j==(size[1]/2)) //Columna central, pasillo
				{
				System.out.printf("%-8s"," |     |");
				System.out.printf("%2s%-3s%2s","  "," "+(j+1),"  ");	
				}
		 	else if (j==(size[1]-1)) 
				{
				System.out.printf("%2s%-3s%3s","| "," "+(j+1),"  |");//L�neas del pasillo de primera l�nea
				}
			else
				{
				System.out.printf("%2s%-3s%2s","| "," "+(j+1),"  ");//L�neas del pasillo de primera l�nea
				}
			}
		System.out.print("\n");		
		//FILA CIERRE PASILLO
		System.out.printf("%8s"," |"); //Primera columna
		System.out.printf("%7s","_______");
		for (int j=1; j<size[1]; j++)
			{
			if (j==(size[1]/2)) //Columna central, pasillo
				{
				System.out.printf("%-8s","_|     |");	
				System.out.printf("%7s","_______");
				}
			else
				{
				System.out.printf("%7s","|______"); //L�neas del pasillo de primera l�nea
				}
			}
		System.out.printf("%-8s","|"); //�ltima columna
		System.out.print("\n");		
		//***************************************************************
		//Filas de la sala de cine
		//***************************************************************		
		for (int i=0; i<size[0]; i++)
			{
			//PRIMERA PARTE DE LA FILA
			System.out.printf("%-8s","       |"); //Primera columna
			for (int j=0; j<size[1]; j++) //Resto de colummnas
				{
				if (j==(size[1]/2)) //Columna central, pasillo
					{
					System.out.printf("%-8s"," |     |");	
					}
				System.out.printf("%7s","-------");//L�neas del pasillo de primera l�nea
				}
			System.out.printf("%-8s","|       "); //�ltima columna
			System.out.print("\n");
			//CUERPO DE LA FILA
			System.out.printf("%-6s%-2s","Fl. "+(i+1)," |"); //N�mero de fila, primera columna
			for (int j=0; j<size[1]; j++) //Resto de colummnas
				{
				if (j==(size[1]/2)) //Columna central, pasillo
					{
					System.out.printf("%-8s","||     |");	
					}
				if (room[i][j]==1) //Si el valor es 1 la butaca est� libre
					{	
					if (j==(size[1]-1))
						System.out.printf("%-6s%1s","|","|");
					else
						System.out.printf("%-7s","|");
					}
				else if (room[i][j]==2)//Si el valor es 2 la butaca est� ocupada
					{
					if (j==(size[1]-1))
						System.out.printf("%-6s%1s","| *** ","|");
					else
						System.out.printf("%-7s","| *** ");
					}
				}
			System.out.printf("%-8s","|Fl. "+(i+1)); //N�mero de fila, �ltima columna
			System.out.print("\n");
			//�LTIMA PARTE DE LA FILA
			System.out.printf("%8s","_______|"); //Primera columna
			for (int j=0; j<size[1]; j++) //Resto de colummnas
				{
				if (j==(size[1]/2)) //Columna central, pasillo
					{
					System.out.printf("%-8s"," |     |");	
					}
				System.out.printf("%7s","-------");
				}
			System.out.printf("%8s","|_______");
			System.out.print("\n");
			}
		//***************************************************************
		//Filas del pasillo trasero
		//***************************************************************	
		//FILA CIERRE PASILLO
		System.out.printf("%8s"," |"); //Primera columna
		for (int j=0; j<size[1]; j++)
			{
			if (j==(size[1]/2)) //Columna central, pasillo
				{
				System.out.printf("%-8s","_|     |");	
				}
			System.out.printf("%7s","_______");//L�neas del pasillo de primera l�nea
			}
		System.out.printf("%-8s","|"); //�ltima columna
		System.out.print("\n");		
		//FILA DE N�MEROS DE BUTACA
		System.out.printf("%8s","|"); //Primera columna
		System.out.printf("%2s%-3s%2s","  "," 1 ","  ");//L�neas del pasillo de primera l�nea
		for (int j=1; j<size[1]; j++)
			{
			if (j==(size[1]/2)) //Columna central, pasillo
				{
				System.out.printf("%-8s"," |     |");
				System.out.printf("%2s%-3s%2s","  "," "+(j+1),"  ");	
				}
		 	else if (j==(size[1]-1)) 
				{
				System.out.printf("%2s%-3s%3s","| "," "+(j+1),"  |");//L�neas del pasillo de primera l�nea
				}
			else
				{
				System.out.printf("%2s%-3s%2s","| "," "+(j+1),"  ");//L�neas del pasillo de primera l�nea
				}
			}
		System.out.print("\n");		
		//FILA CIERRE PASILLO
		System.out.printf("%8s"," |"); //Primera columna
		System.out.printf("%7s","_______");
		for (int j=1; j<size[1]; j++)
			{
			if (j==(size[1]/2)) //Columna central, pasillo
				{
				System.out.printf("%-8s","_|     |");	
				System.out.printf("%7s","_______");
				}
			else
				{
				System.out.printf("%7s","|______"); //L�neas del pasillo de primera l�nea
				}
			}
		System.out.printf("%-8s","|"); //�ltima columna
		System.out.print("\n");		
		}
	/**
	*M�todo que dibuja nuestra sala de cine almacenada utilizando dos pasillos centrales.
	*Este modo est� pensado para salas con m�s de 10 asientos por fila
	*@param room Sala de cine que dibujaremos
	*@param seatcounter Array con informaci�n sobre plazas totales de la sala, plazas utilizadas y tipo de sala
	*@param film Array con informaci�n de la pelicula
	*/
	public static void twoAisle(int[][] room, int[] seatcounter, String[] film)
		{
		int[] size=utils.roomSize(room);
		System.out.print("Proyecci�n: "+film[0]);
		if (film[1].equals("yes"))
			{
			System.out.print(" (Proyeccion en 3D).\n\n");
			}
		else
			{
			System.out.print(" (Proyeccion en 2D HD).\n\n");
			}
		//***************************************************************
		//Comienzo de escritura de los asteriscos que representan
		//la pantalla
		//***************************************************************
		//Primera fila, 11 espacios de los Fl. X, eliminando un espacio para dar
		//el aspecto de la pantalla final
		System.out.printf("%-11s"," ");
		for (int i=0; i<(size[1]+1);i++)
			{
				{
				System.out.printf("%-7s","*******");
				}
			}
		System.out.print("**"); //Asteriscos de relleno para equiparar ambos lados
		System.out.print("\n");
		//Segunda fila fila
		System.out.printf("%-12s"," ");
		for (int i=0; i<(size[1]+1);i++)
			{
			System.out.printf("%-7s","*******");
			}
		System.out.print("\n");
		//***************************************************************
		//Filas del pasillo de entrada
		//***************************************************************	
		//PRIMERA FILA
		System.out.printf("%-8s","________"); //Primera columna
		for (int j=0; j<size[1]; j++)
			{
			if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
				{
				System.out.printf("%-8s","________");	
				}
			System.out.printf("%7s","_______");//L�neas del pasillo de primera l�nea
			}
		System.out.printf("%-8s","________"); //�ltima columna
		System.out.print("\n\n\n");//ESPACIADO DEL PASILLO
		//FILA CIERRE PASILLO
		System.out.printf("%8s"," "); //Primera columna
		for (int j=0; j<size[1]; j++)
			{
			if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
				{
				System.out.printf("%-8s","_       ");	
				}
			System.out.printf("%7s","_______");//L�neas del pasillo de primera l�nea
			}
		System.out.printf("%-8s"," "); //�ltima columna
		System.out.print("\n");		
		//FILA DE N�MEROS DE BUTACA
		System.out.printf("%8s","|"); //Primera columna
		System.out.printf("%2s%-3s%2s","  "," 1 ","  ");//L�neas del pasillo de primera l�nea
		for (int j=1; j<size[1]; j++)
			{
			if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
				{
				System.out.printf("%-8s"," |     |");
				System.out.printf("%2s%-3s%2s","  "," "+(j+1),"  ");	
				}
		 	else if (j==(size[1]-1)) 
				{
				System.out.printf("%2s%-3s%3s","| "," "+(j+1),"  |");//L�neas del pasillo de primera l�nea
				}
			else
				{
				System.out.printf("%2s%-3s%2s","| "," "+(j+1),"  ");//L�neas del pasillo de primera l�nea
				}
			}
		System.out.print("\n");		
		//FILA CIERRE PASILLO
		System.out.printf("%8s"," |"); //Primera columna
		System.out.printf("%7s","_______");
		for (int j=1; j<size[1]; j++)
			{
			if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
				{
				System.out.printf("%-8s","_|     |");	
				System.out.printf("%7s","_______");
				}
			else
				{
				System.out.printf("%7s","|______"); //L�neas del pasillo de primera l�nea
				}
			}
		System.out.printf("%-8s","|"); //�ltima columna
		System.out.print("\n");		
		//***************************************************************
		//Filas de la sala de cine
		//***************************************************************		
		for (int i=0; i<size[0]; i++)
			{
			//PRIMERA PARTE DE LA FILA
			System.out.printf("%-8s","       |"); //Primera columna
			for (int j=0; j<size[1]; j++) //Resto de colummnas
				{
				if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
					{
					System.out.printf("%-8s"," |     |");	
					}
				System.out.printf("%7s","-------");//L�neas del pasillo de primera l�nea
				}
			System.out.printf("%-8s","|       "); //�ltima columna
			System.out.print("\n");
			//CUERPO DE LA FILA
			System.out.printf("%-6s%-2s","Fl. "+(i+1)," |"); //N�mero de fila, primera columna
			for (int j=0; j<size[1]; j++) //Resto de colummnas
				{
				if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
					{
					System.out.printf("%-8s","||     |");	
					}
				if (room[i][j]==1) //Si el valor es 1 la butaca est� libre
					{	
					if (j==(size[1]-1))
						System.out.printf("%-6s%1s","|","|");
					else
						System.out.printf("%-7s","|");
					}
				else if (room[i][j]==2)//Si el valor es 2 la butaca est� ocupada
					{
					if (j==(size[1]-1))
						System.out.printf("%-6s%1s","| *** ","|");
					else
						System.out.printf("%-7s","| *** ");
					}
				}
			System.out.printf("%-8s","|Fl. "+(i+1)); //N�mero de fila, �ltima columna
			System.out.print("\n");
			//�LTIMA PARTE DE LA FILA
			System.out.printf("%8s","_______|"); //Primera columna
			for (int j=0; j<size[1]; j++) //Resto de colummnas
				{
				if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
					{
					System.out.printf("%-8s"," |     |");	
					}
				System.out.printf("%7s","-------");
				}
			System.out.printf("%8s","|_______");
			System.out.print("\n");
			}
		//***************************************************************
		//Filas del pasillo trasero
		//***************************************************************	
		//FILA CIERRE PASILLO
		System.out.printf("%8s"," |"); //Primera columna
		for (int j=0; j<size[1]; j++)
			{
			if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
				{
				System.out.printf("%-8s","_|     |");	
				}
			System.out.printf("%7s","_______");//L�neas del pasillo de primera l�nea
			}
		System.out.printf("%-8s","|"); //�ltima columna
		System.out.print("\n");		
		//FILA DE N�MEROS DE BUTACA
		System.out.printf("%8s","|"); //Primera columna
		System.out.printf("%2s%-3s%2s","  "," 1 ","  ");//L�neas del pasillo de primera l�nea
		for (int j=1; j<size[1]; j++)
			{
			if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
				{
				System.out.printf("%-8s"," |     |");
				System.out.printf("%2s%-3s%2s","  "," "+(j+1),"  ");	
				}
		 	else if (j==(size[1]-1)) 
				{
				System.out.printf("%2s%-3s%3s","| "," "+(j+1),"  |");//L�neas del pasillo de primera l�nea
				}
			else
				{
				System.out.printf("%2s%-3s%2s","| "," "+(j+1),"  ");//L�neas del pasillo de primera l�nea
				}
			}
		System.out.print("\n");		
		//FILA CIERRE PASILLO
		System.out.printf("%8s"," |"); //Primera columna
		System.out.printf("%7s","_______");
		for (int j=1; j<size[1]; j++)
			{
			if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
				{
				System.out.printf("%-8s","_|     |");	
				System.out.printf("%7s","_______");
				}
			else
				{
				System.out.printf("%7s","|______"); //L�neas del pasillo de primera l�nea
				}
			}
		System.out.printf("%-8s","|"); //�ltima columna
		System.out.print("\n");		
		}
	}