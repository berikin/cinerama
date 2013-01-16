/**
*Clase que contiene los métodos que generan
*Salas de cine de muestra, peliculas de muestra
*y rellenan asientos con público de muestra
*@version 0.4
*@author José Antonio Yáñez Jiménez
*/
   class Samples
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
		int[][] roomsatribs={{10,20,2},{8,12,1},{8,10,2},{9,8,1}};
		int[] max_room={10,20};
		int[][][] rooms=Constructors.makeRooms(max_room,roomsatribs);
		Cinerama.filminfo=Constructors.makeFilmInfo(rooms,roomsatribs);
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
		int[][] roomsatribs={{12,12,2},{10,8,1}};
		int[] max_room={12,12};
		int[][][] rooms=Constructors.makeRooms(max_room,roomsatribs);
		Cinerama.filminfo=Constructors.makeFilmInfo(rooms,roomsatribs);
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
		String[][] films=Constructors.makeFilms(4,2);
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
		String[][] films=Constructors.makeFilms(2,0);
		return films;
		}
	/**
	*Método que rellena las salas al con un porcentaje que varía entre
	*el 5 y el 60% de la capacidad de las mismas
	*@param min_percent índice de porcentaje mínimo aleatorio
	*@param max_percent índice de porcentaje máximo aleatorio
	*/
	public static void fillrooms(int min_percent, int max_percent)
		{
		for (int i=0; i<Cinerama.rooms.length;i++)
			{
			Replaces.randomReplaceRoom(Cinerama.rooms[i],(Utils.random(min_percent,max_percent)),i,true);
			}
		}
   }