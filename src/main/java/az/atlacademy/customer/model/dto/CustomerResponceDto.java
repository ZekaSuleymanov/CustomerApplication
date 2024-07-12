package az.atlacademy.customer.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerResponceDto {

    private Long id;

    private String name;

    private String lastName;

    private String email;

    private String country;
}
