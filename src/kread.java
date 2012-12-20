import java.io.*;
/**
*Clase que contiene los métodos para obtener
*entradas de teclado
*@version 0.2
*@author José Antonio Yáñez Jiménez
*/
public class kread 
	{
    public static String readString() 
	 	{
		String texto = null;
		try 
			{
			BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
			texto = teclado.readLine();
			}
		catch (IOException e)
			{}
		return texto;
		}

	public static int parseInt(String texto) 
		{
		int i = 0;
		try
			{
			i = Integer.parseInt(texto);
			}
		catch (NumberFormatException e) 
			{
			return Integer.MIN_VALUE;
			}
		return i;
		}

	public static float real(String texto) 
		{
		float i = 0;
		try 
			{
			i = Float.parseFloat(texto);
			} 
		catch (NumberFormatException e) 
			{
			return Float.MIN_VALUE;
			}
		return i;
		}

	public static int readInt() 
		{
		return parseInt(readString());
		}
	public static float readFloat() 
		{
		return real(readString());
		}
	}