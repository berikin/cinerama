import java.io.*;
/**
*Clase que contiene los m�todos para obtener
*entradas de teclado
*@version 0.4
*@author Jos� Antonio Y��eez Jim�nez
*/
public class Kread 
	{
    public static String readString() 
	 	{
		String text = null;
		try 
			{
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
			text = keyboard.readLine();
			}
		catch (IOException e)
			{}
		return text;
		}
	public static int parseInt(String text) 
		{
		int i = 0;
		try
			{
			i = Integer.parseInt(text);
			}
		catch (NumberFormatException e) 
			{
			return Integer.MIN_VALUE;
			}
		return i;
		}
	public static int readInt() 
		{
		return parseInt(readString());
		}
	}
