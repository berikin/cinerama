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
			if (option<1 || option>2)
				{
				printers.showError("Escogiste una opci�n no v�lida, prueba de nuevo");
				utils.pause(2000);
				}
			else
				{
				return option;
				}
			} while(1==1);
		}
	}