package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.OrdersRepo;
import lk.ijse.spring.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrdersRepo ordersRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addOrder(OrdersDTO dto) {
        if (!ordersRepo.existsById(dto.getOrderId())) {
            ordersRepo.save(modelMapper.map(dto, Orders.class));
        } else {
            throw new ValidateException(dto.getOrderId()+" order is already Exist in this Database");
        }
    }

    @Override
    public void updateOrder(OrdersDTO dto) {
        if (ordersRepo.existsById(dto.getOrderId())) {
            ordersRepo.save(modelMapper.map(dto, Orders.class));
        } else {
            throw new ValidateException(dto.getOrderId()+" <- This order Not Found for update in this database");
        }
    }

    @Override
    public void deleteOrder(String id) {
        if (ordersRepo.existsById(id)) {
            ordersRepo.deleteById(id);
        } else {
            throw new ValidateException(id+" <- This order cant delete in this database");
        }
    }

    @Override
    public List<OrdersDTO> getAllOrders() {
        return modelMapper.map(ordersRepo.findAll(), new TypeToken<List<OrdersDTO>>(){}.getType());

    }

    @Override
    public OrdersDTO searchOrders(String id) {
        Optional<Orders> orders = ordersRepo.findById(id);
        if (orders.isPresent()) {
            return modelMapper.map(orders.get(), OrdersDTO.class);
        } else {
            throw new ValidateException(id+" <- This order Not Found in this database");
        }
    }
}
