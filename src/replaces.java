/**
*Clase que contiene los métodos que modifican nuestros arrays
*@version 0.2
*@author José Antonio Yáñez Jiménez
*/
class replaces
	{
	public static void randomReplaceRoom(int[][] showroom,int seats, int roomnumber, int[][] seatcounter)
		{
		int max_people=0, random_row=0, random_col=0;
		boolean repeated=false;
		int randompeoplecounter=0;
		int[] roomsize=utils.roomSize(showroom);
		max_people=((roomsize[0]*roomsize[1])*seats)/100;
		int[][] randompeople=constructors.makeRandomCounter(max_people,2);
		printers.showInfo("\nRellenando la sala "+(roomnumber+1)+" con "+max_people+" asistentes. Por favor espere... ");
		for (int i=0;i<max_people; i++)
			{
			randompeoplecounter++;
			do
				{
				random_row=utils.random(0,(roomsize[0]-1));
				random_col=utils.random(0,(roomsize[1]-1));
				for (int j=0; j<randompeoplecounter; j++)
					{
					repeated=false;
					if (randompeople[j][0]==random_row & randompeople[j][1]==random_col)
						{
						repeated=true;
						break;
						}
					}
				}while(repeated);
			randompeople[i][0]=random_row;
			randompeople[i][1]=random_col;
			}
		for (int i=0;i<randompeople.length;i++)
			{
			showroom[randompeople[i][0]][randompeople[i][1]]=2;
			seatcounter[roomnumber][1]++;
			}
		}
	}