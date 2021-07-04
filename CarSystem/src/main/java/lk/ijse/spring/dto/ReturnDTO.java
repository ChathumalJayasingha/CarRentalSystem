package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class ReturnDTO {
    private String orderReturnId;
    private String orderReturnDate;
    private double orderReturnUsageKM;
    private OrdersDTO ordersDTO;

}
