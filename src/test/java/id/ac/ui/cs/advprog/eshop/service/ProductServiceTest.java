    package id.ac.ui.cs.advprog.eshop.service;

    import id.ac.ui.cs.advprog.eshop.model.Product;
    import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.extension.ExtendWith;
    import org.mockito.InjectMocks;
    import org.mockito.Mock;
    import org.mockito.Mockito;
    import org.mockito.junit.jupiter.MockitoExtension;

    import java.util.ArrayList;
    import java.util.List;

    import static org.mockito.Mockito.*;
    import static org.junit.jupiter.api.Assertions.*;

    @ExtendWith(MockitoExtension.class)
    public class ProductServiceTest {
        @Mock
        private ProductRepository productRepository;

        @InjectMocks
        private ProductServiceImpl service;

        @Test
        void testCreateAndFind() {
            Product product = new Product();
            product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
            product.setProductName("Sampo Cap Bambang");
            product.setProductQuantity(100);

            when(productRepository.create(product)).thenReturn(product);
            Product createdProduct = service.create(product);

            List<Product> productList = new ArrayList<>();
            productList.add(product);
            when(productRepository.findAll()).thenReturn(productList.iterator());
            List<Product> resultProducts = service.findAll();

            assertFalse(resultProducts.isEmpty());
            Product savedProduct = resultProducts.get(0);
            assertEquals(product.getProductId(), savedProduct.getProductId());
            assertEquals(product.getProductName(), savedProduct.getProductName());
            assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
        }

        @Test
        void testEditProduct() {
            Product product = new Product();
            product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
            product.setProductName("Sampo Cap Bambang");
            product.setProductQuantity(100);

            when(productRepository.edit(product)).thenReturn(product);
            Product resultEdit = service.edit(product);

            assertNotNull(resultEdit);
            assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", resultEdit.getProductId());
            assertEquals("Sampo Cap Bambang", resultEdit.getProductName());
            assertEquals(100, resultEdit.getProductQuantity());
        }

        @Test
        void testEditProductNull() {
            Product product = null;

            Product result = service.edit(product);

            assertNull(result);
        }

        @Test
        void testDeleteProduct() {
            Product product = new Product();
            product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
            product.setProductName("Sampo Cap Bambang");
            product.setProductQuantity(100);

            when(productRepository.delete(product)).thenReturn(true);
            boolean isDeleted = service.delete(product);

            assertTrue(isDeleted);
            verify(productRepository).delete(product);
        }

        @Test
        void testDeleteProductNull() {
            Product product = null;

            boolean isDeleted = service.delete(product);

            assertFalse(isDeleted);
        }

        @Test
        void testGetProduct() {
            List<Product> productList = new ArrayList<>();
            Product expectedProduct = new Product();
            expectedProduct.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
            expectedProduct.setProductName("Sampo Cap Bambang");
            expectedProduct.setProductQuantity(100);
            productList.add(expectedProduct);

            when(productRepository.findAll()).thenReturn(productList.iterator());

            Product result = service.get(expectedProduct.getProductId());

            assertNotNull(result);
            assertEquals(expectedProduct.getProductId(), result.getProductId());
            assertEquals(expectedProduct.getProductName(), result.getProductName());
            assertEquals(expectedProduct.getProductQuantity(), result.getProductQuantity());

            when(productRepository.findAll()).thenReturn(productList.iterator());
            Product nonExistResult = service.get("-");
            assertNull(nonExistResult);
        }



    }
