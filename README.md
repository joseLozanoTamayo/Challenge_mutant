# Challenge_mutant

API REST para el prueba técnica de MercadoLibre.  

Consta de un endpoint que recibe un arreglo de strings (correspondientes a una cadena de ADN) y se analiza si se trata de un mutante o un humano.  
Ademas, se implementa un endpoint para obtener las estadísticas de los casos analizados.

## Tecnologías utilizadas
Se utilizó [Java](https://www.java.com/es/) como lenguaje de programación, [JUnit](https://junit.org/junit4/) como framework de test y [Spring Boot](https://spring.io/projects/spring-boot) como framework de desarrollo.  
La base de datos es [MongoDB](https://www.mongodb.com/) ya que es la brindada a traves de una VPS. Se utilizó [Docker](https://www.docker.com/) para brindar dicha base de datos en el entorno local.  
IDE de desarrolo intellij IDEA Communiti

## Ejecutar la app de forma local
### Requisitos:
* Java 8
* Docker 
* Mongo está habilitado en una ip publica el cual se puede usar local como un ambiente en la nube.
* [Postman](https://www.getpostman.com/) o similar para realizar las request (en los ejemplos se utiliza [Curl](https://curl.haxx.se/))
* IDE de desarrolo