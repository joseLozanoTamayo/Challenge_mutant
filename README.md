# Challenge_mutant
![](https://github.com/joseLozanoTamayo/Challenge_mutant/workflows/Java%20CI/badge.svg)
API REST para el prueba técnica de MercadoLibre.  

Consta de un endpoint que recibe un arreglo de strings (correspondientes a una cadena de ADN) y se analiza si se trata de un mutante o un humano.  
Ademas, se implementa un endpoint para obtener las estadísticas de los casos analizados.

## Tecnologías utilizadas
Se utilizó [Java](https://www.java.com/es/) como lenguaje de programación, [JUnit](https://junit.org/junit4/) como framework de test y [Spring Boot](https://spring.io/projects/spring-boot) como framework de desarrollo.  
La base de datos es [MongoDB](https://www.mongodb.com/) ya que es la brindada a traves de una VPS. Se utilizó [Docker](https://www.docker.com/).  
IDE de desarrolo intellij IDEA Community

## Ejecutar la app de forma local
### Requisitos:
* Java 8
* Docker 
* Mongo está habilitado en una ip publica el cual se puede usar local como un ambiente en la nube.
* [Postman](https://www.getpostman.com/) o similar para realizar las request (en los ejemplos se utiliza [Curl](https://curl.haxx.se/))
* IDE de desarrolo intellij IDEA

### Pasos a seguir
1. Se necesitan Clonar el proyecto e importar las dependencias de gradle en el ide de intellij y luego ejecutar el proyecto por medio de la opcion de bootrun de la seccion de gradle parte superior derecha. El puerto por defecto para la aplicación es el 80.
2. No se debe tener encuenta ninguna variable de entorno. la comunicacion con la base de datos de mongo la realiza a traves de una ip publica hacia una vps.
3. Ejectuar el siguiente comando desde la raíz del repositorio para iniciar la app `./gradlew run`
4. Por defecto, Spring Boot utiliza el puerto 80 quedando como URL: http://localhost

## Entorno de producción AWS
URL: 
GET  : http://ec2-54-224-48-160.compute-1.amazonaws.com/stats
POST : http://ec2-54-224-48-160.compute-1.amazonaws.com/mutant

## Enpoints disponibles
### POST -> /mutant/
#### Ejemplo request
```shell script
curl --header "Content-Type: application/json" \
     --request POST \
     --data '{"dna":["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]}' \
     http://localhost/mutant/
```
#### Posibles response
1. Status code 200 (OK) en caso de ser un mutante
2. Status code 403 (Forbidden (Prohibido)) en caso de ser un humano

### GET -> /stats
#### Ejemplo request
```shell script
curl http://localhost/stats
```
#### Ejemplo response
```json
{
  "count_mutant_dna": 40,
  "count_human_dna": 100,
  "ratio": 0.4
}
```

## Contacto
[jose.lozano.tamayo@gmail.com](mailto:mailto:jose.lozano.tamayo@gmail.com)
