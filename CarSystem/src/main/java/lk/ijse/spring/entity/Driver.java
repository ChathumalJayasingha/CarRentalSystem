package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Driver {
    @Id
    private String driverId;
    private String driverName;
    private String driverAddress;
    private String driverContact;
    private boolean driverAvailable;

    @OneToMany(mappedBy = "driver")
    private List<Orders> orders = new ArrayList<>();
}
