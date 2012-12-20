/**
*Clase que contiene los m�todos que construyen
*las salas de cine, las peliculas
*@version 0.2
*@author Jos� Antonio Y��ez Jim�nez
*/  
   class constructors
   {
   /**
   *M�todo que crea las salas de cine.
   *Definimos un array de 3 dimensiones para poder guardar varias salas
   *En la primera dimensi�n hacemos referencia a cada sala.
   *En la segunda dimensi�n hacemos referencia a las filas de la sala.
   *En la tercera dimensi�n hacemos referencia a las columnas de la sala.
   *@param roomsatrins[][] Tama�o de cada sala indicado en filas y columnas
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
         //Hay peliculas 3D disponibles en la posici�n 0 a 6
         final int AVAILABLE3D=6;
         String[][] films_available={{"El hobbit","yes"},{"Avatar","yes"},{"Ice Age 4","yes"},{"Los vengadores","yes"},{"Men in black 3","yes"},{"Prometheus","yes"},{"The amazing spiderman","yes"},{"El caballero oscuro","no"},{"Pulp Fiction","no"},{"Alien","no"},{"K-paxx","no"},{"La naranja mec�nica","no"},{"La lista de Schindler","no"},{"El pianista","no"},{"El cuervo","no"},{"Constantine","no"},{"Origen","no"},{"Titanic","no"},{"Star Wars","no"}};
         String[][] films=new String[number][2];
         for (int i=0; i<max_3d;i++)
         {
            do
            {
               show3d=utils.random(0,(number-1));
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
   
   }