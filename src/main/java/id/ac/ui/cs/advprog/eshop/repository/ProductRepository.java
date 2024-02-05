package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        product.setProductId(String.valueOf(UUID.randomUUID()));
        productData.add(product);
        return product;
    }

    public boolean delete(Product product) {
        return productData.remove(product);
    }

    public Product edit(Product product) {
        for (int i = 0; i < productData.size(); i++) {
            Product existingProduct = productData.get(i);
            if (existingProduct.getProductId().equals(product.getProductId())) {
                productData.set(i, product); // Update the product in the list
                return product;
            }
        }
        return null; // Return null if the product with the specified ID is not found
    }


    public Iterator<Product> findAll() {
        return productData.iterator();
    }
}