package org.example.repasotarea5.controller;

import org.example.repasotarea5.model.Grupo;
import org.example.repasotarea5.service.MongoGrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grupo")
public class MongoGrupoRestController {

    public final MongoGrupoService mongoGrupoService;

    public MongoGrupoRestController(MongoGrupoService mongoGrupoService) {
        this.mongoGrupoService = mongoGrupoService;
    }

    /**
     * Metodo para crear un nuevo documento de tipo "Grupo" en MongoDB.
     * @param grupo El objeto de tipo Grupo que contiene los datos del grupo a crear.
     * @return ResponseEntity con el estado de la operación y un mensaje correspondiente.
     */
    @PostMapping("/crear")
    public ResponseEntity<String> crearDocumentoMongo(@RequestBody Grupo grupo) {
        try{
            mongoGrupoService.crearGrupo(grupo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Documento creado correctamente");
    }

    /**
     * Metodo para listar todos los grupos almacenados en MongoDB.
     * @param id El identificador único del grupo que se desea listar.
     * @return ResponseEntity con la lista de grupos o un error en caso de fallo.
     */
    @GetMapping("/listar/{id}")
    public ResponseEntity<Grupo> listarGrupoMongo(@PathVariable String id){
        try{
            Grupo grupo = mongoGrupoService.getListGrupoById(id);
            if(grupo == null){
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.ok().body(grupo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(null);
        }
    }

    /**
     * Metodo para eliminar un grupo de la base de datos por su ID.
     * @param id El identificador único del grupo que se desea eliminar.
     * @return ResponseEntity con el estado de la operación y un mensaje correspondiente.
     */
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarGrupoMongo(@PathVariable String id){
        try{
            mongoGrupoService.deleteByIdService(id);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Documento eliminado correctamente");
    }

    /**
     * Metodo para actualizar un grupo de la base de datos por su ID.
     * @param id El identificador único del grupo que se desea actualizar.
     * @param grupo El objeto de tipo Grupo que contiene los datos del grupo a actualizar.
     * @return ResponseEntity con el estado de la operación y un mensaje correspondiente.
     */
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<String> actualizarGrupoMongo(@PathVariable String id, @RequestBody Grupo grupo){
        try{
            mongoGrupoService.updateByIdService(id, grupo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Documento actualizado correctamente");
    }
}
