# Bitácora - tarea 2 - BIS = Programación 2

**Estudiante** : José Ignacio Chavarría Delgado

## Métodos nuevos y dónde los usé : 
- "AsociadoServicio.registrar (String cedula, String nombre, String saldoTexto)": recibe los textos de la ventana y valida los campos vacíos, el saldo no númerico, luego llamada a "registrar(Asociado)".
Esta está en el servicio ya que es parte de la validación y la ventana no debe decidir si el dato es válido. 
-"AsociadoServicio.cantidadAsociados()" con "totalAportes()": cuentan los asociados y suman sus aportes. Los puse en servicio y no en el botón de la ventana, porque cualquier otra ventana podría necesitar el mismo cálculo y así solo lo tengo que escribir una vez.
-"AsociadoServicio.buscarPorCedula(String) ": devuelve el asociado o null si no existe.

## Estructura de la ventana 
- La ventana princiapl solo depende de AsociadoServicio, no abre archivos, no crea el DAO, solo muestra por medio los if, por esto el programa se arranca por el MAIN.

## Uso de IA 
La utilicé para las partes de la interfaz, que me pudiera hacer recomendaciones de otras herramientas distintas a las que estaban en el material, ya que no entendía muy bien o no me gustaba el resultado de las otras.
También la use para ampliar conocimientos, ya que habían ciertas cosas en el material que no me quedaban del todo claras.
También la use para resolver algunas dudas que tenía sobre el uso de GIThub.

## Dificultades que tuve 
-Mi constructor "Asociado" tenía parámetros en distinto orden que prueba y se repetían las cédulas. Lo corregí poniendo el mismo orden siempre, primero cedula, luego nombre y saldo.
-Tuve repetidos errores de compilación por las mayúsculas y minúsculas en los nombres de los métodos
-También un par de veces se me olvidó declarar un botón como atributo.