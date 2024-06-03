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

### libroController.java
- Las solicitudes GET para recuperar un libro por su ID son gestionadas por el método getLibroporId(). Si el libro no se encuentra (es decir, si optionalLibro está vacío), se lanza una excepción de tipo LibroException, que se define en el archivo LibroException.java.
- El método addLibro() gestiona las solicitudes POST para agregar un nuevo libro. Devuelve una respuesta con el estado CREATED después de agregar el libro.

![image](https://github.com/123bry/deberLibroApi-/assets/99741524/3d8e1369-cbee-4ac0-88d0-7ff4bf0aaf2b)

