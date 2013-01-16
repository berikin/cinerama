/**
*Clase que contiene los m�todos que modifican nuestros arrays
*@version 0.4
*@author Jos� Antonio Y��ez Jim�nez
*/
   class Replaces
   {
   /**
   *M�todo que modifica una sala de cine de forma aleatoria rellenando
   *tantas butacas como especiquemos en los par�metros. Adicionalmente muestra
   *el ticket de venta en caso de que no se haya invocado el m�todo para realizar
   *rellenos de p�blico de muestra si no que sea una invocaci�n por una entrada vendida.
   *@param showroom Array con la sala de cine a modificar
   *@param seats Tiene dos usos: Si se trata de una venta a un cliente se utiliza para saber el
   *n�mero de tickets y asientos a modificar. Si se trata de un relleno aleatorio de clientes de
   *muestra se utiliza para conocer el porcentaje de clientes que tendr� la sala sobre el tama�o total
   *@param roomnumber Indica el n�mero de sala que vamos a modificar
   *@param percent Indica si la invocaci�n del m�todo es para un relleno de p�blico de muestra aleatorio
   *o para una compra de tickets.
   */
	public static void randomReplaceRoom(int[][] showroom,int seats, int roomnumber, boolean percent)
		{
		int max_people=seats, random_row=0, random_col=0;
		boolean repeated=false;
		int randompeoplecounter=0;
		int[] roomsize=Utils.roomSize(showroom);
		int combinedpayment=0, totalmoney=0, addonmode=0;
		if (max_people==1)//Si se vende un ticket no mostramos el men� de venta de tickets combinada
			{
			combinedpayment=2;
			}
			/////////////////////////////////////////////////////////////////////////////////////
			//Si nos encontramos realizando un relleno de p�blico calculamos el n�mero final
			//de butacas a rellenar en funci�n del porcentaje recibido por par�metro y el tama�o
			//de la sala
			/////////////////////////////////////////////////////////////////////////////////////
         if (percent)
				{
            max_people=((roomsize[0]*roomsize[1])*seats)/100;
				}
         int[][] randompeople=Constructors.makeRandomCounter(max_people,2);
         Printers.showInfo("\nRellenando la sala "+(roomnumber+1)+" con "+max_people+" asistentes. Por favor espere... ");
         for (int i=0;i<max_people; i++)
         {
            randompeoplecounter++;
            do
            {
               random_row=Utils.random(0,(roomsize[0]-1));
               random_col=Utils.random(0,(roomsize[1]-1));
               for (int j=0; j<randompeoplecounter; j++)
               {
                  repeated=false;
                  if (randompeople[j][0]==random_row & randompeople[j][1]==random_col)
                  {
                     repeated=true;
                     break;
                  }
                  if (percent==false)
                  {
                     if (showroom[random_row][random_col]==2)
                        repeated=true;
                     break;
                  }
               }
            }while(repeated);
            randompeople[i][0]=random_row;
            randompeople[i][1]=random_col;
            if (percent==false)
            {
				if (addonmode!=4 & addonmode!=5 & addonmode!=6)
					{
					addonmode=Inputs.addons(max_people);
					}
				////////////////////////////
				//M�todo de pago combinado//
				////////////////////////////
				if (combinedpayment==0) //Escogemos el m�todo de pago combinado o individual
					{
					combinedpayment=Inputs.paymentMethod();
					}
				if (combinedpayment==1) //Pago combinado muestra todos los tickets y al final el importe total y la pausa
					{
					totalmoney=totalmoney+Printers.buyedTicket(Cinerama.films[roomnumber], roomnumber, random_row, random_col, addonmode);
					}
				else //Pago individual
					{
					Printers.buyedTicket(Cinerama.films[roomnumber], roomnumber, random_row, random_col,addonmode); //Imprimimos el ticket de venta			
					Printers.showInfo("\nRecoja su ticket, pulse intro para continuar.");
					Utils.returnPause();
					}
            }
         }
         for (int i=0;i<randompeople.length;i++)
         {
            replaceArray(showroom, randompeople[i][0], randompeople[i][1], roomnumber);
         }
		if (combinedpayment==1)
			{
			Printers.showInfo("\nAbone el importe de "+totalmoney+" euros, recoja sus tickets y pulse intro para finalizar.");
			Utils.returnPause();
			}
      }
   /**
   *M�todo que modifica los array de salas de cine e informaci�n de las salas.
   *Se encarga de rellenar una butaca indicada por par�metro y sumar una butaca
   *al array de butacas ocupadas
   *@param showroom Array que contiene la sala de cine a modificar
   *@param row Fila a modificar del array de sala de cine
   *@param col Columna a modificar del array de sala de cine
   *@param roomnumber N�mero de sala de cine que queremos modificar
   */
      public static void replaceArray(int[][] showroom, int row, int col, int roomnumber)
      {
         showroom[row][col]=2;
         Cinerama.filminfo[roomnumber][1]++;
      }
	/**
	*M�todo que realiza los c�lculos de ganancias y deducciones en todas las salas de cine.
	*El m�todo se invoca cuando cerramos la caja del cine y sirve para ahorrar carga de trabajo
	*ya que el sistema puede mostrar diferentes tablas varias veces con la consecuente carga
	*que supondr�a tener que calcular beneficios y p�rdidas cada vez que imprimimos la tabla.
	*/
	public static void replaceBalance()
		{
		int aux=0;
		for (int i=0; i<Cinerama.filminfo.length; i++)
			{
			///////////////////////////////////////////////
			///////////////////////////////////////////////
			//             BENEFICIOS BRUTOS             //
			///////////////////////////////////////////////
			///////////////////////////////////////////////
			aux=Cinerama.filminfo[i][1]*Cinerama.prizes[0]; //Precio base entradas
			if (Cinerama.films[i][1].equals("yes"))
				{
				aux=aux+(Cinerama.filminfo[i][1]*Cinerama.prizes[1]); //Recargo por 3D
				aux=aux+(Cinerama.filminfo[i][4]*Cinerama.prizes[2]); //Posible recargo de gafas vendidas
				}
			Cinerama.filminfo[i][7]=aux; //Beneficio Bruto de la pel�cula
			///////////////////////////////////////////////
			///////////////////////////////////////////////
			//                DEDUCCIONES                //
			///////////////////////////////////////////////
			///////////////////////////////////////////////
			aux=0;
			aux=Cinerama.filminfo[i][5]*Cinerama.prizes[3]; //Posible descuento de carn� joven
			aux=aux+Cinerama.filminfo[i][6]*Cinerama.prizes[4]; //Posible descuento de familia numerosa
			aux=aux+Cinerama.filminfo[i][3]*Cinerama.prizes[0]; //Posible descuento de entradas regaladas
			if (Cinerama.films[i][1].equals("yes"))
				{
				aux=aux+Cinerama.filminfo[i][3]*Cinerama.prizes[1]; //Posible descuento de entradas regaladas
				}
			Cinerama.filminfo[i][8]=aux; //Deducci�n total de la pel�cula
			///////////////////////////////////////////////
			///////////////////////////////////////////////
			//              BENEFICIOS NETOS             //
			///////////////////////////////////////////////
			///////////////////////////////////////////////
			Cinerama.filminfo[i][9]=Cinerama.filminfo[i][7]-Cinerama.filminfo[i][8];
			}
		}
	public static void replaceAdm(String change, int intchange, int min_prize, int max_prize)
		{
		do
			{
			Printers.showInfo(change);
			Cinerama.prizes[intchange]=Kread.readInt();
			if (Cinerama.prizes[intchange]<min_prize || Cinerama.prizes[intchange]>max_prize)
				{
				Printers.showInfo("\nEscogiste un precio no v�lido, prueba de nuevo");
				Utils.pause(2000);
				}
			else
				{
				return;
				}
			} while(1==1);
		}
   }