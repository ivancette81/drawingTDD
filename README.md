# drawingTDD

* Crearemos una región espacial de 800x800
* Crearemos un punto objetivo dentro de la región en el punto (400,0)
* Ejecutaremos 100 rondas de lo siguiente:
   * Crearemos una población de 50 puntos en el punto (400, 800)
   * Estos puntos realizarán 1000 movimientos aleatorios dentro de la región. Tenemos que almacenar estos movimientos aleatorios (o calcularlos anticipadamente).
   * Si tocan un límite de la región, dejarán de moverse
   * Una vez que toda la población haya terminado los 1000 movimientos o todos hayan muerto, calcularemos la distancia de cada uno hasta el punto objetivo.
   * Seleccionaremos el punto más cercano al punto objetivo y lo marcaremos como el mejor de la ronda.
   * Volvemos al inicio de la ronda con las siguientes condiciones: crearemos una nueva población de 50 puntos, uno de los cuales será el mejor de la ronda anterior.  Calcularemos los movimientos de cada punto a partir del mejor de la ronda anterior, con una probabilidad de recalculo de cada movimiento de un 10%
* Mostraremos cada una de las rondas en un canvas AWT, coloreando de verde el mejor punto de la ronda anterior

--Zona espacial 800x800
--punto objetivo en (400,0)
--punto en 400, 800
--el punto se mueve de forma aleatoria a una de las 9 posiciones adyacentes
--el punto se mueve de forma aleatoria a una de las 9 posiciones adyacentes muriendo si se sale de la zona
--el punto se mueve de forma aleatoria a una de las 9 posiciones adyacentes muriendo si se sale o toca en zonas prohibidas
--el punto se mueve de forma aleatoria a una de las 9 posiciones adyacentes un número n de veces muriendo si se sale o toca en zonas prohibidas
--n puntos se mueven de forma aleatoria a una de las 9 posiciones adyacentes un número n de veces muriendo si se sale o toca en zonas prohibidas
--m veces ocurre que n puntos se mueven de forma aleatoria a una de las 9 posiciones adyacentes un número n de veces muriendo si se sale o toca en zonas prohibidas
--creamos un punto en la posición inicial y calculamos su distancia al punto objetivo
--creamos dos puntos en la posición inicial, los movemos y cogemos el de menor distancia al punto objetivo
-*calculamos distancia entre dos puntos separados en ambas coordenada
--guardamos los movimientos de un punto
Copiamos los movimientos de un punto en otro punto
Copiamos los movimientos de un punto en otro punto aplicando un coeficiente de mutación en cada movimiento
