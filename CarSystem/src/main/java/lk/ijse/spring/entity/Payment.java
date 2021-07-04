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
public class Payment {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String paymentId;
    private double paymentAmount;
    private double paymentDeduction;

    @OneToOne
    @JoinColumn(name = "orderReturnId", referencedColumnName = "orderReturnId")
    private Returns returns;
}
