# cinerama
***

Proyecto Java (jGRASP) desarrollado por José Antonio Yáñez Jiménez para IES Galileo.

		    ........MMM7$MMMNMNNMMMNMMMMMMMMMNMNNMNNNNNNNNNMMMMNMMMNNNNNNNNNNNNNNNMMNMNMNMMMMNMNMMMMMMM.........
		    .........DMMMMMMMMMMMNMNMMMMMMMMMNMMMNNMNNMMMMMNMMMNNMNNMMMMNMMMNNMNNNNMNMNMMNMMMNNMMDMMMM..........
		    .........7MMMM..........***************************************************..........MMMMM .........
		    .........,MMMM..........*  ____ _____        ___  ___   ___          ___  *..........MMMMM..........
		    ..........MMMM..........* |       |   |\  | |    |___| |   | |\  /| |   | *..........MMMM. .........
		    ..........MMMM..........* |       |   | \ | |-   | \   |___| | \/ | |___| *..........MMMM...........
		    ..........MMMM..........* |____ __|__ |  \| |___ |  \  |   | |    | |   | *..........MMMM ..........
		    ..........MMMM\.........*                                                 *........./MMMM...........
		    ..........MMMMN.........***************************************************.........DMMMM...........
		    ...........MMMM.....................................................................NNMMN...........
		    ..........OMMMM.....................................................................NNMMMM$I,.......
		    MMMMMMMMMMMMMMM.................... José Antonio  Yáñez Jiménez ....................MMNMMMMMMMMMMMMM
		    MMMMMMMMNMMMMMM\.................................................................../NNMMMMMM.I$MMMMM
		    MMMMMMMMMMMMMMMM...................................................................MNMMMMMMMMNMMMMMM
		    MMMMMMMMMMMMMMMMMMMMNNNNNNNNNNNNNNNNNMNNNNNNNNNNNMNNNNNNNNNMNMNNNNNNNNNNMNNNNNNMNNMMNMMMMMMMMNNMMMMN
		    MMMMMMMMNMMMMMMMNMMMMNMNMMNMMMNNNNNNNNNNMNNMNNMMNMNNNNMNNNNNNNNNNNNMMNMNNNMNNNNNNMNMMMMMMMMMMMMMMMMN
		    MMMMMMMMMMZ7$7I$II?++I~:~,,,:,,.,,,,,,~,?,::,,:,::~:::,,,.:,:,,.:.,:,,,:,,,,.,,,,,,,:~+II?MMMMMMMMMM
		    MMMMMMM+~~:,.,,,. ........,,,....,...,..,,....,.............,..,....,,,.:,:,.,..,,,::::,,::++.MMMMMM
		    MMMN=,::,,:, .,.......   .   . .....     .  .   .         .... . . .........    ...+IIO8OOD$D8+DMNNN
		    MMMMMMMMNMMMMMMMNMMMMNMNMMNMMMNNNNNNNNNNMNNMNNMMNMNNNNMNNNNNNNNNNNNMMNMNNNMNNNNNNMNMMMMMMMMMMMMMMMMN
		    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		    ~~/MMMMMMMMMMMNMMM M.~~~~MNNMMNNNMMMM.MMNNN~~~~~~MMNMN.NNMDMNZNNMMMM~~~~~~~MMMMMMMMMMMMMMMMM~~~~MMMM
		    ~D8M    .  . .. . ..7M~~MMO... ........ ..,M~~~~M . .. . . .. . ..MM~~~~~M........... ...?MM~~M ....
		    ~ND  .....  .  ......M~~M:..... ... .. .... M~~M   . .     .  ...7.MN~.M~.  .=MNMMNDN7,..MMM: .?. $M
		    MMO MMMMMMMMMMMMMMM8 M~MM. MMMMMMMMMMMMMMMM,N~MD..MMMMMMMNMMMMMMMMM.MO NNMMNNMMNNMMMMMMMMMMM .ZMMMMN
		    8ZZMMMNNMM 5 MMMMMMMM.NMM.MNMMMNMM 6 MMMMMMMM,MN.MMMMNMNM 7 MMMNMMMMN...NMNNNMMM 8 MMMMMMMM..MMMMMN 
		    N$MMMMMMNMMMMMMMMMNMM8MM.MMMMMMMMMNMNNNMMMMM,MN MMNMMNNNMMMMMMMMMMMMO MMMMMNMMMMMMMNMMMMMMM $NMMMMNM
		    $8MMMMMMMMNMMMMNMMMMMM,M.MMMNMMMMMMMNMMMMMMM,N.IMMMMMMMMNMMNMMMMMMMN .MMMNMMMMMMMMMMMMMMMM .MMMMMMMN
		    8$MMMMMMNNMMNMMMMMMMMM~M MMMMMMNMMMMMMNMMMMM, .DNMNMNMNNNMNMNMMMMMM..+DI, ............IMNM.=MMMMMMMM
		    8NMM, .. .......... . ...MNMMMNMMMMM? . .. ............ .7NMNMMMMMD...................... .7MMMMMMN 
		    .  ........... ............MMMMMMN.........................MMMMMM ........................ MMNNN8...
		    D..........................=MMMMM ........................,IMMMMN..$  ......,:IO8$77O7. ..  MMMM ..?
		    , ~.DZZMNMMMDNNNMNNNNO~, ...MMMMM.=.. :8O8DMMMNMMNMMNMMNMN+.MMMM..8:DMMMMMMMNMMMMMMMMMMMMMMMIMM...NN
		    .78MNMMMMNMNMMMMMNMMMMMMNMM?MMMM, ,N8MMMMMMNNMMMMMNMNNNNNNMMMMMM..DMMNMMNNNNNDNNNNNNNMNNMNMMMMM ..MM

### Última revisión 1.0, 16 de Enero de 2013.

## Funcionalidades

* Posibilidad de crear de 1 a 20 salas de cine con un tamaño variable de 1 a 20 filas y de 1 a 20 butacas por cada fila (cada sala de cine puede tener un tamaño diferente).

* Posibilidad de crear salas de cine con uno o dos pasillos verticales.

* Posibilidad de añadir películas 2D y 3D (a partir de un listado predefinido de películas).

* Posibildad de utilizar ejemplos de relleno automático en los que se crean salas de cine de ejemplo, se rellenan con películas e incluso con público ficticio que cuenta para las finanzas finales.

* Posibilidad de comprar varias entradas y escoger la posición de las mismas mediante variados métodos.

	* Método totalmente automático que posiciona de forma aleatoria sin asegurar asientos contiguos en caso de comprar varios tickets simultáneamente.
	* Métodos manuales para posicionar ventas de varios tickets de forma contigua en distintos sectores de la sala (izquierdo, derecho o central en salas de doble pasillo).
	* Método totalmente manual para escoger fila y butaca de cada ticket comprado.

* Sistema avanzado de muestra de la ocupación de las salas de cine.

* Sistemas de descuento por familia numerosa y carné joven.

* Sistema de recargo por películas en proyección 3D.

* Impresión de tickets de venta avanzados.

* Sistema avanzado de tablas de beneficios y deducciones.

* Huevos de pascua con los que podemos incluso conseguir entradas gratuitas que se deducen en las recaudaciones finales.

* Sistema de venta de grafas 3D en salas con proyección en 3D.

* Panel completo de administración desde el que poder modificar los valores por defecto de precios, descuentos y recargos, así como la disposición de las salas justo antes de lanzar la aplicación principal.

* Sección de "acerca de" con información básica sobre el proyecto.

* Gran implementación de gráficos mediante arte ascii.

## Historial de versiones

### 1.0

### Versión final.

* Debug completo de la aplicación.

* Limpieza de código y pruebas en busca de posibles errores.

* Añadidos gráficos extra con arte ascii.

* Documentación JavaDoc finalizada.

* Añadido Wiki con manual de uso.

* Mejora de los tickets

### 0.5

### Major Release.

* Rediseño de la ejecución inicial de la aplicación para adaptarla al nuevo diseño de menú inicial y panel de administración.

* Añadido menú de administración desde el que poder editar características del cine como los rellenos de salas y películas, los precios de las entradas, los precios de los suplementos y de descuentos.

* Añadida sección "Acerca de".

* Añadido método para calcular los beneficios y deducciones automáticamente al cerrar el menú de venta de tickets. Así tenemos todo calculado para las tablas sin tener que hacer el cálculo cada vez que imprimimos una.

* Finalizados los métodos para imprimir nuevas tablas de beneficios y deducciones.

* Añadidas opciones para descuentos a clientes con carné joven, familias numerosas y la posibilidad de comprar gafas 3D para proyecciones 3D con su recargo correspondiente. Estos descuentos pueden aplicarse a los tickets de forma individual o en conjunto (cuando se compran varias entradas con un sistema de ordenación aleatorio o de posición en butacas contiguas).

* Añadido Método para poder realizar un pago conjunto en compras de varios tickets a la vez. Con este sistema todos los tickets aparecen seguidos y después se nos muestra la suma que tiene que abonar el comprador seguida de la pausa, al contrario que con el método de pago individual, en el que cada vez que aparece un ticket se realiza una pausa para que el comprador lo recoja y pague.

* Debug de la clase Easter añadiendo compatibilidades entre jGRASP para Windows y jGRASP para Mac (Solventados problemas de codificación usando workarounds)

* Añadido Easter egg para poder adquirir entradas de forma gratuita para cualquier proyección utilizando un código promocional.

* JavaDoc actualizado.

### 0.4

* Creado método nuevo para imprimir tablas avanzadas de beneficios y deducciones. Anteriormente se imprimia una tabla que agrupada los beneficios brutos, las deducciones y los beneficios totales de todas las películas. Con el nuevo sistema se diferencian 3 tipos de tablas:

	* Tabla que muestre los beneficios brutos por película
	* Tabla que muestre las deducciones por película
	* Tabla que muestre los beneficios netos por película

* Desde el menú de recaudación podrá escogerse visualizar cada una de las tablas individualmente o todas en conjunción.

* Redefinición de todos los nombres de clase para adaptarse a los estándares.

### 0.3

### Major Release.

* Extracción de los 3 arrays sobre los que se basa la aplicación a la clase Cinerama para que puedan ser utilizados por todos los métodos del paquete como variables globales. Esto nos permite no tener que estar pasando continuamente como parámetros las referencias a estas variables que vamos a utilizar continuamente.

* Eliminación de métodos no utilizados en la clase kread (La aplicación no requiere de lectura de números float)

* Añadida opción de venta de tickets con posicionamiento manual de forma individual. Esta opción nos permite comprar una o varias entradas a la vez escogiendo la fila y butaca dentro de la fila en la que queremos establecernos una por una.

* Añadida opción de venta de tickets con posicionamiento manual de forma grupal. Esta opción solo aparece cuando se compran varias entradas. Nos permite comprar varias entradas a la vez escogiendo la fila y una agrupación de butacas contigua. Se tienen en cuenta los pasillos y el cálculo de butacas libres se realiza una vez se especifica el número de tickets que desea adquirirse, de tal forma que si el número de tickets que se desea adquirir es mayor que las butacas contiguas que hay en las filas para escoger (se tienen en cuenta los pasillos para dividir secciones de butacas libres) la opción no se puede escoger. Además el sistema automáticamente calcula las filas en las que es posible comprar la agrupación de butacas y solo permite escoger entre éstas. De igual modo el sistema calcula las posibles agrupaciones de butacas que es posible escoger en una fila concreta ya seleccionada y solo nos permite escoger entra éstas posibilidades. Una vez se ha seleccionado fila y agrupación de butacas los tickets de venta se imprimen uno a uno.

* Modificación del sistema de returns en la clase inputs. Ahora los métodos que se utilizan para algún tipo de venta devuelven un valor entero (0 si la venta ha sido cancelada en algún momento y 1 si ha sido correcta).

* Añadido método para imprimir un ticket de venta con la información de la película, posición de la butaca y precio del ticket.

* Añadidos métodos variados para poder realizar las nuevas opciones de venta manual individual y de grupos de butacas.

* Modificación de los métodos existentes para adaptarlos a los cambios de variables y constantes globales.

* Añadida clase para huevos de pascua. Los huevos de pascua se activan desde el menú de nuevo cliente. Nos permiten hacer guiños a algunas proyecciones que aparecen en nuestro cine e incluso conseguir alguna entrada gratuita.

* Documentación JavaDoc añadida en gran parte de las clases y métodos nuevos.

### 0.2

* Añadidos Arrays para almacenar información de las salas de cine.

* Añadido método para establecer pausas temporales en la ejecución de la aplicación.

* Añadida clase de ejemplos para probar la aplicación con salas generadas aleatoriamente.

* Añadida clase para realizar modificaciones en los arrays de las salas de cine.

### 0.1

* Creación de la estructura básica -Un array de tres dimensiones que servirá para almacenar los datos de butacas de las posibles salas de cine-.

* Añadida una clase Utils para métodos reciclables que no tienen suficiente nivel como para crear una clase propia.