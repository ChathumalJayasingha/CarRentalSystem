package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CarDTO {
    private String carRegNo;
    private String carType;
    private String carBrand;
    private String carColor;
    private String carTransmission;
    private String carFuelType;
    private int carNoOfPassengers;
    private double carNoOfKm;
    private double carExtraKm;
    private boolean carAvailable;
    private int carQty;
    private int carRentQty;
    private String carImage;
}
