class inputs
	{
	public static int selectSample()
		{
		int option;
		do
			{
			printers.showLogo();
			printers.showSamples();
			option=cs1.Keyboard.readInt();
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
	public static boolean mainMenu(int[][][] rooms,String[][] films,int[][] seatcounter)
		{
		int option;
		printers.showLogo();
		printers.showMainMenu();
		option=cs1.Keyboard.readInt();
		switch (option)
			{
		   case 1:
		      ;
		   case 2:
		      ;
			case 3:
				printers.showLogo();
				printers.showRoomOccupation(seatcounter);
				return false;
			}
		return false;
		}
	}