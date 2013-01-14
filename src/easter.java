import java.io.*;
/**
*Clase que contiene los huevos de pascua de la aplicación
*Estos huevos de pascua se activan desde el menú de nuevo cliente.
*Solo funcionan cuando la película para la que están diseñados se encuentra
*entre las que se proyectan. Con algunos huevos de pascua se pueden obtener
*entradas gratuitas.
*@version 0.4
*@author José Antonio Yáñez Jiménez
*/
class Easter
	{
	/**
	*Método de captura de teclado. El método se basa en kread.readString(),
	*capturando la entrada de teclado y comprobando el contenido de ésta. Si
	*se ha introducido una de las combinaciones de huevo de pascua establecidas
	*y la proyección asignada a esa combinación está disponible invoca al método
	*con el parámetro correspondiente. En caso contrario invocar a la clase Kread
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
		if (texto.equals("BRUCE WAYNE"))
			{
			for (int i=0; i<Cinerama.films.length; i++)
				{
				if (Cinerama.films[i][0].equals("El caballero oscuro") || Cinerama.films[i][0].equals("Batman Begins"))
					{
					validegg=true;
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
	public static void showEaster(int option)
		{
		int choice;
		String answer;
		switch (option)
			{
		   case 1:
				String batman="\n       _==/          i     i          \\==_\n     /XX/            |\\___/|            \\XX\\\n   /XXXX\\            |XXXXX|            /XXXX\\\n  |XXXXXX\\_         _XXXXXXX_         _/XXXXXX|\n XXXXXXXXXXXxxxxxxxXXXXXXXXXXXxxxxxxxXXXXXXXXXXX\n|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n|XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX|\n XXXXXX/^^^^\"\\XXXXXXXXXXXXXXXXXXXXX/^^^^^\\XXXXXX\n  |XXX|       \\XXX/^^\\XXXXX/^^\\XXX/       |XXX|\n    \\XX\\       \\X/    \\XXX/    \\X/       /XX/\n       \"\\       \"      \\X/      \"      /\"\n";
				Printers.showInfo(batman);
				Printers.showInfo("Soy Batman. (Pulsa intro para continuar con la compra de entradas)");
				Utils.returnPause();
		      break;	
			case 2:
				Printers.showInfo("\nLas raíces no se ven, y es más alta que un árbol. Arriba y arriba sube, y sin embargo no crece. ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.equals("MONTA\u00D2A") & !answer.equals("UNA MONTA\u00D2A") & !answer.equals("LA MONTA\u00D2A"))
					{
					Printers.showInfo("\n¡Lástima, fallaste, te comeré vivo!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\nTreinta caballos blancos en una sierra colorada. Primero mordisquean, luego machacan y luego descansan. ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.equals("DIENTES") & !answer.equals("LOS DIENTES"))
					{
					Printers.showInfo("\n¡Lástima, fallaste, huiré de aqui!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\nCanta sin voz, vuela sin alas, sin dientes muerde, sin boca habla. ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.equals("VIENTO") & !answer.equals("EL VIENTO"))
					{
					Printers.showInfo("\n¡Lástima, fallaste, te comeré vivo!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\nUn ojo en la cara azul vio un ojo en la cara verde. \"Ese ojo es como este. ojo\", dijo el ojo primero, \"pero en lugares bajos, y no en lugares altos\". ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.equals("EL SOL SOBRE LAS MARGARITAS") & !answer.equals("SOL SOBRE MARGARITAS"))
					{
					Printers.showInfo("\n¡Lástima, fallaste, huiré de aqui!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\nNo puedes verla ni sentirla, y ocupa todos los huecos: no puedes olerla ni oírla, está detrás de los astros, y está al píe de las colinas, llega primero, y se queda; mala risas y acaba vidas. ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.equals("LA OSCURIDAD") & !answer.equals("OSCURIDAD"))
					{
					Printers.showInfo("\n¡Lástima, fallaste, te comeré vivo!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\nTodos viven sin aliento; y fríos como los muertos, nunca con sed, siempre bebiendo, todos en malla, siempre en silencio. ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.equals("PEZ") & !answer.equals("PECES") & !answer.equals("UN PEZ") & !answer.equals("LOS PECES"))
					{
					Printers.showInfo("\n¡Lástima, fallaste, huiré de aqui!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\nDevora todas las cosas: aves, bestias, plantas y flores; roe el hierro, muerde el acero, y pulveriza la peña compacta; mata reyes, arruina ciudades y derriba las altas montañas. ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.equals("TIEMPO") & !answer.equals("EL TIEMPO"))
					{
					Printers.showInfo("\n¡Lástima, fallaste, te comeré vivo!");
					Utils.pause(2000);
					return;
					}
				Printers.showInfo("\n¿Qué tengo en el bolsillo? ");
				answer=Kread.readString();
				answer=answer.toUpperCase();
				if (!answer.equals("ANILLO") & !answer.equals("EL ANILLO"))
					{
					Printers.showInfo("\n¡Lástima, fallaste, huiré de aqui!");
					Utils.pause(2000);
					return;
					}
				do
					{
					Printers.showInfo("\nFelicidades, has acertado todos los acertijos. Como recompensa puedes conseguir una entrada para el Hobbit gratis si lo deseas.\n");
					Printers.showInfo("\n\t(1)¡Si!¡Queremos esa entrada!¡Tesorooo!");
					Printers.showInfo("\n\t(2)No gracias, quiero volver al menú de proyecciones.\n");
					choice=Kread.readInt();
					if (choice!=1 & choice!=2)
						{
						Printers.showInfo("\nEscogiste una opción incorrecta, prueba de nuevo.");
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
							Cinerama.filminfo[film][3]++; //Anotamos una entrada gratuita
							//Realizamos el proceso de venta de entrada
							//La proyección asiganada será la primera que encuentre como el Hobbit
							//El proceso de selección de butaca será siempre manual
							//Como número de entradas pasamos MAX_VALUE para que el sistema entienda que la entrada
							//se ha conseguido con un easter egg y así no mostrar precio en el ticket de venta
							Inputs.orderMethods(Cinerama.rooms[film], Integer.MAX_VALUE, 2, film); 
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
	}