package example.repository;

import example.model.Song;

import java.util.List;

public  interface ISongRepository {
    List<Song> findAll();
    void update(Song song);
    void delete(int id);
    void save(Song song);
    Song findById(int id);
}
