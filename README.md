# news-bff

##Proyecto Microservicio con Spring Boot y H2 para postulación a Sodexo.
Pre-requisitos:

```sh
Java 11: https://jdk.java.net/archive/
Maven: https://maven.apache.org/
```

1.- Descargar/Clonar este proyecto.

2.- Compilar proyecto:

```sh
mvn clean package
```

Ya compilado y empaquetado el proyecto, procedemos a levantar el servicio
3.- Levantar Servicio:

```sh
mvn spring-boot:run
```

El microservicio quedará expuesto en el puerto 8080 del localhost.

Para mayor información de los endpoints, revise el archivo api-docs.json o en:

```sh
http://localhost:8080/swagger-ui/
```
