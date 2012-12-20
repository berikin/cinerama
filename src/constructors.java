   class constructors
   {
   /**
   *Método que crea una nueva sala de cine
   *@param rows Filas que tendrá nuestra sala de cine
   *@param cols Columnas que tendrá nuestra sala de cine
   *@param AVAILABLE constante que define como denominar a las butacas libres
   *@return devuelve el nuevo array de la sala de cine creada
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
   
   }