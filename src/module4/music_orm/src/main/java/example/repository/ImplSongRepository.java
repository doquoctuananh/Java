package example.repository;

import example.model.Song;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class ImplSongRepository implements ISongRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Song> findAll() {
        String jpql = "select s from Song s";
        TypedQuery<Song> query = em.createQuery(jpql, Song.class);
        return query.getResultList();
    }

    @Override
    public void update(Song song) {
//        song.setId(id);
        em.merge(song);
    }

    @Override
    public void delete(int id) {
        em.remove(em.find(Song.class, id));
    }

    @Override
    public void save(Song song) {
        em.persist(song);
    }

    @Override
    public Song findById(int id) {
        return em.find(Song.class, id);
    }
}
