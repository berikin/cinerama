class cinerama
	{
	public static void main(String[] args)
		{
		//VARIABLES Y CONSTANTES POR DEFECTO
		final String AVAILABLE="Libre";
		final String USED="Usada";
		printers.showLogo();
		String[][] films=samples.makeFilms(4,2);
		for (int i=0; i<films.length; i++)
			{
			System.out.print("\n"+films[i][0]+" - "+films[i][1]);
			}
		}
	}