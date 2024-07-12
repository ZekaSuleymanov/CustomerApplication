package az.atlacademy.customer.controller;


import az.atlacademy.customer.dao.entity.CustomerEntity;
import az.atlacademy.customer.model.dto.CustomerResponceDto;
import az.atlacademy.customer.model.request.CustomerRequestDto;
import az.atlacademy.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Validated
@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponceDto> createCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customerRequestDto));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerResponceDto>> findAllCustomers() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }


    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponceDto> findByID(@PathVariable Long id) {
        if (id == null) {
            throw new NullPointerException("Find not found");
        }
        return ResponseEntity.ok(customerService.findByID(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponceDto> updateCustomer(@PathVariable Long id,
                                                              @RequestBody CustomerRequestDto customerRequestDto) {
        customerService.updateCustomer(id, new CustomerRequestDto());
        return  ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
