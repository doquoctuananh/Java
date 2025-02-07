package example.model;

import jakarta.persistence.Entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }
    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    // kiem tra san pham trong gio hang
    public boolean checkItemCart(Product product) {
        for(Map.Entry<Product,Integer> entry : products.entrySet()) {
            if(entry.getKey().getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    // chon san pham trong gio hang
    public Map.Entry<Product,Integer> selectInCart(Product product) {
        for(Map.Entry<Product,Integer> entry: products.entrySet()){
            if(entry.getKey().getId() == product.getId()) {
                return  entry;
            }
        }
        return null;
    }

    // them san pham

    public void addCart(Product product) {
        if(!checkItemCart(product)) {
            products.put(product,1);
        }
        else{
            Map.Entry<Product,Integer> replaceProduct  = selectInCart(product);
            int newquantity = replaceProduct.getValue()+1;
            products.replace(replaceProduct.getKey(),newquantity);
        }
    }

    //dem san pham trong gio hang
    public int countProductCart() {
        return products.size();
    }

    // dem tong so san pham
    public int countTotalProductsCart() {
        int total = 0;
        for(Map.Entry<Product,Integer> entry : products.entrySet()) {
            total += entry.getValue();
        }
        return total;
    }

    //tong so tien

    public long countTotalPaymentsCart() {
        long totalMoney =0;
        for(Map.Entry<Product,Integer> entry : products.entrySet()) {
            totalMoney += entry.getValue() * entry.getKey().getPrice();
        }
        return totalMoney;
    }

}
