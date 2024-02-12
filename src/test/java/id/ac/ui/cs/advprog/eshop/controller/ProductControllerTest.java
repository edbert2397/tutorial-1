package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @Test
    void testCreateProductPage() {
        String viewName = productController.createProductPage(model);
        assertEquals("createProduct", viewName);
        verify(model).addAttribute(eq("product"), any(Product.class));
    }

    @Test
    void testCreateProductPost() {
        Product product = new Product();
        String redirectViewName = productController.createProductPost(product, model);
        assertEquals("redirect:list", redirectViewName);
        verify(productService).create(product);
    }

    @Test
    void testProductListPage() {
        List<Product> products = new ArrayList<>();
        when(productService.findAll()).thenReturn(products);

        String viewName = productController.productListPage(model);
        assertEquals("productList", viewName);
        verify(model).addAttribute("products", products);
    }

    @Test
    void testDeleteProduct() {
        String productId = "someProductId";
        Product product = new Product();
        when(productService.get(productId)).thenReturn(product);

        String redirectViewName = productController.deletePost(productId);
        assertEquals("redirect:/product/list", redirectViewName);
        verify(productService).delete(product);
    }

    @Test
    void testEditProductPage() {
        String productId = "someProductId";
        Product product = new Product();
        when(productService.get(productId)).thenReturn(product);

        String viewName = productController.editProductPage(productId, model);
        assertEquals("editProduct", viewName);
        verify(model).addAttribute("product", product);
    }

    @Test
    void testEditProductPost() {
        String productId = "someProductId";
        Product updatedProduct = new Product();
        Product existingProduct = new Product();

        when(productService.get(productId)).thenReturn(existingProduct);

        String redirectViewName = productController.editProductPost(productId, updatedProduct);
        assertEquals("redirect:/product/list", redirectViewName);
        verify(productService).edit(existingProduct);
    }
}
