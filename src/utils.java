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
	}