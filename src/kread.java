import java.io.*;
/**
*Clase que contiene los m�todos para obtener
*entradas de teclado
*@version 1.0
*@author Jos� Antonio Y��eez Jim�nez
*/
public class Kread 
	{
	/**
	*M�todo para capturar una entrada de teclado y enviarla como String
	*@return String con la entrada de teclado
	*/
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
	/**
	*M�todo que invoca al m�todo readString e intenta convertir su return
	*en un entero.
	*@return entero formado a partir de la entrada de teclado o Integer.MIN_VALUE
	*si no se introdujo un entero por teclado.
	*/
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
	/**
	*M�todo que invoca a parseInt con la cadena de texto obtenida
	*a trav�s del m�todo readString
	*@return Entero
	*/
	public static int readInt() 
		{
		return parseInt(readString());
		}
	}
