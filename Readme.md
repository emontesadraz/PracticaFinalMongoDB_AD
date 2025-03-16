# EXPLICACIÓN TAREA 5 MONGO DB

*Esteban Montes* - *2 DAM*

---

### **ENUNCIADO DEL PROYECTO**

Escribe un programa (mongoService) que expoña 5 endpoints para cada repositorio:

- /crear:
  Creará un documento en MongoDB (aceptará un body formato JSON)

- /borrar/{id}
  Borrará o documento {id} en MongoDB

- /actualizar/{id}
  Actualizará o documento {id} en MongoDB (aceptará un body formato JSON)

- /listar
  Lista os documentos gardados en MongoDB

- /listar/{id}
  Lista o documento {id} en MongoDB

---

## **CÓMO EMPIEZO**

### 1. ***DEPENDENCIAS***

Vamos a empezar instalando las dependencias necesarias para el proyecto.

- *SPRING WEB:* Spring Web es un framework de Java que se utiliza para crear aplicaciones web. Proporciona una
  infraestructura completa de soporte para el desarrollo de aplicaciones web.


- *SPRING DATA MONGODB:* Permite interactuar con bases de datos MongoDB, almacenando datos en documentos JSON flexibles.


- *CONFIG CLIENT:* Spring Cloud Config Client es una biblioteca que se utiliza para acceder a la configuración
  almacenada en un servidor de configuración remoto.

### 2. ***CONFIGURACIÓN DEL PROYECTO***

Crearemos los siguientes paquetes para organizar nuestro código:

- *Controller:* Define las endpoints de la API REST y maneja las peticiones HTTP.

- *Service:* Contiene la lógica de negocio y la comunicación con el repositorio.

- *Repository:* Contiene las interfaces encargadas de interactuar con la base de datos.

- *Model:* Contiene las clases que representan las entidades del sistema, es decir, los objetos que se almacenarán en la
  base de datos.

- *Configuration:* Contiene configuraciones adicionales como CORS, seguridad, Swagger, etc.

- *Exception(Opcional):* Contiene las clases que manejan las excepciones personalizadas.

### 3. ***DESGLOSE DEL PROYECTO***

1. **Paquete Config**
    - *MongoConfig:* Clase de configuración de MongoDB. Se encarga de establecer la conexión con la base de datos.
        [Enlace al código de MongoConfig](/Users/estebanmontes/Desktop/2 DAM/AD/SegundoTrimestre/RepasoMongo/RepasoTarea5/src/main/java/org/example/repasotarea5/config/MongoConfig.java)
   
    - *SwaggerConfig:* Clase de configuración de Swagger. Se encarga de configurar la documentación de la API REST.
        [Enlace al código de SwaggerConfig](/Users/estebanmontes/Desktop/2 DAM/AD/SegundoTrimestre/RepasoMongo/RepasoTarea5/src/main/java/org/example/repasotarea5/config/SwaggerConfig.java)

**Cosas a tener en cuenta:**

```@Configuration```: Esta anotación indica que esta clase es una clase de configuración de Spring.

```@Value```: Esta anotación se utiliza para inyectar valores en campos, métodos o constructores.

```@Bean```: Esta anotación se utiliza para indicar que un método de un objeto de configuración debe ser tratado como un
método de inicialización de bean.

2. **Paquete Controller**
    - *MongoController:* Clase que define los endpoints de la API REST y maneja las peticiones HTTP.
        [Enlace al código de MongoController](/Users/estebanmontes/Desktop/2 DAM/AD/SegundoTrimestre/RepasoMongo/RepasoTarea5/src/main/java/org/example/repasotarea5/controller/MongoAlbumRestController.java)
   
    - *SwaggerController:* Clase que define los endpoints de la API REST y maneja las peticiones HTTP.
        [Enlace al código de SwaggerController](/Users/estebanmontes/Desktop/2 DAM/AD/SegundoTrimestre/RepasoMongo/RepasoTarea5/src/main/java/org/example/repasotarea5/controller/MongoGrupoRestController.java)
**Cosas a tener en cuenta:**

```@RestController```: Esta anotación se utiliza para definir un controlador REST en Spring.

```@RequestMapping```: Esta anotación se utiliza para asignar una URL a un controlador o método específico.

```@Autowired```: Esta anotación se utiliza para inyectar dependencias en un bean de Spring.

```@PathVariable```: Esta anotación se utiliza para mapear variables de la URL a parámetros de método en un controlador.

```@RequestBody```: Esta anotación se utiliza para mapear el cuerpo de la solicitud HTTP a un objeto Java.

```@GetMapping```: Esta anotación se utiliza para mapear solicitudes HTTP GET a métodos de controlador específicos.

```@PostMapping```: Esta anotación se utiliza para mapear solicitudes HTTP POST a métodos de controlador específicos.

```@PutMapping```: Esta anotación se utiliza para mapear solicitudes HTTP PUT a métodos de controlador específicos.

```@DeleteMapping```: Esta anotación se utiliza para mapear solicitudes HTTP DELETE a métodos de controlador específicos.

3. **Paquete Model**
    1. **Paquete entity**
       - *Album:* Representa un álbum musical con los atributos id, título, artista y año de lanzamiento.
           [Enlace al código de Album](/Users/estebanmontes/Desktop/2 DAM/AD/SegundoTrimestre/RepasoMongo/RepasoTarea5/src/main/java/org/example/repasotarea5/model/entity/Album.java)
   
       - *Grupo:* Representa un grupo musical con los atributos id, nombre, xenero y dataFormacion
           [Enlace al código de Grupo](/Users/estebanmontes/Desktop/2 DAM/AD/SegundoTrimestre/RepasoMongo/RepasoTarea5/src/main/java/org/example/repasotarea5/model/entity/Grupo.java)
    2. **Paquete dto**
       - *AlbumDTO:* Representa un álbum musical con los atributos título, artista y año de lanzamiento.
           [Enlace al código de AlbumDTO](/Users/estebanmontes/Desktop/2 DAM/AD/SegundoTrimestre/RepasoMongo/RepasoTarea5/src/main/java/org/example/repasotarea5/model/dto/AlbumDTO.java)
   
       - *GrupoDTO:* Representa un grupo musical con los atributos nombre, xenero y dataFormacion.
           [Enlace al código de GrupoDTO](/Users/estebanmontes/Desktop/2 DAM/AD/SegundoTrimestre/RepasoMongo/RepasoTarea5/src/main/java/org/example/repasotarea5/model/dto/GrupoDTO.java)

    ### **PARA QUE SIRVE DTO?**
    DTO (Data Transfer Object) sirve para la transferencia de datos sin exponer directamente la entidad de la base de datos.
    También sirve para transformar datos antes de enviarlos, por ejemplo, cambiar formatos de fecha o agregar campos calculados.

**Cosas a tener en cuenta:**

```@Document(collection = "campo")```: Esta anotación se utiliza para indicar que una clase es un documento de MongoDB.

```@Id```: Esta anotación se utiliza para marcar un campo como identificador de un documento.

```@JsonProperty("campo")```: Esta anotación se utiliza para asignar un nombre de campo personalizado en JSON.

```@JsonFormat(pattern = "yyyy-MM-dd")```: Esta anotación se utiliza para formatear la fecha en JSON.

4. **Paquete Repository**
    - *AlbumRepository:* Interfaz que extiende de MongoRepository para interactuar con la colección de álbumes.
        [Enlace al código de AlbumRepository](/Users/estebanmontes/Desktop/2 DAM/AD/SegundoTrimestre/RepasoMongo/RepasoTarea5/src/main/java/org/example/repasotarea5/repository/AlbumRepository.java)
   
    - *GrupoRepository:* Interfaz que extiende de MongoRepository para interactuar con la colección de grupos.
        [Enlace al código de GrupoRepository](/Users/estebanmontes/Desktop/2 DAM/AD/SegundoTrimestre/RepasoMongo/RepasoTarea5/src/main/java/org/example/repasotarea5/repository/GrupoRepository.java)


5. **Paquete Service**
    - *MongoAlbumService:* Clase que contiene la lógica para la gestión de álbumes.
        [Enlace al código de MongoAlbumService](/Users/estebanmontes/Desktop/2 DAM/AD/SegundoTrimestre/RepasoMongo/RepasoTarea5/src/main/java/org/example/repasotarea5/service/MongoAlbumService.java)
   
    - *MongoGrupoService:* Clase que contiene la lógica de negocio para la gestión de grupos.
        [Enlace al código de MongoGrupoService](/Users/estebanmontes/Desktop/2 DAM/AD/SegundoTrimestre/RepasoMongo/RepasoTarea5/src/main/java/org/example/repasotarea5/service/MongoGrupoService.java)