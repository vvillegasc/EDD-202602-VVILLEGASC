# Cómo aplicamos MVC en el Taller 1

Grupo N__ — Integrantes: __________________________

La aplicación es un programa de consola que maneja tres estructuras hechas a mano:
un arreglo de tamaño fijo, una pila y una cola circular. No usamos `ArrayList`,
`java.util.Stack` ni nada de `java.util`.

El código está separado en tres paquetes, uno por cada capa del patrón:

- **model** → `Array`, `Stack`, `Queue`: guardan los datos y hacen las operaciones.
- **view** → `ConsoleView`: muestra los menús y lee lo que escribe el usuario.
- **controller** → `MainController`, `ArrayController`, `StackController`, `QueueController`:
  conectan las otras dos capas.

`Main.java` solo crea la vista y el `MainController`, y arranca el programa.


## El Modelo

Las clases `Array`, `Stack` y `Queue` tienen todos sus atributos `private` y solo
exponen las operaciones que pide el taller:

- Array: `insert`, `deleteByPosition`, `find`, `getMax`, `toArray`
- Stack: `push`, `pop`, `peek`, `isEmpty`, `isFull`, `len`, `toArray`
- Queue: `enqueue`, `dequeue`, `peek`, `size`, `isEmpty`, `isFull`, `toArray`

Lo importante: el modelo **no imprime ni lee nada**. No tiene `System.out` ni
`Scanner`. Si algo sale mal, lanza una excepción y ya está:

- estructura llena o vacía → `IllegalStateException`
- posición fuera de rango → `IndexOutOfBoundsException`

Para mostrar el contenido tampoco recorre ni imprime: `toArray()` devuelve una copia
con los elementos que hay, y la vista se encarga de mostrarlos.


## La Vista

`ConsoleView` es la única clase que usa la consola. Ahí está el `Scanner` y todos
los `System.out.println`.

Hace tres cosas:

- muestra los menús (`showMainMenu`, `showArrayMenu`, `showStackMenu`, `showQueueMenu`)
- lee números validando: `readIntInRange` vuelve a preguntar si el usuario escribe
  algo que no es número o está fuera de rango (se usa desde `askInt`, `position`, `maxSize`)
- muestra resultados y errores (`showResult`, `showError`, `showBoolean`,
  `showContents`, `showMessage`)

La vista no importa el paquete `model`. Solo recibe números o un `int[]`.


## El Controlador

`MainController` lleva el bucle del menú principal y, según la opción, llama al
sub-controlador que toca. Al salir llama a `showGoodbye()` y `close()`.

Cada sub-controlador pide el tamaño a la vista, crea su estructura y repite su
submenú hasta que el usuario vuelve. Por cada opción:

1. pide los datos al usuario a través de la vista (`view.askInt`, `view.position`)
2. llama al método del modelo (`push`, `dequeue`, `deleteByPosition`, etc.)
3. lo mete en un `try/catch`: si el modelo lanza una excepción, le pide a la vista
   que la muestre con `view.showError(e.getMessage())`
4. si sale bien, le pasa el resultado a la vista (`view.showResult`, `view.showContents`)

El controlador nunca usa `System.out` ni `Scanner` directamente.


## Ejemplo: insertar en el arreglo

1. `MainController` muestra el menú, el usuario elige "Arreglo"
2. se crea `ArrayController`, que pide el tamaño y hace `new Array(n)`
3. el usuario elige "Insertar" y el controlador llama a `insertar()`
4. `insertar()` pide el valor con `view.askInt(...)` y llama a `array.insert(valor)`
5. si el arreglo está lleno salta `IllegalStateException` y la vista muestra el
   error; si no, muestra "Elemento insertado"

Los datos van usuario → vista → controlador → modelo, y la respuesta vuelve al
revés. El modelo y la vista nunca se hablan directamente.


## Lo clave para MVC

Ninguna clase de `model` conoce a `ConsoleView`: no la importa ni la menciona.
Solo los controladores dependen de las dos capas. Por eso se podría cambiar la
consola por una interfaz gráfica sin tocar `Array`, `Stack` ni `Queue`.
