package example.service.province;

import example.model.CustomerDTOView;
import example.model.Province;
import example.repository.province.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ImplProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(long id) {
        return provinceRepository.findById(id).get();
    }

    @Override
    public void save(Province entity) {
        provinceRepository.save(entity);
    }

    @Override
    public void delete(long id) {
        provinceRepository.deleteById(id);
    }

    @Override
    public void update(Province entity) {

    }

    @Override
    public CustomerDTOView viewCustomer(long id) {
        return null;
    }

    @Override
    public long countCustomer(long idProvince) {
        return provinceRepository.countCustomer(idProvince);
    }
}
