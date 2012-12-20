class cinerama
	{
	//VARIABLES Y CONSTANTES POR DEFECTO
	static final int AVAILABLE=1;
	static final int USED=2;
	public static void main(String[] args)
		{
		int[][][] rooms;
		String[][] films;
		int sample=inputs.selectSample();
		switch (sample)
			{
		   case 1:
				rooms=samples.cinema1();
				films=samples.showfilms1();
		      break;
		   case 2:
				rooms=samples.cinema2();
				films=samples.showfilms2();
		      break;
			default:
				rooms=samples.cinema1();
				films=samples.showfilms1();
				break;
			}
		}
	}