import java.io.*;
/**
*Clase que contiene los huevos de pascua de la aplicaci�n
*Estos huevos de pascua se activan desde el men� de nuevo cliente.
*Solo funcionan cuando la pel�cula para la que est�n dise�ados se encuentra
*entre las que se proyectan. Con los huevos de pascua se pueden obtener
*entradas gratuitas.
*@version 0.5
*@author Jos� Antonio Y��ez Jim�nez
*/

class Easter
	{
	/**
	*Variable para definir el c�digo promocional de entradas
	*/
	static String promocode="CINERAMADAW";
	/**
	*M�todo de captura de teclado. El m�todo se basa en kread.readString(),
	*capturando la entrada de teclado y comprobando el contenido de �sta. Si
	*se ha introducido una de las combinaciones de huevo de pascua establecidas
	*y la proyecci�n asignada a esa combinaci�n est� disponible invoca al m�todo
	*con el par�metro correspondiente. En caso contrario invocar a la clase Kread
	*para tratar la captura como si fuera una entrada normal.
	*/
	public static int read() 
	 	{
		boolean validegg=false;
		String texto = null;
		try 
			{
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			texto = teclado.readLine();
			}
		catch (IOException e)
			{}
		texto=texto.toUpperCase();
		if (texto.equals(promocode))
			{
			showEaster(3);
			return Integer.MAX_VALUE;
			}
		if (texto.equals("BRUCE WAYNE"))
			{
			for (int i=0; i<Cinerama.films.length; i++)
				{
				if (Cinerama.films[i][0].equals("El caballero oscuro") || Cinerama.films[i][0].equals("Batman Begins"))
					{
					validegg=true;
					break;
					}
				}
			if (validegg)
				{
				showEaster(1);
				return Integer.MAX_VALUE;
				}
			}
		if (texto.equals("BILBO BOLSON"))
			{
			for (int i=0; i<Cinerama.films.length; i++)
				{
				if (Cinerama.films[i][0].equals("El hobbit"))
					{
					validegg=true;
					break;
					}
				}
			if (validegg)
				{
				showEaster(2);
				return Integer.MAX_VALUE;
				}
			}
		return Kread.parseInt(texto);
		}
	/**
	*M�todo que alberga los distintos huevos de pascua.
	*Contiene las pruebas a superar para poder obtener una entrada gratuita
	*/
	public static void showEaster(int option)
		{
		int choice=0;
		String answer;
		switch (option)
			{
			case 3:
				Printers.showInfo("\nC�digo promocional aceptado. Selecciona una pel�cula para obtener una entrada gratuita");
				do
					{
					Printers.showFilmList();
					choice=Kread.readInt();
					if (choice==0)//Saliendo de la venta
							{
							return;
							}
						choice--;
						if (choice<0 || choice>(Cinerama.filminfo.length-1))
							{
							Printers.showInfo("\nEscogiste una opci�n no v�lida, prueba de nuevo");
							Utils.pause(2000);		
							}
						else if (Cinerama.filminfo[option][0]==Cinerama.filminfo[option][1])
							{
							Printers.showInfo("\nLa sala de esta proyecci�n est� llena, prueba de nuevo");
							Utils.pause(2000);		
							}
						else
							{
							break;
							}
					} while(1==1);
				easterWin(choice);
				break;
		   case 1:
				String batman="\n       _==/          i     i          \\==_\n     /XX/            |\\___/|            \\XX\\\n   /XXXX\\            |XXXXX|            /XXXX\\\n  |XXXXXX\\_         _XXXXXXX_         _/XXXXXX|\n XXXXXXXXXXXxxxxxxxXXXXXXXXXXXxxxxxxxXXXXXXXXXXX\n|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|\n XXXXXX/^^^^\"\\XXXXXXXXXXXXXXXXXXXXX/^^^^^\\XXXXXX\n  |XXX|       \\XXX/^^\\XXXXX/^^\\XXX/       |XXX|\n    \\XX\\       \\X/    \\XXX/    \\X/       /XX/\n       \"\\       \"      \\X/      \"      /\"\n";
				Printers.showInfo(batman);
				int dk=Integer.MAX_VALUE,bb=Integer.MAX_VALUE;
				String[] villains={"BANE","CATWOMAN","DOS CARAS","ESPANTAPAJAROS","JOKER","PING\u00B8INO","PING�INO","HARLEY QUINN","HIEDRA VENENOSA","RAS AL GHUL","ZSASZ","CROC","ENIGMA"};
				int[] answers=new int[3];
				for (int i=0; i<answers.length; i++)
					{
					Printers.showInfo("\nNombra a un gran villano de Batman: ");
					answer=Kread.readString();
					answer=answer.toUpperCase();
					for (int j=0; j<villains.length; j++)
						{
						if (answer.contains(villains[j]))
							{
							answers[i]=(j+1);
							break;
							}
						}
					if (answers[i]==0)
						{
						Printers.showInfo("\nEse villano no existe, suerte la pr�xima vez.");
						Utils.pause(2000);
						return;
						}
					for (int j=0; j<i; j++)
						{
						if (answers[j]==answers[i])
							{
							Printers.showInfo("\nHacer trampas est� mal, suerte la pr�xima vez.");
							Utils.pause(2000);
							return;
							}
						}
					}
				do
					{
					Printers.showInfo("\nFelicidades, has nombrado tres villanos diferentes. Como recompensa puedes");
					Printers.showInfo("\nconseguir una entrada para tu pel�cula de batman si quieres.\n");
					for (int i=0; i<Cinerama.films.length; i++)
						{
						if (Cinerama.films[i][0].equals("El caballero oscuro"))
							{
							Printers.showInfo("\n\t(1) Entrada para El caballero oscuro");
							dk=i;
							break;
							}
						}
					for (int i=0; i<Cinerama.films.length; i++)
						{
						if (Cinerama.films[i][0].equals("Batman Begins"))
							{
							Printers.showInfo("\n\t(2) Entrada para Batman Begins");
							bb=i;
							break;
							}
						}
					Printers.showInfo("\n\t(3)No gracias, quiero volver al men� de proyecciones.\n");
					choice=Kread.readInt();
					if (dk!=Integer.MAX_VALUE && choice==1)
						{
						easterWin(dk);
					   return;
						}
					if (bb!=Integer.MAX_VALUE && choice==2)
						{
					   easterWin(bb);
						return;
						}
					Printers.showInfo("\nEscogiste una opci�n incorrecta, prueba de nuevo.");
					Utils.pause(2000);
					} while(1==1);
			case 2:
				Printers.showInfo("\nLas ra�ces no se ven, y es m�s alta que un �rbol. Arriba y arriba sube, y sin embargo no crece. ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.contains("MONTA\u00D2A") & !answer.contains("MONTA�A"))
					{
					Printers.showInfo("\n�L�stima, fallaste, te comer� vivo!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\nTreinta caballos blancos en una sierra colorada. Primero mordisquean, luego machacan y luego descansan. ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.contains("DIENTES"))
					{
					Printers.showInfo("\n�L�stima, fallaste, huir� de aqui!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\nCanta sin voz, vuela sin alas, sin dientes muerde, sin boca habla. ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.contains("VIENTO"))
					{
					Printers.showInfo("\n�L�stima, fallaste, te comer� vivo!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\nUn ojo en la cara azul vio un ojo en la cara verde. \"Ese ojo es como este. ojo\"");
				Printers.showInfo(",\n dijo el ojo primero, \"pero en lugares bajos, y no en lugares altos\". ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.equals("EL SOL SOBRE LAS MARGARITAS") & !answer.equals("SOL SOBRE MARGARITAS") & !answer.equals("SOL SOBRE LAS MARGARITAS"))
					{
					Printers.showInfo("\n�L�stima, fallaste, huir� de aqui!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\nNo puedes verla ni sentirla, y ocupa todos los huecos: no puedes olerla ni o�rla, est� detr�s de los astros,");
				Printers.showInfo("\ny est� al p�e de las colinas, llega primero, y se queda; mala risas y acaba vidas. ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.contains("OSCURIDAD"))
					{
					Printers.showInfo("\n�L�stima, fallaste, te comer� vivo!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\nTodos viven sin aliento; y fr�os como los muertos, nunca con sed, siempre bebiendo, todos en malla, siempre en silencio. ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.contains("PEZ") & !answer.contains("PECES"))
					{
					Printers.showInfo("\n�L�stima, fallaste, huir� de aqui!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\nDevora todas las cosas: aves, bestias, plantas y flores; roe el hierro, muerde el acero, y pulveriza la pe�a compacta;");
				Printers.showInfo("\nmata reyes, arruina ciudades y derriba las altas monta�as. ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.contains("TIEMPO"))
					{
					Printers.showInfo("\n�L�stima, fallaste, te comer� vivo!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\n�Qu� tengo en el bolsillo? ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.contains("ANILLO"))
					{
					Printers.showInfo("\n�L�stima, fallaste, huir� de aqui!");
					Utils.pause(2000);
					return;
					}
				do
					{
					Printers.showInfo("\nFelicidades, has acertado todos los acertijos. Como recompensa puedes conseguir una entrada para el Hobbit gratis si lo deseas.\n");
					Printers.showInfo("\n\t(1)�Si!�Queremos esa entrada!�Tesorooo!");
					Printers.showInfo("\n\t(2)No gracias, quiero volver al men� de proyecciones.\n");
					choice=Kread.readInt();
					if (choice!=1 & choice!=2)
						{
						Printers.showInfo("\nEscogiste una opci�n incorrecta, prueba de nuevo.");
						Utils.pause(2000);
						}
					else
						{
						if (choice==1)
							{
							int film=0;
							for (int i=0; i<Cinerama.films.length; i++)
								{
								if (Cinerama.films[i][0].equals("El hobbit"))
									{
									film=i;
									break;
									}
								}
							easterWin(film);
							break;
							}
						else
							{
							break;
							}
						}
					} while(1==1);
				break;		
		   default:
		      break;
			}
		}
	/*
	*M�todo para dar una entrada gratuita
	*@param filmname ID de la pel�cula sobre la que se obtiene la entrada gratuita
	*/
	public static void easterWin(int film)
		{
		Cinerama.filminfo[film][3]++; //Anotamos una entrada gratuita
		//Realizamos el proceso de venta de entrada
		//La proyecci�n asiganada ser� la primera que encuentre como el titulo que pasamos por par�metro
		//El proceso de selecci�n de butaca ser� siempre manual
		//Como n�mero de entradas pasamos MAX_VALUE para que el sistema entienda que la entrada
		//se ha conseguido con un easter egg y as� no mostrar precio en el ticket de venta
		Inputs.orderMethods(Cinerama.rooms[film], Integer.MAX_VALUE, 2, film); 
		}
	}