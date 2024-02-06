package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);

        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }
    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de45-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());

        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());

        assertFalse(productIterator.hasNext());
    }
    @Test
    void testCreateAndEditProduct() {
        // Create and add a product to the repository
        Product originalProduct = new Product();
        originalProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        originalProduct.setProductName("Original Name");
        originalProduct.setProductQuantity(10);
        productRepository.create(originalProduct);

        // Update product details
        Product updatedProduct = new Product();
        updatedProduct.setProductId(originalProduct.getProductId()); // same ID as original
        updatedProduct.setProductName("Updated Name");
        updatedProduct.setProductQuantity(20);

        // Edit the product in the repository
        Product result = productRepository.edit(updatedProduct);

        assertEquals(updatedProduct.getProductName(), result.getProductName());
        assertEquals(updatedProduct.getProductQuantity(), result.getProductQuantity());
    }

    @Test
    void testCreateAndDeleteProduct() {
        Iterator<Product> iterator = productRepository.findAll();

        Product newProduct = new Product();

        newProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        newProduct.setProductName("Sampo Cap Bambang");
        newProduct.setProductQuantity(100);
        productRepository.create(newProduct);

        assertTrue(iterator.hasNext());
        productRepository.delete(newProduct);
        assertFalse(iterator.hasNext());
    }
    @Test
    void testCreateEditAndDeleteProduct() {
        Iterator<Product> iterator = productRepository.findAll();
        // Create and add a product to the repository
        Product originalProduct = new Product();
        originalProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        originalProduct.setProductName("Original Name");
        originalProduct.setProductQuantity(10);
        productRepository.create(originalProduct);

        // Update product details
        Product updatedProduct = new Product();
        updatedProduct.setProductId(originalProduct.getProductId()); // same ID as original
        updatedProduct.setProductName("Updated Name");
        updatedProduct.setProductQuantity(20);

        // Edit the product in the repository
        Product result = productRepository.edit(updatedProduct);

        assertEquals(updatedProduct.getProductName(), result.getProductName());
        assertEquals(updatedProduct.getProductQuantity(), result.getProductQuantity());

        productRepository.delete(updatedProduct);
        assertFalse(iterator.hasNext());
    }

    @Test
    void testEditIfNotFound() {

        Product existingProduct = new Product();
        productRepository.create(existingProduct);
        existingProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        existingProduct.setProductName("Sampo Cap Bambang");
        existingProduct.setProductQuantity(100);

        Product modifiedProduct = new Product();
        modifiedProduct.setProductId("123");
        modifiedProduct.setProductName("Sampo Cap Bango");
        modifiedProduct.setProductQuantity(120);

        productRepository.edit(modifiedProduct);

        assertNotEquals(120, existingProduct.getProductQuantity());
        assertNotEquals("Sampo Cap Bango", existingProduct.getProductName());
    }

    @Test
    void testDeleteIfNotFound(){
        Iterator<Product> productIterator = productRepository.findAll();

        Product product1 = new Product();
        productRepository.create(product1);
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        Product newProduct = new Product();
        newProduct.setProductId("123");

        boolean deleteResult = productRepository.delete(newProduct);
        assertFalse(deleteResult);
        assertTrue(productIterator.hasNext());

    }


}
