package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.entity.Payment;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.PaymentRepo;
import lk.ijse.spring.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addPayment(PaymentDTO dto) {
        if (!paymentRepo.existsById(dto.getPaymentId())) {
            paymentRepo.save(modelMapper.map(dto, Payment.class));
        } else {
            throw new ValidateException(dto.getPaymentId()+" payment is already Exist in this Database");
        }
    }

    @Override
    public void updatePayment(PaymentDTO dto) {

    }

    @Override
    public void deletePayment(String id) {

    }

    @Override
    public List<PaymentDTO> getAllPayments() {
        return modelMapper.map(paymentRepo.findAll(), new TypeToken<List<PaymentDTO>>(){}.getType());
    }

    @Override
    public PaymentDTO searchPayment(String id) {
        return null;
    }
}
