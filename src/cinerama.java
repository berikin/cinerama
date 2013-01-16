/**
*Clase que contiene el m�todo main
*@version 1.0
*@author Jos� Antonio Y��ez Jim�nez
*/
class Cinerama
	{
	/**
	*Constante para definir las butacas libres
	*/
	static final int AVAILABLE=1;
	/**
	*Constante para definir las butacas ocupadas
	*/
	static final int USED=2;
	/**
	*Variable para definir los precios<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[0]-Precio base de entrada<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[1]-Recargo por proyecci�n 3D<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[2]-Recargo por gafas 3D<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[3]-Descuento carn� joven<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[4]-Descuento familia numerosa<br>
	*/
	static int[] prizes={6,2,1,2,2};
	/**
	*Constante para definir el precio del suplemento 3D
	*/
	//static final int PRIZE_3D=2;
	/**
	*Variable encargada de almacenar todas las salas de cine de la aplicaci�n
	*Se rellena mediante m�todos que contienen muestras o manualmente introduciendo
	*los datos desde un m�todo que lee entradas de teclado. Tiene tres dimensiones para
	*contener informaci�n de filas de asientos, butacas de cada fila y diferentes salas.
	*El tama�o del array lo definir�n m�s adelante los m�todos de la clase constructors
	*en funci�n de los requerimentos de sala deseados.
	*/
	static int[][][] rooms;
	/**
	*Variable encargada de almacenar la informaci�n de las salas de cine
	*Se rellena en funci�n de las salas que creen.
	* &nbsp;&nbsp;&nbsp;&nbsp;[0]-Butacas totales<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[1]-Butacas ocupadas<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[2]-Pasillo simple (1) o doble (2)<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[3]-Butacas gratuitas<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[4]-N� gafas 3D vendidas<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[5]-N� descuentos carn� joven<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[6]-N� descuentos familia numerosa<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[7]-Beneficio bruto<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[8]-Deducciones totales<br>
	* &nbsp;&nbsp;&nbsp;&nbsp;[9]-Beneficio neto<br>
	*El tama�o del array lo definir�n m�s adelante los m�todos de la clase constructors
	*en funci�n de los requerimentos de sala deseados.
	*/
	static int[][] filminfo;
	/**
	*Variable encargada de almacenar las pel�culas que se proyectan
	*Se rellena aleatoriamente con pel�culas guardadas en una constante o con las pel�culas
	*que se escojan de esa constante.
	*Tiene dos dimensiones: una para especificar la sala de cine a la que se refiere y
	*otra para almacenar el t�tulo de la pel�cula y si �sta es 3D o no.
	*El tama�o del array lo definir�n m�s adelante los m�todos de la clase constructors
	*en funci�n de los requerimentos de sala deseados.
	*/
	static String[][] films;
	/**
	*Variable encargada de seleccionar el tipo de relleno por defecto para salas y pel�culas.
	*Por defecto es 1 para que se genere el relleno express. En el men� de administraci�n puede
	*modificarse esto.
	*/
	static int samplenum=1;
	/**
	*M�todo principal de la aplicaci�n, desde el que se lanza la misma
	*/
	public static void main(String[] args)
		{
		boolean exitmenu=false;
		//Pantalla de presentaci�n
		Printers.showInfo("    ........MMM7$MMMNMNNMMMNMMMMMMMMMNMNNMNNNNNNNNNMMMMNMMMNNNNNNNNNNNNNNNMMNMNMNMMMMNMNMMMMMMM.........\n    .........DMMMMMMMMMMMNMNMMMMMMMMMNMMMNNMNNMMMMMNMMMNNMNNMMMMNMMMNNMNNNNMNMNMMNMMMNNMMDMMMM..........\n    .........7MMMM..........***************************************************..........MMMMM .........\n    .........,MMMM..........*  ____ _____        ___  ___   ___          ___  *..........MMMMM..........\n    ..........MMMM..........* |       |   |\\  | |    |___| |   | |\\  /| |   | *..........MMMM. .........\n    ..........MMMM..........* |       |   | \\ | |-   | \\   |___| | \\/ | |___| *..........MMMM...........\n    ..........MMMM..........* |____ __|__ |  \\| |___ |  \\  |   | |    | |   | *..........MMMM ..........\n    ..........MMMM\\.........*                                                 *........./MMMM...........\n    ..........MMMMN.........***************************************************.........DMMMM...........\n    ...........MMMM.....................................................................NNMMN...........\n    ..........OMMMM.....................................................................NNMMMM$I,.......\n    MMMMMMMMMMMMMMM.................... Jos� Antonio  Y��ez Jim�nez ....................MMNMMMMMMMMMMMMM\n    MMMMMMMMNMMMMMM\\.................................................................../NNMMMMMM.I$MMMMM\n    MMMMMMMMMMMMMMMM...................................................................MNMMMMMMMMNMMMMMM\n    MMMMMMMMMMMMMMMMMMMMNNNNNNNNNNNNNNNNNMNNNNNNNNNNNMNNNNNNNNNMNMNNNNNNNNNNMNNNNNNMNNMMNMMMMMMMMNNMMMMN\n    MMMMMMMMNMMMMMMMNMMMMNMNMMNMMMNNNNNNNNNNMNNMNNMMNMNNNNMNNNNNNNNNNNNMMNMNNNMNNNNNNMNMMMMMMMMMMMMMMMMN\n    MMMMMMMMMMZ7$7I$II?++I~:~,,,:,,.,,,,,,~,?,::,,:,::~:::,,,.:,:,,.:.,:,,,:,,,,.,,,,,,,:~+II?MMMMMMMMMM\n    MMMMMMM+~~:,.,,,. ........,,,....,...,..,,....,.............,..,....,,,.:,:,.,..,,,::::,,::++.MMMMMM\n    MMMN=,::,,:, .,.......   .   . .....     .  .   .         .... . . .........    ...+IIO8OOD$D8+DMNNN\n    MMMMMMMMNMMMMMMMNMMMMNMNMMNMMMNNNNNNNNNNMNNMNNMMNMNNNNMNNNNNNNNNNNNMMNMNNNMNNNNNNMNMMMMMMMMMMMMMMMMN\n    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n    ~~/MMMMMMMMMMMNMMM M.~~~~MNNMMNNNMMMM.MMNNN~~~~~~MMNMN.NNMDMNZNNMMMM~~~~~~~MMMMMMMMMMMMMMMMM~~~~MMMM\n    ~D8M    .  . .. . ..7M~~MMO... ........ ..,M~~~~M . .. . . .. . ..MM~~~~~M........... ...?MM~~M ....\n    ~ND  .....  .  ......M~~M:..... ... .. .... M~~M   . .     .  ...7.MN~.M~.  .=MNMMNDN7,..MMM: .?. $M\n    MMO MMMMMMMMMMMMMMM8 M~MM. MMMMMMMMMMMMMMMM,N~MD..MMMMMMMNMMMMMMMMM.MO NNMMNNMMNNMMMMMMMMMMM .ZMMMMN\n    8ZZMMMNNMM 5 MMMMMMMM.NMM.MNMMMNMM 6 MMMMMMMM,MN.MMMMNMNM 7 MMMNMMMMN...NMNNNMMM 8 MMMMMMMM..MMMMMN \n    N$MMMMMMNMMMMMMMMMNMM8MM.MMMMMMMMMNMNNNMMMMM,MN MMNMMNNNMMMMMMMMMMMMO MMMMMNMMMMMMMNMMMMMMM $NMMMMNM\n    $8MMMMMMMMNMMMMNMMMMMM,M.MMMNMMMMMMMNMMMMMMM,N.IMMMMMMMMNMMNMMMMMMMN .MMMNMMMMMMMMMMMMMMMM .MMMMMMMN\n    8$MMMMMMNNMMNMMMMMMMMM~M MMMMMMNMMMMMMNMMMMM, .DNMNMNMNNNMNMNMMMMMM..+DI, ............IMNM.=MMMMMMMM\n    8NMM, .. .......... . ...MNMMMNMMMMM? . .. ............ .7NMNMMMMMD...................... .7MMMMMMN \n    .  ........... ............MMMMMMN.........................MMMMMM ........................ MMNNN8...\n    D..........................=MMMMM ........................,IMMMMN..$  ......,:IO8$77O7. ..  MMMM ..?\n    , ~.DZZMNMMMDNNNMNNNNO~, ...MMMMM.=.. :8O8DMMMNMMNMMNMMNMN+.MMMM..8:DMMMMMMMNMMMMMMMMMMMMMMMIMM...NN\n    .78MNMMMMNMNMMMMMNMMMMMMNMM?MMMM, ,N8MMMMMMNNMMMMMNMNNNNNNMMMMMM..DMMNMMNNNNNDNNNNNNNMNNMNMMMMM ..MM\n");
		Utils.pause(4000);
		Inputs.firstMenu();
		do
			{	
			exitmenu=Inputs.mainMenu();
			}while(exitmenu==false);
		do
			{
			Replaces.replaceBalance();
			exitmenu=Inputs.recaudatoryMenu();
			}while(exitmenu==false);		
		}
	}