package lk.ijse.spring.service;

import lk.ijse.spring.dto.OrdersDTO;

import java.util.List;

public interface OrderService {
    void addOrder(OrdersDTO dto);
    void updateOrder(OrdersDTO dto);
    void deleteOrder(String id);
    List<OrdersDTO> getAllOrders();
    OrdersDTO searchOrders(String id);
}
