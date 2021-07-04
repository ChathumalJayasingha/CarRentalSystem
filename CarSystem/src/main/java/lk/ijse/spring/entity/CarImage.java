package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CarImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int carImageId;
    private String carImageLocation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carId", referencedColumnName = "carRegNo", nullable = false)
    private Car car;
}
