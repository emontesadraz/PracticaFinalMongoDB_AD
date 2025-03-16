package org.example.repasotarea5.service;

import org.example.repasotarea5.exceptions.IdException;
import org.example.repasotarea5.model.dto.GrupoDTO;
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
     * @param grupoDTO
     */
    public void crearGrupo(GrupoDTO grupoDTO) {
        Grupo grupo = new Grupo(grupoDTO.getId(), grupoDTO.getNome(),
                grupoDTO.getXenero(), grupoDTO.getDataFormacion());
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
     * @param id el id del grupo
     * @param grupoDTO el grupo con los datos actualizados
     */
    public void updateByIdService(String id, GrupoDTO grupoDTO){
        Grupo grupo = grupoRepository.findByid(id);
        if(grupo == null){
            throw new IdException("Este id no existe para actualizar un grupo");
        }
        grupo.setNome(grupoDTO.getNome());
        grupo.setXenero(grupoDTO.getXenero());
        grupo.setDataFormacion(grupoDTO.getDataFormacion());
        grupoRepository.save(grupo);
    }
}
