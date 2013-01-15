class Printers
/**
*Cinerama for IES Galileo
*version 0.4
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
		System.out.print("\n\t\tLas salas comienzan con una asistencia que var�a");
		System.out.print("\n\t\tentre el 5% y el 60% de su capacidad total");
		System.out.print("\n\t(2) Relleno 1:");
		System.out.print("\n\t\tCine con 4 salas de tama�o variable");
		System.out.print("\n\t\t4 proyecciones aleatorias, 2 de ellas en 3D");
		System.out.print("\n\t(3) Relleno 2:");
		System.out.print("\n\t\tCine con 2 salas de tama�o variable");
		System.out.print("\n\t\t2 proyecciones aleatorias");
		System.out.print("\n\t(4) Introducci�n manual de datos");
		System.out.print("\n\nRelleno (1-4):");
		}
	/**
	*M�todo que muestra el men� compra de gafas 3D
	*/
	public static void showGlassesMenu(int pairs)
		{
		System.out.print("\nCinerama le ofrece la posibilidad de comprar");
		System.out.print("\nlas fant�sticas gafas 3D modelo Vision.");
		System.out.print("\nSi no desea ning�n par simplemente pulse 0");
		System.out.print("\n\nPares de gafas a comprar (0-"+pairs+"): ");
		}
	/**
	*M�todo para realizar prints desde otras partes de la aplicaci�n
	*que no sean la clase printers
	*@param info Cadena de texto que debe imprimirse
	*/
	public static void showInfo(String info)
		{
		System.out.print(info);
		}
	/**
	*M�todo que sirve para mostrar las filas/butacas disponibles a escoger
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
	*M�todo que sirve para mostrar las butacas disponibles a escoger
	*cuando se trata de grupos de butacas. M�todo muy similar a showElement
	*@param elementfree Array con las /filas/butacas disponibles
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
	*M�todo que dibuja en pantalla el ticket de compra con la informaci�n completa
	*@param film Arrary con la informaci�n de la pel�cula
	*@param roomnumber N�mero de sala
	*@param row Fila de la butaca vendida
	*@param col N�mero de butaca vendida
	*@param addonmode Indica el tipo de ticket (simple, descuento C. joven o F. n�m, gratuito)
	*@return Cantidad a pagar por el ticket
	*/
	public static int buyedTicket(String[] film,int roomnumber,int row,int col, int addonmode)
		{
		int ticketprize;
		System.out.print("\n____________________________________________________________\n"); //60 lineas
		System.out.printf("%1s%58s%1s","|"," ","|\n");
		System.out.printf("%1s%-58s%1s","|","    Cinerama IES Galileo","|\n");
		System.out.printf("%1s%-58s%1s","|","    ____________________","|\n");
		System.out.printf("%1s%58s%1s","|"," ","|\n");
		System.out.printf("%1s%-58s%1s","|","    Proyecci�n:","|\n");
		System.out.printf("%1s%-58s%1s","|","       "+film[0],"|\n");
		if (film[1].equals("yes"))
			{
			System.out.printf("%1s%-58s%1s","|","       (Proyecci�n en 3D)","|\n");
			}
		else
			{
			System.out.printf("%1s%-58s%1s","|","       (Proyecci�n en HD 2D)","|\n");
			}
		System.out.printf("%1s%58s%1s","|"," ","|\n");
		System.out.printf("%1s%-58s%1s","|","    Sala "+(roomnumber+1)+", Fila "+(row+1)+", Butaca "+(col+1),"|\n");
		if (film[1].equals("yes"))
			{
			switch (addonmode)
				{
				//Carn� joven
			   case 2:
				case 5:
					ticketprize=((Cinerama.PRIZES[0]+Cinerama.PRIZES[1])-Cinerama.PRIZES[3]);
					System.out.printf("%1s%4s%-54s%1s","|"," ","Descuento Carn� Joven: "+Cinerama.PRIZES[3]+" Euros.","|\n");
					System.out.printf("%1s%-58s%1s","|","    Precio: "+Cinerama.PRIZES[0]+" Euros.  Suplemento 3D: "+Cinerama.PRIZES[1]+" Euros.","|\n");
					System.out.printf("%1s%-58s%1s","|","                 TOTAL: "+ticketprize+" Euros.","|\n");		      
					break;
				//Familia numerosa
			   case 3:
				case 6:
					ticketprize=((Cinerama.PRIZES[0]+Cinerama.PRIZES[1])-Cinerama.PRIZES[4]);
					System.out.printf("%1s%4s%-54s%1s","|"," ","Descuento Familia Numerosa: "+Cinerama.PRIZES[4]+" Euros.","|\n");
					System.out.printf("%1s%-58s%1s","|","    Precio: "+Cinerama.PRIZES[0]+" Euros.  Suplemento 3D: "+Cinerama.PRIZES[1]+" Euros.","|\n");
					System.out.printf("%1s%-58s%1s","|","                 TOTAL: "+ticketprize+" Euros.","|\n");		      
			      break;
				//Gratuita
				case 7:
					ticketprize=0;
					System.out.printf("%1s%4s%-54s%1s","|"," ","Entrada adquirida con promoci�n","|\n");
					System.out.printf("%1s%-58s%1s","|","       ####ENTRADA GRATUITA####","|\n");
					break;
				//Simple
			   default:
					ticketprize=(Cinerama.PRIZES[0]+Cinerama.PRIZES[1]);
					System.out.printf("%1s%4s%-54s%1s","|"," ","Entrada Estandar","|\n");
					System.out.printf("%1s%-58s%1s","|","      Precio: "+Cinerama.PRIZES[0]+" Euros.  Suplemento 3D: "+Cinerama.PRIZES[1]+" Euros.","|\n");
					System.out.printf("%1s%-58s%1s","|","                 TOTAL: "+ticketprize+" Euros.","|\n");
			  		break;
				}
			}
		else
			{
			switch (addonmode)
				{
			   case 2:
				case 5:
					ticketprize=(Cinerama.PRIZES[0]-Cinerama.PRIZES[3]);
					System.out.printf("%1s%4s%-54s%1s","|"," ","Descuento Carn� Joven: "+Cinerama.PRIZES[3]+" Euros.","|\n");
					System.out.printf("%1s%-58s%1s","|","    Precio: "+Cinerama.PRIZES[0]+" Euros.","|\n");
					System.out.printf("%1s%-58s%1s","|","                 TOTAL: "+ticketprize+" Euros.","|\n");		      
					break;
			   case 3:
				case 6:
					ticketprize=(Cinerama.PRIZES[0]-Cinerama.PRIZES[4]);
					System.out.printf("%1s%4s%-54s%1s","|"," ","Descuento Familia Numerosa: "+Cinerama.PRIZES[4]+" Euros.","|\n");
					System.out.printf("%1s%-58s%1s","|","    Precio: "+Cinerama.PRIZES[0]+" Euros.","|\n");
					System.out.printf("%1s%-58s%1s","|","                 TOTAL: "+ticketprize+" Euros.","|\n");		      
			      break;
				case 7:
					ticketprize=0;
					System.out.printf("%1s%4s%-54s%1s","|"," ","Entrada adquirida con promoci�n","|\n");
					System.out.printf("%1s%-58s%1s","|","       ####ENTRADA GRATUITA####","|\n");
					break;
			   default:
					ticketprize=Cinerama.PRIZES[0];
					System.out.printf("%1s%4s%-54s%1s","|"," ","Entrada Estandar","|\n");
					System.out.printf("%1s%-58s%1s","|","      Precio: "+Cinerama.PRIZES[0]+" Euros.","|\n");
					System.out.printf("%1s%-58s%1s","|","                 TOTAL: "+ticketprize+" Euros.","|\n");
			  		break;
				}
			}
		System.out.printf("%1s%58s%1s","|"," ","|\n");
		System.out.print("|__________________________________________________________|"); //40 lineas
		return ticketprize;
		}
	/**
	*M�todo que imprime por pantalla las posibles opciones de orden de venta de butacas.
	*Las opciones var�an en funci�n del tipo de sala que proyecta la pel�cula.
	*@param option Sala/proyecci�n escogida.
	*@param filmseats N�mero de butacas que deben ocuparse.
	*@return Array con las opciones disponibles.
	*/
	public static int[] showTicketsMode(int option,int filmseats)
		{
		int[] availablerows;
		int[] availableoptions=new int[7];
		int counter_available=2,aux=0;
		boolean oneleft=false, oneright=false, twoleft=false, twocenter=false, tworight=false;
		System.out.print("\n(1) Orden autom�tico (Aleatorio, no se aseguran asientos contiguos).");
		System.out.print("\n(2) Orden manual (escogiendo fila y butaca).");
		//////////////////////////////////////////////////////////////////
		//  Secci�n reservada para ventas de mas de un ticket a la vez  //
		//   La ordenaci�n es manual pero se tienen en cuenta que los   //
		//              tickets que se vendan sean contiguos            //
		//////////////////////////////////////////////////////////////////
		if (filmseats!=1) 
			{
			if (Cinerama.filminfo[option][2]==2)
				{
				availablerows=Utils.aisleTickets(Cinerama.rooms[option],filmseats,3);
				if (availablerows[0]!=Integer.MAX_VALUE)
					{
					System.out.print("\n(5) Orden manual en Zona Izquierda (asientos contiguos).");
					twoleft=true;
					}
				availablerows=Utils.aisleTickets(Cinerama.rooms[option],filmseats,4);
				if (availablerows[0]!=Integer.MAX_VALUE)
					{
					System.out.print("\n(6) Orden manual en Zona Central (asientos contiguos).");
					twocenter=true;
					}
				availablerows=Utils.aisleTickets(Cinerama.rooms[option],filmseats,5);
				if (availablerows[0]!=Integer.MAX_VALUE)
					{
					System.out.print("\n(7) Orden manual en Zona Derecha (asientos contiguos).");
					tworight=true;
					}
				}
			else
				{
				availablerows=Utils.aisleTickets(Cinerama.rooms[option],filmseats,1);
				if (availablerows[0]!=Integer.MAX_VALUE)
					{
					System.out.print("\n(3) Orden manual en Zona Izquierda (asientos contiguos).");
					oneleft=true;
					}
				availablerows=Utils.aisleTickets(Cinerama.rooms[option],filmseats,2);
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
	*M�todo que muestra el men� principal de la aplicaci�n
	*/
	public static void showMainMenu()
		{
		System.out.print("\nEscoge entre una de las siguientes opciones:");
		System.out.print("\n\t(1) Nuevo cliente");
		System.out.print("\n\t(2) Ocupaci�n actual de las salas");
		System.out.print("\n\t(3) Cerrar caja");
		System.out.print("\n");
		}
	/**
	*M�todo que muestra el men� de descuentos de venta
	*/
	public static void showAddonsMenu(int filmseats)
		{
		System.out.print("\nEscoge entre una de las siguientes opciones:");
		System.out.print("\n\t(1) Entrada Est�ndar");
		System.out.print("\n\t(2) Descuento carn� Joven ("+Cinerama.PRIZES[3]+" Eur.)");
		System.out.print("\n\t(3) Descuento familia numerosa ("+Cinerama.PRIZES[4]+" Eur.)");
		if (filmseats>1)
			{
			System.out.print("\n\t(4) Pagar todas como entrada Est�ndar");
			System.out.print("\n\t(5) Pagar todas como descuento carn� Joven ("+Cinerama.PRIZES[3]+" Eur.)");
			System.out.print("\n\t(6) Pagar todas como descuento familia numerosa ("+Cinerama.PRIZES[4]+" Eur.)");
			}
		System.out.print("\n");
		}
	/**
	*M�todo que muestra el men� de descuentos de venta
	*/
	public static void showPaymentMethod()
		{
		System.out.print("\nEscoge entre una de las siguientes opciones:");
		System.out.print("\n\t(1) Pago combinado de entradas");
		System.out.print("\n\t(2) Pago individual");
		System.out.print("\n");
		}
	/**
	*M�todo que muestra el men� principal de la aplicaci�n
	*/
	public static void showRecaudatoryMenu()
		{
		System.out.print("\nEscoge entre una de las siguientes opciones:");
		System.out.print("\n\t(1) Tabla de beneficios brutos");
		System.out.print("\n\t(2) Tabla de deducciones");
		System.out.print("\n\t(3) Tabla de beneficios netos");
		System.out.print("\n\t(4) Tabla completa");
		System.out.print("\n\t(5) Cerrar Aplicaci�n\n");
		}
	/**
	*M�todo que muestra la ocupaci�n de las salas de cine y da la opci�n para ver
	*dicha ocupaci�n de forma gr�fica
	*/
	public static void showRoomOccupation()
		{
		System.out.print("\nOcupaci�n actual de las salas (Pulsa 0 para salir cuando lo desees):\n");
		for (int i=0;i<Cinerama.filminfo.length;i++)
			{
			System.out.print("\n\tProyecci�n "+(i+1)+", "+Cinerama.films[i][0]);
			if (Cinerama.films[i][1].equals("yes"))
				{
				System.out.print("(3D)");
				}
			System.out.print(": "+Cinerama.filminfo[i][1]+" de "+Cinerama.filminfo[i][0]);
			System.out.print(" ("+(Cinerama.filminfo[i][1]*100)/Cinerama.filminfo[i][0]+"%) (Pulsa "+(i+1)+" para ver la ocupaci�n gr�ficamente)\n");
			}
		}	
	/**
	*M�todo que muestra las proyecciones disponibles as� como la ocupaci�n de la sala
	*/
	public static void showFilmList()
		{
		System.out.print("\nEste es el listado de peliculas que se proyectan hoy en Cinerama.");
		System.out.print("\nSelecciona uno de los n�meros disponibles para comprar tu entrada:\n");
		for (int i=0; i<Cinerama.filminfo.length;i++)
			{
			if (Cinerama.filminfo[i][0]!=Cinerama.filminfo[i][1])
				{
				System.out.print("\n\t("+(i+1)+")");
				}
			else
				{
				System.out.print("\n\tSala llena. ");
				}
			System.out.print(Cinerama.films[i][0]);
			if (Cinerama.films[i][1].equals("yes"))
				{
				System.out.print("(Proyecci�n 3D)");
				}
			if (Cinerama.filminfo[i][2]==1)
				{
				System.out.print(". Sala regular (1 pasillo central) ");
				}
			else
				{
				System.out.print(". Sala amplia (2 pasillos centrales) ");
				}
			System.out.print("con "+Cinerama.filminfo[i][0]+" plazas totales.");
			}
		System.out.print("\n");
		}
	/**
	*M�todo que dibuja nuestra sala de cine almacenada utilizando un solo pasillo central
	*@param room Sala de cine que dibujaremos
	*@param filminfo Array con informaci�n sobre plazas totales de la sala, plazas utilizadas y tipo de sala
	*@param film Array con informaci�n de la pelicula
	*/
	public static void oneAisle(int[][] room, int[] filminfo, String[] film)
		{
		int[] size=Utils.roomSize(room);
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
	*@param filminfo Array con informaci�n sobre plazas totales de la sala, plazas utilizadas y tipo de sala
	*@param film Array con informaci�n de la pelicula
	*/
	public static void twoAisle(int[][] room, int[] filminfo, String[] film)
		{
		int[] size=Utils.roomSize(room);
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
	////////////////////////////////////
	////////////////////////////////////
	//TABLAS DE RESULTADOS FINANCIEROS//
	////////////////////////////////////
	////////////////////////////////////
	/*
	*M�todo para imprimir la tabla de beneficios brutos
	*La tabla utiliza las variables globales de Cinerama
	*/
	public static void showGrossProfit()
		{
		int bruteprofit=0;
		System.out.print("\n");
		System.out.printf("%-40s%20s%20s%20s","Pel�cula"," |         Precio U."," | Gafas 3D vendidas"," |  Beneficio bruto ");
		System.out.print("\n====================================================================================================\n"); //100 caracteres
		for (int i=0; i<Cinerama.films.length; i++)
			{
			System.out.printf("%-40s",Cinerama.films[i][0]);
			System.out.printf("%3s%17s"," | ",(Cinerama.films[i][1].equals("no"))?Cinerama.PRIZES[0]+"(2D)":(Cinerama.PRIZES[0]+Cinerama.PRIZES[1])+"(3D)");
			System.out.printf("%3s%17s"," | ",Cinerama.filminfo[i][4]);
			System.out.printf("%3s%17s"," | ",Cinerama.filminfo[i][7]+" Eur. ");
			System.out.print("\n");
			bruteprofit=bruteprofit+Cinerama.filminfo[i][7];
			}
		System.out.print("====================================================================================================\n"); //100 caracteres
		System.out.printf("%-80s%3s%17s","Beneficio bruto total"," | ",bruteprofit+" Eur. ");
		}
	/*
	*M�todo para imprimir la tabla de deducciones
	*La tabla utiliza las variables globales de Cinerama
	*/
	public static void showDiscount()
		{
		int discount=0;
		System.out.print("\n");
		System.out.printf("%-40s%13s%13s%14s%20s","Pel�cula"," |  Fam. Num."," |   C. joven"," |  Cod. prom."," |        Deducci�n ");
		System.out.print("\n====================================================================================================\n"); //100 caracteres
		for (int i=0; i<Cinerama.films.length; i++)
			{
			System.out.printf("%-40s",Cinerama.films[i][0]);
			System.out.printf("%3s%10s"," | ",Cinerama.filminfo[i][6]);
			System.out.printf("%3s%10s"," | ",Cinerama.filminfo[i][5]);
			System.out.printf("%3s%11s"," | ",Cinerama.filminfo[i][3]);
			System.out.printf("%3s%17s"," | ",Cinerama.filminfo[i][8]+" Eur. ");
			discount=discount+Cinerama.filminfo[i][8];
			System.out.print("\n");
			}
		System.out.print("====================================================================================================\n"); //100 caracteres
		System.out.printf("%-80s%3s%17s","Deducciones totales"," | ",discount+" Eur. ");
		}
	/*
	*M�todo para imprimir la tabla de beneficios netos
	*La tabla utiliza las variables globales de Cinerama
	*/
	public static void showNetProfit()
		{
		int netprofit=0;
		System.out.print("\n");
		System.out.printf("%-40s%20s%20s%20s","Pel�cula"," |   Beneficio bruto"," |         Deducci�n"," |   Beneficio neto ");
		System.out.print("\n====================================================================================================\n"); //100 caracteres
		for (int i=0; i<Cinerama.films.length; i++)
			{
			System.out.printf("%-40s",Cinerama.films[i][0]);
			System.out.printf("%3s%17s"," | ",Cinerama.filminfo[i][7]+" Eur. ");
			System.out.printf("%3s%17s"," | ",Cinerama.filminfo[i][8]+" Eur. ");
			System.out.printf("%3s%17s"," | ",Cinerama.filminfo[i][9]+" Eur. ");
			System.out.print("\n");
			netprofit=netprofit+Cinerama.filminfo[i][9];
			}
		System.out.print("====================================================================================================\n"); //100 caracteres
		System.out.printf("%-80s%3s%17s","Beneficio neto total"," | ",netprofit+" Eur. ");
		}
	}