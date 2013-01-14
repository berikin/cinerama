# cinerama


Java (jGRASP) proyecto desarrollado por José Antonio Yáñez Jiménez para IES Galileo.

## Funcionalidades

* Posibilidad de crear de 1 a 20 salas de cine con un tamaño variable de 1 a 20 filas y de 1 a 20 butacas por cada fila (cada sala de cine puede tener un tamaño diferente).

* Posibilidad de crear salas de cine con uno o dos pasillos verticales.

* Posibilidad de añadir películas 2D y 3D (a partir de un listado predefinido de películas).

* Posibildad de utilizar ejemplos de relleno automático en los que se crean salas de cine de ejemplo, se rellenan con películas e incluso con público ficticio que cuenta para las finanzas finales.

* Posibilidad de comprar varias entradas y escoger la posición de las mismas mediante variados métodos.

1. Método totalmente automático que posiciona de forma aleatoria sin asegurar asientos contiguos en caso de comprar varios tickets simultáneamente.
2. Métodos manuales para posicionar ventas de varios tickets de forma contigua en distintos sectores de la sala (izquierdo, derecho o central en salas de doble pasillo).
3. Método totalmente manual para escoger fila y butaca de cada ticket comprado.

* Sistema avanzado de muestra de la ocupación de las salas de cine.

* Sistemas de descuento por familia numerosa y carné joven.

* Sistema de recargo por películas en proyección 3D.

* Impresión de tickets de venta avanzados.

* Sistema avanzado de tablas de beneficios y deducciones.

* Huevos de pascua con los que podemos incluso conseguir entradas gratuitas que se deducen en las recaudaciones finales.

## Historial de versiones


### 0.5

* Añadido método para calcular los beneficios y deducciones automáticamente al cerrar el menú de venta de tickets. Así tenemos todo calculado para las tablas sin tener que hacer el cálculo cada vez que imprimimos una.

* Finalizados los métodos para imprimir nuevas tablas de beneficios y deducciones.

* Añadidas opciones para descuentos a clientes con carné joven, familias numerosas y la posibilidad de comprar gafas 3D para proyecciones 3D con su recargo correspondiente. Estos descuentos pueden aplicarse a los tickets de forma individual o en conjunto (cuando se compran varias entradas con un sistema de ordenación aleatorio o de posición en butacas contiguas).

* Añadido Método para poder realizar un pago conjunto en compras de varios tickets a la vez. Con este sistema todos los tickets aparecen seguidos y después se nos muestra la suma que tiene que abonar el comprador seguida de la pausa, al contrario que con el método de pago individual, en el que cada vez que aparece un ticket se realiza una pausa para que el comprador lo recoja y pague.

### 0.4

* Creado método nuevo para imprimir tablas avanzadas de beneficios y deducciones. Anteriormente se imprimia una tabla que agrupada los beneficios brutos, las deducciones y los beneficios totales de todas las películas. Con el nuevo sistema se diferencian 3 tipos de tablas:
1. Tabla que muestre los beneficios brutos por película
2. Tabla que muestre las deducciones por película
3. Tabla que muestre los beneficios netos por película

* Desde el menú de recaudación podrá escogerse visualizar cada una de las tablas individualmente o todas en conjunción.

* Redefinición de todos los nombres de clase para adaptarse a los estándares.

### 0.3

### Revisión Principal.

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