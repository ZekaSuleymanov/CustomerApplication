package az.atlacademy.customer.mapper;


import az.atlacademy.customer.dao.entity.CustomerEntity;
import az.atlacademy.customer.model.dto.CustomerResponceDto;
import az.atlacademy.customer.model.request.CustomerRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerEntity toEntity(CustomerRequestDto customerRequestDto);

    CustomerResponceDto toDto(CustomerEntity customerEntity);
}
