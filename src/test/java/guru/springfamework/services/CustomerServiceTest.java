package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CategoryMapper;
import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {
    public static final String NAME = "Pierre";
    public static final long ID = 2L;
    public static final String LASTNAME = "Caplin";
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Before
    public void setUp() throws Exception {
        //  initialiser les objets simulés (mocks) dans une classe de test.
        MockitoAnnotations.initMocks(this);

        // SetUp our Mapper
        customerService = new CustomerServiceImpl(CustomerMapper.INSTANCE, customerRepository);
    }

    @Test
    public void getAllCustomers() {
        // Given
        List<Customer> customers = Arrays.asList(new Customer(),new Customer(),new Customer());
        when(customerRepository.findAll()).thenReturn(customers);

        // When
        List<CustomerDTO> categoryDTOS = customerService.getAllCustomers();

        // Then
        assertEquals(3,categoryDTOS.size());
    }

    @Test
    public void getCustomerById() {
        // Given
        Customer customer = new Customer();
        customer.setFirstname(NAME);
        customer.setLastname(LASTNAME);
        customer.setId(ID);

        when(customerRepository.findById(anyLong())).thenReturn(Optional.of(customer));

        // When
        CustomerDTO customerDTO = customerService.getCustomerById(ID);

        // Then
        assertEquals(NAME,customerDTO.getFirstname());
        assertEquals(LASTNAME,customerDTO.getLastname());
    }

    @Test
    public void createNewCustomer () {
        // Given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname("Cédric");

        Customer savecCustomer = new Customer();
        savecCustomer.setFirstname(customerDTO.getFirstname());
        savecCustomer.setLastname(customerDTO.getLastname());
        savecCustomer.setId(ID);

        when(customerRepository.save(any(Customer.class))).thenReturn(savecCustomer);

        // When
        CustomerDTO savedDTO = customerService.createNewCustomer(customerDTO);

        // then
        assertEquals(customerDTO.getFirstname(),savedDTO.getFirstname());
        assertEquals("/api/v1/customers/"+ID,savedDTO.getCustomerUrl());
    }

    @Test
    public void saveCustomerByDTO() throws Exception {
        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname("Jim");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstname(customerDTO.getFirstname());
        savedCustomer.setLastname(customerDTO.getLastname());
        savedCustomer.setId(1l);

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        //when
        CustomerDTO savedDto = customerService.saveCustomerByDTO(1L, customerDTO);

        //then
        assertEquals(customerDTO.getFirstname(), savedDto.getFirstname());
        assertEquals("/api/v1/customer/1", savedDto.getCustomerUrl());
    }
}
