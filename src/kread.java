import java.io.*;
/**
*Clase que contiene los métodos para obtener
*entradas de teclado
*@version 1.0
*@author José Antonio Yáñeez Jiménez
*/
public class Kread 
	{
	/**
	*Método para capturar una entrada de teclado y enviarla como String
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
	*Método que invoca al método readString e intenta convertir su return
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
	*Método que invoca a parseInt con la cadena de texto obtenida
	*a través del método readString
	*@return Entero
	*/
	public static int readInt() 
		{
		return parseInt(readString());
		}
	}
