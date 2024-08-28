#author: Alejandro Polo Carvajal
#language: es

Característica: Abrir una pagina web

  Yo como alejandro
  Quiero realizar una prueba a la carta de elementos y las subFunciones
  Para comprobar la robuste y control de errores de la aplicacion o pagina web

  Antecedentes:
    Dado "alejandro" abre el sitio web de pruebas

  @successful1
  Escenario: Abrir con el navegador la pagina web x
    Cuando ingresa al navegador chrome
    Entonces visualizara el titulo de la pagina "Cucumber"

  @successful2
  Escenario: validacion en la funcion del ID Card Elements
    Y desea validar la funcion de la carta de elementos
    Cuando selecciona aleatoriamente alguna de las subfunciones
    Entonces visualizara en la cabecera el nombre de la opción elegida