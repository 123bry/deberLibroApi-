# Web API de Libro con control de excepciones y mejor descripción de API

## Si no existe el libro, lanzar un expcetion LibroException (GET /libros/{id_libro}). Enviar el estado NOT_FOUND con un mensaje personalizado

### GeneralExceptionHandler.java
- Este archivo crea un manejador de excepciones para la excepción de libro.
- Este manejador devuelve una respuesta con el estado NOT_FOUND y un mensaje personalizado cuando se lanza una excepción de tipo LibroException.

![image](https://github.com/123bry/deberLibroApi-/assets/99741524/82358ee3-a17a-4a10-a413-2472c7c4b0c2)

### LibroException.java
- Esta clase define una excepción única llamada LibroException, que se extiende a la excepción de ejecución.
- Se usa para ilustrar situaciones en las que un libro no se encuentra.

![image](https://github.com/123bry/deberLibroApi-/assets/99741524/f72dbe65-c532-4174-9a56-e843af3c6a7a)

## Cuando se crea un libro, enviar el estado de CREATE

### LibroController.java
- Las solicitudes GET para recuperar un libro por su ID son gestionadas por el método getLibroporId(). Si el libro no se encuentra (es decir, si optionalLibro está vacío), se lanza una excepción de tipo LibroException, que se define en el archivo LibroException.java.
- El método addLibro() gestiona las solicitudes POST para agregar un nuevo libro. Devuelve una respuesta con el estado CREATED después de agregar el libro.

El método addLibro() recibe un objeto Libro como parámetro a través de la anotación @RequestBody. Este objeto muestra el libro que se desea incluir. Después de recibir este libro, el servicio LibroService llama al método addLibro(libro) para agregar el libro a la base de datos (o al repositorio en este caso).
El controlador devuelve una respuesta Entity Response con el estado CREATED una vez que el libro se ha agregado correctamente. Esto se logra mediante el uso de return new ResponseEntity<>(HttpStatus.CREATED);.

![image](https://github.com/123bry/deberLibroApi-/assets/99741524/3d8e1369-cbee-4ac0-88d0-7ff4bf0aaf2b) 

## Pruebas realizadas en Postman

Para realizar las pruebas trabajamos en el puerto 8176

- http://localhost:8766/libro
Como nos podemos dar cuenta solo tenemos 3 libros con los Id: 1,2 y 3.

![image](https://github.com/123bry/deberLibroApi-/assets/99741524/4c0c1785-c3ff-4ac5-ab67-ed14e8bffb9d)


1. Ejemplo
Buscamos un libro con el Id 1

![image](https://github.com/123bry/deberLibroApi-/assets/99741524/0249db7d-34f7-4490-99d9-27c0443787ad)


2. Ejemplo  Buscamos un libro con el Id 4.
Muestra el mensaje personalizado y el estado.

![image](https://github.com/123bry/deberLibroApi-/assets/99741524/6cd9d0c9-7105-487d-b795-9d9e3b214240) 

3. Ejemplo  Buscamos un libro con el Id 15.
Muestra el mensaje personalizado y el estado.

![image](https://github.com/123bry/deberLibroApi-/assets/99741524/45ae5b03-0feb-4241-bcaf-a4d158201176)





