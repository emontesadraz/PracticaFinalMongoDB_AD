package org.example.repasotarea5.service;

import org.example.repasotarea5.exceptions.IdException;
import org.example.repasotarea5.model.entity.Album;
import org.example.repasotarea5.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Esta anotación se utiliza para indicar que esta clase es un servicio de Spring
@Service
public class MongoAlbumService {


    private final AlbumRepository albumRepository;

    public MongoAlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public void crearAlbum(Album album) {
        albumRepository.save(album);
    }

    public List<Album> getListAlbum() {
        return albumRepository.findAll();
    }

    public Album getListAlbumById(String id) {
        if (albumRepository.findByid(id) == null) {
            throw new IdException("Este id no existe para buscar un álbum");
        }
        return albumRepository.findByid(id);
    }

    public void deleteByIdService(String id) {
        Album album = albumRepository.findByid(id);
        if (album == null) {
            throw new IdException("Este id no existe para borrar un álbum");
        }
        albumRepository.deleteById(id);
    }

    public void updateByIdService(String id, Album album) {
        Album albumExistente = albumRepository.findByid(id);
        if (albumExistente == null) {
            throw new IdException("Este id no existe para actualizar un álbum");
        }
        albumExistente.setTitulo(album.getTitulo());
        albumExistente.setData_lanzamento(album.getData_lanzamento());
        albumExistente.setPuntuacion(album.getPuntuacion());
        albumRepository.save(albumExistente);
    }
}
