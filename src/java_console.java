//
// Consola java 0.1

import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class java_console extends WindowAdapter implements WindowListener, ActionListener, Runnable
{	 final static int AVAILABLE=1;
	 final static int USED=2;
public static int a=1;
	private Frame frame;
	private TextArea textArea;
	static TextField textField1;
	private Thread reader;
	private Thread reader2;
	private boolean quit;
					
	private final PipedInputStream pin=new PipedInputStream(); 
	private final PipedInputStream pin2=new PipedInputStream(); 

	Thread errorThrower; // just for testing (Throws an Exception at this Console
	
	public java_console()
	{
		// create all components and add them
		frame=new Frame("Cinerama 0.3 fork 1");
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize=new Dimension((int)(screenSize.width/1.5),(int)(screenSize.height/1.5));
		int x=(int)(100);
		int y=(int)(10);
		frame.setBounds(x,y,frameSize.width,frameSize.height);
		
		textArea=new TextArea();
		textArea.setEditable(false);
		Button button=new Button("Introducir opción");
		textField1 = new TextField();
		textField1.setText("");
		Panel panel=new Panel();
		panel.setLayout(new BorderLayout(20,20));
		panel.add(textField1,BorderLayout.NORTH);
		panel.add(textArea,BorderLayout.CENTER);
		panel.add(button,BorderLayout.SOUTH);
		frame.add(panel);
		
		frame.setVisible(true);		
		
		frame.addWindowListener(this);		
		button.addActionListener(this);
		
		try
		{
			PipedOutputStream pout=new PipedOutputStream(this.pin);
			System.setOut(new PrintStream(pout,true)); 
		} 
		catch (java.io.IOException io)
		{
			textArea.append("Couldn't redirect STDOUT to this console\n"+io.getMessage());
		}
		catch (SecurityException se)
		{
			textArea.append("Couldn't redirect STDOUT to this console\n"+se.getMessage());
	    } 
		
		try 
		{
			PipedOutputStream pout2=new PipedOutputStream(this.pin2);
			System.setErr(new PrintStream(pout2,true));
		} 
		catch (java.io.IOException io)
		{
			textArea.append("Couldn't redirect STDERR to this console\n"+io.getMessage());
		}
		catch (SecurityException se)
		{
			textArea.append("Couldn't redirect STDERR to this console\n"+se.getMessage());
	    } 		
			
		quit=false; // signals the Threads that they should exit
				
		// Starting two seperate threads to read from the PipedInputStreams				
		//
		reader=new Thread(this);
		reader.setDaemon(true);	
		reader.start();	
		//
		reader2=new Thread(this);	
		reader2.setDaemon(true);	
		reader2.start();
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	//VARIABLES Y CONSTANTES POR DEFECTO
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
				samples.fillrooms(rooms,seatcounter);
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
		System.exit(0);
		}

	
	public synchronized void windowClosed(WindowEvent evt)
	{
		quit=true;
		this.notifyAll(); // stop all threads
		try { reader.join(1000);pin.close();   } catch (Exception e){}		
		try { reader2.join(1000);pin2.close(); } catch (Exception e){}
		System.exit(0);
	}		
		
	public synchronized void windowClosing(WindowEvent evt)
	{
		frame.setVisible(false); // default behaviour of JFrame	
		frame.dispose();
	}
	
	public synchronized void actionPerformed(ActionEvent evt)
	{
		textArea.setText("");
		a=0;
	}

	public synchronized void run()
	{
		try
		{			
			while (Thread.currentThread()==reader)
			{
				try { this.wait(100);}catch(InterruptedException ie) {}
				if (pin.available()!=0)
				{
					String input=this.readLine(pin);
					textArea.append(input);
				}
				if (quit) return;
			}
		
			while (Thread.currentThread()==reader2)
			{
				try { this.wait(100);}catch(InterruptedException ie) {}
				if (pin2.available()!=0)
				{
					String input=this.readLine(pin2);
					textArea.append(input);
				}
				if (quit) return;
			}			
		} catch (Exception e)
		{
			textArea.append("\nConsole reports an Internal error.");
			textArea.append("The error is: "+e);			
		}
		
		// just for testing (Throw a Nullpointer after 1 second)
		if (Thread.currentThread()==errorThrower)
		{
			try { this.wait(1000); }catch(InterruptedException ie){}
			throw new NullPointerException("Application test: throwing an NullPointerException It should arrive at the console");
		}

	}
	
	public synchronized String readLine(PipedInputStream in) throws IOException
	{
		String input="";
		do
		{
			int available=in.available();
			if (available==0) break;
			byte b[]=new byte[available];
			in.read(b);
			input=input+new String(b,0,b.length);														
		}while( !input.endsWith("\n") &&  !input.endsWith("\r\n") && !quit);
		return input;
	}	
		
	public static void main(String[] arg)
	{
		new java_console(); // create console with not reference	
	}			
}