package org.example.repasotarea5.service;

import org.example.repasotarea5.exceptions.IdException;
import org.example.repasotarea5.model.entity.Grupo;
import org.example.repasotarea5.repository.GrupoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoGrupoService {

    public final GrupoRepository grupoRepository;


    public MongoGrupoService(GrupoRepository grupoRepository) {
        this.grupoRepository = grupoRepository;
    }

    /**
     * Metodo que crea un grupoDTO en la base de datos
     * @param grupo
     */
    public void crearGrupo(Grupo grupo) {
        grupoRepository.save(grupo);
    }

    /**
     * Metodo que devuelve todos los grupos de la base de datos
     * @return la lista de grupos
     */
    public List<Grupo> getListGrupo(){
        return grupoRepository.findAll();
    }

    /**
     * Metodo que devuelve un grupo por su id
     * @param id el id del grupo a buscar
     * @return el grupo o nada
     */
    public Grupo getListGrupoById(String id){
        return grupoRepository.findByid(id);
    }

    /**
     * Metodo que elimina un grupo por su id
     * @param id
     */
    public void deleteByIdService(String id){
        Grupo grupo = grupoRepository.findByid(id);
        if (grupo == null){
            throw new IdException("No se ha encontrado el grupo con el id: " + id);
        }
        grupoRepository.deleteById(id);
    }

    /**
     * Metodo para actualizar un grupo por su id
     * @param id el ID del grupo
     * @param grupo el grupo con los datos actualizados
     */
    public void updateByIdService(String id, Grupo grupo){
        Grupo nuevoGrupo = grupoRepository.findByid(id);
        if(grupo == null){
            throw new IdException("Este id no existe para actualizar un grupo");
        }
        grupo.setNome(nuevoGrupo.getNome());
        grupo.setXenero(nuevoGrupo.getXenero());
        grupo.setDataFormacion(nuevoGrupo.getDataFormacion());
        grupoRepository.save(grupo);
    }
}
