package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Advertisement;
import com.hva.tradeforgoals.domain.Customer;
import com.hva.tradeforgoals.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AdvertisementServiceTest {

    private static final long fakeID = 1L;

    private AdvertisementService objectUnderTest;

    @Mock
    private AdvertisementRepository advertisementRepositoryMock;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        objectUnderTest = new AdvertisementService();
        objectUnderTest.setAdvertisementRepository(advertisementRepositoryMock);
    }


    @Test
    public void findAll() {

        Advertisement advertisement1 = createAdvertisement();
        Advertisement advertisement2 = createAdvertisement();
        advertisement1.setId(fakeID);
        advertisement2.setId(2L);

        Iterable<Advertisement> advertisements = objectUnderTest.findAll();
        assertNotNull(StreamSupport.stream(advertisements.spliterator(), false));
    }

    @Test
    public void findById() {
        Advertisement advertisement = createAdvertisement();
        when(advertisementRepositoryMock.findById(fakeID)).thenReturn(Optional.of(advertisement));
        Advertisement advertisement1 = objectUnderTest.findById(fakeID);

        assertNotNull(advertisement1);
        assertEquals(advertisement.getId(), advertisement1.getId());
        assertEquals(advertisement.getTitle(), advertisement1.getTitle());
    }

    @Test
    public void save() {
        Advertisement advertisement = createAdvertisement();
        objectUnderTest.save(advertisement);

        assertNotNull(advertisement);
    }

    @Test
    public void deleteById() {
        objectUnderTest.deleteById(fakeID);
        verify(advertisementRepositoryMock, times(1)).deleteById(fakeID);
    }

    private Advertisement createAdvertisement() {

        Product product = new Product();
        product.setId(fakeID);

        Customer customer = new Customer();
        customer.setId("2");

        Advertisement advertisement = new Advertisement();
        advertisement.setId(1L);
        advertisement.setAdvertisementProduct(product);
        advertisement.setCustomer(customer);
        advertisement.setTitle("advertisementTitle");
        advertisement.setDescription("advertisementDescription");

        return advertisement;
    }
}