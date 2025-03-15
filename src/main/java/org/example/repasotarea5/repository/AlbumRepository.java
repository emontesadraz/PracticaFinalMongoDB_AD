package org.example.repasotarea5.repository;

import org.example.repasotarea5.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Esta anotación se utiliza para indicar que esta clase es un repositorio de Spring
public interface AlbumRepository extends MongoRepository<Album, String> {

    //busqueda de album por id
    Album findByid(String id);
}
