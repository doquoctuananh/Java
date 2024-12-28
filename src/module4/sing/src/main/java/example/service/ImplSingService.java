package example.service;

import example.model.Sing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ImplSingService implements ISingService {
    private List<Sing> singList= new ArrayList<>();
    @Override
    public List<Sing> findAll() {
        return singList;
    }

    @Override
    public void create(Sing sing) {
        singList.add(sing);
    }
}
