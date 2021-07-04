package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.exception.NotFoundException;
import lk.ijse.spring.service.OrderService;
import lk.ijse.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrdersController {

    @Autowired
    private OrderService service;


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveOrder(@RequestBody OrdersDTO dto) {
        if (dto.getOrderId().trim().length() <= 0) {
            throw new NotFoundException("OrderID cannot be empty");
        }
        if (dto.getCar() == null) {
            throw new NotFoundException("CarDTO  cannot be empty");
        }
        if (dto.getCustomer()==null) {
            throw new NotFoundException("customerDTO cannot be empty");
        }
        if (dto.getLossDamage() <= 0) {
            throw new NotFoundException("Loss Damage Wavier cannot be empty");
        }
        service.addOrder(dto);
        return new ResponseEntity(new StandardResponse("201", "Done", dto), HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAllOrders() {
        List<OrdersDTO> allOrders = service.getAllOrders();
        return new ResponseEntity(new StandardResponse("200", "Done", allOrders), HttpStatus.OK);
    }

    @GetMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity searchOrder(@RequestParam String id) {
        OrdersDTO ordersDTO = service.searchOrders(id);
        return new ResponseEntity(new StandardResponse("200", "Done", ordersDTO), HttpStatus.OK);
    }


    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteOrder(@RequestParam String id) {
        service.deleteOrder(id);
        return new ResponseEntity(new StandardResponse("200", "Done", id), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateOrder(@RequestBody OrdersDTO dto) {
        if (dto.getOrderId().trim().length() <= 0) {
            throw new NotFoundException("No id provided to update");
        }
        service.updateOrder(dto);
        return new ResponseEntity(new StandardResponse("200", "Done", dto), HttpStatus.OK);
    }

}
