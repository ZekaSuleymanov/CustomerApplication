package az.atlacademy.customer.dao.repository;


import az.atlacademy.customer.dao.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
