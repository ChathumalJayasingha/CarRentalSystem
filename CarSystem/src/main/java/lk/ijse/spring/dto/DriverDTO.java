package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class DriverDTO {
    private String driverId;
    private String driverName;
    private String driverAddress;
    private String driverContact;
    private boolean driverAvailable;
}
