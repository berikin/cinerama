class printers
/**
*Cinerama for IES Galileo
*version 0.3
*Author José Antonio Yáñez Jiménez
*/
	{
	/**
	*Método que muestra el logo de la aplicación
	*/
	public static void showLogo()
		{
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print("\n--------------------------");
		System.out.print("\n   Cinerama IES Galileo");
		System.out.print("\n--------------------------\n");
		}
	/**
	*Método que muestra el menú de ejemplos
	*/
	public static void showSamples()
		{
		System.out.print("\nEscoge entre uno de los siguientes rellenos:");
		System.out.print("\n\t(1) Relleno Express:");
		System.out.print("\n\t\tCine con 4 salas de tamaño variable");
		System.out.print("\n\t\t4 proyecciones aleatorias, 2 de ellas en 3D");
		System.out.print("\n\t\tLas salas comienzan con una asistencia que varía");
		System.out.print("\n\t\tentre el 5% y el 60% de su capacidad total");
		System.out.print("\n\t(2) Relleno 1:");
		System.out.print("\n\t\tCine con 4 salas de tamaño variable");
		System.out.print("\n\t\t4 proyecciones aleatorias, 2 de ellas en 3D");
		System.out.print("\n\t(3) Relleno 2:");
		System.out.print("\n\t\tCine con 2 salas de tamaño variable");
		System.out.print("\n\t\t2 proyecciones aleatorias");
		System.out.print("\n\t(4) Introducción manual de datos");
		System.out.print("\n\nRelleno (1-4):");
		}
	/**
	*Método para realizar prints desde otras partes de la aplicación
	*que no sean la clase printers
	*/
	public static void showInfo(String info)
		{
		System.out.print(info);
		}
	/**
	*Método que sirve para mostrar las filas/butacas disponibles a escoger
	*@param elementfree Array con las /filas/butacas disponibles
	*@param type Cadena de texto que indica si nos referimos a filas o butacas
	*/
	public static void showElement(int[] elementfree, String type)
		{
		System.out.print("\nEscoge la "+type+" (");
		for (int i=0; i<(elementfree.length-1); i++)
			{
			System.out.print((elementfree[i]+1)+", ");
			}
		System.out.print((elementfree[elementfree.length-1]+1)+"): ");
		}
	/**
	*Método que sirve para mostrar las butacas disponibles a escoger
	*cuando se trata de grupos de butacas. Método muy similar a showElement
	*@param elementfree Array con las /filas/butacas disponibles
	*@param type Cadena de texto que indica si nos referimos a filas o butacas
	*/
	public static void multiShowElement(int[][] elementfree)
		{
		System.out.print("\nEscoge el grupo de butacas:");
		for (int i=0; i<(elementfree.length); i++)
			{
			System.out.print("\n\t("+(i+1)+")de la butaca "+(elementfree[i][0]+1)+" a la butaca "+(elementfree[i][1]+1));
			}
		System.out.print("\n");
		}
	/**
	*Método que dibuja en pantalla el ticket de compra con la información completa
	*@param film Arrary con la información de la película
	*@param roomnumber Número de sala
	*@param row Fila de la butaca vendida
	*@param col Número de butaca vendida
	*/
	public static void buyedTicket(String[] film,int roomnumber,int row,int col, boolean redemption)
		{
		System.out.print("\n____________________________________________________________\n"); //60 lineas
		System.out.printf("%1s%58s%1s","|"," ","|\n");
		System.out.printf("%1s%-58s%1s","|","    Cinerama IES Galileo","|\n");
		System.out.printf("%1s%-58s%1s","|","    ____________________","|\n");
		System.out.printf("%1s%58s%1s","|"," ","|\n");
		System.out.printf("%1s%-58s%1s","|","    Proyección:","|\n");
		System.out.printf("%1s%-58s%1s","|","       "+film[0],"|\n");
		if (film[1].equals("yes"))
			{
			System.out.printf("%1s%-58s%1s","|","       (Proyección en 3D)","|\n");
			}
		else
			{
			System.out.printf("%1s%-58s%1s","|","       (Proyección en HD 2D)","|\n");
			}
		System.out.printf("%1s%58s%1s","|"," ","|\n");
		System.out.printf("%1s%-58s%1s","|","    Sala "+(roomnumber+1)+", Fila "+(row+1)+", Butaca "+(col+1),"|\n");
		if (redemption)
			{
			System.out.printf("%1s%-58s%1s","|","       ####ENTRADA GRATUITA####","|\n");
			}
		else
			{
			if (film[1].equals("yes"))
				{
				System.out.printf("%1s%-58s%1s","|","       Precio: "+cinerama.PRIZE+" Euros.  Suplemento 3D: "+cinerama.PRIZE_3D+" Euros.","|\n");
				System.out.printf("%1s%-58s%1s","|","                 TOTAL: "+(cinerama.PRIZE+cinerama.PRIZE_3D)+" Euros.","|\n");
				}
			else
				{
				System.out.printf("%1s%-58s%1s","|","       Precio: "+cinerama.PRIZE+" Euros.","|\n");
				System.out.printf("%1s%-58s%1s","|","                 TOTAL: "+cinerama.PRIZE+" Euros.","|\n");
				}
			}
		System.out.printf("%1s%58s%1s","|"," ","|\n");
		System.out.print("|__________________________________________________________|"); //40 lineas
		}
	/**
	*Método que imprime por pantalla las posibles opciones de orden de venta de butacas.
	*Las opciones varían en función del tipo de sala que proyecta la película.
	*@param option Sala/proyección escogida.
	*@param filmseats Número de butacas que deben ocuparse.
	*@return Array con las opciones disponibles.
	*/
	public static int[] showTicketsMode(int option,int filmseats)
		{
		int[] availablerows;
		int[] availableoptions=new int[7];
		int counter_available=2,aux=0;
		boolean oneleft=false, oneright=false, twoleft=false, twocenter=false, tworight=false;
		System.out.print("\n(1) Orden automático (Aleatorio, no se aseguran asientos contiguos).");
		System.out.print("\n(2) Orden manual (escogiendo fila y butaca).");
		//////////////////////////////////////////////////////////////////
		//  Sección reservada para ventas de mas de un ticket a la vez  //
		//   La ordenación es manual pero se tienen en cuenta que los   //
		//              tickets que se vendan sean contiguos            //
		//////////////////////////////////////////////////////////////////
		if (filmseats!=1) 
			{
			if (cinerama.filminfo[option][2]==2)
				{
				availablerows=utils.aisleTickets(cinerama.rooms[option],filmseats,3);
				if (availablerows[0]!=Integer.MAX_VALUE)
					{
					System.out.print("\n(5) Orden manual en Zona Izquierda (asientos contiguos).");
					twoleft=true;
					}
				availablerows=utils.aisleTickets(cinerama.rooms[option],filmseats,4);
				if (availablerows[0]!=Integer.MAX_VALUE)
					{
					System.out.print("\n(6) Orden manual en Zona Central (asientos contiguos).");
					twocenter=true;
					}
				availablerows=utils.aisleTickets(cinerama.rooms[option],filmseats,5);
				if (availablerows[0]!=Integer.MAX_VALUE)
					{
					System.out.print("\n(7) Orden manual en Zona Derecha (asientos contiguos).");
					tworight=true;
					}
				}
			else
				{
				availablerows=utils.aisleTickets(cinerama.rooms[option],filmseats,1);
				if (availablerows[0]!=Integer.MAX_VALUE)
					{
					System.out.print("\n(3) Orden manual en Zona Izquierda (asientos contiguos).");
					oneleft=true;
					}
				availablerows=utils.aisleTickets(cinerama.rooms[option],filmseats,2);
				if (availablerows[0]!=Integer.MAX_VALUE)
					{
					System.out.print("\n(4) Orden manual en Zona Derecha (asientos contiguos).");
					oneright=true;
					}
				}
			}
		System.out.print("\n");
		//////////////////////////////////////////////////////////////
		//Devolvemos al invocador las opciones disponibles en un array
		//Esto nos evita volver a calcularlas
		//////////////////////////////////////////////////////////////
		availableoptions[0]=1;
		availableoptions[1]=2;
		if (oneleft)
			{
			availableoptions[counter_available]=3;
			counter_available++;
			}
		if (oneright)
			{
			availableoptions[counter_available]=4;
			counter_available++;
			}
		if (twoleft)
			{
			availableoptions[counter_available]=5;
			counter_available++;
			}
		if (twocenter)
			{
			availableoptions[counter_available]=6;
			counter_available++;
			}
		if (tworight)
			{
			availableoptions[counter_available]=7;
			counter_available++;
			}
		for (int i=0;i<availableoptions.length;i++)
			{
			if (availableoptions[i]!=0)
				{
				aux++;
				}
			}
		int[] returnavailable=new int[aux];
		for (int i=0;i<aux;i++)
			{
			returnavailable[i]=availableoptions[i];
			}
		return returnavailable;
		}
	/**
	*Método que muestra el menú principal de la aplicación
	*/
	public static void showMainMenu()
		{
		System.out.print("\nEscoge entre una de las siguientes opciones:");
		System.out.print("\n\t(1) Nuevo cliente");
		System.out.print("\n\t(2) Ocupación actual de las salas");
		System.out.print("\n\t(3) Cerrar caja");
		System.out.print("\n");
		}
	/**
	*Método que muestra el menú principal de la aplicación
	*/
	public static void showRecaudatoryMenu()
		{
		System.out.print("\nEscoge entre una de las siguientes opciones:");
		System.out.print("\n\t(1) Tabla de ventas");
		System.out.print("\n\t(2) Cerrar Aplicación\n");
		}
	/**
	*Método que muestra la tabla de recaudación del cine con beneficios y deducciones
	*/
	public static void showRecaudatoryTable()
		{
		int totalprofit=0;
		System.out.print("\nTabla de Recaudación");
		System.out.print("\n____________________\n\n");
		System.out.printf("%-40s%10s%11s%5s%14s","Película"," | Butacas"," | Vendidas"," | 3D"," |  Beneficio ");
		System.out.print("\n================================================================================\n");
		for (int i=0; i<cinerama.films.length; i++)
			{
			if (cinerama.films[i][1].equals("yes"))
				{
				System.out.printf("%-40s%3s%7s%3s%8s%5s%3s%11s",cinerama.films[i][0]," | ",cinerama.filminfo[i][0]," | ",cinerama.filminfo[i][1]," | Si"," | ",((cinerama.PRIZE*cinerama.filminfo[i][1])+(cinerama.PRIZE_3D*cinerama.filminfo[i][1]))+" Euros\n");
				totalprofit=totalprofit+((cinerama.PRIZE*cinerama.filminfo[i][1])+(cinerama.PRIZE_3D*cinerama.filminfo[i][1]));
				}
			else
				{
				System.out.printf("%-40s%3s%7s%3s%8s%5s%3s%11s",cinerama.films[i][0]," | ",cinerama.filminfo[i][0]," | ",cinerama.filminfo[i][1]," | No"," | ",(cinerama.PRIZE*cinerama.filminfo[i][1])+" Euros\n");
				totalprofit=totalprofit+(cinerama.PRIZE*cinerama.filminfo[i][1]);
				}
			}
		System.out.print("================================================================================\n");
		System.out.printf("%-53s%13s%14s","Película"," | Regaladas "," |  Deducción ");
		System.out.print("\n================================================================================\n");
		for (int i=0; i<cinerama.films.length; i++)
			{
			if (cinerama.films[i][1].equals("yes"))
				{
				System.out.printf("%-53s%3s%10s%3s%11s",cinerama.films[i][0]," | ",cinerama.filminfo[i][3]," | ",((cinerama.PRIZE*cinerama.filminfo[i][3])+(cinerama.PRIZE_3D*cinerama.filminfo[i][3]))+" Euros\n");
				totalprofit=totalprofit-((cinerama.PRIZE*cinerama.filminfo[i][3])+(cinerama.PRIZE_3D*cinerama.filminfo[i][3]));
				}
			else
				{
				System.out.printf("%-53s%3s%10s%3s%11s",cinerama.films[i][0]," | ",cinerama.filminfo[i][3]," | ",(cinerama.PRIZE*cinerama.filminfo[i][3])+" Euros\n");
				totalprofit=totalprofit-(cinerama.PRIZE*cinerama.filminfo[i][3]);
				}
			
			}
		System.out.print("================================================================================\n");
		System.out.printf("%-66s%3s%11s","Beneficio total","| ",totalprofit+ " Euros ");
		}
	/**
	*Método que muestra la ocupación de las salas de cine y da la opción para ver
	*dicha ocupación de forma gráfica
	*/
	public static void showRoomOccupation()
		{
		System.out.print("\nOcupación actual de las salas (Pulsa 0 para salir cuando lo desees):\n");
		for (int i=0;i<cinerama.filminfo.length;i++)
			{
			System.out.print("\n\tProyección "+(i+1)+", "+cinerama.films[i][0]);
			if (cinerama.films[i][1].equals("yes"))
				{
				System.out.print("(3D)");
				}
			System.out.print(": "+cinerama.filminfo[i][1]+" de "+cinerama.filminfo[i][0]);
			System.out.print(" ("+(cinerama.filminfo[i][1]*100)/cinerama.filminfo[i][0]+"%) (Pulsa "+(i+1)+" para ver la ocupación gráficamente)\n");
			}
		}	
	/**
	*Método que muestra las proyecciones disponibles así como la ocupación de la sala
	*/
	public static void showFilmList()
		{
		System.out.print("\nEste es el listado de peliculas que se proyectan hoy en Cinerama.");
		System.out.print("\nSelecciona uno de los números disponibles para comprar tu entrada:\n");
		for (int i=0; i<cinerama.filminfo.length;i++)
			{
			if (cinerama.filminfo[i][0]!=cinerama.filminfo[i][1])
				{
				System.out.print("\n\t("+(i+1)+")");
				}
			else
				{
				System.out.print("\n\tSala llena. ");
				}
			System.out.print(cinerama.films[i][0]);
			if (cinerama.films[i][1].equals("yes"))
				{
				System.out.print("(Proyección 3D)");
				}
			if (cinerama.filminfo[i][2]==1)
				{
				System.out.print(". Sala regular (1 pasillo central) ");
				}
			else
				{
				System.out.print(". Sala amplia (2 pasillos centrales) ");
				}
			System.out.print("con "+cinerama.filminfo[i][0]+" plazas totales.");
			}
		System.out.print("\n");
		}
	/**
	*Método que dibuja nuestra sala de cine almacenada utilizando un solo pasillo central
	*@param room Sala de cine que dibujaremos
	*@param filminfo Array con información sobre plazas totales de la sala, plazas utilizadas y tipo de sala
	*@param film Array con información de la pelicula
	*/
	public static void oneAisle(int[][] room, int[] filminfo, String[] film)
		{
		int[] size=utils.roomSize(room);
		System.out.print("Proyección: "+film[0]);
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
			System.out.printf("%7s","_______");//Líneas del pasillo de primera línea
			}
		System.out.printf("%-8s","________"); //Última columna
		System.out.print("\n\n\n");//ESPACIADO DEL PASILLO
		//FILA CIERRE PASILLO
		System.out.printf("%8s"," "); //Primera columna
		for (int j=0; j<size[1]; j++)
			{
			if (j==(size[1]/2)) //Columna central, pasillo
				{
				System.out.printf("%-8s","_|     |");	
				}
			System.out.printf("%7s","_______");//Líneas del pasillo de primera línea
			}
		System.out.printf("%-8s"," "); //Última columna
		System.out.print("\n");		
		//FILA DE NÚMEROS DE BUTACA
		System.out.printf("%8s","|"); //Primera columna
		System.out.printf("%2s%-3s%2s","  "," 1 ","  ");//Líneas del pasillo de primera línea
		for (int j=1; j<size[1]; j++)
			{
			if (j==(size[1]/2)) //Columna central, pasillo
				{
				System.out.printf("%-8s"," |     |");
				System.out.printf("%2s%-3s%2s","  "," "+(j+1),"  ");	
				}
		 	else if (j==(size[1]-1)) 
				{
				System.out.printf("%2s%-3s%3s","| "," "+(j+1),"  |");//Líneas del pasillo de primera línea
				}
			else
				{
				System.out.printf("%2s%-3s%2s","| "," "+(j+1),"  ");//Líneas del pasillo de primera línea
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
				System.out.printf("%7s","|______"); //Líneas del pasillo de primera línea
				}
			}
		System.out.printf("%-8s","|"); //Última columna
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
				System.out.printf("%7s","-------");//Líneas del pasillo de primera línea
				}
			System.out.printf("%-8s","|       "); //Última columna
			System.out.print("\n");
			//CUERPO DE LA FILA
			System.out.printf("%-6s%-2s","Fl. "+(i+1)," |"); //Número de fila, primera columna
			for (int j=0; j<size[1]; j++) //Resto de colummnas
				{
				if (j==(size[1]/2)) //Columna central, pasillo
					{
					System.out.printf("%-8s","||     |");	
					}
				if (room[i][j]==1) //Si el valor es 1 la butaca está libre
					{	
					if (j==(size[1]-1))
						System.out.printf("%-6s%1s","|","|");
					else
						System.out.printf("%-7s","|");
					}
				else if (room[i][j]==2)//Si el valor es 2 la butaca está ocupada
					{
					if (j==(size[1]-1))
						System.out.printf("%-6s%1s","| *** ","|");
					else
						System.out.printf("%-7s","| *** ");
					}
				}
			System.out.printf("%-8s","|Fl. "+(i+1)); //Número de fila, última columna
			System.out.print("\n");
			//ÚLTIMA PARTE DE LA FILA
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
			System.out.printf("%7s","_______");//Líneas del pasillo de primera línea
			}
		System.out.printf("%-8s","|"); //Última columna
		System.out.print("\n");		
		//FILA DE NÚMEROS DE BUTACA
		System.out.printf("%8s","|"); //Primera columna
		System.out.printf("%2s%-3s%2s","  "," 1 ","  ");//Líneas del pasillo de primera línea
		for (int j=1; j<size[1]; j++)
			{
			if (j==(size[1]/2)) //Columna central, pasillo
				{
				System.out.printf("%-8s"," |     |");
				System.out.printf("%2s%-3s%2s","  "," "+(j+1),"  ");	
				}
		 	else if (j==(size[1]-1)) 
				{
				System.out.printf("%2s%-3s%3s","| "," "+(j+1),"  |");//Líneas del pasillo de primera línea
				}
			else
				{
				System.out.printf("%2s%-3s%2s","| "," "+(j+1),"  ");//Líneas del pasillo de primera línea
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
				System.out.printf("%7s","|______"); //Líneas del pasillo de primera línea
				}
			}
		System.out.printf("%-8s","|"); //Última columna
		System.out.print("\n");		
		}
	/**
	*Método que dibuja nuestra sala de cine almacenada utilizando dos pasillos centrales.
	*Este modo está pensado para salas con más de 10 asientos por fila
	*@param room Sala de cine que dibujaremos
	*@param filminfo Array con información sobre plazas totales de la sala, plazas utilizadas y tipo de sala
	*@param film Array con información de la pelicula
	*/
	public static void twoAisle(int[][] room, int[] filminfo, String[] film)
		{
		int[] size=utils.roomSize(room);
		System.out.print("Proyección: "+film[0]);
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
			System.out.printf("%7s","_______");//Líneas del pasillo de primera línea
			}
		System.out.printf("%-8s","________"); //Última columna
		System.out.print("\n\n\n");//ESPACIADO DEL PASILLO
		//FILA CIERRE PASILLO
		System.out.printf("%8s"," "); //Primera columna
		for (int j=0; j<size[1]; j++)
			{
			if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
				{
				System.out.printf("%-8s","_       ");	
				}
			System.out.printf("%7s","_______");//Líneas del pasillo de primera línea
			}
		System.out.printf("%-8s"," "); //Última columna
		System.out.print("\n");		
		//FILA DE NÚMEROS DE BUTACA
		System.out.printf("%8s","|"); //Primera columna
		System.out.printf("%2s%-3s%2s","  "," 1 ","  ");//Líneas del pasillo de primera línea
		for (int j=1; j<size[1]; j++)
			{
			if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
				{
				System.out.printf("%-8s"," |     |");
				System.out.printf("%2s%-3s%2s","  "," "+(j+1),"  ");	
				}
		 	else if (j==(size[1]-1)) 
				{
				System.out.printf("%2s%-3s%3s","| "," "+(j+1),"  |");//Líneas del pasillo de primera línea
				}
			else
				{
				System.out.printf("%2s%-3s%2s","| "," "+(j+1),"  ");//Líneas del pasillo de primera línea
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
				System.out.printf("%7s","|______"); //Líneas del pasillo de primera línea
				}
			}
		System.out.printf("%-8s","|"); //Última columna
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
				System.out.printf("%7s","-------");//Líneas del pasillo de primera línea
				}
			System.out.printf("%-8s","|       "); //Última columna
			System.out.print("\n");
			//CUERPO DE LA FILA
			System.out.printf("%-6s%-2s","Fl. "+(i+1)," |"); //Número de fila, primera columna
			for (int j=0; j<size[1]; j++) //Resto de colummnas
				{
				if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
					{
					System.out.printf("%-8s","||     |");	
					}
				if (room[i][j]==1) //Si el valor es 1 la butaca está libre
					{	
					if (j==(size[1]-1))
						System.out.printf("%-6s%1s","|","|");
					else
						System.out.printf("%-7s","|");
					}
				else if (room[i][j]==2)//Si el valor es 2 la butaca está ocupada
					{
					if (j==(size[1]-1))
						System.out.printf("%-6s%1s","| *** ","|");
					else
						System.out.printf("%-7s","| *** ");
					}
				}
			System.out.printf("%-8s","|Fl. "+(i+1)); //Número de fila, última columna
			System.out.print("\n");
			//ÚLTIMA PARTE DE LA FILA
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
			System.out.printf("%7s","_______");//Líneas del pasillo de primera línea
			}
		System.out.printf("%-8s","|"); //Última columna
		System.out.print("\n");		
		//FILA DE NÚMEROS DE BUTACA
		System.out.printf("%8s","|"); //Primera columna
		System.out.printf("%2s%-3s%2s","  "," 1 ","  ");//Líneas del pasillo de primera línea
		for (int j=1; j<size[1]; j++)
			{
			if (j==(size[1]/3) || j==(size[1]-(size[1]/3))) //Columna central, pasillo
				{
				System.out.printf("%-8s"," |     |");
				System.out.printf("%2s%-3s%2s","  "," "+(j+1),"  ");	
				}
		 	else if (j==(size[1]-1)) 
				{
				System.out.printf("%2s%-3s%3s","| "," "+(j+1),"  |");//Líneas del pasillo de primera línea
				}
			else
				{
				System.out.printf("%2s%-3s%2s","| "," "+(j+1),"  ");//Líneas del pasillo de primera línea
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
				System.out.printf("%7s","|______"); //Líneas del pasillo de primera línea
				}
			}
		System.out.printf("%-8s","|"); //Última columna
		System.out.print("\n");		
		}
	}