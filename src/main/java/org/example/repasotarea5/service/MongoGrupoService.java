package org.example.repasotarea5.service;

import org.example.repasotarea5.exceptions.IdException;
import org.example.repasotarea5.model.Grupo;
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
     * Metodo que crea un grupo en la base de datos
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
     * Metodo que actualiza un grupo por su id
     * @param id
     * @param grupo
     */
    public void updateByIdService(String id, Grupo grupo){
        Grupo grupoExistente = grupoRepository.findByid(id);
        if (grupoExistente == null){
            throw new IdException("No se ha encontrado el grupo con el id: " + id);
        }
        grupoExistente.setNome(grupo.getNome());
        grupoExistente.setXenero(grupo.getXenero());
        grupoExistente.setDataFormacion(grupo.getDataFormacion());
        grupoRepository.save(grupo);
    }
}
