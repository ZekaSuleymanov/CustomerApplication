package az.atlacademy.customer.service.impl;

import az.atlacademy.customer.dao.entity.CustomerEntity;
import az.atlacademy.customer.dao.repository.CustomerRepository;
import az.atlacademy.customer.exception.CustomerNotFoundException;
import az.atlacademy.customer.mapper.CustomerMapper;
import az.atlacademy.customer.model.dto.CustomerResponceDto;
import az.atlacademy.customer.model.request.CustomerRequestDto;
import az.atlacademy.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper customerMapper;

    private final CustomerRepository customerRepository;


    @Override
    public CustomerResponceDto createCustomer(CustomerRequestDto customerRequestDto) {
        CustomerEntity customerEntity = customerMapper.toEntity(customerRequestDto);
        return customerMapper.toDto(customerRepository.save(customerEntity));
    }

    @Override
    public CustomerResponceDto findByID(Long id) {
         return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + id));
    }

    @Override
    public List<CustomerResponceDto> findAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDto)
                .toList();
    }

    @Override
    public void updateCustomer(Long id, CustomerRequestDto customerRequestDto) {
        CustomerEntity CustomerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + id));

        customerMapper.toEntity(new CustomerRequestDto());

        customerRepository.save(CustomerEntity);
    }


    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


}
