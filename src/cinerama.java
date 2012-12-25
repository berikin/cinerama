/**
*Clase que contiene el método main
*@version 0.2
*@author José Antonio Yáñez Jiménez
*/
class cinerama
	{
	/**
	*Constante para definir las butacas libres
	*/
	static final int AVAILABLE=1;
	/**
	*Constante para definir las butacas ocupadas
	*/
	static final int USED=2;
	public static void main(String[] args)
		{
		int[][][] rooms;
		int[][] seatcounter;
		String[][] films;
		boolean exitmenu=false;
		int sample=inputs.selectSample();
		switch (sample)
			{
		   case 1:
				rooms=samples.cinema1();
				films=samples.showfilms1();
				seatcounter=constructors.makeSeatCounter(rooms);
				samples.fillrooms(rooms,seatcounter,99,100);
		      break;
		   case 2:
				rooms=samples.cinema1();
				films=samples.showfilms1();
				seatcounter=constructors.makeSeatCounter(rooms);
		      break;
		   case 3:
				rooms=samples.cinema2();
				films=samples.showfilms2();
				seatcounter=constructors.makeSeatCounter(rooms);
		      break;
			default:
				rooms=samples.cinema1();
				films=samples.showfilms1();
				seatcounter=constructors.makeSeatCounter(rooms);
				break;
			}
		do
			{	
			exitmenu=inputs.mainMenu(rooms,films,seatcounter);
			}while(exitmenu==false);
		do
			{	
			exitmenu=inputs.recaudatoryMenu(rooms,films,seatcounter);
			}while(exitmenu==false);		
		}
	}