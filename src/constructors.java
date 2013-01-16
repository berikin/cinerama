/**
*Clase que contiene los m�todos que construyen
*las salas de cine, las peliculas
*@version 0.5
*@author Jos� Antonio Y��ez Jim�nez
*/  
	class Constructors
   {
	//Hay peliculas 3D disponibles en la posici�n 0 a 6
	static final int AVAILABLE3D=6;
	static String[][] FILMS_AVAILABLE={{"El hobbit","yes"},{"Avatar","yes"},{"Ice Age 4","yes"},{"Los vengadores","yes"},{"Men in black 3","yes"},{"Prometheus","yes"},{"The amazing spiderman","yes"},{"El caballero oscuro","no"},{"Pulp Fiction","no"},{"Alien","no"},{"K-paxx","no"},{"La naranja mec�nica","no"},{"La lista de Schindler","no"},{"El pianista","no"},{"El cuervo","no"},{"Constantine","no"},{"Origen","no"},{"Titanic","no"},{"Star Wars","no"},{"Batman Begins","no"}};
   /**
   *M�todo que crea las salas de cine.
   *Definimos un array de 3 dimensiones para poder guardar varias salas
   *En la primera dimensi�n hacemos referencia a cada sala.
   *En la segunda dimensi�n hacemos referencia a las filas de la sala.
   *En la tercera dimensi�n hacemos referencia a las columnas de la sala.
   *@param roomsatribs Tama�o de cada sala indicado en filas y columnas
   *@return devuelve el nuevo array de las salas de cine
   */
	public static int[][][] makeRooms(int[] max_room, int[][] roomsatribs)
		{
		int[][][] showrooms=new int[roomsatribs.length][max_room[0]][max_room[1]];
		for (int i=0; i<showrooms.length; i++)
			{
			for (int j=0; j<roomsatribs[i][0]; j++)
				{
				for (int x=0; x<roomsatribs[i][1]; x++)
					{
					showrooms[i][j][x]=Cinerama.AVAILABLE;
               }
            }
         }
		return showrooms;
      }
   /**
   *M�todo que genera el array con las peliculas del cine
   *Las peliculas 3D se establecer�n de forma aleatoria entre las
   *peliculas generales, ya que el orden de este array es el que 
   *definir� tambi�n el orden de las salas de cine. Una pelicula podr�
   *ser proyectada en varias salas, tanto en 3D como normal.
   *@param number n�mero total de peliculas que habr�
   *@param max_3d n�mero total de peliculas que ser�n 3D
   *@return array con las peliculas y si son 3D o no
   */
	public static String[][] makeFilms(int number, int max_3d)
		{
		int show3d, show;
		boolean repeated=false, film_filled=false;
		int[] shows3d=new int[max_3d];
		for (int i=0; i<shows3d.length;i++)
			{
			shows3d[i]=Integer.MAX_VALUE;
         }
		String[][] films=new String[number][2];
		for (int i=0; i<max_3d;i++)
			{
			do
				{
				show3d=Utils.random(0,(number-1));
				for (int j=0; j<=i;j++)
				//El bucle sirve para evitar que escojamos repetidas veces
				//la misma posici�n del array final de peliculas para encajar
				//las peliculas 3D
					{
					if (shows3d[j]==show3d)
						{
						repeated=true;
                  }
					else
						{
						repeated=false;
                  }
               }
            } while(repeated);
			repeated=false;
			shows3d[i]=show3d;
         }
		for (int i=0;i<number;i++)
         {
			for (int j=0; j<shows3d.length; j++)
				{
				if (i==shows3d[j])
               {
					show=Utils.random(0,AVAILABLE3D);
					films[i][0]=FILMS_AVAILABLE[show][0];
					films[i][1]=FILMS_AVAILABLE[show][1];
					film_filled=true;
               }
            }
			if (film_filled)
            {
				film_filled=false;
            }
			else
            {
				show=Utils.random(0,(FILMS_AVAILABLE.length-1));
				films[i][0]=FILMS_AVAILABLE[show][0];
				films[i][1]="no";
            }
         }
		return films;
      }
	/**
	*M�todo que rellena el contador de los asientos de sala
	*@param showroom Sala de la que queremos conocer el n�mero de asientos
	*@param filminfo Posici�n del contador en el que apuntaremos el n�mero de asientos
	*@param aisles N�mero de pasillos que tendr� la sala de cine
	*/
	public static void fillFilmInfo(int[][] showroom,int[] filminfo, int aisles)
		{
		int[] roomsize=Utils.roomSize(showroom);
		filminfo[0]=(roomsize[0]*roomsize[1]);
		filminfo[2]=aisles;
		}
	/**
	*M�todo que construye array con informaci�n sobre butacas totales, ocupadas, pasillos
	*simples o dobles en las salas y entradas obtenidas por easter egg.
	*@param showrooms Salas que tendr� que ser�n manejadas por el contador de asientos
	*@return filminfo Array con el n�mero de asientos de todas las salas
	*/
	public static int[][] makeFilmInfo(int[][][] showrooms, int[][] roomatribs)
		{
		int[] roomsize;
		//Array de 2 dimensiones
		//Primera dimensi�n para especificar la sala/pel�cula
		//Segunda dimensi�n:
		// [0]-Butacas totales
		// [1]-Butacas ocupadas
		// [2]-Pasillo simple (1) o doble (2)
		// [3]-Butacas gratuitas
		// [4]-N� gafas 3D vendidas
		// [5]-N� descuentos carn� joven
		// [6]-N� descuentos familia numerosa
		// [7]-Beneficio bruto
		// [8]-Deducciones totales
		// [9]-Beneficio neto
		int[][] filminfo=new int[showrooms.length][10];
		for (int i=0; i<filminfo.length;i++)
			{
			roomsize=Utils.roomSize(showrooms[i]);
			if (roomatribs[i][2]==2)
				{
				fillFilmInfo(showrooms[i],filminfo[i],2);
				}
			else
				{
				fillFilmInfo(showrooms[i],filminfo[i],1);
				}
			}
		return filminfo;
		}
   /**
	*M�todo que construye un array para guardar posiciones del p�blico que se
	*distribuir� de forma aleatoria.
	*@param maxpeople N�mero total de personas que habr�
	*@param positions Las longitud de la segunda dimensi�n (normalmente 2, fila y columna que ocupar�)
	*@return Array en el que colocar a la gente, con todo fijado a MAX_VALUE (puede darse el caso de que una persona est� en la posici�n 0 - 0)
	*/
	public static int[][] makeRandomCounter(int maxpeople, int positions)
		{
		int[][] randompeople=new int[maxpeople][positions];
		for (int i=0;i<randompeople.length;i++)
			{
			randompeople[i][0]=Integer.MAX_VALUE;
			randompeople[i][1]=Integer.MAX_VALUE;
			}
		return randompeople;
		}
   }