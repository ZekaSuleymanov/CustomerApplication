package az.atlacademy.customer.model.request;


import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;


@Data
@NoArgsConstructor
@FieldNameConstants(level = AccessLevel.PRIVATE)
public class CustomerRequestDto {

    @NotBlank
    String name;

    @NotBlank
    String lastName;

    @NotBlank
    String email;

    @NotBlank
    String country;

}
