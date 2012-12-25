/**
*Clase que contiene los métodos que construyen
*las salas de cine, las peliculas
*@version 0.2
*@author José Antonio Yáñez Jiménez
*/  
   class constructors
   {
   /**
   *Método que crea las salas de cine.
   *Definimos un array de 3 dimensiones para poder guardar varias salas
   *En la primera dimensión hacemos referencia a cada sala.
   *En la segunda dimensión hacemos referencia a las filas de la sala.
   *En la tercera dimensión hacemos referencia a las columnas de la sala.
   *@param roomsatribs Tamaño de cada sala indicado en filas y columnas
   *@param AVAILABLE constante que define como denominar a las butacas libres
   *@return devuelve el nuevo array de las salas de cine
   */
      public static int[][][] makeRooms(int[][] roomsatribs, int AVAILABLE)
      {
         int[][][] showrooms=new int[roomsatribs.length][roomsatribs[0][0]][roomsatribs[0][1]];
         for (int i=0; i<showrooms.length; i++)
         {
            for (int j=0; j<roomsatribs[i][0]; j++)
            {
               for (int x=0; x<roomsatribs[i][1]; x++)
               {
                  showrooms[i][j][x]=AVAILABLE;
               }
            }
         }
         return showrooms;
      }
   /**
   *Método que genera el array con las peliculas del cine
   *Las peliculas 3D se establecerán de forma aleatoria entre las
   *peliculas generales, ya que el orden de este array es el que 
   *definirá también el orden de las salas de cine. Una pelicula podrá
   *ser proyectada en varias salas, tanto en 3D como normal.
   *@param number número total de peliculas que habrá
   *@param max_3d número total de peliculas que serán 3D
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
         //Hay peliculas 3D disponibles en la posición 0 a 6
         final int AVAILABLE3D=6;
         String[][] films_available={{"El hobbit","yes"},{"Avatar","yes"},{"Ice Age 4","yes"},{"Los vengadores","yes"},{"Men in black 3","yes"},{"Prometheus","yes"},{"The amazing spiderman","yes"},{"El caballero oscuro","no"},{"Pulp Fiction","no"},{"Alien","no"},{"K-paxx","no"},{"La naranja mecánica","no"},{"La lista de Schindler","no"},{"El pianista","no"},{"El cuervo","no"},{"Constantine","no"},{"Origen","no"},{"Titanic","no"},{"Star Wars","no"}};
         String[][] films=new String[number][2];
         for (int i=0; i<max_3d;i++)
         {
            do
            {
               show3d=utils.random(0,(number-1));
               for (int j=0; j<=i;j++)
               //El bucle sirve para evitar que escojamos repetidas veces
               //la misma posición del array final de peliculas para encajar
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
                  show=utils.random(0,AVAILABLE3D);
                  films[i][0]=films_available[show][0];
                  films[i][1]=films_available[show][1];
                  film_filled=true;
               }
            }
            if (film_filled)
            {
               film_filled=false;
            }
            else
            {
               show=utils.random(0,(films_available.length-1));
               films[i][0]=films_available[show][0];
               films[i][1]="no";
            }
         }
         return films;
      }
	/**
	*Método que rellena el contador de los asientos de sala
	*@param showroom Sala de la que queremos conocer el número de asientos
	*@param seatcounter Posición del contador en el que apuntaremos el número de asientos
	*@param aisles Número de pasillos que tendrá la sala de cine
	*/
	public static void fillSeatCounter(int[][] showroom,int[] seatcounter, int aisles)
		{
		int[] roomsize=utils.roomSize(showroom);
		seatcounter[0]=(roomsize[0]*roomsize[1]);
		seatcounter[2]=aisles;
		}
	/**
	*Método que construye el contador de los asientos de sala, libres y ocupados
	*@param showrooms Salas que tendrá que serán manejadas por el contador de asientos
	*@return seatcounter Array con el número de asientos de todas las salas
	*/
	public static int[][] makeSeatCounter(int[][][] showrooms)
		{
		int[] roomsize;
		int[][] seatcounter=new int[showrooms.length][3];
		for (int i=0; i<seatcounter.length;i++)
			{
			roomsize=utils.roomSize(showrooms[i]);
			if (roomsize[1]>=10)
				{
				fillSeatCounter(showrooms[i],seatcounter[i],2);
				}
			else
				{
				fillSeatCounter(showrooms[i],seatcounter[i],1);
				}
			}
		return seatcounter;
		}
   /**
	*Método que construye un array para guardar posiciones del público que se
	*distribuirá de forma aleatoria.
	*@param maxpeople Número total de personas que habrá
	*@param positions Las longitud de la segunda dimensión (normalmente 2, fila y columna que ocupará)
	*@return Array en el que colocar a la gente, con todo fijado a MAX_VALUE (puede darse el caso de que una persona esté en la posición 0 - 0)
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