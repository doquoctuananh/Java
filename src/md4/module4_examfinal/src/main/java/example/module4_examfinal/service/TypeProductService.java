package example.module4_examfinal.service;

import example.module4_examfinal.model.TypeProduct;
import example.module4_examfinal.repository.ITypeProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService implements ITypeProductService {
    @Autowired
    private ITypeProductRepository typeProductRepository;
    @Override
    public List<TypeProduct> findAllTypeProducts() {
        return typeProductRepository.findAll();
    }
}
