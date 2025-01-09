package example.service.province;

import example.model.Province;
import example.service.IGeneration;

public interface IProvinceService extends IGeneration<Province> {
    long countCustomer(long idProvince);
}
