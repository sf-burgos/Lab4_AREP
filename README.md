# Lab4 AREP
# TALLER DE ARQUITECTURAS DE SERVIDORES DE APLICACIONES, META PROTOCOLOS DE OBJETOS, PATRÓN IOC, REFLEXIÓN 
<img src="https://github.com/sf-burgos/ArquitecturaEmpresarial/blob/master/laboratorio1AREP-app/resources/Imagenes/BB.jpg" width="100" height="100">

##### **Presentado por:** **[Brayan Steven Burgos Delgado](https://www.linkedin.com/in/brayan-steven-burgos-delgado-21a9a0178/)**
##### Repositorio: [click aqui](https://github.com/sf-burgos/Lab3_AREP_Reto1)
## Objetivo: 
Para este taller los estudiantes deberán construir un servidor Web (tipo Apache) en Java. El servidor debe ser capaz de entregar páginas html e imágenes tipo PNG. Igualmente el servidor debe proveer un framework IoC para la construcción de aplicaciones web a partir de POJOS. Usando el servidor se debe construir una aplicación Web de ejemplo y desplegarlo en Heroku. El servidor debe atender múltiples solicitudes no concurrentes.
Para este taller desarrolle un prototipo mínimo que demuestre capcidades reflexivas de JAVA y permita por lo menos cargar un bean (POJO) y derivar una aplicación Web a partir de él. Debe entregar su trabajo al final del laboratorio.
Escribir un servidor web que soporte múlltiples solicitudes seguidas (no concurrentes). El servidor debe retornar todos los archivos solicitados, incluyendo páginas html e imágenes. Construya un sitio web con javascript para probar su servidor. Despliegue su solución en Heroku. NO use frameworks web como Spark o Spring use solo Java y las librerías para manejo de la red.

# Creacion del proyecto 

> mvn archetype:generate -DgroupId=edu.escuelaing.edu.AREP -DartifactId=LAB4 -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

## Prerrequisitos

Java

Es una plataforma necesaria para que Maven ejecute, desde la linea de comandos comprobamos que se encuentre instalado por medio del comando:

> java -version

- java version "1.8.0_101"
- Java(TM) SE Runtime Environment (build 1.8.0_101-b13)
- Java HotSpot(TM) Client VM (build 25.101-b13, mixed mode)

Maven
- La estructura está estandalizada con Maven, desde la linea de comandos comprobamos que se encuentre instalado por medio del comando:

> mvn -v

# Git version

>git --version
>git version 2.21.0.windows.1

# Heroku
La página web se encuentra invocada en la nube usando Heroku, para comprobar que se tengan los requisitos localmente:

> heroku -v

#Instalacion

1. Clone el repositorio: 

>git clone https://github.com/sf-burgos/Lab4_AREP.git

2. Compile el proyecto 

>mvn package



