package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CustomerDTO {
    private String customerNIC;
    private String customerName;
    private String customerAddress;
    private String customerContact;
}
