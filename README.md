# Web API de Libro con control de excepciones y mejor descripción de API

## Si no existe el libro, lanzar un expcetion LibroException (GET /libros/{id_libro}). Enviar el estado NOT_FOUND con un mensaje personalizado

### libroController.java
- Este archivo contiene la definición de un controlador Spring MVC para administrar solicitudes de libros relacionadas.
- Las solicitudes GET para recuperar un libro por su ID son gestionadas por el método getLibroporId(). Si el libro no se encuentra (es decir, si optionalLibro está vacío), se lanza una excepción de tipo LibroException, que se define en el archivo LibroException.java.
- El método addLibro() gestiona las solicitudes POST para agregar un nuevo libro. Devuelve una respuesta con el estado CREATED después de agregar el libro.
![image](https://github.com/123bry/deberLibroApi-/assets/99741524/3d8e1369-cbee-4ac0-88d0-7ff4bf0aaf2b)
