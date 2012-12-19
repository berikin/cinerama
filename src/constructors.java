class constructors
	{
	/**
	MŽtodo que crea una nueva sala de cine
	@param
		rows ser‡n las filas que tendr‡ nuestra sala de cine
		cols ser‡n las columnas que tendr‡ nuestra sala de cine
		AVAILABLE es la constante que define como denominar a las butacas libres
	@return devuelve el nuevo array de la sala de cine creada
	*/
	public static String[][] makeShowRoom(int rows, int cols, String AVAILABLE)
		{
		String[][] showroom = new String[rows][cols];
		for (int i=0; i<showroom.length; i++)
			{
			for (int j=0; j<showroom[0].length; j++)
				{
				showroom[i][j]=AVAILABLE;
				}
			}
		return showroom;
		}
	}