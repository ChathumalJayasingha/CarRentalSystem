package lk.ijse.spring.controller;

import lk.ijse.spring.dto.PaymentDTO;
import lk.ijse.spring.service.PaymentService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity savePayment(@RequestBody PaymentDTO dto) {
        service.addPayment(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllPayments() {
        List<PaymentDTO> allPayments = service.getAllPayments();
        return new ResponseEntity(new StandardResponse("200", "Done", allPayments), HttpStatus.OK);
    }



}
