class utils
	{
	/**
	*/
	static int random(int n1, int n2)
	{
		int min=Math.min(n1, n2);
		int max=Math.max(n1, n2);
		return ((int) (Math.random()*(max-min+1)+min));
	}
	static void pause(int miliseconds)
		{
		try
			{
			Thread.sleep(miliseconds);
			}
		catch(InterruptedException e)
			{}
		}
	public static int[] roomSize(int[][] showroom)
		{
		boolean rows_limit=false, cols_limit=false;
		int rows=0, cols=0;
		for (int j=0; j<showroom.length;j++)
			{
			if (showroom[j][0]==0)
				{
				rows_limit=true;
				}
			else
				{
				rows=j;
				}
			if (rows_limit)
				break;
			}
		for (int j=0; j<showroom[0].length;j++)
			{
			if (showroom[0][j]==0)
				{
				cols_limit=true;
				}
			else
				{
				cols=j;
				}
			if (cols_limit)
				break;
			}
		int[] size={rows,cols};
		return size;
		}
	}