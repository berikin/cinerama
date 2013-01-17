class Cinerama_min
	{
	static boolean availableseats=false;
	static int total=120;
	static final int PRIZE=5;
	public static void showRoom(int[][] room)
		{
		System.out.print("\nVista de ocupación de la sala\n");
		System.out.printf("%5s%39s"," ","  1   2   3   4   5   6   7   8   9  10\n");
		for (int i=0; i<room.length; i++)
			{
			System.out.printf("%5s","F"+(i+1)+" ");
			for (int j=0; j<room[0].length; j++)
				{
				System.out.printf("%4s",room[i][j]+" ");
				}
			System.out.printf("%5s","F"+(i+1)+" \n");
			}
		}
	public static int requestData(String data,int minimal, int limit, String error)
		{
		int option;
		do
			{
			System.out.print(data);
			option=cs1.Keyboard.readInt();
			if (option<minimal || option>limit)
				{
				System.out.print(error);
				}
			else
				{
				return option;
				}
			}while(1==1);
		}
	public static void rowsFree(int[] freerows, int[][] room, int filmseats)
		{
		for (int i=0; i<freerows.length; i++)
			{
			for (int j=0; j<room[0].length; j++)
				{
				if (room[i][j]==0)
					{
					if ((j+filmseats)-1<room[0].length)
						{
						if (room[i][((j+filmseats)-1)]==0)
							{
							freerows[i]=1;
							break;
							}
						else
							{
							freerows[i]=0;
							}
						}
					else
						{
						freerows[i]=0;
						}
					}
				else
					{
					freerows[i]=0;
					}
				}
			}
		availableseats=false;
		for (int i=0; i<freerows.length; i++)
			{
			if (freerows[i]==1)
				{
				availableseats=true;
				return;
				}
			}
		}
	public static void replaceRoom(int[] room, int filmseats, int row)
		{
		System.out.print("\nSus entradas son: ");
		for (int i=0; i<room.length; i++)
			{
			if (room[i]==0)
				{
				for (int j=i; j<filmseats; j++)
					{
					System.out.print("\nFila: "+row+" Asiento: "+(j+1));
					room[j]=1;
					total--;
					}
				System.out.print("\nImporte de las entradas = "+(filmseats*PRIZE)+" Euros");
				return;
				}
			}
		}
	public static void main(String[] args)
		{
		int[][] room=new int[12][10];
		int[] freerows=new int[12];
		int filmseats, row;
		do
			{
			showRoom(room);
			filmseats=requestData("\n¿Cuantas entradas desea? (teclear 0 para finalizar): ",0,120,"\nNúmero de entradas no válido");
			if (filmseats==0)
				{
				break;
				}
			if (filmseats<=total)
				{
				rowsFree(freerows,room,filmseats);
				row=requestData("\n¿Fila (1-12)?: ",1,12,"\nNúmero de fila no válido");
				if (availableseats)
					{
					if (freerows[(row-1)]==1)
						{
						replaceRoom(room[(row-1)],filmseats,row);
						}
					else
						{
						System.out.print("\nNo hay "+filmseats+" asientos contiguos libres en la fila "+row);
						System.out.print("\nFilas donde hay "+filmseats+" asientos contiguos libres: \n");
						for (int i=0; i<freerows.length; i++)
							{
							if(freerows[i]==1)
								{
								System.out.print("\t"+(i+1));
								}
							}
						System.out.print("\n");
						}
					}
				else
					{
					System.out.print("\nNo hay ninguna fila con "+filmseats+" entradas contiguas libres");
					}
				}
			else
				{
				System.out.print("\nSolo quedan "+total+" entradas para esta sesión");
				}
			if (total==0)
				{
				System.out.print("\nENTRADAS AGOTADAS");
				break;
				}
			}while(1==1);
		System.out.print("\nRecaudación = "+(120-total)+" entradas vendidas x "+PRIZE+" Euros = "+(120-total)*PRIZE+" Euros");
		}
	}