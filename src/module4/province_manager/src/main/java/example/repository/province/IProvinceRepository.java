package example.repository.province;

import example.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IProvinceRepository extends JpaRepository<Province, Long> {
    @Query("select count(*) from Customer as c " +
            "where c.province.id=?1")
    long countCustomer(long idProvince);
}
