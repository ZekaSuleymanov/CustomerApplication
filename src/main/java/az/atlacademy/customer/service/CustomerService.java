package az.atlacademy.customer.service;

import az.atlacademy.customer.model.dto.CustomerResponceDto;
import az.atlacademy.customer.model.request.CustomerRequestDto;

import java.util.List;

public interface CustomerService {

    CustomerResponceDto createCustomer(CustomerRequestDto customerRequestDto);

    CustomerResponceDto findByID(Long id);

    List<CustomerResponceDto> findAllCustomers();

    void updateCustomer(Long id, CustomerRequestDto customerRequestDto);

    void deleteCustomer(Long id);
}
