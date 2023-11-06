package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {
    public static final String FIRSTNAME = "Yves";
    public static final String LASTNAME = "Caplin";
    public static final long ID = 1L;
    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

@Test
    public void customerToCustomerDTO() {
    // Given
    Customer customer = new Customer();
    customer.setFirstname(FIRSTNAME);
    customer.setLastname(LASTNAME);
    customer.setId(ID);

    // When
    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

    // then
    assertEquals(Long.valueOf(ID),customerDTO.getId());
    assertEquals(FIRSTNAME,customerDTO.getFirstname());
    assertEquals(LASTNAME,customerDTO.getLastname());
}

}
