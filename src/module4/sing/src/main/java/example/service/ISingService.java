package example.service;

import example.model.Sing;

import java.util.List;

public interface  ISingService {
    List<Sing> findAll();
    void create(Sing sing);
}
