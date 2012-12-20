class printers
/**
*Cinerama for IES Galileo
*version 0.1
*Author José Antonio Yáñez Jiménez
*/
	{
	public static void showLogo()
		{
		System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.print("\n--------------------------");
		System.out.print("\n   Cinerama IES Galileo");
		System.out.print("\n--------------------------\n");
		}
	public static void showSamples()
		{
		System.out.print("\nEscoge entre uno de los siguientes rellenos:");
		System.out.print("\n\t(1) Relleno 1:");
		System.out.print("\n\t\tCine con 4 salas");
		System.out.print("\n\t\t4 proyecciones aleatorias, 2 de ellas en 3D");
		System.out.print("\n\t(2) Relleno 2:");
		System.out.print("\n\t\tCine con 2 salas");
		System.out.print("\n\t\t2 proyecciones aleatorias");
		System.out.print("\nRelleno (1-2):");
		}
	public static void showError(String errorchar)
		{
		System.out.print("\n"+errorchar);
		}
	}