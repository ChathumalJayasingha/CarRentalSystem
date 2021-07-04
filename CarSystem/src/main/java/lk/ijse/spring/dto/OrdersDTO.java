package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class OrdersDTO {

    private String orderId;
    private String dateTime;
    private String returnDate;
    private boolean bankSlip;
    private double lossDamage;
    private boolean status;
    private CustomerDTO customer;
    private CarDTO car;
    private DriverDTO driver;

}
