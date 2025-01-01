package example.service;

import example.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findALl();

    void update(Song song);
    void delete(int id);
    void save(Song song);
    Song findById(int id);
}
