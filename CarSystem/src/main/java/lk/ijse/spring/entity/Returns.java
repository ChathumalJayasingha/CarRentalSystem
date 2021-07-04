package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Returns {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderReturnId;
    private String orderReturnDate;
    private double orderReturnUsageKM;

    @OneToOne(mappedBy = "returns")
    private Payment payment;

    @OneToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private Orders orders;
}
