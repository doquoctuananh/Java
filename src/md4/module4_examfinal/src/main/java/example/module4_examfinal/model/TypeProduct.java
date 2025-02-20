package example.module4_examfinal.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "type_product")
public class TypeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(unique = true, nullable = false)
    public String name;

    @OneToMany(mappedBy = "typeProduct")
    private List<Product> products;

    public TypeProduct() {
    }

    public TypeProduct(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeProduct(Long id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public TypeProduct(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
