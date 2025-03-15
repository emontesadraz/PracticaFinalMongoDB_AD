package org.example.repasotarea5.controller;

import org.example.repasotarea5.model.Album;
import org.example.repasotarea5.service.MongoAlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Esta anotación se utiliza para indicar que esta clase es un controlador de Spring
@RequestMapping ("/album") // Esta anotación se utiliza para mapear solicitudes web a métodos de controlador y se aplica a la clase de controlador
public class MongoAlbumRestController {

    private final MongoAlbumService mongoAlbumService; // Se declara una variable de tipo MongoAlbumService llamada mongoAlbumService

    public MongoAlbumRestController(MongoAlbumService mongoAlbumService) { // Constructor de la clase MongoAlbumRestController
        this.mongoAlbumService = mongoAlbumService; // Se asigna el valor de mongoAlbumService al atributo de la clase
    }

    /**
     * Metodo post para crear el album
     * @param album el abum dto
     * @return un mensaje indicando si se creo o no el album
     */
    @PostMapping("/crear") // Esta anotación se utiliza para mapear solicitudes HTTP POST a métodos de controlador y se aplica a un método de controlador
    public ResponseEntity<String> crearAlbumController(@RequestBody Album album) { // Método que recibe un objeto de tipo Album y devuelve un objeto de tipo ResponseEntity<String>
        try{ // Inicio del bloque try
            mongoAlbumService.crearAlbum(album); // Se llama al método crearAlbum de la clase MongoAlbumService
        }catch (Exception e){ // Inicio del bloque catch
            return ResponseEntity.badRequest().body(e.getMessage()); // Se devuelve un objeto de tipo ResponseEntity con un mensaje de error
        } // Fin del bloque catch
        return ResponseEntity.ok().body("Album creado correctamente"); // Se devuelve un objeto de tipo ResponseEntity con un mensaje de éxito
    }

}
