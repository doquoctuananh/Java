package example.service;

import example.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ImplProductService implements IProductService {
    private static List<Product> products;
    static {
        products = new ArrayList<>();
        products.add(new Product(1,"Ford",50000000,10));
        products.add(new Product(2,"Ford2",60000000,9));
        products.add(new Product(3,"Ford3",750000000,11));
        products.add(new Product(4,"Ford4",850000000,12));
    }

    @Override
    public Product findProduct(int id) {
        Product product = null;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                product= products.get(i);
                break;
            }
        }
        return product;
    }

    @Override
    public List<Product> showALlProduct() {
        return products;
    }

    @Override
    public void createProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == product.getId()) {
                products.set(i, product);
                break;
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                break;
            }
        }
    }

    @Override
    public List<Product> searchProduct(String name) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if(product.getName().toLowerCase().contains(name.trim().toLowerCase())){
                productList.add(product);
            }
        }
        return productList;
    }
}
