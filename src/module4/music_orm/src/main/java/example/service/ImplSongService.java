package example.service;

import example.model.Song;
import example.repository.ISongRepository;
import example.repository.ImplSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ImplSongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findALl() {
        return songRepository.findAll();
    }

    @Override
    public void update(Song song) {
        songRepository.update(song);
    }

    @Override
    public void delete(int id) {
        songRepository.delete(id);
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.findById(id);
    }
}
