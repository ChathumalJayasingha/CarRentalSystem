package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Car {
    @Id
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

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<CarImage> carImages;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Orders> orders = new ArrayList<>();

    public Car(String carRegNo) {
        this.carRegNo = carRegNo;
    }
}
