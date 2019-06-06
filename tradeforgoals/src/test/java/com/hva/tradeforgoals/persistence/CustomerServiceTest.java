package com.hva.tradeforgoals.persistence;

import com.hva.tradeforgoals.domain.Customer;
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
public class CustomerServiceTest {

    private static final String fakeID = "1";

    private CustomerService objectUnderTest;

    @Mock
    private CustomerRepository customerRepositoryMock;


    @Before
    public void Setup() {
        MockitoAnnotations.initMocks(this);
        objectUnderTest = new CustomerService();
        objectUnderTest.setCustomerRepository(customerRepositoryMock);
    }

    @Test
    public void findById() {
        Customer testCustomer = createCustomer();

        when(customerRepositoryMock.findById(fakeID)).thenReturn(Optional.of(testCustomer));

        Customer customerTest = objectUnderTest.findById(fakeID);

        assertNotNull(customerTest);
        assertEquals("Jorik", testCustomer.getFirstname());
        assertEquals("Barten", testCustomer.getLastname());

        Customer customerTest2 = objectUnderTest.findById("8");
        assertNull(customerTest2);

    }

    @Test
    public void deleteById() {
        objectUnderTest.deleteById(fakeID);
        verify(customerRepositoryMock, times(1)).deleteById(fakeID);

    }


    @Test
    public void save() {
        Customer savedCustomer = createCustomer();
        objectUnderTest.save(savedCustomer);

        assertNotNull(savedCustomer);
    }

    private Customer createCustomer() {
        Customer customer = new Customer();
        customer.setId(fakeID);
        customer.setFirstname("Jorik");
        customer.setLastname("Barten");
        customer.setEmail("een@email.com");
        customer.setHousenumber("123");
        customer.setZipcode("4567PW");
        customer.setAdvertisements(null);
        customer.setProducts(null);

        return customer;
    }

    @Test
    public void findAll() {

        Customer customer1 = createCustomer();
        Customer customer2 = createCustomer();
        customer1.setId("2");
        customer2.setId("3");

        Iterable<Customer> customers = objectUnderTest.findAll();
        assertNotNull(StreamSupport.stream(customers.spliterator(), false));

    }
}