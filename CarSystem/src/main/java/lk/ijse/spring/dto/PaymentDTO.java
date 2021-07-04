package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class PaymentDTO {
    private String paymentId;
    private double paymentAmount;
    private double paymentDeduction;
    private ReturnDTO returnDTO;
}
