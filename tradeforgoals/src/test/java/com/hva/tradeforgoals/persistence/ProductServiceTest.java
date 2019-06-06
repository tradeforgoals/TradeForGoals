package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    private static final long fake_ID = 1L;

    private ProductService objectUnderTest;

    @Mock
    private ProductRepository productRepositoryMock;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        objectUnderTest = new ProductService();
        objectUnderTest.setProductRepository(productRepositoryMock);

    }

    @Test
    public void findAll() {
        Product product1 = createProduct();
        Product product2 = createProduct();
        product1.setId(2L);
        product2.setId(3L);

        Iterable<Product> products = objectUnderTest.findAll();
        assertNotNull(StreamSupport.stream(products.spliterator(), false));
    }

    @Test
    public void findById() {
        Product product = createProduct();

        when(productRepositoryMock.findById(fake_ID)).thenReturn(Optional.of(product));

        Product testProduct = objectUnderTest.findById(fake_ID);

        assertNotNull(testProduct);
        assertEquals(testProduct.getId(), product.getId());
        assertEquals("Title", testProduct.getTitle());
        assertEquals("Description", testProduct.getDescription());

        Product product2 = objectUnderTest.findById(3L);
        assertNull(product2);
    }

    @Test
    public void save() {
        Product savedProduct = createProduct();
        objectUnderTest.save(savedProduct);

        assertNotNull(savedProduct);
    }

    @Test
    public void deleteById() {
        objectUnderTest.deleteById(fake_ID);
        verify(productRepositoryMock, times(1)).deleteById(fake_ID);
    }

    private Product createProduct() {
        Product product = new Product();
        product.setId(fake_ID);
        product.setTitle("Title");
        product.setDescription("Description");

        return product;
    }

}