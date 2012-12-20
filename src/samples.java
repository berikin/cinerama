/**
*Clase que contiene los métodos que generan
*Salas de cine de muestra, peliculas de muestra
*y rellenan asientos con público de muestra
*@version 0.2
*@author José Antonio Yáñez Jiménez
*/
   class samples
   {
	/**
	*Método que utiliza el ejemplo de cine 1
	*Crea 4 salas de cine
	*	La primera de 10 filas y 8 asientos por fila
	*	La segunda de 8 filas y 6 asientos por fila
	*	La tercera de 8 filas y 5 asientos por fila
	*	La cuarta de 9 filas y 7 asientos por fila
	*@return Salas de cine creadas
	*/
	public static int[][][] cinema1()
		{
		int[][] roomsatribs={{10,8},{8,6},{8,5},{9,7}};
		int[][][] rooms=constructors.makeRooms(roomsatribs,cinerama.AVAILABLE);
		return rooms;
		}
	/**
	*Método que utiliza el ejemplo de cine 2
	*Crea 2 salas de cine
	*	La primera de 12 filas y 12 asientos por fila
	*	La segunda de 10 filas y 8 asientos por fila
	*@return Salas de cine creadas
	*/
	public static int[][][] cinema2()
		{
		int[][] roomsatribs={{12,12},{10,8}};
		int[][][] rooms=constructors.makeRooms(roomsatribs,cinerama.AVAILABLE);
		return rooms;
		}
	/**
	*Método que utiliza el ejemplo de cine 1
	*Crea 4 peliculas
	*	Dos de las peliculas serán en formato 3D
	*@return Peliculas creadas
	*/
	public static String[][] showfilms1()
		{
		String[][] films=constructors.makeFilms(4,2);
		return films;
		}
	/**
	*Método que utiliza el ejemplo de cine 2
	*Crea 2 peliculas
	*	ninguna de las peliculas será 3D
	*@return Peliculas creadas
	*/
	public static String[][] showfilms2()
		{
		String[][] films=constructors.makeFilms(2,0);
		return films;
		}
	public static void fillroom1(int[][][] showrooms)
		{
		boolean rows_limit=false, cols_limit=false;
		int rows=0, cols=0, max_people=0, random_row=0, random_col=0;
		for (int i=0; i<showrooms.length;i++)
			{
			replaces.replace();
			}
		}
   }